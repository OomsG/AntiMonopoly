package be.kdg.view.game;

import be.kdg.spelLogica.spel.Spel;
import be.kdg.spelLogica.speler.Speler;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
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


    public GameView() {
        initialiseNodes();
        layoutNodes();

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
        //speelBord = new ImageView(new Image("monopolySpeelBord.png"));
        speelBord = new ImageView(new Image("monopolySpeelBordNummers.png"));
        scheidingsLijn = new ImageView(new Image("scheidingslijn.png"));
        tainstructiesConsoleBox = new TextArea("");
        tainstructiesConsoleBox.setEditable(false);
        btnBeurt = new Button("Beurt");
        btnBouwen = new Button("Bouwen");
        btnDobbel = new Button("Dobbel");
        btnKoopGrond = new Button("Kopen");
        taNaamBeurt = new TextArea("Druk op Beurt\nom te beginnen.");
        taNaamBeurt.setEditable(false);
    }

    public void toggleKoopGrond(boolean status){
        btnKoopGrond.setVisible(status);
        btnKoopGrond.setText("Kopen");
    }

    public void toggleGrondBouwen(boolean status){
        btnBouwen.setVisible(status);
        btnBouwen.setText("Bouwen");
    }

    public void toggleKoopGrond(boolean status, int prijs){
        btnKoopGrond.setVisible(status);
        btnKoopGrond.setText("Kopen €"+prijs);
    }

    public void toggleGrondBouwen(boolean status, int prijs, boolean isHuisGebouwd){
        btnBouwen.setVisible(status);
        if(!isHuisGebouwd){
            btnBouwen.setText("Bouwen €"+prijs);
        } else {
            btnBouwen.setText("Verkopen €"+prijs);
        }
    }

    public void toggleBeurtBtn(boolean status){
        btnBeurt.setVisible(status);
    }

    public void toggleDobbelBtn(boolean status){
        btnDobbel.setVisible(status);
    }

    public void updateGetTaNaamBeurt(Speler speler){
        String tekst = "Speler: "+ speler.getNaam()
                +"\nRol: "+ speler.getRol()
                +"\nSaldo: €"+ speler.getScore()
                +"\nPositie: "+ speler.getPositie()
                +"\nBezittingen: "+ speler.toonBezittingen();
        getTaNaamBeurt().setText(tekst);
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

    public ImageView getSpeelBord() {
        return speelBord;
    }

    public TextArea getTainstructiesConsoleBox() {
        return tainstructiesConsoleBox;
    }

    public void voegToeAanConsoleBox(String log){
        System.out.println(log);
        getTainstructiesConsoleBox().setText(log+"\n"+getTainstructiesConsoleBox().getText());
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
        hboxInterfaceKoopGrondEnBouwen.setMargin(btnKoopGrond, new Insets(0, 0, 0, 0));


        // Widths & Heights

        vboxInterface.setPrefWidth(200);
        hboxInterfaceKoopGrondEnBouwen.setPrefWidth(100);
        btnBeurt.setPrefWidth(212);
        btnBeurt.setPrefHeight(40);
        btnDobbel.setPrefWidth(212);
        btnDobbel.setPrefHeight(40);
        btnBouwen.setPrefWidth(280); //normaal 106
        btnBouwen.setPrefHeight(40);
        btnKoopGrond.setPrefWidth(270); //normaal 106
        btnKoopGrond.setPrefHeight(40);
        taNaamBeurt.setPrefHeight(160);
        tainstructiesConsoleBox.setPrefHeight(180);

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
        tainstructiesConsoleBox.setStyle("-fx-background-color: GREY; -fx-text-alignment:CENTER; -fx-alignment: CENTER; -fx-border-color: linear-gradient(#303842 0%, #3e5577 20%, #375074 100%);-fx-border-width: 6");

        // Icons

        btnDobbel.setGraphic(new ImageView(new Image("dice.png")));
        btnBeurt.setGraphic(new ImageView(new Image("wisselspeler.png")));
        tainstructiesConsoleBox.setFont(Font.font("Verdana", FontWeight.BOLD, 8));




    }
}



