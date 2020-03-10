package be.kdg.view.game;

import be.kdg.spelLogica.spel.Spel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private TextArea tainstructiesConsoleBox;
    private TextArea taNaamBeurt;
    private Button btnDobbel;
    private Button btnKoopGrond;
    private Button btnBouwen;
    private javafx.scene.control.Button btnBeurt;
    private HBox hboxBord;
    private HBox hboxScheidingslijn;
    private VBox vboxInterface;
    private HBox hboxInterfaceKoopGrondEnBouwen;
    private Spel spel;


    public GameView(Spel spel) {
        initialiseNodes();
        layoutNodes();
        this.spel = spel;

    }

    public Spel getSpel() {
        return spel;
    }

    private void initialiseNodes() {
        hboxBord = new HBox();
        hboxScheidingslijn = new HBox();
        vboxInterface = new VBox();
        hboxInterfaceKoopGrondEnBouwen = new HBox();
        hboxInterfaceKoopGrondEnBouwen.setSpacing(10);
        vboxInterface.setSpacing(40);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //controls
        speelBord = new ImageView(new Image("monopolySpeelBord.png"));
        scheidingsLijn = new ImageView(new Image("scheidingslijn.png"));
        tainstructiesConsoleBox = new TextArea("labelInstructiesConsoleBox");
        tainstructiesConsoleBox.setEditable(false);
        btnBeurt = new Button("Beurt");
        btnBouwen = new Button("Bouwen");
        btnDobbel = new Button("Dobbel");
        btnKoopGrond = new Button("Kopen");
        taNaamBeurt = new TextArea(" Speler: " +"\n Saldo: xxx€ \n Positie: n");
        taNaamBeurt.setEditable(false);
    }

    public TextArea getTaNaamBeurt() {
        return taNaamBeurt;
    }

    public Button getBtnDobbel() {
        return btnDobbel;
    }

    public Button getBtnKoopGrond() {
        return btnKoopGrond;
    }

    public Button getBtnBouwen() {
        return btnBouwen;
    }

    public Button getBtnBeurt() {
        return btnBeurt;
    }

    private void layoutNodes() {
        // Controls aan boxen toevoegen
        hboxBord.getChildren().addAll(speelBord);
        speelBord.setFitHeight(700);
        speelBord.setFitWidth(800);
        hboxScheidingslijn.getChildren().addAll(scheidingsLijn);
        hboxInterfaceKoopGrondEnBouwen.getChildren().addAll(btnKoopGrond, btnBouwen);
        vboxInterface.getChildren().addAll(tainstructiesConsoleBox, taNaamBeurt, btnDobbel, btnBeurt, hboxInterfaceKoopGrondEnBouwen);

        // Boxen aan GridPane toevoegen

        this.add(hboxBord, 1, 0);
        this.add(hboxScheidingslijn, 2, 0);
        this.add(vboxInterface, 3, 0);


        // Margins & Padding

        GridPane.setMargin(hboxScheidingslijn, new Insets(20, 40, 20, 40));
        GridPane.setMargin(hboxBord, new Insets(20, 0, 20, 0));
        GridPane.setMargin(vboxInterface, new Insets(20, 40, 20, 10));
        hboxInterfaceKoopGrondEnBouwen.setMargin(btnKoopGrond, new Insets(0, 40, 0, 0));


        // Widths & Heights

        vboxInterface.setPrefWidth(200);
        hboxInterfaceKoopGrondEnBouwen.setPrefWidth(100);
        btnBeurt.setPrefWidth(212);
        btnBeurt.setPrefHeight(40);
        btnDobbel.setPrefWidth(212);
        btnDobbel.setPrefHeight(40);
        btnBouwen.setPrefWidth(106);
        btnBouwen.setPrefHeight(40);
        btnKoopGrond.setPrefWidth(106);
        btnKoopGrond.setPrefHeight(40);
        taNaamBeurt.setPrefHeight(100);
        tainstructiesConsoleBox.setPrefHeight(150);

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

        btnKoopGrond.setStyle("-fx-background-color: \n" +
                "        #a6b5c9,\n" +
                "        linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n" +
                "        linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);-fx-text-fill: WHITE;");

        btnBouwen.setStyle("-fx-background-color: \n" +
                "        #a6b5c9,\n" +
                "        linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n" +
                "        linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);-fx-text-fill: WHITE;");

        taNaamBeurt.setStyle("-fx-background-color: GREY; -fx-text-alignment:CENTER; -fx-alignment: CENTER; -fx-font-weight: BOLD; -fx-border-color: linear-gradient(#303842 0%, #3e5577 20%, #375074 100%);-fx-border-width: 6");
        tainstructiesConsoleBox.setStyle("-fx-background-color: GREY; -fx-text-alignment:CENTER; -fx-alignment: CENTER; -fx-font-weight: BOLD; -fx-border-color: linear-gradient(#303842 0%, #3e5577 20%, #375074 100%);-fx-border-width: 6");

        // Icons

        btnDobbel.setGraphic(new ImageView(new Image("dice.png")));
        btnBeurt.setGraphic(new ImageView(new Image("wisselspeler.png")));


    }
}



