import Model.Board;
import Model.Dice;
import Model.Player;
import com.sun.glass.ui.Size;
import gui_codebehind.GUI_Center;
import gui_fields.*;
import gui_main.GUI;
import java.awt.Color;

import gui_main.GUI;

import java.awt.*;
import java.util.Scanner;
public class Game {
    Scanner in = new Scanner(System.in);
    public void Start() {

        //loads board
        Board board = new Board();
        GUI gui = new GUI(board.setupField(), Color.white);

        //gui dice showing 6 eyes
        Dice dice = new Dice();
        gui.setDie(6);

        Player player;
        Scanner in = new Scanner(System.in);
        int totalPlayers;
        int boardSize = 24;


        //getting player amount
        System.out.println("How many players?");
        totalPlayers = in.nextInt();
        //initializing player object array
        Player[] players = new Player[totalPlayers];
        GUI_Player[] guiPlayers = new GUI_Player[totalPlayers];

        for (int j = 0; j < totalPlayers; j++) {
            if (j == 0) {
                System.out.println("The youngest starts");
                players[j] = setupPlayer(totalPlayers, gui);
                guiPlayers[j] = setupGuiPlayer(players[j], gui);
                System.out.println(players[j].getPlayerType());
            }
            if (j >= 1) {
                players[j] = setupPlayer(totalPlayers, gui);
                guiPlayers[j] = setupGuiPlayer(players[j], gui);
                System.out.println(players[j].getPlayerType());
            }
        }

        while (totalPlayers >= 1) {
            for(int i = 0; i < players.length; i++) {
                String answer = gui.getUserButtonPressed("Your turn: ", "Roll");
                if (answer.equals("Roll")) {
                    int maxEye = 6;
                    int minEye = 1;
                    int diceOutcome = (int) ((Math.random() * maxEye) + minEye);
                    roll(diceOutcome, gui, guiPlayers[i], players[i]);
                }
            }
        }
    }

    public Dice roll(int eyes, GUI gui, GUI_Player guiPlayer, Player player) {
        Dice dice = new Dice();
        dice.rollDice();
        dice.setDiceOutcome(eyes);
        gui.setDie(eyes);
        System.out.println(player.getPosition());

        // Remove previous reference to gui piece
        gui.getFields()[player.getPosition()].setCar(guiPlayer, false);

        // Move position for piece
        int newpos = eyes+player.getPosition();

        if (newpos > 23) {
            newpos = newpos - 24;
        }

        gui.getFields()[newpos].setCar(guiPlayer, true);
        player.setPosition(newpos);
        return dice;
    }

    public Player setupPlayer(int playerAmount, GUI gui) {
        Scanner in = new Scanner(System.in);
        System.out.println("Select piece by entering a number (1 = Tractor, 2 = Racecar, 3 = UFO, 4 = Car");
        int type = in.nextInt();
        Player player = new Player(type);
        player.setupAccount(playerAmount);
        System.out.println("Enter your name: ");
        Scanner scanner2 = new Scanner(System.in);
        String name = scanner2.nextLine();
        player.setPlayername(name);

        //allows user to select between 4 pieces
        return player;
    }

    public GUI_Player setupGuiPlayer(Player player, GUI gui) {
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

        GUI_Player guiPlayer = new GUI_Player(player.getPlayername(), player.getPlayerAccount().getTotalBalance(), guiCar);

        gui.addPlayer(guiPlayer);
        //gui.addPlayer(guiPlayer);

        GUI_Field field = gui.getFields()[0];
        field.setCar(guiPlayer, true);

        return guiPlayer;
    }
}