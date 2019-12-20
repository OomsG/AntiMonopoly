package be.kdg;

import be.kdg.spel.Spel;
import be.kdg.speler.Rol;
import be.kdg.speler.Speler;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Spel spel = new Spel();
        Rol rolDefined = null;
        Scanner myKeyboard = new Scanner(System.in);
        //Random myRandom = new Random();
        int rolKeuze = 0;
        System.out.print("Met hoeveel spelers wilt u spelen: ");
        int aantalSpelers = myKeyboard.nextInt();
        for(int i = 1;i<=aantalSpelers;i++){
            System.out.print("Naam speler "+i+": ");
            String naam = myKeyboard.next();
            do{
                System.out.print("Welke rol wilt u?\n- Druk op '1' voor concurrent.\n- Druk op '2' voor monopolist\nUw keuze: ");
                rolKeuze = myKeyboard.nextInt();
                if(rolKeuze == 1){
                    rolDefined = Rol.CONCURRENT;
                } else if(rolKeuze == 2) {
                    rolDefined = Rol.MONOPOLIST;
                } else {
                    System.out.println("Foute keuze");
                }
            }while(rolKeuze < 1 || rolKeuze > 2);
            Speler speler = new Speler(naam, rolDefined);
            spel.voegSpelerToe(speler);
        }
    }
}
