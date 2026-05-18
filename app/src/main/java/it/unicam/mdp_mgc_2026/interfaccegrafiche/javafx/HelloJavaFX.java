package it.unicam.mdp_mgc_2026.interfaccegrafiche.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloJavaFX extends Application {


    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        l.rotateProperty().set(45);
        //l.setBackground(Background.fill(Color.RED));
        //l.setStyle("-fx-background-color: rgba(231,19,119,0.41)");
        l.getStyleClass().add("label");
        ImageView image = new ImageView(new Image("logo.png"));
        VBox vBox = new VBox(l,image);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 640, 480);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}