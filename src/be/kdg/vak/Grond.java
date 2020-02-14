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
        straatNamen.add("kreeft");
        straatNamen.add("panther");
        straatNamen.add("tafel");
        straatNamen.add("kat");
        straatNamen.add("hond");
        straatNamen.add("vis");
        straatNamen.add("bever");
        straatNamen.add("nummer");
        straatNamen.add("kap");
        straatNamen.add("grijs");
        straatNamen.add("goud");
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
