import Model.Board;
import Model.Dice;
import Model.Player;

import java.util.Scanner;
public class Game {

    Board board = new Board();
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalPlayers;

        //getting player amount
        System.out.println("How many players?");
        totalPlayers = in.nextInt();
        //initializing player object array
        Player[] players = new Player[totalPlayers];

        for (int j = 0; j < totalPlayers; j++) {
            if (j == 0) {
                System.out.println("The youngest starts");
                players[j] = setupPlayer();
                System.out.println(players[j].getPlayerType());
            }
            if (j >= 1) {
                players[j] = setupPlayer();
                System.out.println(players[j].getPlayerType());
            }
        }
    }

    public static Player setupPlayer() {
        Scanner in = new Scanner(System.in);
        System.out.println("hvilken brik vil du have? 1-4?");
        int type = in.nextInt();
        return new Player(type);
    }

}