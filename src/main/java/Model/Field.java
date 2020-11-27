package Model;

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

    public String[] getStringtRules(){

        String stringRule[];
        stringRule = new String[3];
        stringRule[0]=fieldName;
        stringRule[1]=fieldDescription;
        stringRule[2]=color;

        return new String[]{fieldName,fieldDescription, color};

    }
    public boolean[] getBooleanRules(){
        boolean booleanRule[];

        return new boolean[]{drawCard,attemptPurchase, goToJail, goToStart, goToStrandPromade, canEscape, goToColor, goUpToFive, birthday};

    }

    public int[] getIntRules(){
        int intRule[];

        return new int[]{changeMoney, movePiece, fieldValue};
    }

    public Object[] getAllRules(){
        String[] stringR = getStringtRules();
        boolean[] booleanR = getBooleanRules();
        int[] intR = getIntRules();

        return new Object[]{stringR[0],stringR[1],stringR[2],booleanR[0],booleanR[1],booleanR[2],booleanR[3],booleanR[4],booleanR[5],booleanR[6],booleanR[7], booleanR[8], intR[0],intR[1], intR[2]};
    }

    public String getFieldName(){
        return fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public String getColor() {return color;}
}
