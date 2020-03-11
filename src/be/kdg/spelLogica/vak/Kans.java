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

    private String[] posMessages = {
            "U vindt een briefje van €%d op straat.",
            "U vindt een briefje van €%d in uw zetel.",
            "U hebt de lotto gewonnen en krijgt €%d.",
            "Een neef die je niet kent is gestorven. U erft €%d.",
            "Een nicht die je niet kent is gestorven. U erft €%d.",
            "U wint een tombola en hebt een voetbal ter waarde van €%d gewonnen!",
            "U wint een tombola en hebt een fiets ter waarde van €%d gewonnen!",
            "U wint een tombola en hebt een trui ter waarde van €%d gewonnen!",
            "U wint een tombola en hebt tampasta ter waarde van €%d gewonnen!",
            "U wint een tombola en hebt toilet papier ter waarde van €%d gewonnen!"
    };

    private String[] negMessages = {
            "Netflix heeft u een onbetaalde factuur gestuurd van €%d.",
            "De bank heeft u een onbetaalde factuur gestuurd van €%d.",
            "ABInBev heeft u een onbetaalde factuur gestuurd van €%d.",
            "De loodgieter heeft u een onbetaalde factuur gestuurd van €%d.",
            "Proximus heeft u een onbetaalde factuur gestuurd van €%d.",
            "Telenet heeft u een onbetaalde factuur gestuurd van €%d.",
            "Electrabel heeft u een onbetaalde factuur gestuurd van €%d."
    };

    @Override
    public String getSoort() {
        return soort;
    }

    public String getPosMessage(){
        int msgId = generator.nextInt(posMessages.length);
        return posMessages[msgId];
    }
    public String getNegMessage(){
        int msgId = generator.nextInt(negMessages.length);
        return negMessages[msgId];
    }
}
