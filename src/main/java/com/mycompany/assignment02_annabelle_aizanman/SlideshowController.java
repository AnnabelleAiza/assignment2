/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment02_annabelle_aizanman;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author annab
 */
public class SlideshowController {
    
    @FXML
    private ImageView carImage;
    
    @FXML
    private Button nextBtn;
    
    @FXML
    private Button previousBtn;
    
    @FXML
    private Button startBtn;

    @FXML
    private Label carLbl;

    @FXML
    private Label countlbl;
    
    private int currentCar = 0;
    
    private String[] images = {"car1.png", "car2.png", "car3.png", "car4.png"};
    
    private MediaPlayer player;
    
    @FXML
    private void initialize(){
        showCar(); 
        
        String soundPath = getClass().getResource("/sounds/engine.mp3").toExternalForm();
        Media sound = new Media(soundPath);
        player = new MediaPlayer(sound);
        player.play();
    }
    
    /**
     * updates the previous and next buttons so they aren't seen when unnecessary
     */
    private void updateButtons(){
        previousBtn.setVisible(currentCar > 0);
        
        nextBtn.setVisible(currentCar < images.length-1);
    }
    
    /**
     * shows the drawings of the cars that I drew in the slideshow
     */
    private void showCar() {
        String path = "/images/" + images[currentCar];
    
        Image image = new Image(getClass().getResource(path).toExternalForm());
        carImage.setImage(image);
        countlbl.setText("Car "+ (currentCar + 1) + " of 4");
        updateButtons();
    }
    
    /**
     * lets the slideshow go to the next slide
     */
    @FXML
    private void nextCar(){
        if(currentCar < images.length -1){
            currentCar++;
            showCar();
        }
    }
    
    /**
     * lets the slideshow go to the last slide
     */
    @FXML
    private void previousCar(){
        if(currentCar >0){
            currentCar--;
            showCar();
        }
    }
    
    /**
     * brings you to the next slide where the race takes place
     * @throws IOException can occur if java has trouble reading the FXML file,
     * it tells java that this method might produce that error
     */
    @FXML
    private void startRace() throws IOException{
        App.setRoot("primary");
    }
}

  
