package com.company;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

/**
 * Created by nhimani on 9/16/15.
 */
public class confirmationBox {

    static boolean result;

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(250);
        Label label = new Label();
        label.setText(message);

        Button one = new Button("Yes");
        Button two = new Button("No");

        one.setOnAction(e -> {
            result = true;
            window.close();
        });

        two.setOnAction(e -> {
            result = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, one, two);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return result;
    }
}
