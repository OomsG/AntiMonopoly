package be.kdg.spelLogica.vak;

public class Politie implements Vak {
    protected String soort = "politie";

    @Override
    public String getSoort() {
        return soort;
    }
}
