package be.kdg;

import be.kdg.model.MonopolyModel;
import be.kdg.spel.Spel;
import be.kdg.speler.Rol;
import be.kdg.speler.Speler;
import be.kdg.vak.*;
import be.kdg.view.MonopolyPresenter;
import be.kdg.view.MonopolyView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {
        Spel spel = new Spel();
        spel.maakSpelers();
        spel.maakBord();
        spel.startSpel();

    }

    @Override
    public void start(Stage primaryStage)  {
        MonopolyModel model =
                new MonopolyModel();
        MonopolyView view =
                new MonopolyView();
        new MonopolyPresenter(model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.show();

    }
}
