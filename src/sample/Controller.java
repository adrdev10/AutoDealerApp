package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.regex.Pattern;

public class Controller {

    private Customer customer;

    private final double car1 = 27700.00;
    private final double car2 = 32500.00;
    private final double car3 = 36000.00;
    private final double car4 = 44000.00;

    private final double TAG_AND_TITLE = 325.00;

    @FXML
    private Button signInButton;
    @FXML
    private Button signUpButton;
    @FXML
    private Button signUp;
    @FXML
    private TextField userName;
    @FXML
    private TextField pssswordText;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField userNumber;
    @FXML
    private TextField userEmail;
    @FXML
    private Button buyButton;

    @FXML
    private Button Button1;
    @FXML
    private Button Button2;
    @FXML
    private Button Button3;
    @FXML
    private Button Button4;

    @FXML
    private RadioButton checkBoxPaint;

    @FXML
    private Label labelId;


    @FXML
    public void handleButtonClick(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        if(actionEvent.getSource()==signInButton){
            stage = (Stage)signInButton.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                //Exception thrown by calling the getWindow method. IOException
                e.printStackTrace();
            }

        }
        else if(actionEvent.getSource()==signUpButton){
            stage = (Stage) signUpButton.getScene().getWindow();
            try{
                root = FXMLLoader.load(getClass().getResource("signUpWindow.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }





    public void registerButton(ActionEvent actionEvent) {

        String user = userName.getText().toString();
        String email = userEmail.getText().toString();
        String number = userNumber.getText().toString();
        String firstN = firstName.getText().toString();
        String lastN = lastName.getText().toString();
        Stage stage;
        Parent root;

        if(!(isEmail(email)) || !(isNumber(number))){
            Runnable myRunnable = new Runnable(){
                public void run(){
                    JOptionPane.showMessageDialog(null, "Either phone number or email are not in the right format");
                }
            };
            Thread thread = new Thread(myRunnable);
            thread.start();

        }else{
            Customer customer = new Customer(firstN, lastN, email, "Coral Spring", "1234");
            if(actionEvent.getSource()==signUp){
                stage = (Stage)signUp.getScene().getWindow();
                try {
                    root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }catch (IOException e){
                    //Exception thrown by calling the getWindow method. IOException
                    e.printStackTrace();
                }

            }

        }
    }

    public void ButtonPressed(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        if(actionEvent.getSource()==Button1){
            stage = (Stage)Button1.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("wOne.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                //Exception thrown by calling the getWindow method. IOException
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource()==Button2){
            stage = (Stage)Button2.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("car2Window.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                //Exception thrown by calling the getWindow method. IOException
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource()==Button3){
            stage = (Stage)Button3.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("car3Window.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                //Exception thrown by calling the getWindow method. IOException
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource()==Button4){
            stage = (Stage)Button4.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("car4Window4.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                //Exception thrown by calling the getWindow method. IOException
                e.printStackTrace();
            }
        }
    }



    public static boolean isEmail(String email) {
        boolean isEmailOk = true;

        if(email.endsWith(".") || email.startsWith(".")) {
            isEmailOk = false;
        }
        if(email.contains("..")) {
            isEmailOk = false;
        }
        if(!(email.contains("@"))){
            isEmailOk = false;
        }
        return isEmailOk;

    }

    public static boolean isNumber(String number){
        boolean isNumberOk = true;
        Pattern replace = Pattern.compile("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$");

        if(replace.matcher(number).matches()){
            return isNumberOk;
            //Phone number is in good format
        }else {
            JOptionPane.showMessageDialog(null, "Please reenter Phone number");
            isNumberOk = false;
            return false;
        }

    }


    public void buyButton(ActionEvent actionEvent) {
        if(actionEvent.getSource()==buyButton){
            double price = car2 + 2200;
            double tax = price * 0.06;


            double totalPrice = price + tax + TAG_AND_TITLE;

            Runnable runnable2 = new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "Price: " + price + "\n"+
                            "Tax: " + tax + "\n" + "Total Price: " + totalPrice);
                }
            };
            Thread thread = new Thread(runnable2);
            thread.start();

            Runnable runnable3 = new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "Customer: " + customer);
                }
            };
            Thread thread2 = new Thread(runnable3);
            thread2.start();

        }




    }
}
