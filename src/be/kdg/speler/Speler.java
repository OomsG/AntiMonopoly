package be.kdg.speler;

import be.kdg.vak.Grond;

import java.util.ArrayList;

public class Speler  {
    private String naam;
    private Rol rol;
    private int score = 1500;
    private int positie = 0;
    private ArrayList<Grond> bezittingen = null;


    public Speler(String naam, Rol rol) {
        this.naam = naam;
        this.rol = rol;
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

}
