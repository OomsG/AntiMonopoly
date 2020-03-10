package be.kdg.view.game;


import be.kdg.model.MonopolyModel;


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

    }
}

