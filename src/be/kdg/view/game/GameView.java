package be.kdg.view.game;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.*;

public class GameView extends GridPane {
    //private Text test;
    private ImageView speelBord;
    private ImageView scheidingsLijn;
    private Label lblinstructiesConsoleBox;
    private javafx.scene.control.Button btnBeurt;


    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        //test = new Text("Console box hier");
        //test.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        speelBord = new ImageView(new Image("monopolySpeelBord.png"));
        scheidingsLijn = new ImageView(new Image("scheidingslijn.png"));
        lblinstructiesConsoleBox = new Label("labelInstructiesConsoleBox");
        btnBeurt = new Button("Volgende beurt");

    }

    private void layoutNodes() {
        this.add(speelBord, 1, 0);
        speelBord.setFitHeight(900);
        speelBord.setFitWidth(1000);
        GridPane.setMargin(speelBord, new Insets(15, 20, 15, 45));
        this.add(scheidingsLijn, 1, 0);
        GridPane.setMargin(scheidingsLijn, new Insets(0, 20, 0, 1100));
        this.add(lblinstructiesConsoleBox, 2, 0);
        GridPane.setMargin(lblinstructiesConsoleBox, new Insets(0, 45, 800, 45));
        this.add(btnBeurt, 2, 0);
        GridPane.setMargin(btnBeurt, new Insets(150, 45, 200, 70));
        btnBeurt.setPadding(new Insets(20, 20, 20, 20));
        lblinstructiesConsoleBox.setStyle("-fx-effect: dropshadow(one-pass-box, black, 100, 0.1, 1, 1);");

    }
}



