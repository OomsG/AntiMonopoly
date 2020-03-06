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
    private Label lblNaamBeurt;
    private Button btnDobbel;
    private Button btnKoopGrond;
    private Button btnBouwen;
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
        btnBeurt = new Button("Beurt");
        btnBouwen = new Button("Bouwen");
        btnDobbel = new Button("Dobbel");
        btnKoopGrond = new Button("Kopen");
        lblNaamBeurt = new Label("Sander speelt");

    }

    private void layoutNodes() {
        // Controls aan GridPane toevoegen
        this.add(speelBord, 1, 0);
        speelBord.setFitHeight(700);
        speelBord.setFitWidth(800);
        this.add(scheidingsLijn, 1, 0);
        this.add(lblinstructiesConsoleBox, 2, 0);
        this.add(btnBeurt, 2, 0);
        this.add(btnDobbel,2,0);

        // Margins & Padding
        GridPane.setMargin(speelBord, new Insets(0, 20, 0, 45));

        GridPane.setMargin(scheidingsLijn, new Insets(0, 20, 0, 900));

        GridPane.setMargin(lblinstructiesConsoleBox, new Insets(50, 45, 800, 45));

        GridPane.setMargin(btnBeurt, new Insets(500, -50, 20, 30));
        btnBeurt.setPadding(new Insets(25, 39, 25, 39));

        GridPane.setMargin(btnDobbel, new Insets(300, -50, 20, 30));
        btnDobbel.setPadding(new Insets(25, 32, 25, 32));


        // CSS

        btnBeurt.setStyle("-fx-background-color: \n" +
                "        #a6b5c9,\n" +
                "        linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n" +
                "        linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);-fx-text-fill: WHITE;");
        btnBeurt.setFont(Font.font("Verdana", FontWeight.BOLD, 15));


        btnDobbel.setStyle("-fx-background-color: \n" +
                "        #a6b5c9,\n" +
                "        linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n" +
                "        linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);-fx-text-fill: WHITE;");
        btnDobbel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));



        //Extra

        btnDobbel.setGraphic(new ImageView(new Image("dice.png")));
        btnBeurt.setGraphic(new ImageView(new Image("wisselspeler.png")));
    }
}



