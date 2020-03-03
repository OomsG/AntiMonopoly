package be.kdg.vak;

import java.util.Random;

public class Fonds implements Vak {
    protected String soort = "fonds";
    private Random generator = new Random();

    private String[] messages = {
            "nog iets.."
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
