import Model.Board;
import Model.Dice;
import Model.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import java.awt.Color;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;
import java.util.Scanner;
public class Game {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        //loads board
        Board board = new Board();
        GUI gui = new GUI(board.setupField());


        Player player;
        Scanner in = new Scanner(System.in);
        int totalPlayers;
        int boardSize = 24;


        Dice dice = new Dice();


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