package be.kdg.view.start;

import be.kdg.spelLogica.speler.Rol;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static java.awt.Color.black;

public class StartView extends GridPane
        /* layout type */ {

    // private Node attributen (controls)
    private final ObservableList<Rol> monopolistOfConcurrentComboBoxKeuze = FXCollections.observableArrayList(
            Rol.MONOPOLIST,
            Rol.CONCURRENT
    );
    private javafx.scene.control.TextField tfNaamSpeler1;
    private javafx.scene.control.TextField tfNaamSpeler2;
    private javafx.scene.control.TextField tfNaamSpeler3;
    private javafx.scene.control.TextField tfNaamSpeler4;
    private Text titelMetUitleg;
    private ComboBox monopolistOfConcurrent1;
    private ComboBox monopolistOfConcurrent2;
    private ComboBox monopolistOfConcurrent3;
    private ComboBox monopolistOfConcurrent4;
    private Button btnBevestigSpelers;
    private Image mainLogo;
    private Label lbMainLogo;


    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        titelMetUitleg = new Text("Geef alstublieft de namen van de spelers en hun rol in.");
        tfNaamSpeler1 = new javafx.scene.control.TextField();
        tfNaamSpeler1.setPromptText("Naam speler 1");
        tfNaamSpeler2 = new javafx.scene.control.TextField();
        tfNaamSpeler2.setPromptText("Naam speler 2");
        tfNaamSpeler3 = new javafx.scene.control.TextField();
        tfNaamSpeler3.setPromptText("Naam speler 3");
        tfNaamSpeler4 = new javafx.scene.control.TextField();
        tfNaamSpeler4.setPromptText("Naam speler 4");
        btnBevestigSpelers = new javafx.scene.control.Button("Spelers bevestigen");
        mainLogo = new Image("/logo.png");
        lbMainLogo = new Label("", new ImageView(mainLogo));
        monopolistOfConcurrent1 = new ComboBox(monopolistOfConcurrentComboBoxKeuze);
        monopolistOfConcurrent2 = new ComboBox(monopolistOfConcurrentComboBoxKeuze);
        monopolistOfConcurrent3 = new ComboBox(monopolistOfConcurrentComboBoxKeuze);
        monopolistOfConcurrent4 = new ComboBox(monopolistOfConcurrentComboBoxKeuze);


// Initialisatie van de Nodes
// bvb.:
// button = new Button("...")
// label = new Label("...")
    }

    private void layoutNodes() {

        // Controls aan GridPane toevoegen
        this.add(titelMetUitleg, 0, 1, 2, 1);
        this.add(lbMainLogo, 0, 0, 2, 1);
        this.add(tfNaamSpeler1, 0, 2, 1, 1);
        this.add(tfNaamSpeler2, 1, 2, 1, 1);
        this.add(tfNaamSpeler3, 0, 4);
        this.add(tfNaamSpeler4, 1, 4);
        this.add(monopolistOfConcurrent1, 0, 2, 1, 1);
        this.add(monopolistOfConcurrent2, 1, 2, 1, 1);
        this.add(monopolistOfConcurrent3, 0, 4);
        this.add(monopolistOfConcurrent4, 1, 4);
        this.add(btnBevestigSpelers, 0, 5);

        // Extra
        this.tfNaamSpeler1.setMaxWidth(150);
        this.tfNaamSpeler2.setMaxWidth(150);
        this.tfNaamSpeler3.setMaxWidth(150);
        this.tfNaamSpeler4.setMaxWidth(150);
        titelMetUitleg.setFill(Color.RED);
        titelMetUitleg.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        // Margins
        GridPane.setMargin(lbMainLogo, new Insets(0, 8, 5, 12));
        GridPane.setMargin(titelMetUitleg, new Insets(0, 0, -25, 45));
        GridPane.setMargin(tfNaamSpeler1, new Insets(5, 20, 10, 30));
        GridPane.setMargin(tfNaamSpeler2, new Insets(5, 20, 10, 10));
        GridPane.setMargin(tfNaamSpeler3, new Insets(5, 20, 20, 30));
        GridPane.setMargin(tfNaamSpeler4, new Insets(5, 20, 20, 10));
        GridPane.setMargin(btnBevestigSpelers, new Insets(5, 0, 20, 180));
        GridPane.setMargin(monopolistOfConcurrent1, new Insets(90, 20, 20, 30));
        GridPane.setMargin(monopolistOfConcurrent2, new Insets(90, 20, 20, 10));
        GridPane.setMargin(monopolistOfConcurrent3, new Insets(70, 20, 20, 30));
        GridPane.setMargin(monopolistOfConcurrent4, new Insets(70, 20, 20, 10));

        // CSS
        btnBevestigSpelers.setStyle("-fx-background-color: \n" +
                "        #a6b5c9,\n" +
                "        linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n" +
                "        linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);-fx-text-fill: WHITE;-fx-font-weight: BOLD");


    }



    public TextField getTfNaamSpeler1() {
        return tfNaamSpeler1;
    }

    public TextField getTfNaamSpeler2() {
        return tfNaamSpeler2;
    }

    public TextField getTfNaamSpeler3() {
        return tfNaamSpeler3;
    }

    public TextField getTfNaamSpeler4() {
        return tfNaamSpeler4;
    }

    public ComboBox getMonopolistOfConcurrent1() {
        return monopolistOfConcurrent1;
    }

    public ComboBox getMonopolistOfConcurrent2() {
        return monopolistOfConcurrent2;
    }

    public ComboBox getMonopolistOfConcurrent3() {
        return monopolistOfConcurrent3;
    }

    public ComboBox getMonopolistOfConcurrent4() {
        return monopolistOfConcurrent4;
    }

    public Button getBtnBevestigSpelers() {
        return btnBevestigSpelers;
    }


    // implementatie van de nodige
// package-private Getters
}

