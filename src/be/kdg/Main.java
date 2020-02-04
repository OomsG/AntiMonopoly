package be.kdg;

import be.kdg.spel.Spel;
import be.kdg.speler.Rol;
import be.kdg.speler.Speler;
import be.kdg.vak.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Spel spel = new Spel();
        spel.maakSpelers();

        Vak[] bord = new Vak[39];
        bord[0] = new Start();
        bord[10] = new Gevangenis();
        bord[20] = new VrijParkeren();
        bord[27] = new Start();
// elke hoek heeft een vaste waarde




        //sommige vakken hebben een vaste waarde

        for (int i = 0; i < 38; i++) {
            if (bord[i] != null) {
                bord[i] = new Grond();

                //telkens als bord niet gelijk is aan 0 maak je er een grond van
            }
        }
    }

}
