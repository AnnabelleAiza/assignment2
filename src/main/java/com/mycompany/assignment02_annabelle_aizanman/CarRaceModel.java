/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment02_annabelle_aizanman;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author annab
 */
public class CarRaceModel extends Group {
    private final Group frontWheel;
    private final Group rearWheel;
    private final RotateTransition frontRotation;
    private final RotateTransition rearRotation;
    
    public CarView(int num, Color color) {
        
        
        //wheels
        rearWheel = createWheel(25,50);
        frontWheen = creatWheel(105,50);
    }
    
    private Group creatWheel(double x, double y){
        
    }
    
    private RotateTransition createRotation(Group wheel){
        
    }
    
    public void startWheels(){
        
    }
    
    public void pauseWheels(){
        
    }
    
    public void stopWheels(){
    }    
}
