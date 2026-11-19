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
    
    @FXML
    private void initialize(){
        showCar();   
    }
    
    private void updateButtons(){
        previousBtn.setVisible(currentCar > 0);
        nextBtn.setVisible(currentCar < images.length-1);
    }
    
    private void showCar() {
        String path = "/images/" + images[currentCar];
    
        Image image = new Image(getClass().getResource(path).toExternalForm());
        carImage.setImage(image);
        countlbl.setText("Car "+ (currentCar + 1) + " of 4");
    }
    
        @FXML
    private void nextCar(){
        if(currentCar < images.length -1){
            currentCar++;
            showCar();
        }
    }
    
    @FXML
    private void previousCar(){
        if(currentCar >0){
            currentCar--;
            showCar();
        }
    }
    
    @FXML
    private void startRace() throws IOException{
        App.setRoot("primary");
//        Parent root = FXMLLoader.load(getClass.getResource(
//        "/com/mycompany/assignment02_annabelle_aizanman/primary.fxml"));
//        
//        Stage stage = (stage)startBtn.getScene();
//        stage.setScene(new Scene(root));
    }
}

  
