package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

class ConfirmBox { //input and pass it along to the main program

    private static boolean answer;


    static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality( Modality.APPLICATION_MODAL ); // dopoki nie ogarne tego okna nie moge uzywac innych
        window.setTitle( title );
        window.setMinWidth( 250 );
        Label label = new Label();
        label.setText( message );

        //Create two buttons

        Button yesButton = new Button( "Yes" );
        Button noButton = new Button( "No" );

        yesButton.setOnAction( e -> {
            answer = true;
            window.close();
        } );
        noButton.setOnAction( e -> {
            answer = false;
            window.close();
        } );

        VBox layout = new VBox();
        layout.getChildren().addAll( label,yesButton,noButton );
        layout.setAlignment( Pos.CENTER );
        Scene scene = new Scene( layout );
        window.setScene( scene );
        window.showAndWait();

        return answer;

        // jak stosowac w mainie
//        button.setOnAction( e -> {
//          boolean result = ConfirmBox.display("Title of window","Are you sure to do this thing?");
//        });
    }
}


