package be.kdg.spelLogica.vak;

import java.util.Random;

public class Kans implements Vak {
    protected String soort = "kans";
    private Random generator = new Random();
    /*protected final double x;
    protected final double y;*/

    /*public Kans(double x, double y) {
        this.x = x;
        this.y = y;
    }*/

    private String[] negMessages = {
            "Netflix heeft %s een onbetaalde factuur gestuurd van €%d.",
            "De bank heeft %s een onbetaalde factuur gestuurd van €%d.",
            "ABInBev heeft %s een onbetaalde factuur gestuurd van €%d.",
            "De loodgieter heeft %s een onbetaalde factuur gestuurd van €%d.",
            "Proximus heeft %s een onbetaalde factuur gestuurd van €%d.",
            "Telenet heeft %s een onbetaalde factuur gestuurd van €%d.",
            "Electrabel heeft %s een onbetaalde factuur gestuurd van €%d."
    };

    @Override
    public String getSoort() {
        return soort;
    }

    public String getPosMessage(){
        Fonds fonds = new Fonds();
        return fonds.getMessage();
    }
    public String getNegMessage(){
        int msgId = generator.nextInt(negMessages.length);
        return negMessages[msgId];
    }
}
