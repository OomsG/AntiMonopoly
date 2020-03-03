package be.kdg.spel;

import be.kdg.speler.Rol;
import be.kdg.speler.Speler;
import be.kdg.vak.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Spel {
    private Scanner myKeyboard = new Scanner(System.in);
    private Random generator = new Random();
    Vak[] bord = new Vak[39];

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

    public void maakBord() {
        bord[0] = new Start();
        bord[7] = new Fonds();
        bord[10] = new Gevangenis();
        bord[17] = new Fonds();
        bord[20] = new VrijParkeren();
        bord[22] = new Kans();
        bord[27] = new Fonds();
        bord[36] = new Kans();
        // elke hoek heeft een vaste waarde

        int prijs = 100;
        for (int i = 0; i < bord.length; i++) {
            if (bord[i] == null) {
                bord[i] = new Grond(prijs,i);
                prijs += 15;
            }
        }
    }



    public void startSpel() throws InterruptedException {
        boolean einde = false;
        System.out.println("Spel begint...");
        int counter = 0;
        while(!einde){
            counter++;
            for(int i = 0;i<spelers.size(); i++){
                Speler speler = spelers.get(i);
                System.out.println("\n-"+counter+"--------------------");
                System.out.println("Beurt aan "+speler.getNaam()+", uw vorige positie: "+speler.getPositie());
                int newPos = speler.getPositie() + (generator.nextInt(5)+1)*2;
                if(newPos >= 39){
                    newPos -= 39;
                }
                speler.setPositie(newPos);
                System.out.println("Uw nieuwe positie is: "+newPos);
                System.out.println("U hebt momenteel €"+speler.getScore());
                if(newPos == 0){
                    speler.setScore(speler.getScore()+100);
                    System.out.println("Doordat u op Start staat is uw balans met €100 gestegen.");
                    System.out.println("Uw nieuwe balans: €"+speler.getScore());
                } else if(this.bord[newPos].getSoort() == "grond"){
                    Grond vak = (Grond)this.bord[newPos];
                    if(!vak.isGekocht() && vak.getPrijs() <= speler.getScore()){
                        System.out.print("Druk op '1' om de grond '"+vak.getNaam()+"' (€"+vak.getPrijs()+") te kopen. Druk op 0 om uw beurt te beëindigen. ");
                        if(myKeyboard.nextInt() == 1){
                            speler.setScore(speler.getScore() - vak.getPrijs());
                            vak.setGekocht(true);
                            speler.voegBezittingToe(vak);
                            System.out.println(speler.toonBezittingen());
                        }
                    } else if(vak.isGekocht() && (vak.getPrijs()*0.3)+1 <= speler.getScore()){
                        int boete = (int)(vak.getPrijs()*0.3);
                        speler.setScore(speler.getScore()-boete);
                        System.out.println("*** U hebt €"+boete+" moeten betalen voor uw bezoek op de "+vak.getNaam()+".");
                        System.out.println("Uw nieuwe balans: €"+speler.getScore());

                        for(Speler eigenaar : spelers){
                            if(eigenaar.toonBezittingen().contains(vak.getNaam())){
                                eigenaar.setScore(eigenaar.getScore()+boete);
                                System.out.println(eigenaar.getNaam()+" zijn balens is met €"+boete+" gestegen.");
                            }

                        }
                    } else if(vak.isGekocht()) {
                        einde = true;
                        System.out.println("EINDE");
                    }
                }

            }
            TimeUnit.MILLISECONDS.sleep(400);
        }
    }
}
