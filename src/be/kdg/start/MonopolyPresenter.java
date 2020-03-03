package be.kdg.start;

import be.kdg.model.MonopolyModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;


public class MonopolyPresenter {
        private MonopolyModel model;
        private MonopolyView view;
        public MonopolyPresenter(
                MonopolyModel model,
                MonopolyView view) {
            this.model = model;
            this.view = view;
            this.updateView();
        }
/*
    private void addEventHandlers() {
        MonopolyView.getBtnBevestigSpelers().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameView gameView = new GameView();
                GamePresenter gamePresenter = new GamePresenter(model, gameView);
                view.getScene().setRoot(gameView);
                gameView.getScene().getWindow().sizeToScene();
            }
        });
    }

 */

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


