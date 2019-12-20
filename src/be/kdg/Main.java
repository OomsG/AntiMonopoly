package be.kdg;

import be.kdg.speler.Rol;
import be.kdg.speler.Speler;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Rol rolDefined;
        Scanner myKeyboard = new Scanner(System.in);
        Random myRandom = new Random();
        System.out.print("Met hoeveel spelers wilt u spelen: ");
        int aantalSpelers = myKeyboard.nextInt();
        for(int i = 1;i<=aantalSpelers;i++){
            System.out.print("Naam speler "+i+": ");
            String naam = myKeyboard.next();
            Boolean rol = myRandom.nextBoolean();
            if(rol){
                rolDefined = Rol.MONOPOLIST;
            } else {
                rolDefined = Rol.CONCURRENT;
            }
            Speler speler = new Speler(naam, rolDefined);
        }
    }
}
