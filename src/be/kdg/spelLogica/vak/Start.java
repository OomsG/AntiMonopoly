package be.kdg.spelLogica.vak;

public class Start implements Vak {
    protected String soort = "start";

    public void getLocatie() {

    }

    @Override
    public String getSoort() {
        return soort;
    }
}