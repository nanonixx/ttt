package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ToggleGroup aaa;
    @FXML
    RadioButton hVSh, hVSc, cVSc;
    boolean turn = true;

    public void onClick(javafx.event.ActionEvent actionEvent){

        RadioButton rb = (RadioButton)aaa.getSelectedToggle();
        if (rb!=null) {
            if (hVSh.isSelected()) hVSh(actionEvent);
            if (hVSc.isSelected()) hVSh(actionEvent);
            if (cVSc.isSelected()) hVSh(actionEvent);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void hVSh(javafx.event.ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();

        if (b.getText().equals("")){
            if (turn) {
                b.setText("X");
                turn = !turn;
            }
            else {
                b.setText("O");
                turn = !turn;
            }

            //TODO método checkWin

        }
    }

}
