package be.kdg.view;

import be.kdg.model.MonopolyModel;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;

public class MonopolyPresenter {
        private MonopolyModel model;
        private MonopolyView view;
        public MonopolyPresenter(
                MonopolyModel model,
                MonopolyView view) {
            this.model = model;
            this.view = view;
            this.updateView();
        }

// Koppelt event handlers (anon. inner klassen)
// aan de controls uit de view.
// Event handlers: roepen methodes aan uit het
// model en zorgen voor een update van de view.
        
        private void updateView() {
// Vult de view met data uit model
        }
    }


