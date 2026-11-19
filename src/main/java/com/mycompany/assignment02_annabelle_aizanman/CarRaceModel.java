/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment02_annabelle_aizanman;

import javafx.scene.paint.Color;

/**
 *
 * @author annab
 */
public class CarRaceModel{
    private final String type;
    private final int number;
    private double x;
    private final double y;
    private double speed;
    private final Color color;
    
    public CarRaceModel(String type, int number, double x, double y, double speed, Color color){
        this.type = type;
        this.number = number;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
    }
    
    /**
     * updates the car's horizontal position by adding the distance traveled
     * @param distance  the distance traveled
     */
    public void updatePosition(double distance){
        x += distance;
    }
    
    /**
     * resets the car's position to the starting position
     * @param startingX the starting position
     */
    public void resetPosition(double startingX){
        x = startingX;
    }
    
    public String getType() {
        return type;
    }
    
    public int getNumber() {
        return number;
    }
    
    public double getX() {
        return x;
    }
    
    public double setX(double x){
        return this.x = x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public void setSpeed(double speed){
        this.speed = speed;
    }
    
    public Color getColor(){
        return color;
    }
}
