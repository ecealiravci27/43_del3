package model;

import gui_fields.*;

import java.awt.*;

public class GuiBoard {
    GUI_Field[] field;



    public Object getField(int id) {
        return field[id];
    }



    public GUI_Field[] setupField() {
        GUI_Field[] fields = new GUI_Field[24];



        //START
        fields[0] = new GUI_Start();
        fields[0].setTitle("Start");
        fields[0].setDescription("Modtag 2 når du passerer");
        fields[0].setSubText("Modtag 2 når du passerer");
        fields[0].setBackGroundColor(Color.white);

        fields[1] = new GUI_Street();
        fields[1].setTitle("Burgerbaren");
        fields[1].setDescription("Nom nom");
        fields[1].setSubText("1");
        fields[1].setBackGroundColor(new Color(109, 81, 51));

        fields[2] = new GUI_Street();
        fields[2].setTitle("Pizzeriaet");
        fields[2].setDescription("");
        fields[2].setSubText("1");
        fields[2].setBackGroundColor(new Color(109, 81, 51));

        //CHANCE
        fields[3] = new GUI_Chance();
        fields[3].setTitle("Chance");
        fields[3].setDescription("");
        fields[3].setSubText("");
        fields[3].setBackGroundColor(Color.white);

        fields[4] = new GUI_Street();
        fields[4].setTitle("Slikbutikken");
        fields[4].setDescription("");
        fields[4].setSubText("1");
        fields[4].setBackGroundColor(new Color(121, 175, 194));

        fields[5] = new GUI_Street();
        fields[5].setTitle("Iskiosken");
        fields[5].setDescription("");
        fields[5].setSubText("1");
        fields[5].setBackGroundColor(new Color(121, 175, 194));

        //JAIL/VISITATION
        fields[6] = new GUI_Jail();
        fields[6].setSubText("På besøg");
        fields[6].setBackGroundColor(Color.white);


        fields[7] = new GUI_Street();
        fields[7].setTitle("Museet");
        fields[7].setDescription("");
        fields[7].setSubText("2");
        fields[7].setBackGroundColor(new Color(212, 90, 150));

        fields[8] = new GUI_Street();
        fields[8].setTitle("Biblioteket");
        fields[8].setDescription("");
        fields[8].setSubText("2");
        fields[8].setBackGroundColor(new Color(212, 90, 150));

        fields[9] = new GUI_Chance();
        fields[9].setTitle("Chance");
        fields[9].setDescription("");
        fields[9].setSubText("");
        fields[9].setBackGroundColor(Color.white);

        fields[10] = new GUI_Street();
        fields[10].setTitle("Skaterparken");
        fields[10].setDescription("");
        fields[10].setSubText("2");
        fields[10].setBackGroundColor(new Color(224, 189, 100));

        fields[11] = new GUI_Street();
        fields[11].setTitle("Swimmingpoolen");
        fields[11].setDescription("");
        fields[11].setSubText("2");
        fields[11].setBackGroundColor(new Color(224, 189, 100));

        //FREE PARKING
        fields[12] = new GUI_Refuge();
        fields[12].setDescription("");
        fields[12].setTitle("Gratis parkering");
        fields[12].setSubText("Gratis parkering");
        fields[12].setBackGroundColor(Color.white);

        fields[13] = new GUI_Street();
        fields[13].setTitle("Spillehallen");
        fields[13].setDescription("");
        fields[13].setSubText("3");
        fields[13].setBackGroundColor(new Color(182, 67, 52));

        fields[14] = new GUI_Street();
        fields[14].setTitle("Biografen");
        fields[14].setDescription("");
        fields[14].setSubText("3");
        fields[14].setBackGroundColor(new Color(182, 67, 52));

        fields[15] = new GUI_Chance();
        fields[15].setTitle("Chance");
        fields[15].setDescription("");
        fields[15].setSubText("");
        fields[15].setBackGroundColor(Color.white);

        fields[16] = new GUI_Street();
        fields[16].setTitle("Lejetøjsbutikken");
        fields[16].setDescription("");
        fields[16].setSubText("3");
        fields[16].setBackGroundColor(new Color(244, 255, 0));

        fields[17] = new GUI_Street();
        fields[17].setTitle("Dyrehandlen");
        fields[17].setDescription("");
        fields[17].setSubText("3");
        fields[17].setBackGroundColor(new Color(244, 255, 0));

        //GO TO JAIL
        fields[18] = new GUI_Jail();
        fields[18].setDescription("");
        fields[18].setTitle("Gå i fængsel");
        fields[18].setSubText("Gå i fængsel");
        fields[18].setBackGroundColor(Color.white);

        fields[19] = new GUI_Street();
        fields[19].setTitle("Bowlinghallen");
        fields[19].setDescription("");
        fields[19].setSubText("4");
        fields[19].setBackGroundColor(new Color(1, 104, 38));

        fields[20] = new GUI_Street();
        fields[20].setTitle("Zoo");
        fields[20].setDescription("");
        fields[20].setSubText("4");
        fields[20].setBackGroundColor(new Color(1, 104, 38));

        fields[21] = new GUI_Chance();
        fields[21].setTitle("Chance");
        fields[21].setDescription("");
        fields[21].setSubText("");
        fields[21].setBackGroundColor(Color.white);

        fields[22] = new GUI_Street();
        fields[22].setTitle("Vandlandet");
        fields[22].setDescription("");
        fields[22].setSubText("5");
        fields[22].setBackGroundColor(new Color(0, 51, 83));
        fields[22].setForeGroundColor(new Color(255, 255, 255));


        fields[23] = new GUI_Street();
        fields[23].setTitle("Strandpromenaden");
        fields[23].setDescription("");
        fields[23].setSubText("5");
        fields[23].setBackGroundColor(new Color(0, 51, 83));
        fields[23].setForeGroundColor(new Color(255, 255, 255));

        return fields;
    }

}