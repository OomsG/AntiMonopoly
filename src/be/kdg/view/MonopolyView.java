package be.kdg.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import javax.swing.*;
import java.awt.*;

public class MonopolyView extends BorderPane
        /* layout type */ {
    // private Node attributen (controls)
    private javafx.scene.control.TextField tfNaamSpeler1;
    private Button btnBevestigNaam1;
    private Image mainLogo;
    private Label lbMainLogo;


    public MonopolyView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        tfNaamSpeler1 = new javafx.scene.control.TextField("Naam speler 1");
        btnBevestigNaam1 = new javafx.scene.control.Button("Speler 1 bevestigen");
        mainLogo = new Image("/logo.png");
        lbMainLogo = new Label("", new ImageView(mainLogo));



// Initialisatie van de Nodes
// bvb.:
// button = new Button("...")
// label = new Label("...")
    }

    private void layoutNodes() {
        setCenter(tfNaamSpeler1);
        setBottom(btnBevestigNaam1);
        setTop(lbMainLogo);
        setAlignment(lbMainLogo,Pos.TOP_CENTER);
        setAlignment(tfNaamSpeler1, Pos.TOP_CENTER);
        setAlignment(btnBevestigNaam1,Pos.BOTTOM_CENTER);
        tfNaamSpeler1.setPadding(new Insets(25,35,25,35));

        btnBevestigNaam1.setPadding(new Insets(20,20,20,20));

// Layout van de Nodes
// add… methodes (of set…)
// Insets, padding, alignment, …
    }

// implementatie van de nodige
// package-private Getters
}

