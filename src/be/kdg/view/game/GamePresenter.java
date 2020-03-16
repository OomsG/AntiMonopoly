package be.kdg.view.game;


import be.kdg.spelLogica.spel.Spel;
import be.kdg.spelLogica.speler.Speler;
import be.kdg.view.start.StartPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;


public class GamePresenter {
    private GameView view;
    private Spel model;
    private boolean heeftGedobbeld;

    public GamePresenter(Spel model, GameView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    int i = -1;
    private void addEventHandlers() {
        //view.getScene().
        view.getBtnBeurt().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(heeftGedobbeld == true){
                    i++;
                    if(i >= model.getSpelers().size()){
                        i = 0;
                    }
                    for(Speler speler : model.getSpelers()){
                        speler.setBeurt(false);
                    }
                    model.getSpelers().get(i).setBeurt(true);
                    heeftGedobbeld = false;
                    String tekst = "Speler: "+ model.getSpelers().get(i).getNaam()
                            +"\nRol: "+ model.getSpelers().get(i).getRol()
                            +"\nSaldo: €"+ model.getSpelers().get(i).getScore()
                            +"\nPositie: "+ model.getSpelers().get(i).getPositie();
                    view.getTaNaamBeurt().setText(tekst);
                }
            }
        });
        view.getBtnDobbel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Speler mySpeler = null;
                System.out.println("Start dobbel");
                for(Speler speler : model.getSpelers()){
                    if(speler.isBeurt() == true){
                        mySpeler = speler;
                    }
                }
                int newPos = model.dobbelNewPos() + mySpeler.getPositie();
                if(newPos >= 39){
                    newPos -= 39;
                }
                System.out.println("New position: "+newPos);
                mySpeler.setPositie(newPos);
                heeftGedobbeld = true;

                String tekst = "Speler: "+ model.getSpelers().get(i).getNaam()
                        +"\nRol: "+ model.getSpelers().get(i).getRol()
                        +"\nSaldo: €"+ model.getSpelers().get(i).getScore()
                        +"\nPositie: "+ model.getSpelers().get(i).getPositie();
                view.getTaNaamBeurt().setText(tekst);
            }
        });

        view.getSpeelBord().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("X: "+event.getX()+" | Y: "+event.getY());
            }
        });

        view.getBtnDobbel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        view.getBtnBouwen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("bouwen");
                view.getTainstructiesConsoleBox().setText(view.getTainstructiesConsoleBox().getText() + "\n x heeft gebouwd.");
            }
        });

        view.getBtnKoopGrond().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("grond");
                view.getTainstructiesConsoleBox().setText(view.getTainstructiesConsoleBox().getText() + "\n x heeft gekocht.");
            }
        });

    }
}

