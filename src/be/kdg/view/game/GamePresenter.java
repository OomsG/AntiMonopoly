package be.kdg.view.game;


import be.kdg.spelLogica.spel.Spel;
import be.kdg.spelLogica.speler.Rol;
import be.kdg.spelLogica.speler.Speler;
import be.kdg.spelLogica.vak.Fonds;
import be.kdg.spelLogica.vak.Grond;
import be.kdg.spelLogica.vak.Kans;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class GamePresenter {
    final private GameView view;
    final private Spel spel;
    private boolean heeftGedobbeld = true;
    private boolean kanGrondKopen = false;
    private Grond huidigeGrond = null;
    int i = -1;

    public GamePresenter(Spel model, GameView view) {
        this.view = view;
        this.spel = model;
        addEventHandlers();
        view.getBtnBeurt().fire();
    }

    private void addEventHandlers() {

        //view.getScene().
        view.getBtnBeurt().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(heeftGedobbeld == true){
                    heeftGedobbeld = false;
                    kanGrondKopen = false;
                    view.toggleDobbelBtn(true);
                    view.toggleBeurtBtn(false);
                    view.toggleKoopGrond(false);
                    view.toggleGrondBouwen(false);
                    i++;
                    if(i >= spel.getSpelers().size()){
                        i = 0;
                        view.voegToeAanConsoleBox("-- RONDE --");
                    }
                    for(Speler speler : spel.getSpelers()){
                        speler.setBeurt(false);
                    }
                    spel.getSpelers().get(i).setBeurt(true);
                    view.voegToeAanConsoleBox("Beurt doorgegeven aan "+ spel.getSpelers().get(i).getNaam());
                    view.updateGetTaNaamBeurt(spel.getSpelers().get(i));
                } else {
                    view.toggleDobbelBtn(true);
                    view.voegToeAanConsoleBox("Je moet eerst dobbelen!");
                }
            }
        });
        view.getBtnDobbel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(heeftGedobbeld == false){
                    //view.voegToeAanConsoleBox("Gooit de dobbelstenen (spannend)");
                    Speler mySpeler = null;
                    System.out.println("Start dobbel");
                    for(Speler speler : spel.getSpelers()){
                        if(speler.isBeurt() == true){
                            mySpeler = speler;
                        }
                    }
                    int mijnGooi = spel.dobbelNewPos();
                    int newPos = mijnGooi + mySpeler.getPositie();
                    view.voegToeAanConsoleBox("Dobbelen... U hebt "+mijnGooi+" gegooid!");
                    if(newPos >= 39){
                        newPos -= 39;
                    }

                    mySpeler.setScore(mySpeler.getScore()+spel.voorbijStart(mySpeler, mySpeler.getPositie(),newPos));
                    if(spel.voorbijStart(mySpeler, mySpeler.getPositie(),newPos) > 0){
                        if(spel.voorbijStart(mySpeler, mySpeler.getPositie(),newPos) == 200){
                            view.voegToeAanConsoleBox(mySpeler.getNaam()+" is voorbij start gekomen en krijgt dus €200.");
                        } else {
                            view.voegToeAanConsoleBox(mySpeler.getNaam()+" is op start beland en krijgt dus €400.");
                        }
                        view.updateGetTaNaamBeurt(mySpeler);
                    }

                    System.out.println("New position: "+newPos);
                    mySpeler.setPositie(newPos);
                    heeftGedobbeld = true;
                    view.toggleDobbelBtn(false);

                    if(spel.getVak(newPos).getSoort() == "grond"){
                        Grond huidigVak = (Grond) spel.getVak(newPos);
                        if(!huidigVak.isGekocht() && huidigVak.getPrijs() <= mySpeler.getScore()){
                            view.toggleKoopGrond(true,huidigVak.getPrijs());
                            kanGrondKopen = true;
                            System.out.println("Mogelijkheid om huis te kopen: JA");
                            huidigeGrond = huidigVak;
                        } else if(huidigVak.isGekocht()){
                            huidigeGrond = huidigVak;
                            boolean eigenBezitting = false;
                            for(Grond grond : mySpeler.getBezittingen()){
                                if(grond.getNaam() == huidigeGrond.getNaam()){
                                    eigenBezitting = true;
                                }
                            }
                            if(eigenBezitting){
                                if(huidigeGrond.getPrijs()*1.2 <= mySpeler.getScore() && (mySpeler.getBezittingen().size() >= 4 || mySpeler.getRol() == Rol.CONCURRENT)){
                                    if(huidigeGrond.isHuisGebouwd()){
                                        view.toggleGrondBouwen(true,(int)(huidigeGrond.getPrijs()*1.2), true);
                                    } else {
                                        view.toggleGrondBouwen(true,(int)(huidigeGrond.getPrijs()*1.2), false);
                                    }
                                    System.out.println("Speler kan bouwen");
                                }
                            } else {
                                if(huidigVak.isGekocht() && !huidigVak.isHuisGebouwd() && (huidigVak.getPrijs()*0.3)+1 <= mySpeler.getScore()) {
                                    view.voegToeAanConsoleBox(spel.boeteBetalen(mySpeler, huidigVak));
                                } else if(huidigVak.isGekocht() && huidigVak.isHuisGebouwd()){
                                    boolean eigenaarIsMonopolist = false;
                                    for(Speler eigenaar : spel.getSpelers()){
                                        for(Grond bezitting : eigenaar.getBezittingen()){
                                            if(bezitting.equals(huidigeGrond) && eigenaar.getRol() == Rol.MONOPOLIST){
                                                eigenaarIsMonopolist = true;
                                            }
                                        }
                                    }
                                    if(eigenaarIsMonopolist && huidigVak.isGekocht() && huidigVak.isHuisGebouwd() && (huidigVak.getPrijs()*0.7)+1 <= mySpeler.getScore()){
                                        view.voegToeAanConsoleBox(spel.boeteBetalen(mySpeler, huidigVak));
                                    } else if(!eigenaarIsMonopolist && huidigVak.isGekocht() && huidigVak.isHuisGebouwd() && (huidigVak.getPrijs()*0.5)+1 <= mySpeler.getScore()){
                                        view.voegToeAanConsoleBox(spel.boeteBetalen(mySpeler, huidigVak));
                                    }
                                }
                            }
                        }
                    } else {
                        String vakSoort = spel.opWelkVak(newPos,mySpeler);
                        if(vakSoort == "fonds"){
                            Fonds fonds = new Fonds();
                            String msg = String.format(fonds.getMessage(),mySpeler.getNaam(),spel.opFonds(newPos,mySpeler));
                            view.voegToeAanConsoleBox(msg);
                        } else if(vakSoort == "kans"){
                            Kans kans = new Kans();
                            String msg;
                            int prijs = spel.opKans(newPos,mySpeler);
                            if(prijs > 0){
                                msg = kans.getPosMessage();
                            } else {
                                msg = kans.getNegMessage();
                            }
                            String msgFinal = String.format(msg,mySpeler.getNaam(),prijs);
                            view.voegToeAanConsoleBox(msgFinal);
                        } else if(vakSoort == "vrijparkeren"){
                            view.voegToeAanConsoleBox(mySpeler.getNaam()+" heeft €100 gekregen omdat hij op vrij parkeren is beland!");
                        } else if(vakSoort == "politie"){
                            view.voegToeAanConsoleBox(mySpeler.getNaam()+" is naar de gevangenis gestuurd en heeft €200 moeten betalen om vrij te komen!");
                        }
                    }
                    view.updateGetTaNaamBeurt(spel.getSpelers().get(i));
                    view.toggleBeurtBtn(true);

                    if(mySpeler.getScore()<0){
                        view.toggleDobbelBtn(false);
                        view.toggleBeurtBtn(false);
                        view.getTainstructiesConsoleBox().setText("---------------------------");
                        view.voegToeAanConsoleBox(mySpeler.getNaam() + " kan boete niet betalen.");
                        view.voegToeAanConsoleBox("SPEL IS BEËINDIGD");
                        view.voegToeAanConsoleBox("---------------------------");
                        try {
                            if(spel.setEinde()==0){
                                view.voegToeAanConsoleBox("Kon highscores bestand niet updaten");
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText("");
                                alert.setContentText("Kon highscores bestand niet updaten.");
                                alert.setTitle("Error");
                                alert.showAndWait();
                            }
                        } catch (IOException e) {
                            System.out.println("Could not execute EINDE");
                            view.voegToeAanConsoleBox("Kon highscores bestand niet updaten");
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText("");
                            alert.setContentText("Kon highscores bestand niet updaten.");
                            alert.setTitle("Error");
                            alert.showAndWait();
                        }
                    }

                } else {
                    view.voegToeAanConsoleBox("Geef de beurt eerst aan de volgende!");
                    view.toggleBeurtBtn(true);
                }
            }
        });

        view.getBtnBouwen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Speler mySpeler = null;
                for(Speler speler : spel.getSpelers()){
                    if(speler.isBeurt() == true){
                        mySpeler = speler;
                    }
                }
                System.out.println("bouwen");
                if(!huidigeGrond.isHuisGebouwd()){
                    huidigeGrond.setHuisGebouwd(mySpeler,true);
                    view.voegToeAanConsoleBox("Hoera! Huis gebouwd op grond!");
                } else {
                    huidigeGrond.setHuisGebouwd(mySpeler,false);
                    view.voegToeAanConsoleBox("Oh nee.. Huis verkocht!");
                }
                view.toggleGrondBouwen(false);
                view.updateGetTaNaamBeurt(mySpeler);
            }
        });

        view.getBtnKoopGrond().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Speler mySpeler = null;
                for(Speler speler : spel.getSpelers()){
                    if(speler.isBeurt() == true){
                        mySpeler = speler;
                    }
                }
                spel.koopGrond(mySpeler,huidigeGrond);
                view.voegToeAanConsoleBox("Hoera! " + mySpeler.getNaam() + " heeft "+huidigeGrond.getNaam()+" gekocht");
                view.updateGetTaNaamBeurt(mySpeler);
                view.toggleKoopGrond(false);
                if(mySpeler.getScore() >= (int)(huidigeGrond.getPrijs()*1.2) && (mySpeler.getBezittingen().size() >= 4 || mySpeler.getRol() == Rol.CONCURRENT)){
                    view.toggleGrondBouwen(true,(int)(huidigeGrond.getPrijs()*1.2),false);
                }
            }
        });

    }
}

