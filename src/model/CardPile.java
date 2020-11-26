package model;

public class CardPile{

    public int cardIndex;
    Field[] card;

    public CardPile(int cardIndex){
        this.card = setupCard();
        this.cardIndex = (int) (Math.random()*7);
    }


    public Field[] setupCard() {
        card = new Card[8];
        card[0] = new Card(true,false, false, false, false,false,  2,0, "");
        card[1] = new Card(false,true, false, false, false,false, 0,0, "light blue");
        card[2] = new Card(false,true, false, false, false,false, 0,0, "green");
        card[3] = new Card(false,false, false, false, false,true, 0,0, "");
        card[4] = new Card(false,false, false, false, true,false, 0,0, "");
        card[5] = new Card(false,false, false, true, false,false, 0,0, "");
        card[6] = new Card(false,false, false, false, false,false, -2,0, "");
        card[7] = new Card(false,false, true, false, false,false, 0,0,"");
        return card;
    }

    public Card drawCard(){
        cardIndex++;
        return (Card) card[cardIndex-1];


    }


}