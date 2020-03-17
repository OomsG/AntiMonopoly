package be.kdg.view.help;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import javax.swing.*;

public class HelpView extends GridPane
        /* layout type */ {
    private Image mainLogo;
    private Label lbMainLogo;
    private Text titelText;
    private Text mainText;
    private VBox vboxText;
    private Button btnTerug;

    // private Node attributen (controls)
    public HelpView () {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        vboxText = new VBox();
        mainLogo = new Image("/logo.png");
        lbMainLogo = new Label("", new ImageView(mainLogo));
        titelText = new Text(10,50,"Meer info over het spel");
        mainText = new Text(10,50,"In deze digitale versie van Anti-Monopoly is het de bedoeling dat je als\n" +
                " concurrent of monopolist probeert om zoveel mogelijk geld in je kas te houden. Lukt je dat niet, dan\n " +
                "kan dat schadelijke gevolgen voor je hebben. Het spel kent zijn einde vanaf het moment dat een speler\n " +
                "een saldo van 0€ heeft bereikt. Die speler is dan ook de verliezer van het spel.\n" +
                "\n" +
                "\n" +
                "Als concurrent of monopolist is het de bedoeling dat je huizen koopt en bouwt. Natuurlijk komen\n " +
                "er gedurende het spel ook andere interessante dingen op je af, zoals kanskaarten, fondsen, gevangenis, enzovoort.\n " +
                "Bij zo een fonds kan je bijvoorbeeld WC papieren twv van 100€ winnen.\n" +
                "\n" +
                "\n" +
                "Monopolisten kunnen enkel huizen en hotels bouwen als ze een monopolypositie in een stad hebben, terwijl de concurrenten\n " +
                "op elk eigendom mogen bouwen, ongeacht of ze een hele stad bezitten of een enkele straat.\n" +
                "\n" +
                "\n" +
                "Elk spel wordt gespeeld met 2 tot 4 spelers. Je kan een spel beginnen door de namen van de spelers en hun rollen\n " +
                "in te voeren en vervolgens op ‘Spel Beginnen’ te drukken.\n" +
                "\n" +
                "\n" +
                "Per spel wordt er tevens ook een ‘High Score’ bijgehouden. De speler met de hoogste score is degene\n " +
                "die binnen de kortste tijd het spel kon winnen.\n" +
                "\n" +
                "\n");
        btnTerug = new Button("Terug naar start");
        vboxText.getChildren().addAll(titelText,mainText,btnTerug);
        vboxText.setSpacing(20);
        vboxText.setPrefWidth(100);
        vboxText.setPrefHeight(150);

    }
    private void layoutNodes() {
        this.add(lbMainLogo, 0, 0,1,1);
        this.add(vboxText,0,1);
        GridPane.setMargin(lbMainLogo,new Insets(5,0,0,120));
        GridPane.setMargin(vboxText,new Insets(10,10,10,10));
        titelText.setFont(new Font(30));
        VBox.setMargin(titelText,new Insets(0,0,0,170));

        titelText.setStyle("-fx-font-weight: BOLD;");

        btnTerug.setStyle("-fx-background-color: \n" +
                "        #a6b5c9,\n" +
                "        linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n" +
                "        linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);-fx-text-fill: WHITE;-fx-font-weight: BOLD");


    }


    public Button getBtnTerug() {
        return btnTerug;
    }
}