package model;

public class Account {

        private int totalBalance;
        private int balanceToBankruptcy;

        public Account(){
            this.totalBalance = 1;
            this.balanceToBankruptcy = 0;
        }


        public void changeTotalBalance(int change){
            totalBalance = totalBalance + change;

            if (totalBalance < 0) {
                totalBalance = 0;
            }
        }

        public void setTotalBalance(int money){
            totalBalance = money;
        }




        public int getTotalBalance(){
            return totalBalance;
        }
}
