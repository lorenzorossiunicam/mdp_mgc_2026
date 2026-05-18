package it.unicam.mdp_mgc_2026.interfaccegrafiche.javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MVC_C implements Initializable {


    @FXML private Label etichetta;
    @FXML private Button bottone;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        etichetta.setText("0");
        bottone.setOnAction(e -> {
            int num = Integer.parseInt(etichetta.getText());
            etichetta.setText(String.valueOf(num+1));
        });
    }
}
