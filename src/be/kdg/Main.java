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
        spel.maakBord();
        spel.startSpel();

    }

}
