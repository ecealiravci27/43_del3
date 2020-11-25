package model;

public class Account {

        private int totalBalance;
        private int balanceToBankruptcy;

        public Account(int balance){
            this.totalBalance = balance;
            this.balanceToBankruptcy = 0;
        }

        public void setStartingBalace(int playerAmount){

        }

        public void changeTotalBalance(int change){
            totalBalance = totalBalance + change;

            if (totalBalance < 0) {
                totalBalance = 0;
            }
        }

        public int getTotalBalance(){
            return totalBalance;
        }
}
