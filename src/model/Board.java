package model;

public class Board {
   Field[] field;

   public Board(){
      this.field = setupField();
   }

   public Field getFielobject(int id) {

      while (id > 23) {
         id = id - 24;
      }

      return field[id];
   }

   public Field[] setupField() {
      field = new Field[24];
      field[0] = new CornerField("Start",false, 2); //der skal også gives 2m hvis man også går forbi startfeltet. må finde ud af hvordan
      field[1] = new PropertyField ("Burgerbaren","nom nom","brown",1 );
      field[2] = new PropertyField("pizzahuset", "wow pizza", "brown", 1);
      field[3] = new ChanceField();
      field[4] = new PropertyField("Slikbutikken", "sluk :D","light blue", 1);
      field[5] = new PropertyField("Iskiosken", "nøj, slik", "light blue", 1);
      field[6] = new CornerField("Fængsel", false, 0);
      field[7] = new PropertyField("Museet", "museum wow", "purple", 2);
      field[8] = new PropertyField("Bibliotek", "study study", "purple", 2);
      field[9] = new ChanceField();
      field[10]= new PropertyField("Skaterparken", "skating yay", "cream", 2);
      field[11] = new PropertyField( "Swimmingpool", "swim swim", "cream", 2);
      field[12] = new CornerField("Parkeringsplads", false, 0);
      field[13] = new PropertyField("Spillehallen", "games!", "red", 3);
      field[14] = new PropertyField("Biograffen", "popcorn woo", "red", 3);
      field[15] = new ChanceField();
      field[16] = new PropertyField("Legetøjsbutikken", "play play", "yellow", 3);
      field[17] = new PropertyField("Dyrehandlen", "animal sounds", "yellow", 3);
      field[18] = new CornerField("Police", true, 0);
      field[19] = new PropertyField("Bowlinghallen", "strike!", "green", 4);
      field[20] = new PropertyField("Zoo", "monkeys :D", "green", 4);
      field[21] = new ChanceField();
      field[22] = new PropertyField("Vandlandet", "swosh", "blue", 5);
      field[23] = new PropertyField("Strandpromaden", "flot vejr","blue",5);

      return field;
   }

}