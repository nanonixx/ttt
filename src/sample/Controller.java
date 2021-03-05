package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    Label win;


    boolean turn = true;
    int turno = 0;
    boolean finish = false;

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
        finish = false;
        turno = 0;
        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");
    }

    private boolean checkWin(String letra) {
        //howizontales
        if (b00.getText().equals(letra) && b01.getText().equals(letra) && b02.getText().equals(letra) ) return true;
        else if (b10.getText().equals(letra) && b11.getText().equals(letra) && b12.getText().equals(letra) ) return true;
        else if (b20.getText().equals(letra) && b21.getText().equals(letra) && b22.getText().equals(letra) ) return true;

            //verticales

        else if (b00.getText().equals(letra) && b10.getText().equals(letra) && b20.getText().equals(letra) ) return true;
        else if (b01.getText().equals(letra) && b11.getText().equals(letra) && b21.getText().equals(letra) ) return true;
        else if (b02.getText().equals(letra) && b12.getText().equals(letra) && b22.getText().equals(letra) ) return true;


        //diagonales

        else if (b00.getText().equals(letra) && b11.getText().equals(letra) && b22.getText().equals(letra) ) return true;
        else if (b02.getText().equals(letra) && b11.getText().equals(letra) && b20.getText().equals(letra) ) return true;

        else return false;

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void hVSh(javafx.event.ActionEvent actionEvent) {
        if (!finish) {

        Button b = (Button) actionEvent.getSource();

        if (b.getText().equals("")){
            if (turn) {
                b.setText("X");
                if (checkWin("X")){
                    finish = true;
                    System.out.println("X wins!");
                }
                turn = !turn;
            }
            else {
                b.setText("O");
                if (checkWin("O")) {
                    finish = true;
                    System.out.println("O wins!");
                    //TODO: pasarlo a un label
                }
                turn = !turn;
            }

            if (finish) System.out.println("GAME OVER");

        }

        }
    }

    public void hVSc(javafx.event.ActionEvent actionEvent) {
        if (!finish) {
            Button b = (Button) actionEvent.getSource();
            Button botonsico;
            boolean valid = false;
            List<Button> botonsicos = new ArrayList<>(Arrays.asList(b00, b01, b02, b10, b11, b12, b20, b21, b22));


            if (b.getText().equals("")) {
                b.setText("X");

                if (checkWin("X")) {
                    finish = true;
                    System.out.println("X wins!");
                }


                while (!valid && turno <= 3) {
                    int randomNum = (int) (Math.random() * 9);
                    botonsico = botonsicos.get(randomNum);

                    if (botonsico.getText().equals("")) {
                        botonsico.setText("O");
                        if (checkWin("O")) {
                            finish = true;
                            System.out.println("O wins!");
                            //TODO: pasarlo a un label
                        }
                        valid = true;
                        turno++;
                    }
                }
                if (finish) System.out.println("GAME OVER");

            }
        }
        }


        public void cVSc() {
                while (!finish || turno == 9) {

                    List<Button> botonsicos = new ArrayList<>(Arrays.asList(b00, b01, b02, b10, b11, b12, b20, b21, b22));
                    Button botonsico;

                    boolean valid = false;

                    while (!valid) {
                        int randomNum = (int) (Math.random() * 9);
                        botonsico = botonsicos.get(randomNum);

                        if (botonsico.getText().equals("")) {
                            if (turn) {
                                botonsico.setText("X");
                                if (checkWin("X")){
                                    finish = true;
                                    System.out.println("X wins!");
                                }
                                turn = !turn;
                            } else {
                                botonsico.setText("O");
                                if (checkWin("O")) {
                                    finish = true;
                                    System.out.println("O wins!");
                                    //TODO: pasarlo a un label
                                }
                                turn = !turn;
                            }
                            valid = true;
                        }
                        if (finish) System.out.println("GAME OVER");
                    }

                    turno++;

                }


        }

        }

