package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ToggleGroup aaa;
    @FXML
    RadioButton hVSh, hVSc, cVSc;
    @FXML
    Button b00, b01, b02, b10, b11, b12, b20, b21, b22, start;


    boolean turn = true;
    int turno = 0;

    public void onClick(javafx.event.ActionEvent actionEvent){

        RadioButton rb = (RadioButton)aaa.getSelectedToggle();
        if (rb!=null) {
            if (hVSh.isSelected()) hVSh(actionEvent);
            if (hVSc.isSelected()) hVSc(actionEvent);
        }

    }

    public void startButton() {
        reset();

        RadioButton rb = (RadioButton)aaa.getSelectedToggle();
        if (rb!=null) {
            if (cVSc.isSelected()) cVSc();
        }

    }

    private void reset() {
        b00.setText("");
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

    public void hVSc(javafx.event.ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        Button botonsico;
        boolean valid = false;
        List<Button> botonsicos = new ArrayList<>(Arrays.asList(b00, b01, b02, b10, b11, b12, b20, b21, b22));


        if (b.getText().equals("")){
                b.setText("X");


                while (!valid && turno <= 3){
                    int randomNum = (int) (Math.random() * 9);
                    botonsico = botonsicos.get(randomNum);

                    if (botonsico.getText().equals("")){
                        botonsico.setText("O");
                        valid = true;
                        turno++;
                    }

                }
                }

        }


        public void cVSc() {
            while (turno < 9){

                System.out.println(turno);
            List<Button> botonsicos = new ArrayList<>(Arrays.asList(b00, b01, b02, b10, b11, b12, b20, b21, b22));
            Button botonsico;
            System.out.println(botonsicos.toString());

            boolean valid = false;

            while(!valid){
                int randomNum = (int) (Math.random() * 9);
                botonsico = botonsicos.get(randomNum);

            if (botonsico.getText().equals("")) {
                if (turn) {
                    botonsico.setText("X");
                    turn = !turn;
                } else {
                    botonsico.setText("O");
                    turn = !turn;
                }
                valid = true;
            }

                //TODO método checkWin
            }
                turno++;

            }
            System.out.println("fin del while");

            }



        }

