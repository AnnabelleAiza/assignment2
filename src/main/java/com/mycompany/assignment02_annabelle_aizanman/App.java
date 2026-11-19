package com.mycompany.assignment02_annabelle_aizanman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("slideshow"), 700, 400);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * loads the requested FXML file to display a screen
     * @param fxml the name of the FXML file to load
     * @return the root node of the loaded FXML file
     * @throws IOException if the FXML file cannot be loaded
     */
    private static Parent loadFXML(String fxml) throws IOException {
        String path;
        
        if(fxml.equals("slideshow")){
            path = "/fxml/slideshow.fxml";
        }else{
            path = "/com/mycompany/assignment02_annabelle_aizanman/" + fxml + ".fxml";
        }
        
        FXMLLoader loader = new FXMLLoader(App.class.getResource(path));
        return loader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}