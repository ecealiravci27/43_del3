import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        //Initiating variables and creating objects for 2 players
        Scanner in = new Scanner(System.in);
        Dice dice = new Dice();
        Player player = new Player(1, 2);
        int i = 1;

        //getting player information
        System.out.println("Are you player 1 or player 2?");

        // Checks if the value is an int
        while (!in.hasNextInt()) {
            System.out.println("Please write 1 or 2");
            in.nextLine();
        }
        int playerType = in.nextInt();

        // Checks if the int is higher than 2 or lower than 1
        while (playerType < 1 || playerType > 2) {
            System.out.println("Please write 1 or 2");
            if (in.hasNextInt()) {
                playerType = in.nextInt();
            }
        }

        switch (playerType) {
            case 1:namePlayer(player1, player2);
                break;
            case 2: namePlayer(player2, player1);
                break;
        }


        while ((!account1.winCondition()) && (!account2.winCondition())) {

            if (i % 2 == 1) {

                playTurn(dicetotal1, account1, piece1, player1);
            }
            else {
                playTurn(dicetotal2, account2, piece2, player2);
            }

            if (account.winCondition()) {
                System.out.println(player2.getPlayerName() + " won!");
                System.out.println(" ");
                break;
            }
        }
    }
    //this keeps track of what happens during a turn, given the object instances
    private static void playTurn(Dice dicetotal, Account account, Board piece, Player player) {
        Scanner in = new Scanner(System.in);
        System.out.println(player.getPlayerName() + "'s turn");
        System.out.println("Press enter to roll:");
        in.nextLine();
        dicetotal.setDiceTotal(Dice.diceTotal());
        piece.updateBoardPosition(dicetotal.getDiceTotal());
        System.out.println("You rolled " + "" + dicetotal.getDiceTotal());
        System.out.println("Landed on " + piece.getFieldName() + ", your points are changed by " + "" + piece.getFieldValue());
        System.out.println(piece.getFieldText());
        account.updateBalance(piece.getFieldValue());
        while (piece.getboardPosition() == 10) {
            System.out.println("Current points on the Werewall: " + "" + account.getTotalBalance() + ", you get an extra turn");
            System.out.println("Press enter to roll:");
            in.nextLine();
            //System.out.println("Rolling again..");
            //System.out.println(" ");
            //rolling
            piece.updateBoardPosition(dicetotal.getDiceTotal());
            account.updateBalance(piece.getFieldValue());
            if (piece.getboardPosition() != 10) {
                System.out.println("Landed on " + piece.getFieldName() + " giving " + "" + piece.getFieldValue());
                System.out.println(piece.getFieldText());
            }
        }
        System.out.println("Turn ended with: " + "" + account.getTotalBalance());
        System.out.println(" ");
    }

    //this sets a playerName, keeping track of the order of input
    private static void namePlayer(Player first, Player last) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write your name");
        while (!in.hasNextLine()){
            System.out.println("invalid input");
            in.nextLine();
        }
        String firstName = in.nextLine();
        first.setPlayerName(firstName);

        if (first.playerType == 2){
            System.out.println("Write player 1's name");
        }

        if (first.playerType == 1){
            System.out.println("Write player 2's name");
        }

        while (!in.hasNextLine()){
            System.out.println("Please write 1 or 2");
            in.nextLine();
        }
        String lastName = in.nextLine();
        last.setPlayerName(lastName);
    }
}
