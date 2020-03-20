package be.kdg.spelLogica.vak;

import be.kdg.spelLogica.speler.Speler;

import java.util.ArrayList;
import java.util.Random;

public class Grond implements Vak {
    final protected String soort = "grond";
    private boolean gekocht = false;
    private boolean huisGebouwd = false;
    final private int prijs;
    final private String naam;
    final private Random generator = new Random();
    private double x;
    private double y;

    public Grond(int prijs, int nummer) {
        this.prijs = prijs;
        ArrayList<String> straatNamen = new ArrayList<String>();
        straatNamen.add("sander");
        straatNamen.add("hart");
        straatNamen.add("hard");
        straatNamen.add("vis");
        straatNamen.add("kop");
        straatNamen.add("dob");
        straatNamen.add("grove");
        straatNamen.add("leopold");
        straatNamen.add("maarten");
        straatNamen.add("nathan");
        straatNamen.add("bolivar");
        straatNamen.add("karel");
        straatNamen.add("grote");
        straatNamen.add("evian");
        straatNamen.add("prinses");
        straatNamen.add("integer");
        straatNamen.add("breda");
        straatNamen.add("tafel");
        straatNamen.add("kat");
        straatNamen.add("provinciale");
        straatNamen.add("quellin");
        straatNamen.add("leeuw");
        straatNamen.add("hond");
        straatNamen.add("sint");
        straatNamen.add("ram");
        straatNamen.add("puts");
        straatNamen.add("amerika");
        straatNamen.add("maria");
        straatNamen.add("duin");
        straatNamen.add("covid");
        straatNamen.add("hong");
        straatNamen.add("kong");
        straatNamen.add("chauffage");
        straatNamen.add("");
        this.naam = (straatNamen.get(generator.nextInt(straatNamen.size()))+straatNamen.get(generator.nextInt(straatNamen.size()))+"-straat "+nummer).toUpperCase();
    }

    public boolean isHuisGebouwd() {
        return huisGebouwd;
    }

    public void setHuisGebouwd(Speler speler, boolean huisKopen) {
        double prijsHuis = getPrijs()*1.2;
        if(isHuisGebouwd() == false){
            //koopt huis
            speler.setScore((int)(speler.getScore() - prijsHuis));
        } else {
            //verkoopt huis
            speler.setScore((int)(speler.getScore() + prijsHuis));
        }
        this.huisGebouwd = huisKopen;
    }

    public Grond(int prijs, int nummer, double x, double y) {
        this.prijs = prijs;
        ArrayList<String> straatNamen = new ArrayList<String>();
        straatNamen.add("leeuw");
        straatNamen.add("sander");
        straatNamen.add("breda");
        straatNamen.add("tafel");
        straatNamen.add("kat");
        straatNamen.add("hond");
        straatNamen.add("nathan");
        straatNamen.add("sint");
        straatNamen.add("amerika");
        straatNamen.add("leopold");
        straatNamen.add("maarten");
        straatNamen.add("duin");
        straatNamen.add("hong");
        straatNamen.add("kong");
        straatNamen.add("");
        this.naam = (straatNamen.get(generator.nextInt(straatNamen.size()))+straatNamen.get(generator.nextInt(straatNamen.size()))+"-straat "+nummer).toUpperCase();
        this.x = x;
        this.y = y;
     }

    public void setGekocht(boolean gekocht) {
        this.gekocht = gekocht;
    }

    public String getNaam() {
        return naam;
    }

    public boolean isGekocht() {
        return gekocht;
    }

    public String getSoort() {
        return soort;
    }

    public int getPrijs() {
        return prijs;
    }
}
