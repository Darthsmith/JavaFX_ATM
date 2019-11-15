package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

class Operations {
    Operations() {
        this.setAccountBalance( basic );
    }

    private int basic;


    int getBasic() {
        return basic;
    }

    private void setBasic(int basic) {
        this.basic = basic;
    }

    private int setAccountBalance(int accountBalance) {
        setBasic( basic+accountBalance );
        return basic;
    }


    void addDeposit(TextField input){
        try{
            int deposit = Integer.parseInt(input.getText());
            setAccountBalance( deposit );
        }catch(NumberFormatException e){
            System.out.println("Zły input");
        }
    }

}