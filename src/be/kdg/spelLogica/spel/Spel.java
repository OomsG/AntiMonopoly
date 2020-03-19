package be.kdg.spelLogica.spel;

import be.kdg.spelLogica.speler.Rol;
import be.kdg.spelLogica.speler.Speler;
import be.kdg.spelLogica.vak.*;

import java.io.*;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Spel {
    private Random generator = new Random();
    private LocalTime beginTijd = LocalTime.now();
    Vak[] bord = new Vak[40];

    public void setEinde() throws IOException {
        System.out.println("************************EINDE************************");
        Speler bestPlayerOfThisGame = null;
        HashMap<Speler, Integer> eindScore = new HashMap<>();
        for (Speler speler : spelers) {
            int totaleScore = speler.getScore();
            for (Grond grond : speler.getBezittingen()) {
                totaleScore += grond.getPrijs();
                if (grond.isHuisGebouwd()) {
                    totaleScore += grond.getPrijs() * 1.2;
                }
            }
            eindScore.put(speler, totaleScore);
            for (Speler spelervegelijker : eindScore.keySet()) {
                if (eindScore.get(spelervegelijker) >= totaleScore) {
                    bestPlayerOfThisGame = spelervegelijker;
                }
            }
        }
        String path = "C:\\MonopolyScores";
        String fileName = "scores.csv";
        File myDir = new File(path);
        File myFile = new File(path + "\\" + fileName);

        if (!myDir.exists()) {
            myDir.mkdir();
        }
        if (!myFile.exists()) {
            myFile.createNewFile();
        }
        try {
            System.out.println("Trying to read file..");
            List<String> mijnRegelsTekst;
            mijnRegelsTekst = Files.readAllLines(myFile.toPath());
            String myNewText = "";
            int lijnLaagsteScore = 0;
            if (mijnRegelsTekst.size() == 0) {
                System.out.println("File has no content");
                String setStartText = "naamVanHighScore5;-1;tijd;rol\n" +
                        "naamVanHighScore4;-2;tijd;rol\n" +
                        "naamVanHighScore3;-3;tijd;rol\n" +
                        "naamVanHighScore2;-4;tijd;rol\n" +
                        "naamVanHighScore1;-5;tijd;rol\n";

                BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));
                writer.append(setStartText);
                writer.close();
                System.out.println("Content created");
                mijnRegelsTekst = Files.readAllLines(myFile.toPath());
            }
            int counter = 0;
            for (String huidigeRegel : mijnRegelsTekst) {
                System.out.println("Line "+counter+": "+huidigeRegel);
                String[] huidigeScore = new String[4];
                huidigeScore = huidigeRegel.split(";");
                String[] getLijnLaagsteScore = mijnRegelsTekst.get(lijnLaagsteScore).split(";");
                int mySum = Integer.parseInt(huidigeScore[1]) + Integer.parseInt(getLijnLaagsteScore[1]);
                System.out.println( Integer.parseInt(huidigeScore[1])+ " + " +Integer.parseInt(getLijnLaagsteScore[1]) +" = "+mySum );
                if (Integer.parseInt(huidigeScore[1]) < Integer.parseInt(getLijnLaagsteScore[1])) {
                    lijnLaagsteScore = counter;
                    System.out.println("New lowest score: "+counter);
                }
                counter++;
            }
            System.out.println("FINAL lowest score: "+lijnLaagsteScore);
            counter = 0;
            for (String huidigeRegel : mijnRegelsTekst) {
                if (lijnLaagsteScore == counter) {
                    Duration myDuration = Duration.between(beginTijd,LocalTime.now());
                    String newDuration = LocalTime.MIDNIGHT.plus(myDuration).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                    myNewText += String.format("%s;%d;%s;%s%n", bestPlayerOfThisGame.getNaam(), eindScore.get(bestPlayerOfThisGame), newDuration,bestPlayerOfThisGame.getRol().toString());
                } else {
                    myNewText += String.format("%s%n",huidigeRegel);
                }
                counter++;
            }

            myFile.delete();
            myFile.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));
            writer.append(myNewText);
            writer.close();
        } catch (IOException ex) {
            System.out.println("Could not read file because: " + ex.getCause());
        }

    }

    protected ArrayList<Speler> spelers = new ArrayList<Speler>();

    public void voegSpelerToe(Speler speler) {
        this.spelers.add(speler);
    }

    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    public void koopGrond(Speler speler, Grond grond) {
        speler.setScore(speler.getScore() - grond.getPrijs());
        grond.setGekocht(true);
        speler.voegBezittingToe(grond);
    }

    public Vak getVak(int positie) {
        return bord[positie];
    }

    public void maakSpelers(String naam1, Rol rol1, String naam2, Rol rol2, String naam3, Rol rol3, String naam4, Rol rol4) {
        int aantalSpelers = 0;
        if (naam1.length() > 0) {
            if (rol1 != Rol.MONOPOLIST && rol1 != Rol.CONCURRENT) {
                rol1 = Rol.MONOPOLIST;
            }
            Speler speler = new Speler(naam1, rol1);
            voegSpelerToe(speler);
            aantalSpelers++;
            System.out.println("1 ingevuld: " + naam1 + " " + rol1);
        }
        if (naam2.length() > 0) {
            if (rol2 != Rol.MONOPOLIST && rol2 != Rol.CONCURRENT) {
                rol2 = Rol.MONOPOLIST;
            }
            Speler speler = new Speler(naam2, rol2);
            voegSpelerToe(speler);
            aantalSpelers++;
            System.out.println("2 ingevuld: " + naam2 + " " + rol2);
        }
        if (naam3.length() > 0) {
            if (rol3 != Rol.MONOPOLIST && rol3 != Rol.CONCURRENT) {
                rol3 = Rol.MONOPOLIST;
            }
            Speler speler = new Speler(naam3, rol3);
            voegSpelerToe(speler);
            aantalSpelers++;
            System.out.println("3 ingevuld: " + naam3 + " " + rol3);
        }
        if (naam4.length() > 0) {
            if (rol4 != Rol.MONOPOLIST && rol4 != Rol.CONCURRENT) {
                rol4 = Rol.MONOPOLIST;
            }
            Speler speler = new Speler(naam4, rol4);
            voegSpelerToe(speler);
            aantalSpelers++;
            System.out.println("4 ingevuld: " + naam4 + " " + rol4);
        }

        while (aantalSpelers++ < 2) {
            System.out.println("Te weinig spelers, extra speler automatisch aangemaakt!");
            Speler speler = new Speler("Guest" + aantalSpelers + "_" + (generator.nextInt(8999) + 1000), Rol.MONOPOLIST);
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
        bord[30] = new Politie(); //moet politie zijn
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
            if (i <= 9) {
                if (i == 3) grondXCoords = 464;
                grondXCoords -= 66;
                grondYCoords = 650;
            } else if (i <= 20) {
                if (i == 10) grondYCoords = 580 + 60;
                grondXCoords = 40;
                grondYCoords -= 66;
            } else if (i <= 30) {
                if (i == 21) grondXCoords = 64;
                grondXCoords += 66;
                grondYCoords = 35;
            } else if (i <= 40) {
                grondXCoords = 760;
                grondYCoords += 66;
            }
            if (bord[i] == null) {
                bord[i] = new Grond(prijs, i, grondXCoords, grondYCoords);
                prijs += 15;
            }
        }
    }

    public int opFonds(int newPos, Speler speler) {
        Fonds fonds = (Fonds) this.bord[newPos];
        int prijs = (generator.nextInt(4) + 1) * 100;
        speler.setScore(speler.getScore() + prijs);
        return prijs;
    }

    public int voorbijStart(Speler speler, int vorigePositie, int nieuwePositie) {
        if (nieuwePositie == 0) {
            return 400;
        } else if (nieuwePositie < vorigePositie) {
            return 200;
        }
        return 0;
    }

    public String boeteBetalen(Speler speler, Grond vak) {
        int boete;
        Speler deEigenaar = null;
        for (Speler eigenaar : spelers) {
            if (eigenaar.toonBezittingen().contains(vak.getNaam())) {
                deEigenaar = eigenaar;
            }
        }

        if (vak.isHuisGebouwd() && deEigenaar.getRol() == Rol.MONOPOLIST) {
            boete = (int) (vak.getPrijs() * 0.7);
        } else if (vak.isHuisGebouwd()) {
            boete = (int) (vak.getPrijs() * 0.5);
        } else {
            boete = (int) (vak.getPrijs() * 0.3);
        }
        speler.setScore(speler.getScore() - boete);
        deEigenaar.setScore(deEigenaar.getScore() + boete);
        return speler.getNaam() + " heeft €" + boete + " boete moeten betalen aan " + deEigenaar.getNaam();
    }

    public int opKans(int newPos, Speler speler) {
        Kans kans = (Kans) this.bord[newPos];
        int prijs = 0;
        while (prijs == 0) prijs = ((generator.nextInt(8) - 4)) * 100;
        speler.setScore(speler.getScore() + prijs);
        return prijs;
    }

    public String opWelkVak(int newPos, Speler speler) {
        if (this.bord[newPos].getSoort() == "start") {
            return "start";
        } else if (this.bord[newPos].getSoort() == "kans") {
            return "kans";
        } else if (this.bord[newPos].getSoort() == "fonds") {
            return "fonds";
        } else if (this.bord[newPos].getSoort() == "vrijparkeren") {
            speler.setScore(speler.getScore() + 100);
            return "vrijparkeren";
        } else if (this.bord[newPos].getSoort() == "politie") {
            int nodigePositie = 10;
            for (int i = 0; i < bord.length; i++) {
                if (bord[i].getSoort().equals("gevangenis")) {
                    nodigePositie = i;
                    break;
                }
            }
            speler.setPositie(nodigePositie);
            speler.setScore(speler.getScore() - 200);
            return "politie";
        } else {
            return "undefined";
        }
    }

    public int dobbelNewPos() {
        int newPos = (generator.nextInt(5) + 1) * 2;
        return newPos;
    }
}
