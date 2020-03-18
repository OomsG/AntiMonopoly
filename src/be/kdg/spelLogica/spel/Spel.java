package be.kdg.spelLogica.spel;

import be.kdg.spelLogica.speler.Rol;
import be.kdg.spelLogica.speler.Speler;
import be.kdg.spelLogica.vak.*;
import be.kdg.view.game.GamePresenter;
import be.kdg.view.game.GameView;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Spel {
    private Scanner myKeyboard = new Scanner(System.in);
    private Random generator = new Random();
    private boolean einde = false;
    private boolean spelerHeeftGedobbeld;
    private LocalTime beginTijd;
    Vak[] bord = new Vak[40];

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

    public void koopGrond(Speler speler, Grond grond){
        speler.setScore(speler.getScore() - grond.getPrijs());
        grond.setGekocht(true);
        speler.voegBezittingToe(grond);
    }

    public Vak getVak(int positie){
        return bord[positie];
    }

    public void maakSpelers(String naam1, Rol rol1, String naam2, Rol rol2, String naam3, Rol rol3, String naam4, Rol rol4){
        int aantalSpelers = 0;
        if(naam1.length() > 0){
            if(rol1 != Rol.MONOPOLIST && rol1 != Rol.CONCURRENT){
                rol1 = Rol.MONOPOLIST;
            }
            Speler speler = new Speler(naam1, rol1);
            voegSpelerToe(speler);
            aantalSpelers++;
            System.out.println("1 ingevuld: "+naam1+" "+rol1);
        }
        if(naam2.length() > 0){
            if(rol2 != Rol.MONOPOLIST && rol2 != Rol.CONCURRENT){
                rol2 = Rol.MONOPOLIST;
            }
            Speler speler = new Speler(naam2, rol2);
            voegSpelerToe(speler);
            aantalSpelers++;
            System.out.println("2 ingevuld: "+naam2+" "+rol2);
        }
        if(naam3.length() > 0){
            if(rol3 != Rol.MONOPOLIST && rol3 != Rol.CONCURRENT){
                rol3 = Rol.MONOPOLIST;
            }
            Speler speler = new Speler(naam3, rol3);
            voegSpelerToe(speler);
            aantalSpelers++;
            System.out.println("3 ingevuld: "+naam3+" "+rol3);
        }
        if(naam4.length() > 0){
            if(rol4 != Rol.MONOPOLIST && rol4 != Rol.CONCURRENT){
                rol4 = Rol.MONOPOLIST;
            }
            Speler speler = new Speler(naam4, rol4);
            voegSpelerToe(speler);
            aantalSpelers++;
            System.out.println("4 ingevuld: "+naam4+" "+rol4);
        }

        while(aantalSpelers++ < 2){
            System.out.println("Te weinig spelers, extra speler automatisch aangemaakt!");
            Speler speler = new Speler("Guest"+aantalSpelers+"_"+(generator.nextInt(8999)+1000), Rol.MONOPOLIST);
            voegSpelerToe(speler);
        }
    }

    public void maakBord() {
        bord[0] = new Start();
        bord[2] = new Fonds();
        bord[7] = new Kans();
        bord[10] = new Gevangenis();
        bord[17] = new Fonds();
        bord[20] = new VrijParkeren();
        bord[22] = new Kans();
        bord[30] = new Fonds(); //moet politie zijn
        bord[33] = new Fonds();
        bord[36] = new Kans();
        // elke hoek heeft een vaste waarde

        int prijs = 100;
        int grondXCoords = 730;
        int grondYCoords = 650;
        /*for (int i = 0; i < bord.length; i++) {
            if (bord[i] == null) {
                if(i <= 9) {
                    grondXCoords -= 66;
                    grondYCoords = 650;
                    if(i == 3) grondXCoords = 530;
                } else if(i <= 20){
                    if(i == 10) grondYCoords = 580+60;
                    if(i == 13) grondYCoords += 20;
                    if(i == 15 || i == 19) grondYCoords += 10;
                    if(i == 18) grondYCoords -= 42;
                    grondXCoords = 40;
                    grondYCoords -= 66;
                } else if(i <= 30){
                    grondXCoords += 66;
                    grondYCoords = 35;
                    if(i == 21) grondXCoords = 130;
                    if(i == 23) grondXCoords = 265;
                } else if(i <= 40){
                    grondXCoords = 760;
                    grondYCoords += 66;

                }
                bord[i] = new Grond(prijs,i,grondXCoords,grondYCoords);
                prijs += 15;
            }
        }*/
        for (int i = 0; i < bord.length; i++) {
            if(i <= 9) {
                if(i == 3) grondXCoords = 464;
                grondXCoords -= 66;
                grondYCoords = 650;
            } else if(i <= 20){
                if(i == 10) grondYCoords = 580+60;
                grondXCoords = 40;
                grondYCoords -= 66;
            } else if(i <= 30){
                if(i == 21) grondXCoords = 64;
                grondXCoords += 66;
                grondYCoords = 35;
            } else if(i <= 40){
                grondXCoords = 760;
                grondYCoords += 66;
            }
            if (bord[i] == null) {
                bord[i] = new Grond(prijs,i,grondXCoords,grondYCoords);
                prijs += 15;
            }
        }
    }

    public int opFonds(int newPos, Speler speler){
        Fonds fonds = (Fonds)this.bord[newPos];
        int prijs = (generator.nextInt(4)+1)*100;
        speler.setScore(speler.getScore()+prijs);
        return prijs;
    }

    public int voorbijStart(Speler speler, int vorigePositie, int nieuwePositie){
        if(nieuwePositie == 0){
            return 400;
        } else if(nieuwePositie < vorigePositie){
            return 200;
        }
        return 0;
    }

    public String boeteBetalen(Speler speler, Grond vak){
        int boete;
        Speler deEigenaar = null;
        for(Speler eigenaar : spelers){
            if(eigenaar.toonBezittingen().contains(vak.getNaam())){
                deEigenaar = eigenaar;
            }
        }

        if(vak.isHuisGebouwd() && deEigenaar.getRol() == Rol.MONOPOLIST){
            boete = (int)(vak.getPrijs()*0.7);
        } else if(vak.isHuisGebouwd()){
            boete = (int)(vak.getPrijs()*0.5);
        } else {
            boete = (int)(vak.getPrijs()*0.3);
        }
        speler.setScore(speler.getScore()-boete);
        deEigenaar.setScore(deEigenaar.getScore()+boete);
        return speler.getNaam() + " heeft €"+boete+" boete moeten betalen aan "+deEigenaar.getNaam();
    }

    //moet herbekeken worden
    public void opGrond(int newPos, Speler speler){
        Grond vak = (Grond)this.bord[newPos];
        if(!vak.isGekocht() && vak.getPrijs() <= speler.getScore()){
            System.out.print("**Druk op '1' om de grond '"+vak.getNaam()+"' (€"+vak.getPrijs()+") te kopen. Druk op 0 om uw beurt te beëindigen. ");
            if(myKeyboard.nextInt() == 1){
                speler.setScore(speler.getScore() - vak.getPrijs());
                vak.setGekocht(true);
                speler.voegBezittingToe(vak);
                System.out.println(speler.toonBezittingen());
            }
        } else if(vak.isGekocht() && (vak.getPrijs()*0.3)+1 <= speler.getScore()){
            int boete = (int)(vak.getPrijs()*0.3);
            speler.setScore(speler.getScore()-boete);
            System.out.println("** U hebt €"+boete+" moeten betalen voor uw bezoek op de "+vak.getNaam()+".");
            for(Speler eigenaar : spelers){
                if(eigenaar.toonBezittingen().contains(vak.getNaam())){
                    eigenaar.setScore(eigenaar.getScore()+boete);
                    System.out.println(eigenaar.getNaam()+" zijn balens is met €"+boete+" gestegen.");
                }
            }
            System.out.println("Uw nieuwe balans: €"+speler.getScore());
        } else if(speler.getScore() < 0) {
            einde = true;
        }
    }

    public int opKans(int newPos, Speler speler){
        Kans kans = (Kans)this.bord[newPos];
        int prijs = 0;
        while(prijs == 0) prijs = ((generator.nextInt(8)-4))*100;
        speler.setScore(speler.getScore()+prijs);
        return prijs;
    }

    public void opStart(Speler speler){
        speler.setScore(speler.getScore()+100);
    }

    public String opWelkVak(int newPos, Speler speler){
        if(this.bord[newPos].getSoort() == "start"){
            return "start";
        } else if(this.bord[newPos].getSoort() == "kans"){
            return "kans";
        } else if(this.bord[newPos].getSoort() == "fonds"){
            return "fonds";
        } else {
            return "undefined";
        }
    }

    public int dobbelNewPos(Speler speler){
        int newPos = speler.getPositie() + (generator.nextInt(5)+1)*2;
        if(newPos >= 39){
            newPos -= 39;
        }
        return newPos;
    }

    public int dobbelNewPos(){
        int newPos = (generator.nextInt(5)+1)*2;
        return newPos;
    }

    public void startSpel() throws InterruptedException {
        System.out.println("Spel begint...");
        int counter = 0;
        while(!einde){
            counter++;
            for(int i = 0;i<spelers.size(); i++){
                spelerHeeftGedobbeld = false;
                Speler speler = spelers.get(i);
                System.out.println("\n-"+counter+"--------------------");
                System.out.println("Beurt aan "+speler.getNaam()+", uw vorige positie: "+speler.getPositie());


                int newPos = dobbelNewPos(speler);
                speler.setPositie(newPos);
                spelerHeeftGedobbeld = true;

                System.out.println("Uw nieuwe positie is: "+newPos);
                System.out.println("U hebt momenteel €"+speler.getScore());

                opWelkVak(newPos, speler);

            }
            TimeUnit.MILLISECONDS.sleep(400);
        }
        System.out.println("EINDE");
    }

    public void start(){

    }
}
