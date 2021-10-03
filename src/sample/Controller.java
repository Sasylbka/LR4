package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button calculate;
    @FXML
    private TextField minCountOfBattery;
    @FXML
    private TextField avgShutdownTime;
    @FXML
    private TextField frequencyOfShutdown;
    @FXML
    private Label result;
    @FXML
    void initialize(){
        calculate.setOnAction(event->{
            if(frequencyOfShutdown.getText().equals("")){
                result.setText("Введите частоту отключения");
            }
            else {
                if(!avgShutdownTime.getText().equals("")) {
                    if (!minCountOfBattery.getText().equals("")) {
                        if (Integer.parseInt(frequencyOfShutdown.getText()) <= 1) {
                            if (Integer.parseInt(avgShutdownTime.getText()) <= 1) {
                                result.setText(minCountOfBattery.getText());
                            } else {
                                if (Integer.parseInt(avgShutdownTime.getText()) > 1) {
                                    if (Integer.parseInt(avgShutdownTime.getText()) < 12) {
                                        result.setText(String.valueOf(Integer.parseInt(minCountOfBattery.getText()) * 1.5));
                                    } else {
                                        result.setText(String.valueOf(Integer.parseInt(minCountOfBattery.getText()) * 2));
                                    }
                                } else {
                                    result.setText(String.valueOf(Integer.parseInt(minCountOfBattery.getText()) * 2));
                                }
                            }
                        } else {
                            if (Integer.parseInt(avgShutdownTime.getText()) <= 1) {
                                result.setText(String.valueOf(Integer.parseInt(minCountOfBattery.getText()) * 1.5));
                            } else {
                                if (Integer.parseInt(avgShutdownTime.getText()) > 1 && Integer.parseInt(avgShutdownTime.getText()) < 12) {
                                    result.setText(String.valueOf(Integer.parseInt(minCountOfBattery.getText()) * 2));
                                } else {
                                    result.setText(String.valueOf(Integer.parseInt(minCountOfBattery.getText()) * 2.5));
                                }
                            }
                        }
                    }
                    else {
                        result.setText("Введите минимальное количество батарей");
                    }
                }
                else {
                    result.setText("Введите среднее время отключения");
                }
            }
        });
    }
}
