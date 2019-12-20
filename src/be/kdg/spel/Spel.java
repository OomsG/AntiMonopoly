package be.kdg.spel;

import be.kdg.speler.Rol;
import be.kdg.speler.Speler;

import java.util.ArrayList;
import java.util.Scanner;

public class Spel {
    protected ArrayList<Speler> spelers = new ArrayList<Speler>();

    public void voegSpelerToe(Speler speler){
        this.spelers.add(speler);
    }

    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    public void maakSpelers(){
        Rol rolDefined = null;
        Scanner myKeyboard = new Scanner(System.in);
        //Random myRandom = new Random();
        int rolKeuze = 0;
        System.out.print("Met hoeveel spelers wilt u spelen: ");
        int aantalSpelers = myKeyboard.nextInt();
        if(aantalSpelers > 4){
            aantalSpelers = 4;
            System.out.println("Je mag met max. 4 spelers spelen");
        }
        else if(aantalSpelers < 2){
            aantalSpelers = 2;
            System.out.println("Je mag met min. 2 spelers spelen");
        }
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
            voegSpelerToe(speler);
            for(int x = 0;x<2;x++) System.out.println("\n");
        }
    }
}
