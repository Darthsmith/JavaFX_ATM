package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

class Operations {
    Operations() {
        this.addMoney( money );
        this.takeMoney( money );
    }

    private int money;


    int getMoney() {
        return money;
    }

    private void setMoney(int money) {
        this.money = money;
    }

    private int addMoney(int accountBalance) {
        setMoney( money+accountBalance );
        return money;
    }
    private int takeMoney(int accountBalance) {
        if(accountBalance>money) {
            AlertBox.display( "Error", "You don't have enough money for this operation!"  );
        } else {
            setMoney( money - accountBalance );
        }
        return money;
    }


    void depositMoney(TextField input){
        try{
            int deposit = Integer.parseInt(input.getText());
            addMoney( deposit );
        }catch(NumberFormatException e){
            System.out.println("Wrong input");
        }
    }
    void withdrawMoney(TextField input){
        try{
            int withdraw = Integer.parseInt(input.getText());
            takeMoney( withdraw );
        }catch(NumberFormatException e){
            System.out.println("Wrong input");
        }
    }

}