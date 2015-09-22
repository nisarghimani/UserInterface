package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;

public class Main extends Application { // dont need this (implements EventHandler<ActionEvent>) because Lambda exp handles this

    Stage hubWindow;
    Scene hubContent, tvContent;
    Button television;
    Button light;
    Button hub, channelUp, channelDown, volumeUp, volumeDown, turnOffTV;
    public static void main(String[] args) {
	    launch(args); //Method inside application class .. setup program as java fx application which also then calls start method below
    }

    //Window is called Stage (max, min, close)
    //Content inside is Scene (buttons, widgets)

    @Override
    public void start(Stage primaryStage) throws Exception {
        hubWindow = primaryStage;
        Label label1 = new Label("Welcome to the Hub!");
        hubWindow.setTitle("Title: Hub");

        hubWindow.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        television = new Button();
        television.setText("Television");
        light = new Button("Light");

        HBox hubLayout = new HBox(100); //hubLayout lays children/buttons in horizontal column
        hubLayout.getChildren().addAll(television, light);
        hubLayout.setAlignment(Pos.CENTER);

        television.setOnAction(e -> hubWindow.setScene(tvContent));

        //This class will handle the button events
        light.setOnAction(e -> System.out.println("Print for light")); //Lambda Expression: on event

        hubContent = new Scene(hubLayout, 500, 500);

        //new page creation after clicking the television button
        hub = new Button("          Hub          ");
        channelUp = new Button("Channel Up");
        channelDown = new Button("Channel Down");
        volumeUp = new Button("Volume Up");
        volumeDown = new Button("Volume Down");
        turnOffTV = new Button("Turn Off");

        hub.setOnAction(e -> hubWindow.setScene(hubContent));
        channelUp.setOnAction(e -> System.out.println("Channel Up"));
        channelDown.setOnAction(e -> System.out.println("Channel Down"));
        volumeUp.setOnAction(e -> System.out.println("Volume Up"));
        volumeDown.setOnAction(e -> System.out.println("Volume Down"));
        turnOffTV.setOnAction(e -> hubWindow.setScene(hubContent));

        BorderPane border = new BorderPane();
        HBox top = new HBox();
        top.setAlignment(Pos.TOP_CENTER);
        top.getChildren().add(hub);
        border.setTop(top);

        VBox middle = new VBox();
        middle.setAlignment(Pos.CENTER);
        middle.getChildren().addAll(channelUp, turnOffTV, channelDown);
        middle.setSpacing(80);
        border.setCenter(middle);

        VBox left = new VBox();
        left.setAlignment(Pos.CENTER_RIGHT);
        left.getChildren().add(volumeDown);
        border.setLeft(left);

        VBox right = new VBox();
        right.setAlignment(Pos.CENTER_LEFT);
        right.getChildren().add(volumeUp);
        border.setRight(right);
        border.setPadding(new Insets(10, 20, 10, 20));

        tvContent = new Scene(border, 500, 500);
        hubWindow.setScene(hubContent);
        hubWindow.show();
    }

    /* @Override ......... This was needed when we were implementing eventhandler, now we're using labda expressions

    public void handle(ActionEvent event) {
        if(event.getSource()==television){
            System.out.println("Open New Window");
        }
    }
    */

    private void closeProgram(){
        Boolean close = confirmationBox.display("Close Window", "Are you sure you want to exit?");
        if(close)
            hubWindow.close();
    }
}
