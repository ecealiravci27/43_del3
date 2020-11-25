package model;

public abstract class Field {
    protected String fieldName;
    protected String fieldDescription;
    protected String color;
    protected boolean drawCard;
    protected boolean attemptPurchase;
    protected boolean goToJail;
    protected int changeMoney;
    protected int fieldValue;

    public Field(){
        this.fieldName = "";
        this.fieldDescription = "";
        this.color = "";
        this.drawCard = false;
        this.attemptPurchase = false;
        this.goToJail = false;
        this.changeMoney = 0;
        this.fieldValue = 0;
    }

    public String[] getStringtRules(){
        return new String[]{fieldName,fieldDescription, color};
    }
    public boolean[] getBooleanRules(){
        return new boolean[]{drawCard,attemptPurchase, goToJail};
    }
    public int[] getIntRules(){
        return new int[]{changeMoney,fieldValue};
    }

    public Object[] getAllRules(){
        String[] stringR = getStringtRules();
        boolean[] booleanR = getBooleanRules();
        int[] intR = getIntRules();

        Object[] allR = new Object[]{stringR[0],stringR[1],stringR[2],booleanR[0],booleanR[1],booleanR[2], intR[0],intR[1]};
        return allR;
    }

    public String getFieldName(){
        return fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}
