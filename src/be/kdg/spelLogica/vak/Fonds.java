package be.kdg.spelLogica.vak;

import java.util.Random;

public class Fonds implements Vak {
    protected String soort = "fonds";
    private Random generator = new Random();

    private String[] messages = {
            "%s vindt een briefje van €%d op straat.",
            "%s vindt een briefje van €%d in zijn zetel.",
            "%s heeft de lotto gewonnen en krijgt €%d.",
            "Een neef die je niet kent is gestorven. %s erft €%d.",
            "Een nicht die je niet kent is gestorven. %s erft €%d.",
            "%s wint een tombola en heeft een voetbal ter waarde van €%d gewonnen!",
            "%s wint een tombola en heeft een fiets ter waarde van €%d gewonnen!",
            "%s wint een tombola en heeft een trui ter waarde van €%d gewonnen!",
            "%s wint een tombola en heeft tampasta ter waarde van €%d gewonnen!",
            "%s wint een tombola en heeft toilet papier ter waarde van €%d gewonnen!"
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
