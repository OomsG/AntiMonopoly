package be.kdg.view.game;


import be.kdg.spelLogica.spel.Spel;
import be.kdg.spelLogica.speler.Speler;
import be.kdg.spelLogica.vak.Grond;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class GamePresenter {
    private GameView view;
    private Spel spel;
    private boolean heeftGedobbeld = true;
    private boolean kanGrondKopen = false;
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
                    String tekst = "Speler: "+ spel.getSpelers().get(i).getNaam()
                            +"\nRol: "+ spel.getSpelers().get(i).getRol()
                            +"\nSaldo: €"+ spel.getSpelers().get(i).getScore()
                            +"\nPositie: "+ spel.getSpelers().get(i).getPositie();
                    view.getTaNaamBeurt().setText(tekst);
                } else {
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
                    view.voegToeAanConsoleBox("Dobbelen.. U hebt "+mijnGooi+" gegooid!");
                    if(newPos >= 39){
                        newPos -= 39;
                    }

                    System.out.println("New position: "+newPos);
                    mySpeler.setPositie(newPos);
                    heeftGedobbeld = true;

                    if(spel.getVak(newPos).getSoort() == "grond"){
                        Grond huidigVak = (Grond) spel.getVak(newPos);
                        if(!huidigVak.isGekocht() && huidigVak.getPrijs() <= mySpeler.getScore()){
                            view.toggleKoopGrond(true);
                            kanGrondKopen = true;
                            System.out.println("Mogelijkheid om huis te kopen: JA");
                        } else if(huidigVak.isGekocht() && mySpeler.toonBezittingen().equals(huidigVak)){
                            view.toggleGrondBouwen(true);
                            System.out.println("Speler kan bouwen");
                        } else if(huidigVak.isGekocht() && (huidigVak.getPrijs()*0.3)+1 <= mySpeler.getScore()){

                            System.out.println("Speler moet boete betalen");
                        } else if(mySpeler.getScore() < 0) {

                            System.out.println("Speler kan boete niet betalen..");
                        }
                    }

                    String tekst = "Speler: "+ spel.getSpelers().get(i).getNaam()
                            +"\nRol: "+ spel.getSpelers().get(i).getRol()
                            +"\nSaldo: €"+ spel.getSpelers().get(i).getScore()
                            +"\nPositie: "+ spel.getSpelers().get(i).getPositie();
                    view.getTaNaamBeurt().setText(tekst);



                } else {
                    view.voegToeAanConsoleBox("Geef de beurt eerst aan de volgende!!");
                }
            }
        });

    view.getSpeelBord().setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            System.out.println("Host clicked on; X: "+event.getX()+" | Y: "+event.getY());
        }
    });

        view.getBtnBouwen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("bouwen");
                view.voegToeAanConsoleBox("Huis gebouwd op grond");

            }
        });

        view.getBtnKoopGrond().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.voegToeAanConsoleBox("Grond gekocht");
            }
        });

    }
}

