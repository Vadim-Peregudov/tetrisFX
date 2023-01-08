package com.example.testris;


import com.example.testris.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
public class TetrisFxApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TetrisFxApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 800, Color.rgb(255, 255, 255));
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        MainController mm = fxmlLoader.getController();
        mm.setStage(stage);
        mm.start();
    }

    public static void main(String[] args) {
        launch();
    }
}