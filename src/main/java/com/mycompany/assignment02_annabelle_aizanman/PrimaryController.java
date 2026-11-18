package com.mycompany.assignment02_annabelle_aizanman;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

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
    private Pane racePane;
    @FXML
    private Label speedLbl;
    @FXML
    private Slider speedSlider;
    
    private CarRaceModel[] models;
    private CarView[] cars;
    private TranslateTransition[] movements;
    
    private List<Integer> finishOrder;
    
    private boolean raceStarted = false;
    private boolean raceFinished = false;
    private int finishedCount = 0;
    
    private static final double FINISH_X = 670;

    @FXML
    private void initialize() {
        models = new CarRaceModel[4];
        cars = new CarView[4];
        movements = new TranslateTransition[4];
        
        finishOrder = new ArrayList<>();
        
        models[0] = new CarRaceModel("Sports", 23, 20, 25, 115, Color.BLUE);
        models[1] = new CarRaceModel("Sedan", 45, 20, 125,130, Color.RED);
        models[2] = new CarRaceModel("Coupe", 78, 20, 225, 205, Color.GREEN);
        models[3] = new CarRaceModel("Racing", 88, 20, 325, 120, Color.ORANGE);
        
        for(int i = 0; i < models.length; i++){
            CarRaceModel model = models[i];
            
            //creates graphical car
            cars[i] = new CarView(
            model.getNumber(), model.getColor());
            
            //places car at the starting position
            cars[i].setX(model.getX());
            cars[i].setY(model.getY());
            
            //places car on the raceTrack
            racePane.getChildren().add(cars[i].getCarPane());
            
            createMovement(i);
        }
        
        speedSlider.valueProperty().addListener((obs, oldVal, newVal)->{
            double rate = newVal.doubleValue();
            
            speedLbl.setText(String.format("Simulation speed: %.1fx", rate));
            
            for(int i = 0; i < 4; i++){
                movements[i].setRate(rate);
                cars[i].setWheelrate(rate);
            }
        });
    }
    
    /**
     * Creates the movement animation for one car
     * @param idx the index of the car to work with
     */
    private void createMovement(int idx){
        CarRaceModel model = models[idx];
        double distance = FINISH_X - model.getX();
        double seconds = distance / model.getSpeed();
        
        TranslateTransition movement = new TranslateTransition(
            Duration.seconds(seconds), cars[idx].getCarPane());
        
        movement.setByX(distance);
        movement.setRate(speedSlider.getValue());
        movement.setOnFinished(event -> {
            carFinished(idx);
        });
        movements[idx] = movement;
    }

    @FXML
    private void startRace(ActionEvent event) {
        if(raceFinished){
            return;
        }
        
        for(int i = 0; i < 4; i++){
            movements[i].play();
            cars[i].startWheels();
        }
        
        raceStarted = true;
        resultsLbl.setText("Race in progress!");
    }

    @FXML
    private void pauseRace(ActionEvent event) {
        if(!raceStarted || raceFinished){
            return;
        }
        
        for(int i = 0; i < 4; i++){
            movements[i].pause();
            cars[i].pauseWheels();
        }
        
        resultsLbl.setText("Race Paused.");
    }

    @FXML
    private void resetRace(ActionEvent event) {
        for(int i = 0; i < 4; i++){
            movements[i].stop();
            cars[i].stopWheels();
            cars[i].getCarPane().setTranslateX(0);
            models[i].resetPosition(20);
            cars[i].setX(models[i].getX());
        }
        
        finishOrder.clear();
        finishedCount = 0;
        
        raceStarted = false;
        raceFinished = false;
        
        resultsLbl.setText("Waiting for race...");
    }
    
    public void carFinished(int idx){
        cars[idx].stopWheels();
        //updates model to record its final position
        models[idx].setX(FINISH_X);
        
        //adds cras index to the finishing order list
        finishOrder.add(idx);
        finishedCount++;
        
        //for the winner
        if(finishedCount == 1){
            CarRaceModel winner = models[idx];
            resultsLbl.setText("Winner: Car #" + winner.getNumber() + 
                    "(" + winner.getColor() + ")");
        }
        
        //once they are all finished
        if (finishedCount == 4) {
            raceFinished = true;
            raceStarted = false;
            displayResults();
        }
    }
    
    private void displayResults(){
        CarRaceModel winner = models[finishOrder.get(0)];
        
        String results = "Congratulations! Car #" + winner.getNumber() + 
                " is the winner!\n\n" + "Final Results:\n";
        
        for(int i = 0; i < finishOrder.size(); i++){
            int carIdx = finishOrder.get(i);
            results += (i + 1) + ". Car #" + models[carIdx].getNumber() + "\n";
            
        }
        
        resultsLbl.setText(results);
    }
}
