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

    public static void main(String[] args) {

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

        for (int j = 0; j < totalPlayers; j++) {
            if (j == 0) {
                System.out.println("The youngest starts");
                players[j] = setupPlayer(totalPlayers, gui);
                System.out.println(players[j].getPlayerType());
            }
            if (j >= 1) {
                players[j] = setupPlayer(totalPlayers, gui);
                System.out.println(players[j].getPlayerType());
            }
        }

    }

/*
    public static Dice roll(int eyes, GUI gui) {
        Dice dice = new Dice();
        dice.rollDice();
        dice.setDiceOutcome(eyes);
        gui.setDie(eyes);

        gui.showMessage("Click the button to roll");
        Button button = new Button("Roll");

        return dice;


    }*/


    public static Player setupPlayer(int playerAmount, GUI gui) {
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
        GUI_Car.Type carType;
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
        GUI_Field field = gui.getFields()[0];
        field.setCar(guiPlayer, true);
        return player;
    }
}