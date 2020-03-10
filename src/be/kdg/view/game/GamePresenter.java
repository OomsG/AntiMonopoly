package be.kdg.view.game;


import be.kdg.model.MonopolyModel;
import be.kdg.spelLogica.speler.Speler;
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

    int i = -1;
    private void addEventHandlers() {
        //view.getScene().
        view.getBtnBeurt().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                i++;
                if(i >= view.getSpel().getSpelers().size()){
                    i = 0;
                }
                String tekst = "Speler: "+ view.getSpel().getSpelers().get(i).getNaam()
                        +"\nRol: "+ view.getSpel().getSpelers().get(i).getRol()
                        +"\nSaldo: €"+ view.getSpel().getSpelers().get(i).getScore()
                        +"\nPositie: "+ view.getSpel().getSpelers().get(i).getPositie();
                view.getTaNaamBeurt().setText(tekst);
            }
        });
    }
}

