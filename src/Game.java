import model.*;

import java.util.Arrays;
import java.util.Scanner;
public class Game {

    Dice dice;
    Player player;
    Board board;

    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        //initializing variables

        //initializing objects. player array needs an input variable so its done later
        Board board = new Board();
        Dice dice = new Dice();
        CardPile pile = new CardPile();
        Scanner in = new Scanner(System.in);
        Property property = new Property();
        Player[] player = setupPlayers();
        int playerturn = 0;

            while (!checkBancrupcy(player)) {
                playerturn = playerturn % player.length;
                player[playerturn].movePlayerPiece(dice.rollDice());
                int position = (player[playerturn].getPieceMoves())%23;
                System.out.println(position);
                doRule(board.getField(position), pile, player, property, playerturn);
                playerturn++;
            }
        }





























    private static Player setupPlayer() {
        Scanner in = new Scanner(System.in);
        System.out.println("What piece do you want? 1-4?");
        int type = in.nextInt();
        return new Player(type);
    }

    public static Player[] setupPlayers() {
        Scanner in = new Scanner(System.in);
        System.out.println("How many players?");
        int totalPlayers = in.nextInt();
        Player[] players = new Player[totalPlayers];
        for (int j = 0; j < totalPlayers; j++) {
            if (j == 0) {
                System.out.println("The youngest starts");
                players[j] = setupPlayer();
            }
            if (j >= 1) {
                players[j] = setupPlayer();
            }
        }
        for (int i = 0; i < totalPlayers; i++) {
            int startingBalance = 0;
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



    public static void doRule(Field field,CardPile pile, Player[] player, Property property, int active) {
        int position = player[active].getPlayerPosition();
        Object[] rules = field.getAllRules();
        boolean[] rulesB = field.getBooleanRules();
        System.out.println("player with piece type " + player[active].getPlayerType() + " is doing rules for " + rules[0].toString());
        System.out.println("description: " + rules[1]);

        if (rulesB[0]) {
            Card card = pile.drawCard();
            doCard(card, player, active);
        }
        if (rulesB[1]) {
            int owner = property.getOwner(position);
            int change = (Integer) rules[14];
            if (owner == active) {
                return;
            }
            if (owner == 0) {
                player[active].changeMoney((change));
                property.buy(position, player[active].getPlayerType());
            } else {
                player[active].changeMoney(-(change));
                player[owner].changeMoney(-(change));
            }

        }
    }

    public static void doCard(Card card, Player[] player, int active) {
        boolean[] rulesB = card.getBooleanRules();
        if (rulesB[2]) {
            if (player[active].getCanEscape()) {
                player[active].setPlayerPiece(6);
                player[active].setCanNotEscape();
            }
            if (!player[active].getCanEscape()) {
                player[active].setPlayerPiece(6);
                player[active].changeMoney(-1);
            }
        }

        if (rulesB[3]) {
            player[active].setPlayerPiece(0);
        }

        if (rulesB[4]) {
            player[active].setPlayerPiece(23); //possibly make it so you try to buy the beach
        }

        if (rulesB[6]) {
            Scanner in = new Scanner(System.in);
            System.out.println("you have to go to a color. 1-2?");
            int position = in.nextInt();
            String color = card.getColor();
            if (color == "light blue") {
                System.out.println(color);
                if (position == 1) {
                    player[active].setPlayerPiece(4);
                }
                if (position == 2) {
                    player[active].setPlayerPiece(5);
                }

            }
            if (color == "green") {
                System.out.println(color);
                if (position == 1) {
                    player[active].setPlayerPiece(19);
                }
                if (position == 2) {
                    player[active].setPlayerPiece(20);
                }
            }
        }
        if (rulesB[7]) {
            Scanner in = new Scanner(System.in);
            System.out.println("How many fields do you want to go up?"); //make exceptions!. only 1-5
            int move = in.nextInt();
            player[active].movePlayerPiece(move);
        }

        if (rulesB[8]) {
            for (int i = 0; i < player.length; i++) {
                if (i != active) {
                    player[i].changeMoney(-1);
                    player[active].changeMoney(1);
                }
            }
        }
    }

    public static void movePlayer(Player player) {

    }

    public static boolean checkBancrupcy (Player[] player) {
        for (int i = 0; i < player.length; i++) {
            if (player[i].isBancrupt()) {
                return true;
            }
        }
        return false;
    }
}
