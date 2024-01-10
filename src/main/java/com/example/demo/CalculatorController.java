package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    private Label numberLabel;
    double num1 = 0;
    double num2 = 0 ;
    String currentOperation = "null";
    boolean decimalPresent = false;
    int trailingZeroes = 0;
    int currentNumber = 1;
    boolean lastInputWasOperation = false;
    public void displayNum() {
        double displayNumber;
        String actualDisplay;
        if (currentNumber == 1) {
            displayNumber = num1;
        } else {
            displayNumber = num2;
        }
        if (displayNumber % 1 == 0) {
            if (decimalPresent) {
                actualDisplay = String.valueOf((int)displayNumber) + ".";
            } else {
                actualDisplay = String.valueOf((int)displayNumber);
            }
        }else{
            actualDisplay = String.valueOf(displayNumber);
        }
        for (int i = 0; i < trailingZeroes; i++){
            actualDisplay = actualDisplay + "0";
        }
        numberLabel.setText(actualDisplay);
    }
    public void displayOperation(double number, String operation){
        if (number%1 == 0){
            numberLabel.setText(String.valueOf((int) number) + operation);
        }else {
            numberLabel.setText(String.valueOf(number) + operation);
        }
    }
    //Buttons
    public void input1(ActionEvent e){
        numberInput("1");
    }
    public void input2(ActionEvent e){
        numberInput("2");
    }
    public void input3(ActionEvent e){
        numberInput("3");
    }
    public void input4(ActionEvent e){
        numberInput("4");
    }
    public void input5(ActionEvent e){
        numberInput("5");
    }
    public void input6(ActionEvent e){
        numberInput("6");
    }
    public void input7(ActionEvent e){
        numberInput("7");
    }
    public void input8(ActionEvent e){
        numberInput("8");
    }
    public void input9(ActionEvent e){
        numberInput("9");
    }
    public void input0(ActionEvent e){
        numberInput("0");
    }
    public void inputAddition(ActionEvent e){
        operationInput("+");
    }
    public void inputSubtraction(ActionEvent e){
        operationInput("-");
    }
    public void inputMultiplication(ActionEvent e){
        operationInput("*");
    }
    public void inputDivision(ActionEvent e){
        operationInput("/");
    }
    public void inputEquals(){
        if (currentOperation.equals("+")){
            num1 = num1 + num2;
        }
        if (currentOperation.equals("-")){
            num1 = num1 - num2;
        }
        if (currentOperation.equals("*")){
            num1 = num1 * num2;
        }
        if (currentOperation.equals("/")){
            num1 = num1 / num2;
        }
        currentNumber = 1;
        trailingZeroes = 0;
        displayNum();
    }
    public void inputClear(ActionEvent e){
        num1 = 0;
        num2 = 0;
        currentNumber = 1;
        currentOperation = "null";
        decimalPresent = false;
        displayNum();
    }
    public void inputDecimal(ActionEvent e){
        decimalPresent = true;
        displayNum();
    }
    public void numberInput (String num){
        double outputNum;
        if (currentNumber == 1){
            outputNum = num1;
        }else{
            outputNum = num2;
        }
        if (outputNum % 1 == 0 || outputNum == 0) {
            if (decimalPresent){
                if (num.equals("0")){
                    trailingZeroes++;
                }else{
                    String output;
                    output = String.valueOf((int)outputNum);
                    output = output + ".";
                    for (int i = 0; i < trailingZeroes; i++){
                        output = output + "0";
                    }
                    output = output + num;
                    trailingZeroes = 0;
                    outputNum = Double.parseDouble(output);
                }
            }else{
                outputNum = Double.parseDouble(String.valueOf((int)outputNum) + num);
            }
        }else{
            if (num.equals("0")){
                trailingZeroes++;
            }else{
                String output;
                output = String.valueOf(outputNum);
                for (int i = 0; i < trailingZeroes; i++){
                    output = output + "0";
                }
                output = output + num;
                trailingZeroes = 0;
                outputNum = Double.parseDouble(output);
            }
        }
        if (currentNumber == 1){
            num1 = outputNum;
        }else{
            num2 = outputNum;
        }
        displayNum();
        lastInputWasOperation = false;
    }
    public void operationInput (String operation){
        if (lastInputWasOperation == false){
            if (currentNumber == 2){
                inputEquals();
                displayOperation(num1,operation);
                num2 = 0;
                currentNumber = 2;
                currentOperation = operation;
                decimalPresent = false;
            }else{
                currentNumber = 2;
                currentOperation = operation;
                decimalPresent = false;
                displayOperation(num1,operation);
            }
        }
        lastInputWasOperation = true;
    }
}