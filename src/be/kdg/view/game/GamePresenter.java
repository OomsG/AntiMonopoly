package be.kdg.view.game;


import be.kdg.spelLogica.spel.Spel;
import be.kdg.spelLogica.speler.Speler;
import be.kdg.view.start.StartPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class GamePresenter {
    private GameView view;
    private Spel model;

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
                i++;
                if(i >= model.getSpelers().size()){
                    i = 0;
                }
                view.getTaNaamBeurt().setText("YOLO");
                /*String tekst = "Speler: "+ model.getSpelers().get(i).getNaam()
                        +"\nRol: "+ model.getSpelers().get(i).getRol()
                        +"\nSaldo: €"+ model.getSpelers().get(i).getScore()
                        +"\nPositie: "+ model.getSpelers().get(i).getPositie();
                view.getTaNaamBeurt().setText(tekst);*/
            }
        });

        view.getBtnDobbel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.dobbelNewPos(model.getSpelers().get(1));
            }
        });



    }
}

