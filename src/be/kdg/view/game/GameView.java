package be.kdg.view.game;

import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class GameView extends BorderPane {
    private Text test;

    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
test = new Text("test");
    }

    private void layoutNodes() {
setCenter(test);
    }
}



