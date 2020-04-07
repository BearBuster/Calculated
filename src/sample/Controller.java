package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label lable_field;

    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_plus_minus;

    @FXML
    private Button btn_division;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_multi;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_minus;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_plus;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_procent;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_coma;

    @FXML
    private Button btn_equal;

    private String str_num = "";
    private float first_num = 0;
    private char operation;

    @FXML
    void initialize(){
        btn_0.setOnAction(event ->{
            addNumber(0);
        });
        btn_1.setOnAction(event ->{
            addNumber(1);
        });
        btn_2.setOnAction(event ->{
            addNumber(2);
        });
        btn_3.setOnAction(event ->{
            addNumber(3);
        });
        btn_4.setOnAction(event ->{
            addNumber(4);
        });
        btn_5.setOnAction(event ->{
            addNumber(5);
        });
        btn_6.setOnAction(event ->{
            addNumber(6);
        });
        btn_7.setOnAction(event ->{
            addNumber(7);
        });
        btn_8.setOnAction(event ->{
            addNumber(8);
        });
        btn_9.setOnAction(event ->{
            addNumber(9);
        });
        btn_plus.setOnAction(event ->{
            mathAction('+');
        });
        btn_minus.setOnAction(event ->{
            mathAction('-');
        });
        btn_multi.setOnAction(event ->{
            mathAction('*');
        });
        btn_division.setOnAction(event ->{
            mathAction('/');
        });
        btn_equal.setOnAction(event ->{
            if( this.operation == '+' || this.operation == '-' || this.operation == '*' || this.operation == '/')
                equalMethod();
        });
        btn_coma.setOnAction(event -> {
            if(!this.str_num.contains(".")) {
                this.str_num += ".";
                lable_field.setText(str_num);
            }
        });
        btn_procent.setOnAction(event ->{
            if(str_num != "") {
                float num = Float.parseFloat(this.str_num) * 0.1f;
                this.str_num = Float.toString(num);
                lable_field.setText(str_num);

            }
        });
        btn_plus_minus.setOnAction(event ->{
            if(str_num != "") {
                float num = Float.parseFloat(this.str_num) * -1;
                this.str_num = Float.toString(num);
                lable_field.setText(str_num);
            }
        });
        btn_clear.setOnAction(event ->{
            lable_field.setText("0");
            this.str_num = "";
            this.first_num = 0;
            this.operation = 'A';
        });
    }

    private void equalMethod() {
        float res = 0;
        switch (operation){
            case '+':
                res = this.first_num + Float.parseFloat(this.str_num);
                break;
            case '-':
                res = this.first_num - Float.parseFloat(this.str_num);
                break;
            case '*':
                res = this.first_num * Float.parseFloat(this.str_num);
                break;
            case '/':
                if(Integer.parseInt(this.str_num) != 0)
                    res = this.first_num / Float.parseFloat(this.str_num);
                else
                    res = 0;
                break;
        }
        lable_field.setText(Float.toString(res));
        this.str_num = "";
        this.operation = 'A';
        this.first_num = 0;
    }

    private void mathAction(char operation) {
        if( this.operation != '+' && this.operation != '-' && this.operation != '*' && this.operation != '/') {
            this.first_num = Float.parseFloat(this.str_num);
            lable_field.setText(String.valueOf(operation));
            this.str_num = "";
            this.operation = operation;
        }
    }

    void addNumber(int number){
        this.str_num += Integer.toString(number);
        lable_field.setText(str_num);
    };

}
