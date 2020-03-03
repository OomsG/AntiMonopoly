package be.kdg;

import be.kdg.model.MonopolyModel;
import be.kdg.spel.Spel;
import be.kdg.start.MonopolyPresenter;
import be.kdg.start.MonopolyView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage)  {
        MonopolyModel model = new MonopolyModel();
        MonopolyView view = new MonopolyView();
       MonopolyPresenter startPresenter = new MonopolyPresenter(model, view);
        primaryStage.setScene(new Scene(view));
        startPresenter.addWindowEventHandlers();
        primaryStage.show();
        primaryStage.setResizable(false);

    }

    public static void main(String[] args) throws InterruptedException {
        Application.launch(args);
        Spel spel = new Spel();
        spel.maakSpelers();
        spel.maakBord();
        spel.startSpel();


    }


}
