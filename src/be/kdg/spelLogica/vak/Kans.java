package be.kdg.spelLogica.vak;

import java.util.Random;

public class Kans implements Vak {
    protected String soort = "kans";
    private Random generator = new Random();

    private String[] messages = {
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

    @Override
    public String getSoort() {
        return soort;
    }

    public String getMessage(){
        int msgId = generator.nextInt(messages.length);
        return messages[msgId];
    }
}
