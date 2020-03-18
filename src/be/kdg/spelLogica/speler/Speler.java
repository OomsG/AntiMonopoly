package be.kdg.spelLogica.speler;

import be.kdg.spelLogica.vak.Grond;

import javax.swing.text.html.ImageView;
import java.util.ArrayList;

    public class Speler  {
        private String naam;
        private Rol rol;
        private int score = 1500;
        private int positie = 0;
        private boolean beurt = false;
        private ArrayList<Grond> bezittingen = new ArrayList<Grond>();


        public Speler(String naam, Rol rol) {
            this.naam = naam;
            this.rol = rol;
        }

    public void voegBezittingToe(Grond vak){
        bezittingen.add(vak);
    }

    public String toonBezittingen(){
        String resultaat = "";
        for(Grond bezitting : bezittingen){
            resultaat += "\n- "+bezitting.getNaam();
        }
        return resultaat;
    }

    public boolean isBeurt() {
            return beurt;
        }

    public void setBeurt(boolean beurt) {
            this.beurt = beurt;
        }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPositie() {
        return positie;
    }

    public void setPositie(int positie) {
        this.positie = positie;
    }

        public ArrayList<Grond> getBezittingen() {
            return bezittingen;
        }
    }
