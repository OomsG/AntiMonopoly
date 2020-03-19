package be.kdg.spelLogica.vak;

import java.util.Random;

public class Fonds implements Vak {
    final protected String soort = "fonds";
    final private Random generator = new Random();

    private String[] messages = {
            "%s vindt een briefje van €%d op straat.",
            "%s vindt een briefje van €%d op de trein.",
            "%s heeft de lotto gewonnen en \nkrijgt €%d.",
            "Een neef die je niet kent is \ngestorven. %s erft €%d.",
            "Een nicht die je niet kent is \ngestorven. %s erft €%d.",
            "%s wint een tombola en heeft een \nvoetbal ter waarde van €%d gewonnen!",
            "%s wint een tombola en heeft een \nfiets ter waarde van €%d gewonnen!",
            "%s wint een tombola en heeft een \ntrui ter waarde van €%d gewonnen!",
            "%s wint een tombola en heeft \ntandpasta ter waarde van €%d gewonnen!",
            "%s wint een tombola en heeft \ntoilet papier ter waarde van €%d gewonnen!"
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
