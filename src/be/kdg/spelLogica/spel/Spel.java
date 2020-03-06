package be.kdg.spelLogica.spel;

import be.kdg.spelLogica.speler.Rol;
import be.kdg.spelLogica.speler.Speler;
import be.kdg.spelLogica.vak.*;

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
                if(this.bord[newPos].getSoort() == "start"){
                    speler.setScore(speler.getScore()+100);
                    System.out.println("**Doordat u op Start staat is uw balans met €100 gestegen.");
                    System.out.println("Uw nieuwe balans: €"+speler.getScore());
                } else if(this.bord[newPos].getSoort() == "kans"){
                    Kans kans = (Kans)this.bord[newPos];
                    int prijs = ((generator.nextInt(8)+1)*100)-400;
                    if(prijs > 0){
                        System.out.printf("\n**"+kans.getPosMessage()+"\n",prijs);
                    } else if(prijs < 0) {
                        System.out.printf("\n**"+kans.getNegMessage()+"\n",prijs);
                    } else {
                        System.out.printf("\n**De bank had u een factuur gestuurt maar u hebt geluk. Uw ouders hebben deze al betaald.\n",prijs);
                    }

                    speler.setScore(speler.getScore()+prijs);
                    System.out.println("Uw nieuwe balans: €"+speler.getScore());
                } else if(this.bord[newPos].getSoort() == "fonds"){
                    Fonds fonds = (Fonds)this.bord[newPos];
                    int prijs = (generator.nextInt(4)+1)*100;
                    System.out.printf("\n**"+fonds.getMessage()+"\n",prijs);
                    speler.setScore(speler.getScore()+prijs);
                    System.out.println("Uw nieuwe balans: €"+speler.getScore());
                } else if(this.bord[newPos].getSoort() == "grond"){
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

            }
            TimeUnit.MILLISECONDS.sleep(400);
        }
        System.out.println("EINDE");
    }
}