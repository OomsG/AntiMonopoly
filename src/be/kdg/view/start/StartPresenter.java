package be.kdg.view.start;

import be.kdg.spelLogica.spel.Spel;
import be.kdg.spelLogica.speler.Rol;
import be.kdg.view.game.GamePresenter;
import be.kdg.view.game.GameView;
import be.kdg.model.MonopolyModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;


public class StartPresenter {
    private MonopolyModel model;
    private StartView view;

    public StartPresenter(
            MonopolyModel model,
            StartView view) {
        this.model = model;
        this.view = view;
        this.updateView();
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtnBevestigSpelers().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                GameView gameView = new GameView();
                GamePresenter gamePresenter = new GamePresenter(model, gameView);
                view.getScene().setRoot(gameView);
                gameView.getScene().getWindow().sizeToScene();
                Spel spel = new Spel();

               /* int aantalIngevuldeVelden = 0;
                if(view.getTfNaamSpeler1().isBlank()) aantalIngevuldeVelden++;
                if(view.getTfNaamSpeler2().isBlank()) aantalIngevuldeVelden++;
                if(view.getTfNaamSpeler3().isBlank()) aantalIngevuldeVelden++;
                if(view.getTfNaamSpeler4().isBlank()) aantalIngevuldeVelden++;
                if(aantalIngevuldeVelden < 2) event.consume();*/

                spel.maakSpelers(view.getTfNaamSpeler1(), view.getMonopolistOfConcurrent1(),
                                 view.getTfNaamSpeler2(), view.getMonopolistOfConcurrent2(),
                                 view.getTfNaamSpeler3(), view.getMonopolistOfConcurrent3(),
                                 view.getTfNaamSpeler4(), view.getMonopolistOfConcurrent4());
                spel.maakBord();


            }
        });
    }


    public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Hierdoor stopt het spel!");
                alert.setContentText("Ben je zeker?");
                alert.setTitle("Waarschuwing!");
                alert.getButtonTypes().clear();
                ButtonType neen = new ButtonType("Nee");
                ButtonType ja = new ButtonType("Ja");
                alert.getButtonTypes().addAll(neen, ja);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals(neen)) {
                    event.consume();
                }
            }
        });
    }

// Koppelt event handlers (anon. inner klassen)
// aan de controls uit de view.
// Event handlers: roepen methodes aan uit het
// model en zorgen voor een update van de view.

    private void updateView() {
// Vult de view met data uit model
    }
}


