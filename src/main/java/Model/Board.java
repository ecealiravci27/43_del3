package Model;

public class Board {
   Field[] field;
   int totalField = 24;

   public Field getFieldIndex(int id) {
      return field[id];
   }


   public Field getField() {

      return null;
   }

   public void setupField(int totalField) {

   }
}