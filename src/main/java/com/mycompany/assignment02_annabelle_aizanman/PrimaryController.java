package com.mycompany.assignment02_annabelle_aizanman;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PrimaryController {

    @FXML
    private VBox buttonsVBox;
    @FXML
    private Button startBtn;
    @FXML
    private Button pauseBtn;
    @FXML
    private Button resetBtn;
    @FXML
    private VBox raceResultsVBox;
    @FXML
    private Label resultsLbl;
    @FXML
    private Label winnerLbl;
    @FXML
    private Pane racePane;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
