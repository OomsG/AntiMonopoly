package be.kdg;

import be.kdg.model.MonopolyModel;
import be.kdg.spel.Spel;
import be.kdg.view.start.StartPresenter;
import be.kdg.view.start.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage)  {
        MonopolyModel model = new MonopolyModel();
        StartView view = new StartView();
       StartPresenter startPresenter = new StartPresenter(model, view);
        primaryStage.setScene(new Scene(view));
        startPresenter.addWindowEventHandlers();
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("pictogram.png"));
        primaryStage.setTitle("Anti-Monopoly | Spelen maar!");

    }

    public static void main(String[] args) throws InterruptedException {
        //Application.launch(args);
        Spel spel = new Spel();
        spel.maakSpelers();
        spel.maakBord();
        spel.startSpel();


    }


}
