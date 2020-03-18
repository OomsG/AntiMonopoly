package be.kdg.view.start;

import be.kdg.spelLogica.spel.Spel;
import be.kdg.spelLogica.speler.Rol;
import be.kdg.view.game.GamePresenter;
import be.kdg.view.game.GameView;
import be.kdg.view.help.HelpPresenter;
import be.kdg.view.help.HelpView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;

import java.time.LocalTime;


public class StartPresenter {
    //private Spel model;
    private StartView view;
    private Spel spel;
    private LocalTime beginTijd;

    public StartPresenter(
            Spel model,
            StartView view) {
        this.spel = model;
        this.view = view;
        this.updateView();
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtnBevestigSpelers().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int aantalIngevuldeVelden = 0;
                if(!view.getTfNaamSpeler1().isEmpty()) aantalIngevuldeVelden++;
                if(!view.getTfNaamSpeler2().isEmpty()) aantalIngevuldeVelden++;
                if(!view.getTfNaamSpeler3().isEmpty()) aantalIngevuldeVelden++;
                if(!view.getTfNaamSpeler4().isEmpty()) aantalIngevuldeVelden++;
                if(aantalIngevuldeVelden >= 2){
                    spel = new Spel();
                    spel.maakSpelers(view.getTfNaamSpeler1(), view.getMonopolistOfConcurrent1(),
                            view.getTfNaamSpeler2(), view.getMonopolistOfConcurrent2(),
                            view.getTfNaamSpeler3(), view.getMonopolistOfConcurrent3(),
                            view.getTfNaamSpeler4(), view.getMonopolistOfConcurrent4());
                    spel.maakBord();
                    GameView gameView = new GameView();
                    GamePresenter gamePresenter = new GamePresenter(spel, gameView);
                    view.getScene().setRoot(gameView);
                    gameView.getScene().getWindow().sizeToScene();
                    gameView.setStyle("-fx-background-image: url(achtergrond.jpg); -fx-background-position: center center; -fx-background-size: 2000 1700");
                    gameView.setPrefWidth(100);
                    gameView.setPrefHeight(500);
                } else {
                    System.out.println("Niet genoeg users ingevuld");
                    view.getTitelMetUitleg().setVisible(true);
                }

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

        view.getHelpIcon().setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HelpView helpView = new HelpView();
                HelpPresenter helpPresenter = new HelpPresenter(spel, helpView);

                view.getScene().setRoot(helpView);
                helpView.getScene().getWindow().sizeToScene();
                helpView.setStyle("-fx-background-image: url(achtergrond.jpg); -fx-background-position: center center; -fx-background-size: 1024 950");

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


