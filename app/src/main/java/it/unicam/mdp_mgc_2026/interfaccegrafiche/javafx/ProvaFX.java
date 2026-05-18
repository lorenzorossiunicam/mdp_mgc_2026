package it.unicam.mdp_mgc_2026.interfaccegrafiche.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ProvaFX extends Application {

    @Override
    public void start(Stage stage) {
        Circle c = new Circle(100, Color.RED);
        Rectangle r = new Rectangle(200, 200, Color.BLUE);
        Scene s = new Scene(new Pane(c, r), 300, 300);
        r.setX(100);
        r.setY(100);
        stage.setScene(s);
        stage.show();
//        String javaVersion = System.getProperty("java.version");
//        String javafxVersion = System.getProperty("javafx.version");
//        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        //l.rotateProperty().set(45);
//        //l.setBackground(Background.fill(Color.RED));
//        //l.setStyle("-fx-background-color: rgba(231,19,119,0.41)");
//        //l.getStyleClass().add("label");
//        //ImageView image = new ImageView(new Image("logo.png"));
//        VBox vBox = new VBox(l);//,image);
//        vBox.setSpacing(10);
//        vBox.setAlignment(Pos.CENTER);
//        Scene scene = new Scene(vBox, 640, 480);
//        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}