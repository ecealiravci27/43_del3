import model.Board;
import model.Dice;
import model.Field;
import model.Player;

import java.util.Arrays;
import java.util.Scanner;
public class Game {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Player player;
        Board board = new Board();
        Scanner in = new Scanner(System.in);
        Dice dice = new Dice();
        Field[] fields = board.setupField();
        fields[0].getFieldName();
        System.out.println((Arrays.toString(fields[0].getAllRules())));
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