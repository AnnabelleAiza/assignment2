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
    
    /**
     * Creates the image of the car using geometric shapes
     * @param num the number on the car
     * @param color the color of the car
     */
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
    
    /**
     * moves the car horizontally
     * @param x the horizontal position
     */
    public void setX(double x){
        carPane.setLayoutX(x);
    }
    
    /**
     * moves the car vertically to make sure its in the proper position
     * @param y the vertical position of the car
     */
    public void setY(double y){
        carPane.setLayoutY(y);
    }
    
    /**
     * rotate the lines on the wheels to make them appear to spin
     * @param angle  the angle of rotation in degrees
     */
    public void rotateWheels(double angle){
        rearLine.setRotate(angle);
        frontLine.setRotate(angle);
    }
    
    /**
     * starts the turning of the wheels
     */
    public void startWheels(){
        rearRotation.play();
        frontRotation.play();
    }
    
    /**
     * pauses the turning of the wheels
     */
    public void pauseWheels(){
        rearRotation.pause();
        frontRotation.pause();
    }
    
    /**
     * stops the turning of the wheels
     */
    public void stopWheels(){
        rearRotation.stop();
        frontRotation.stop();
        rearLine.setRotate(0);
        frontLine.setRotate(0);
    }
    
    /**
     * sets the rate at which the wheels turn
     * @param rate 
     */
    public void setWheelrate(double rate){
        rearRotation.setRate(rate);
        frontRotation.setRate(rate);
    }
}
