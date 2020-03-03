package be.kdg.spelerEenView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.awt.*;

public class MonopolyView extends GridPane
        /* layout type */ {
    // private Node attributen (controls)
    private javafx.scene.control.TextField tfNaamSpeler1;
    private javafx.scene.control.TextField tfNaamSpeler2;
    private javafx.scene.control.TextField tfNaamSpeler3;
    private javafx.scene.control.TextField tfNaamSpeler4;
    private Button btnBevestigSpelers;
    private Image mainLogo;
    private Label lbMainLogo;


    public MonopolyView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        tfNaamSpeler1 = new javafx.scene.control.TextField("Naam speler 1");
        tfNaamSpeler2 = new javafx.scene.control.TextField("Naam speler 2");
        tfNaamSpeler3 = new javafx.scene.control.TextField("Naam speler 3");
        tfNaamSpeler4 = new javafx.scene.control.TextField("Naam speler 4");
        btnBevestigSpelers = new javafx.scene.control.Button("Spelers bevestigen");
        mainLogo = new Image("/logo.png");
        lbMainLogo = new Label("", new ImageView(mainLogo));


// Initialisatie van de Nodes
// bvb.:
// button = new Button("...")
// label = new Label("...")
    }

    private void layoutNodes() {
        this.add(lbMainLogo, 0, 1, 2, 1);
        this.add(tfNaamSpeler1, 0, 2,1,1);
        this.add(tfNaamSpeler2, 1, 2,1,1);
        this.add(tfNaamSpeler3, 0, 4);
        this.add(tfNaamSpeler4, 1, 4);
        this.add(btnBevestigSpelers, 0, 5);

        this.tfNaamSpeler1.setMaxWidth(200);
        this.tfNaamSpeler2.setMaxWidth(200);
        this.tfNaamSpeler3.setMaxWidth(200);
        this.tfNaamSpeler4.setMaxWidth(200);
        GridPane.setMargin(tfNaamSpeler1, new Insets(20, 20, 20, 10));
        GridPane.setMargin(tfNaamSpeler2, new Insets(20, 20, 20, 10));
        GridPane.setMargin(tfNaamSpeler3, new Insets(5, 20, 20, 10));
        GridPane.setMargin(tfNaamSpeler4, new Insets(5, 20, 20, 10));


        GridPane.setMargin(btnBevestigSpelers, new Insets(5, 20, 20, 150));



// Layout van de Nodes
// add… methodes (of set…)
// Insets, padding, alignment, …
    }

// implementatie van de nodige
// package-private Getters
}

