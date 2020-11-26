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
        Scanner in = new Scanner(System.in);
        Property property = new Property();
        Field[] field = board.setupField();
        Player[] players = setupPlayers();

        doRule(field[0], players[0]);

        }
    private static Player setupPlayer() {
        Scanner in = new Scanner(System.in);
        System.out.println("hvilken brik vil du have? 1-4?");
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
                System.out.println(players[j].getPlayerType());
            }
            if (j >= 1) {
                players[j] = setupPlayer();
                System.out.println(players[j].getPlayerType());
            }
        }
        return players;
    }

    private static void doRule(Field field, Player player) {
        Object[] rules = field.getAllRules();
        System.out.println("player with piece type " + player.getPlayerType() + " is doing rules for " + rules[0].toString());
        System.out.println("description: " + rules[1]);





        //this.fieldName = "";
        //this.fieldDescription = "";
        //this.color = "";
        //this.drawCard = false;
        //this.attemptPurchase = false;
        //this.goToJail = false;
        //this.goToStart = false;
        //this.goToStrandPromade = false;
        //this.canEscape = false;
        //this.goToColor = false;
        //this.goUpToFive = false;
        //this.birthday = false;
        //this.movePiece = 0;
        //this.changeMoney = 0;
        //this.fieldValue = 0;




    }

    private void playTurn() {

        dice.rollDice();
        player.movePlayerPiece(dice.getDiceOutcome());
        board.getFielobject(player.getPieceMoves());
    }



}