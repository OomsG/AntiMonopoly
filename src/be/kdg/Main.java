package be.kdg;

import be.kdg.spel.Spel;
import be.kdg.speler.Rol;
import be.kdg.speler.Speler;
import be.kdg.vak.Start;
import be.kdg.vak.Vak;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Spel spel = new Spel();
        spel.maakSpelers();

        Vak[] bord = new Vak[38];
        bord[0] = new Start();
        bord[9] = new Start();
        for(int i = 0;i<38;i++){

            //bord[i] =
        }
    }
}
