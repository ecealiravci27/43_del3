import Model.Dice;
import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.util.Scanner;
public class Game {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        GUI gui = new GUI();
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
        System.out.println("hvilken brik vil du have? 1-4?");
        int type = in.nextInt();
        Player player = new Player(type);
        player.setupAccount(playerAmount);
        System.out.println("Enter your name: ");
        Scanner scanner2 = new Scanner(System.in);
        String name = scanner2.nextLine();
        player.setPlayername(name);
        GUI_Player guiPlayer = new GUI_Player(player.getPlayername(), player.getPlayerAccount().getTotalBalance());

        gui.addPlayer(guiPlayer);
        GUI_Field field = gui.getFields()[0];
        field.setCar(guiPlayer, true);
        return player;
    }
}