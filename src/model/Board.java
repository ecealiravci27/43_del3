package model;

public class Board {
   Field[] field;



   public Board(){
      this.field = setupField();
   }

   public Field getFielobject(int id) {
      return field[id];
   }

   public Field[] setupField() {
      field = new Field[24];
      field[0] = new CornerField("start",false, 2); //der skal også gives 2m hvis man også går forbi startfeltet. må finde ud af hvordan
      field[1] = new PropertyField ("Burgerbaren","nom nom","brown",1 );
      field[2] = new PropertyField("pizzahuset", "wow pizza", "brown", 1);
      field[3] = new ChanceField();
      field[4] = new PropertyField("slikbutikken", "sluk :D","silver", 1);
      field[5] = new PropertyField("iskiosken", "nøj, slik", "silver", 1);
      field[6] = new CornerField("Fængsel", false, 0);
      field[7] = new PropertyField("museet", "museum wow", "purple", 2);
      field[8] = new PropertyField("bibliotek", "study study", "purple", 2);
      field[9] = new ChanceField();
      field[10]= new PropertyField("skaterparken", "skating yay", "cream", 2);
      field[11] = new PropertyField( "swimmingpool", "swim swim", "cream", 2);
      field[12] = new CornerField("parkeringsplads", false, 0);
      field[13] = new PropertyField("spillehallen", "games!", "red", 3);
      field[14] = new PropertyField("biograffen", "popcorn woo", "red", 3);
      field[15] = new ChanceField();
      field[16] = new PropertyField("legetøjsbutikken", "play play", "yellow", 3);
      field[17] = new PropertyField("dyrehandlen", "animal sounds", "yellow", 3);
      field[18] = new CornerField("police", true, 0);
      field[19] = new PropertyField("bowlinghallen", "strike!", "green", 4);
      field[20] = new PropertyField("zoo", "monkeys :D", "green", 4);
      field[21] = new ChanceField();
      field[22] = new PropertyField("vandlandet", "swosh", "blue", 5);

      return field;
   }

}