package be.kdg.view.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.awt.*;

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
        setLeft(new ImageView(new Image("monopolySpeelBord.png")));
    }
}



