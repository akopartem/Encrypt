package xyz.akopartem.encrypts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Encrypt");
        stage.getIcons().add(new Image("https://sun4-17.userapi.com/s/v1/ig2/a-mvUxYAVtQrlUOhnnOKaQFEnof_toFlXabTHC5edcPJ1M8HGgY5cSptLvp7U2gX8DPB8rRTx23fTTkGm84n9XcC.jpg?size=50x50&quality=96&crop=12,12,200,200&ava=1"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}