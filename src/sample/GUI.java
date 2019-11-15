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

    GUI() {
        this.welcomeLabel();
        this.welcomeButton();
        this.mainATMLabel();
        this.depositLabel();
        this.exitMainButton();
        this.checkBalanceButton();
        this.withdrawButton();
        this.depositButton();
        this.exitCheckBalanceButton();
        this.exitDepositButton();
        this.backCheckBalanceButton();
        this.backDepositButton();
        this.depositAmountGrid();
        this.depositAmountLabel();
        this.depositAmountTextField();
        this.accountBalanceTextArea();
        this.addDepositButton();
    }

    Button addDepositButton;
    TextArea accountBalanceTextArea;
    TextField depositAmountTextField;
    Label depositAmountLabel;
    GridPane depositAmountGrid;
    Label welcomeLabel;
    Button welcomeButton;
    Label mainATMLabel;
    Button exitMainButton;
    Button checkBalanceButton;
    Button exitCheckBalanceButton;
    Button withdrawButton;
    Button depositButton;
    Button exitDepositButton;
    Button backCheckBalanceButton;
    Button backDepositButton;
    private Label depositLabel;
    private Operations operations = new Operations();

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

    private void depositLabel() {
        this.depositLabel = new Label( "Choose amount:" );

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
    private void backDepositButton(){
        this.backDepositButton = new Button( "Return" );
        this.backDepositButton.setLayoutX( 50 );
        this.backDepositButton.setLayoutY( 450 );
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

    private void depositAmountLabel(){
        this.depositAmountLabel = new Label("Input the deposit amount");
        GridPane.setConstraints( this.depositAmountLabel, 0,0 );
    }

    private void depositAmountTextField(){
        this.depositAmountTextField = new TextField(  );
        GridPane.setConstraints( this.depositAmountTextField, 1,0 );
    }
    private void accountBalanceTextArea(){
        this.accountBalanceTextArea = new TextArea("Your account balance at" + " is: " + operations.getBasic() + "zł");
    }

    private void addDepositButton(){
        this.addDepositButton = new Button("Click me!");
        this.addDepositButton.setLayoutX( 50 );
        this.addDepositButton.setLayoutY( 50 );
        this.addDepositButton.setOnAction( e -> {
            operations.addDeposit(depositAmountTextField);
            accountBalanceTextArea.setText( "Your account balance at" + " is: " + operations.getBasic() + "zł" );
        });
    }
}