package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class Main extends Application {

public static void Main(String[] args) {
launch(args);
}

@Override
public void start(Stage primaryStage) throws Exception{
	primaryStage.setTitle("Login");
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(30);
    grid.setVgap(30);
    grid.setPadding(new Insets(40, 40, 40, 40));

    Text scenetitle = new Text("Welcome");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    grid.add(scenetitle, 0, 0, 2, 1);


    Button Encrypt = new Button("Encrypt New File");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.CENTER_LEFT);
    hbBtn.getChildren().add(Encrypt);
    grid.add(hbBtn, 1, 1);

    final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 1);

    Button Decrypt = new Button("Decrypt A Previous File");
    HBox DecBtn = new HBox(10);
    DecBtn.setAlignment(Pos.CENTER_RIGHT);
    DecBtn.getChildren().add(Decrypt);
    grid.add(DecBtn, 1, 2);

    final Text Decryptaction = new Text();
    grid.add(Decryptaction, 1, 2);

    Encrypt.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	Encrypt_GUI enc = new Encrypt_GUI();
					enc.encrypt();



        }
    });
    Decrypt.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	Decrypt_GUI dec = new Decrypt_GUI();
					dec.decrypt();






        }
    });


    Scene scene= new Scene(grid, 500, 475);
    StackPane root = new StackPane();
    primaryStage.setScene(scene);
    primaryStage.show();
}
}
