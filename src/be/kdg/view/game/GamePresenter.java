package be.kdg.view.game;


import be.kdg.model.MonopolyModel;
import be.kdg.view.start.StartPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class GamePresenter {
    private GameView view;
    private MonopolyModel model;

    public GamePresenter(MonopolyModel model, GameView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void addEventHandlers() {
        //view.getScene().
        view.getBtnBeurt().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String tekst = "Speler: "+ view.getSpel().getSpelers().get(0).getNaam()
                        +"\nRol: "+ view.getSpel().getSpelers().get(0).getRol()
                        +"\nSaldo: €"+ view.getSpel().getSpelers().get(0).getScore()
                        +"\nPositie: "+ view.getSpel().getSpelers().get(0).getPositie();
                view.getTaNaamBeurt().setText(tekst);
            }
        });
    }
}

