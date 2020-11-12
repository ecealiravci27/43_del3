package Model;

public class Account {

        private int totalBalance;
        private int balanceToBankruptcy;

        public Account(){
            this.totalBalance = 1000;
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
