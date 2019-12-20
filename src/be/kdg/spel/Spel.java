package be.kdg.spel;

import be.kdg.speler.Speler;

import java.util.ArrayList;

public class Spel {
    protected ArrayList<Speler> spelers = new ArrayList<Speler>();

    public void voegSpelerToe(Speler speler){
        this.spelers.add(speler);
    }

    public ArrayList<Speler> getSpelers() {
        return spelers;
    }
}
