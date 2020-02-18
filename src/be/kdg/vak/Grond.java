package be.kdg.vak;

import be.kdg.speler.Speler;

import java.util.ArrayList;
import java.util.Random;

public class Grond implements Vak {
    protected String soort = "grond";
    private boolean gekocht = false;
    private int prijs;
    private String naam;
    private Random generator = new Random();

    public Grond(int prijs, int nummer) {
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
