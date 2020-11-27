import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import model.*;

import java.awt.*;
import java.util.Scanner;
public class Controller {

    Dice dice;
    Player player;
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //initializing variables

        //initializing objects. player array needs an input variable so its done later

        //loads guiboard
        GuiBoard guiBoard = new GuiBoard();
        GUI gui = new GUI(guiBoard.setupField(), Color.white);
        Board board = new Board();
        Dice dice = new Dice();
        CardPile pile = new CardPile();
        Scanner in = new Scanner(System.in);
        Property property = new Property();
        System.out.println("How many players? (2-4 of players allowed)");
        int totalPlayers = in.nextInt();
        Player[] player = setupPlayers(totalPlayers);
        GUI_Player[] guiPlayers = new GUI_Player[totalPlayers];
        for (int i = 0; i < player.length; i++) {
            guiPlayers[i] = setupGuiPlayer(player[i], gui);
        }

        int playerturn = 0;
        System.out.println(player[0].getPlayerType());
        while (!checkBancrupcy(player)) {
            playerturn = playerturn%(player.length);
            int position = (player[playerturn].getPlayerPosition());
            int account = player[playerturn].getMoney();
            System.out.println(account);

            ///gui rooldice
            String answer = gui.getUserButtonPressed(player[playerturn].getPlayername()+"\'s turn: ", "Roll");
            int eyes = dice.rollDice();
            dice.rememberDice(eyes);
            guiRoll(gui, dice);
            player[playerturn].movePlayerPiece(dice.getRememberDice());
            //guimovepiece

            setGuiposition(gui, position, guiPlayers[playerturn], player[playerturn].getPosition());

            doRule(board.getField(position), pile, player, property, playerturn, gui, guiPlayers[playerturn]);
            if(player[playerturn].getMoney() == 0){
                int max = 0;
                String name = "";

                for (int i = 0; i < player.length; i++) {
                    if(player[i].getMoney() > max) {
                        max = player[i].getMoney();
                        name = player[i].getPlayername();
                    }
                }
                gui.showMessage("Winner is: " + name + " with total of: " + max + " M");
                System.out.println("Game over!");
                break;
            }

            playerturn++;
        }

    }

    private static Player setupPlayer() {
        Scanner in = new Scanner(System.in);
        System.out.println("Select piece by entering a number (1 = Tractor, 2 = Racecar, 3 = UFO, 4 = Car");
        int type = in.nextInt();
        return new Player(type);
    }

    public static GUI_Player setupGuiPlayer(Player player, GUI gui) {
        GUI_Car.Type carType;
        int type = player.getPlayerType();
        switch (type) {
            case 1:
                carType = GUI_Car.Type.TRACTOR;
                break;
            case 2:
                carType = GUI_Car.Type.RACECAR;
                break;
            case 3:
                carType = GUI_Car.Type.UFO;
                break;
            case 4:
                carType = GUI_Car.Type.CAR;
                break;
            default:
                carType = GUI_Car.Type.CAR;
        }

        GUI_Car guiCar = new GUI_Car(null, null, carType, GUI_Car.Pattern.FILL);
        Scanner in = new Scanner(System.in);
        System.out.println("Write player name for 'Player "+ player.getPlayerType()+"'");
        String name = in.nextLine();
        player.setPlayername(name);
        GUI_Player guiPlayer = new GUI_Player(name, player.getMoney(), guiCar);
        gui.addPlayer(guiPlayer);
        //gui.addPlayer(guiPlayer);
        GUI_Field field = gui.getFields()[0];
        field.setCar(guiPlayer, true);

        return guiPlayer;
    }


    public static Player[] setupPlayers(int totalPlayers) {

        Player[] players = new Player[totalPlayers];
        for (int j = 0; j < totalPlayers; j++) {
            if (j == 0) {
                System.out.println("The youngest player starts: ");
                players[j] = setupPlayer();
            }
            if (j >= 1) {
                players[j] = setupPlayer();
            }
        }
        for (int i = 0; i < totalPlayers; i++) {
            int startingBalance = 1;
            if (totalPlayers == 2) {
                startingBalance = 20;
            } else if (totalPlayers == 3) {
                startingBalance = 18;
            } else if (totalPlayers == 4) {
                startingBalance = 16;
            }
            players[i].setMoney(startingBalance);
        }
        return players;
    }


    //dice
    public static void guiRoll (GUI gui, Dice dice) {
        int eyes = dice.getRememberDice();
        gui.setDie(eyes);
}

    //Method for rules when landing on a field
    public static void doRule(Field field,CardPile pile, Player[] player, Property property, int active, GUI gui, GUI_Player gplayer) {
        int position = player[active].getPlayerPosition();
        Object[] rules = field.getAllRules();
        boolean[] rulesB = field.getBooleanRules();
        int[] rulesI = field.getIntRules();
        System.out.println("Player with piece type " + player[active].getPlayerType() + " is doing rules for " + rules[0].toString());
        System.out.println("Field description: " + rules[1]);


        //Active player draws a card
        if (rulesB[0]) {
            Card card = pile.drawCard();
            doCard(card, player, active, gui, gplayer);
        }

        //The field is a property field, rules for a property fied commence
        if (rulesB[1]) {
            int owner = property.getOwner(position);
            int change = rulesI[2];

            if (owner == 5) {
                System.out.println("Charging: " + change);
                player[active].changeMoney(-(change));
                gplayer.setBalance(player[active].getMoney());
                property.buy(position, active);
            } else {
                player[active].changeMoney(-(change));
                int own = property.getOwner(position);
                player[own].changeMoney((change));
                gplayer.setBalance(player[active].getMoney());
                gplayer.setBalance(player[own].getMoney());
            }

            if (rulesB[2]) {
                if (player[active].getCanEscape()) {
                    player[active].setPosition(6);
                    player[active].setCanNotEscape();
                }
                if (!player[active].getCanEscape()) {
                    player[active].setPosition(6);
                    player[active].changeMoney(-1);
                    gplayer.setBalance(player[active].getMoney());
                }
            }

        }
    }
    //Rules for when drawing a card
    //Missing rule for "pay 2M to the bank"
    public static void doCard(Card card, Player[] player, int active, GUI gui, GUI_Player gplayer) {
        boolean[] rulesB = card.getBooleanRules();
        int[] rulesI = card.getIntRules();
        int prevposition = (player[active].getPlayerPosition());
        //Active player gets a canEscape effect activated
        if (rulesB[5]) {
            player[active].setCanEscape();
        }

        //Active player moves to field 0, start field
        if (rulesB[3]) {
            player[active].setPosition(0);
            setGuiposition(gui, prevposition, gplayer, player[active].getPosition());
        }

        //Active player moves to field 23
        if (rulesB[4]) {
            player[active].setPosition(23); //possibly make it so you try to buy the beach
            setGuiposition(gui, prevposition, gplayer, player[active].getPosition());
        }


        //Active player moves to a field of a particular color, chooses
        if (rulesB[6]) {
            Scanner in = new Scanner(System.in);
            System.out.println("You have to move to a color (1 for first color, 2 for second color)");
            int position = in.nextInt();
            String color = card.getColor();
            if (color.equals("Moved to a light blue field.")) {
                System.out.println(color);
                if (position == 1) {
                    player[active].setPosition(4);
                    setGuiposition(gui, prevposition, gplayer, player[active].getPosition());
                }
                if (position == 2) {
                    player[active].setPosition(5);
                    setGuiposition(gui, prevposition, gplayer, player[active].getPosition());
                }

            }
            if (color.equals("Moved to a green field.")) {
                System.out.println(color);
                if (position == 1) {
                    player[active].setPosition(19);
                    setGuiposition(gui, prevposition, gplayer, player[active].getPosition());
                }
                if (position == 2) {
                    player[active].setPosition(20);
                    setGuiposition(gui, prevposition, gplayer, player[active].getPosition());
                }
            }
        }

        //Active player chooses to move 1-5 fields
        if (rulesB[7]) {
            Scanner in = new Scanner(System.in);
            System.out.println("How many fields do you want to go up? (Choose between 1-5)"); //make exceptions!. only 1-5
            int move = in.nextInt();
            player[active].movePlayerPiece(move);
            setGuiposition(gui, prevposition, gplayer, player[active].getPosition());
        }

        //Birthday. Every other player gives activeplayer 1M
        if (rulesB[8]) {
            for (int i = 0; i < player.length; i++) {
                if (i != active) {
                    player[i].changeMoney(-1);
                    player[active].changeMoney(1);
                    gplayer.setBalance(player[active].getMoney());
                    gplayer.setBalance(player[i].getMoney());
                }
            }
        }

        //Active player pays 2M to bank
        if (rulesI[1] != 0) {
            player[active].changeMoney(rulesI[1]);
            gplayer.setBalance(player[active].getMoney());
        }
    }

    public static boolean checkBancrupcy (Player[] player) {
        for (int i = 0; i < player.length; i++) {
            if (player[i].isBancrupt()) {
                return true;
            }
        }
        return false;
    }

    public static void setGuiposition(GUI gui, int position, GUI_Player guiPlayer, int move) {
        gui.getFields()[move].setCar(guiPlayer, true);
        gui.getFields()[position].setCar(guiPlayer, false);

    }




}