package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        // Step 1 - create one or more control
        FileInputStream imagePath = new FileInputStream("src/sample/finn.jpg/");
        Label helloLabel = new Label("Hello, World");
        Label goodByeLabel = new Label("Good Bye!");
        Label anotherLabel = new Label("Another Label");
        Label yetAnotherLabel = new Label("Yet another label!!");
        Button clickMeButton = new Button("Click me");
        Button closeButton = new Button("Close");

        //Step 1 for images is to load the images
        Image finn = new Image(imagePath);
        //Step 2 is setup the image view
        ImageView finnImageView = new ImageView(finn);
        finnImageView.setFitHeight(100);
        finnImageView.setFitWidth(200);


        //Border gridBorder = new Border(new BorderStroke(Color.BLANCHEDALMOND, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        // Step 1.1 - Configure your controls
        Font font = Font.font("Consolas", FontWeight.BOLD, 20);
        clickMeButton.setFont(font);

        // Step 1.2 - For button controls (or other event-type controls) - set the event
        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("ClickMe Button Clicked!");

                helloLabel.setText("Clicked!");
            }
        });

        closeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                Platform.exit();
            }
        });

        // Step 2 - create a container
       HBox hbox = new HBox(10, helloLabel, goodByeLabel);
       HBox hbox2 = new HBox(finnImageView);
        //VBox vbox = new VBox(helloLabel, clickMeButton);
        hbox.setStyle("-fx-border-color: black; -fx-alignment: center;");


        GridPane gridPane = new GridPane();

        gridPane.setStyle("-fx-border-color: black; -fx-font-size: 18; -fx-font-family: Consolas;" +
                          " -fx-font-weight: bold; ");

        gridPane.add(hbox, 1, 1);
      //  gridPane.add(goodByeLabel, 1, 1);
        gridPane.add(clickMeButton, 2, 2);
        gridPane.add(closeButton, 2, 3);
        gridPane.add(hbox2, 0, 0);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        // Step 3 - add layout container to scene
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);

        // Step 4 - add scene to stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
