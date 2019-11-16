package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.application.Platform.exit;

class GUI {

    GUI(Operations operations) {
        this.operations = operations;
        this.welcomeLabel();
        this.welcomeButton();
        this.mainATMLabel();
        this.exitMainButton();
        this.checkBalanceButton();
        this.withdrawButton();
        this.depositButton();
        this.exitCheckBalanceButton();
        this.exitDepositButton();
        this.exitWithdrawButton();
        this.backCheckBalanceButton();
        this.backDepositButton();
        this.backWithdrawButton();
        this.depositAmountGrid();
        this.depositAmountLabel();
        this.depositAmountTextField();
        this.withdrawAmountGrid();
        this.withdrawAmountLabel();
        this.withdrawAmountTextField();
        this.accountBalanceTextArea();
        this.depositConfirmButton();
        this.withdrawConfirmButton();
    }

    Button depositConfirmButton;
    Button withdrawConfirmButton;
    TextArea accountBalanceTextArea;
    TextField depositAmountTextField;
    Label depositAmountLabel;
    GridPane depositAmountGrid;
    TextField withdrawAmountTextField;
    Label withdrawAmountLabel;
    GridPane withdrawAmountGrid;
    Label welcomeLabel;
    Button welcomeButton;
    Label mainATMLabel;
    Button exitMainButton;
    Button checkBalanceButton;
    Button exitCheckBalanceButton;
    Button withdrawButton;
    Button depositButton;
    Button exitDepositButton;
    Button exitWithdrawButton;
    Button backCheckBalanceButton;
    Button backDepositButton;
    Button backWithdrawButton;

    private Operations operations;

    private void welcomeLabel() {
        this.welcomeLabel = new Label( "Welcome to the ATM" );
        this.welcomeLabel.setLayoutX( 60 );
        this.welcomeLabel.setLayoutY( 80 );
        this.welcomeLabel.setFont( new Font( 20 ) );
    }


    private void welcomeButton() {
        this.welcomeButton = new Button( "Click to proceed" );
        this.welcomeButton.setLayoutX( 100 );
        this.welcomeButton.setLayoutY( 120 );
    }

    private void mainATMLabel() {
        this.mainATMLabel = new Label( "Choose operation:" );
        this.mainATMLabel.setLayoutX( 250 );
        this.mainATMLabel.setLayoutY( 100 );
        this.mainATMLabel.setFont( new Font( 20 ) );
    }

    private void withdrawButton() {
        this.withdrawButton = new Button( "Withdrawal" );
        this.withdrawButton.setLayoutX( 80 );
        this.withdrawButton.setLayoutY( 160 );
    }

    private void depositButton() {
        this.depositButton = new Button( "Deposit" );
        this.depositButton.setLayoutX( 480 );
        this.depositButton.setLayoutY( 160 );
    }



    private void checkBalanceButton() {
        this.checkBalanceButton = new Button( "Check your account balance" );
        this.checkBalanceButton.setLayoutX( 80 );
        this.checkBalanceButton.setLayoutY( 260 );


    }

    private void exitMainButton() {
        this.exitMainButton = new Button( "Exit" );
        this.exitMainButton.setLayoutX( 480 );
        this.exitMainButton.setLayoutY( 260 );
        exitMainButton.setOnAction( e -> closeProgram());
    }

    private void exitDepositButton() {
        this.exitDepositButton = new Button( "Exit" );
        this.exitDepositButton.setLayoutX( 650 );
        this.exitDepositButton.setLayoutY( 450 );
        exitDepositButton.setOnAction( e -> closeProgram());
    }

    private void exitWithdrawButton(){
        this.exitWithdrawButton = new Button( "Exit" );
        this.exitWithdrawButton.setLayoutX( 650 );
        this.exitWithdrawButton.setLayoutY( 450 );
        exitWithdrawButton.setOnAction( e -> closeProgram());
    }
    private void backDepositButton(){
        this.backDepositButton = new Button( "Return" );
        this.backDepositButton.setLayoutX( 50 );
        this.backDepositButton.setLayoutY( 450 );
    }

    private void backWithdrawButton(){
        this.backWithdrawButton = new Button( "Return" );
        this.backWithdrawButton.setLayoutX( 50 );
        this.backWithdrawButton.setLayoutY( 450 );
    }

    private void exitCheckBalanceButton() {
        this.exitCheckBalanceButton = new Button( "Exit" );
        this.exitCheckBalanceButton.setLayoutX( 650 );
        this.exitCheckBalanceButton.setLayoutY( 450 );
        exitCheckBalanceButton.setOnAction( e -> closeProgram());
    }

    private void backCheckBalanceButton(){
        this.backCheckBalanceButton = new Button( "Return" );
        this.backCheckBalanceButton.setLayoutX( 50 );
        this.backCheckBalanceButton.setLayoutY( 450 );
    }
    private void closeProgram(){
        boolean answer = ConfirmBox.display( "Exit", "Do you want to quit?" );
        if (answer) {
            exit();
        }
    }

    private void depositAmountGrid(){
        this.depositAmountGrid = new GridPane();
        this.depositAmountGrid.setPadding( new Insets( 10,10,10,10 ) );
        this.depositAmountGrid.setVgap( 8 );
        this.depositAmountGrid.setHgap( 8 );
    }

    private void withdrawAmountGrid(){
        this.withdrawAmountGrid = new GridPane();
        this.withdrawAmountGrid.setPadding( new Insets( 10,10,10,10 ) );
        this.withdrawAmountGrid.setVgap( 8 );
        this.withdrawAmountGrid.setHgap( 8 );
    }

    private void depositAmountLabel(){
        this.depositAmountLabel = new Label("How much money do you want to deposit?");
        GridPane.setConstraints( this.depositAmountLabel, 0,0 );
    }
    private void withdrawAmountLabel(){
        this.withdrawAmountLabel = new Label("How much money do you want to withdraw?");
        GridPane.setConstraints( this.withdrawAmountLabel, 0,0 );
    }

    private void depositAmountTextField(){
        this.depositAmountTextField = new TextField(  );
        GridPane.setConstraints( this.depositAmountTextField, 1,0 );
    }

    private void withdrawAmountTextField(){
        this.withdrawAmountTextField = new TextField(  );
        GridPane.setConstraints( this.withdrawAmountTextField, 1,0 );
    }
    private void accountBalanceTextArea(){
        this.accountBalanceTextArea = new TextArea("Your account balance at" + " is: " + operations.getMoney() + "zł");
    }

    private void depositConfirmButton(){
        this.depositConfirmButton = new Button("Click me!");
        this.depositConfirmButton.setLayoutX( 50 );
        this.depositConfirmButton.setLayoutY( 50 );
        this.depositConfirmButton.setOnAction( e -> {
            operations.depositMoney(depositAmountTextField);
            accountBalanceTextArea.setText( "Your account balance at" + " is: " + operations.getMoney() + "zł" );
        });
    }

    private void withdrawConfirmButton(){
        this.withdrawConfirmButton = new Button("Click me!");
        this.withdrawConfirmButton.setLayoutX( 50 );
        this.withdrawConfirmButton.setLayoutY( 50 );
        this.withdrawConfirmButton.setOnAction( e -> {
            operations.withdrawMoney(withdrawAmountTextField);
            accountBalanceTextArea.setText( "Your account balance at" + " is: " + operations.getMoney() + "zł" );
        });
    }
}