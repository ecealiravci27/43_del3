package model;

public abstract class Field {
    protected String fieldName;
    protected String fieldDescription;
    protected String color;
    protected boolean drawCard;
    protected boolean attemptPurchase;
    protected boolean goToJail;
    protected boolean goToStart;
    protected boolean goToStrandPromade;
    protected boolean canEscape;
    protected boolean goToColor;
    protected boolean goUpToFive;
    protected boolean birthday;
    protected int movePiece;
    protected int changeMoney;
    protected int fieldValue;

    public Field(){
        this.fieldName = "";
        this.fieldDescription = "";
        this.color = "";
        this.drawCard = false;
        this.attemptPurchase = false;
        this.goToJail = false;
        this.goToStart = false;
        this.goToStrandPromade = false;
        this.canEscape = false;
        this.goToColor = false;
        this.goUpToFive = false;
        this.birthday = false;
        this.movePiece = 0;
        this.changeMoney = 0;
        this.fieldValue = 0;
    }

    public String getStringtRules(int id){

        String stringRule[];
        stringRule = new String[3];
        stringRule[0]=fieldName;
        stringRule[1]=fieldDescription;
        stringRule[2]=color;

        //return new String[]{fieldName,fieldDescription, color};

        return stringRule[id];
    }
    public boolean getBooleanRules(int id){
        boolean booleanRule[];
        booleanRule = new boolean[8];
        booleanRule[0]=drawCard;
        booleanRule[1]=attemptPurchase;
        booleanRule[2]=goToJail;
        booleanRule[3]=goToStart;
        booleanRule[4]=goToStrandPromade;
        booleanRule[5]=goToColor;
        booleanRule[6]=goUpToFive;
        booleanRule[7]=birthday;

        //return new boolean[]{drawCard,attemptPurchase, goToJail, goToStart, goToStrandPromade, canEscape, goToColor, goUpToFive, birthday};

        return booleanRule[id];
    }

    public int getIntRules(int id){
        int intRule[];
        intRule = new int[3];

        intRule[0]=changeMoney;
        intRule[1]=fieldValue;
        intRule[2]=movePiece;

        //return new int[]{changeMoney,fieldValue, movePiece};

        return intRule[id];
    }

    /*public Object[] getAllRules(){
        String[] stringR = getStringtRules();
        boolean[] booleanR = getBooleanRules();
        int[] intR = getIntRules();

        return new Object[]{stringR[0],stringR[1],stringR[2],booleanR[0],booleanR[1],booleanR[2],booleanR[3],booleanR[4],booleanR[5],booleanR[6],booleanR[7], booleanR[8], intR[0],intR[1], intR[2]};
    }*/

    public String getFieldName(){
        return fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}
