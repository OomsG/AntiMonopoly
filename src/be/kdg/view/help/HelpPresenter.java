package be.kdg.view.help;


import be.kdg.spelLogica.spel.Spel;
import be.kdg.view.start.StartPresenter;
import be.kdg.view.start.StartView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HelpPresenter {
    private Spel spel;;
    private HelpView view;
    public HelpPresenter(
            Spel model,
            HelpView view) {
        this.spel = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {
view.getBtnTerug().setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        StartView startView = new StartView();
        StartPresenter startPresenter = new StartPresenter(spel, startView);
        view.getScene().setRoot(startView);
        startView.getScene().getWindow().sizeToScene();
        startView.setStyle("-fx-background-image: url(achtergrond.jpg); -fx-background-position: center center");

    }
});
    }
    private void updateView() {
// Vult de view met data uit model
    }
}
