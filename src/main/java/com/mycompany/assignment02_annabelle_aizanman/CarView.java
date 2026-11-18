/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment02_annabelle_aizanman;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;



/**
 *
 * @author annab
 */
public class CarView {
    private Pane carPane;
    
    private Circle frontWheel;
    private Circle rearWheel;
    private Line frontLine;
    private Line rearLine;
    
    private RotateTransition frontRotation;
    private RotateTransition rearRotation;
    
    public CarView(int num, Color color){
        carPane = new Pane();
        carPane.setPrefSize(140, 70);
        
        //car body/roof
        Polygon body = new Polygon(0,30,  20,30,  40,10,
        85,10,  105,30,  130,30,  130,55,  0,55);
        
        body.setFill(color);
        body.setStroke(Color.BLACK);
        
        
        //windows
        Rectangle window1 = new Rectangle(43,15,18,12);
        Rectangle window2 = new Rectangle(66,15,18,12);
        
        window1.setFill(Color.LIGHTBLUE);
        window2.setFill(Color.LIGHTBLUE);
        
        
        //wheels
        rearWheel = new Circle(25,55,12);
        frontWheel = new Circle(105,55,12);
        
        rearWheel.setFill(Color.BLACK);
        frontWheel.setFill(Color.BLACK);
        
        //lines on wheels
        rearLine = new Line(25,47, 25,63);
        frontLine = new Line(105,47, 105,63);
        
        rearLine.setStroke(Color.WHITE);
        frontLine.setStroke(Color.WHITE);
        
        rearLine.setStrokeWidth(3);
        frontLine.setStrokeWidth(3);
        
        //Car number
        Text carNumber = new Text(58,45, String.valueOf(num));
        
        carNumber.setFill(Color.WHITE);
        carNumber.setStyle("-fx-font-size:16px;");
        
        carPane.getChildren().addAll(body, window1, window2, rearWheel, frontWheel,
                rearLine, frontLine, carNumber);
        
        //rearRotation animation
        rearRotation = new RotateTransition(Duration.seconds(0.5), rearLine);
        rearRotation.setByAngle(360);
        rearRotation.setCycleCount(Animation.INDEFINITE);
        rearRotation.setInterpolator(Interpolator.LINEAR);
        
        //frontRotation animation
        frontRotation = new RotateTransition(Duration.seconds(0.5), frontLine);
        frontRotation.setByAngle(360);
        frontRotation.setCycleCount(Animation.INDEFINITE);
        frontRotation.setInterpolator(Interpolator.LINEAR);
    }
    
    public Pane getCarPane(){
        return carPane;
    }
    
    //to move the car horizontally
    public void setX(double x){
        carPane.setLayoutX(x);
    }
    
    //to move the car vertically
    public void setY(double y){
        carPane.setLayoutY(y);
    }
    
    //rotate the lines on the wheels to show that they turn
    public void rotateWheels(double angle){
        rearLine.setRotate(angle);
        frontLine.setRotate(angle);
    }
    
    public void startWheels(){
        rearRotation.play();
        frontRotation.play();
    }
    
    public void pauseWheels(){
        rearRotation.pause();
        frontRotation.pause();
    }
    
    public void stopWheels(){
        rearRotation.stop();
        frontRotation.stop();
        rearLine.setRotate(0);
        frontLine.setRotate(0);
    }
    
    public void setWheelrate(double rate){
        rearRotation.setRate(rate);
        frontRotation.setRate(rate);
    }
}
