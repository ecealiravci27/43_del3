package Model;
public class PropertyField extends Field {

    public PropertyField(String fieldName, String fieldDescription, String color, int fieldValue){
        super();
        this.attemptPurchase = true;
        this.color = color;
        this.fieldName = fieldName;
        this.fieldDescription = fieldDescription;
        this.fieldValue = fieldValue;
    }
}