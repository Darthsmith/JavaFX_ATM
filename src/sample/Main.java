package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.time.Instant;
import java.util.regex.Pattern;

public class Main extends Application {

    public static void main(String[] args) {
        launch( args );
    }
    private Stage window;
    private Scene welcomeScene, mainATMScene;
    private Scene withdrawScene, depositScene, checkBalanceScene,exitScene;
    private Group welcomeLayout, mainLayout;
    private Group checkBalanceLayout,depositLayout, withdrawLayout;

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;

        Operations operations = new Operations();
        GUI gui = new GUI(operations);

        //closing app
        primaryStage.setOnCloseRequest( e -> {
            e.consume();
            closeProgram();
        } );


        //welcome screen
        welcomeLayout = new Group(gui.welcomeLabel,gui.welcomeButton);
        welcomeScene = new Scene(welcomeLayout,300,300);


        //main screen
        mainLayout = new Group(gui.mainATMLabel,gui.checkBalanceButton,gui.depositButton,gui.exitMainButton,gui.withdrawButton);
        mainATMScene = new Scene( mainLayout,700,500 );
        gui.welcomeButton.setOnAction(e -> primaryStage.setScene( mainATMScene ));

        //Deposit screen
        depositLayout= new Group(gui.exitDepositButton,gui.depositAmountGrid,gui.backDepositButton,gui.depositConfirmButton);
        depositScene = new Scene(depositLayout,700,700);
        gui.depositButton.setOnAction(e -> primaryStage.setScene( depositScene ));
        gui.backDepositButton.setOnAction(e -> primaryStage.setScene( mainATMScene ));

        gui.depositAmountGrid.getChildren().addAll( gui.depositAmountLabel,gui.depositAmountTextField);

        //withdraw screen
        withdrawLayout = new Group(gui.exitWithdrawButton,gui.withdrawAmountGrid,gui.backWithdrawButton,gui.withdrawConfirmButton);
        withdrawScene = new Scene(withdrawLayout,700,500);
        gui.withdrawButton.setOnAction(e -> primaryStage.setScene( withdrawScene ));
        gui.backWithdrawButton.setOnAction(e -> primaryStage.setScene( mainATMScene ));

        gui.withdrawAmountGrid.getChildren().addAll( gui.withdrawAmountLabel,gui.withdrawAmountTextField);


        //checkBalance screen
        checkBalanceLayout = new Group(gui.accountBalanceTextArea,gui.exitCheckBalanceButton,gui.backCheckBalanceButton);
        checkBalanceScene = new Scene(checkBalanceLayout,700,500);
        gui.checkBalanceButton.setOnAction(e -> primaryStage.setScene( checkBalanceScene ));
        gui.backCheckBalanceButton.setOnAction(e -> primaryStage.setScene( mainATMScene )
        );



        //running app
        primaryStage.setScene( welcomeScene );
        primaryStage.setTitle( "ATM" );
        primaryStage.show();

    }

    private void closeProgram(){
        boolean answer = ConfirmBox.display( "Exit", "Do you want to quit?" );
        if (answer) {
            window.close();
        }
    }
}