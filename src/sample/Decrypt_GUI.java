package sample;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import javafx.application.Application;
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

public class Decrypt_GUI{




    public void decrypt(){

    	Stage decrypt_stage = new Stage();
        decrypt_stage.setTitle("Login");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setPadding(new Insets(40, 40, 40, 40));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label FilepathLabel = new Label("Enter Filepath To Decrypt");
        grid.add(FilepathLabel, 0, 1);

        TextField path = new TextField();
        grid.add(path, 1, 1);


        Label FileNameLabel = new Label("Enter Original File Name");
        grid.add(FileNameLabel, 0, 2);

        TextField name = new TextField();
        grid.add(name, 1, 2);


        Label pw = new Label("Enter Key");
        grid.add(pw, 0, 3);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 3);


        Button Enter = new Button("Enter");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(Enter);
        grid.add(hbBtn, 1, 4);



        final Text actiontarget = new Text();
            grid.add(actiontarget, 1, 6);

        Enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String Filepath = path.getText();
            	String filename = name.getText();
            	String Key = pwBox.getText();
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in Button Pressed");
                System.out.println(Filepath);

                try {
					CryptoTime(Filepath, filename, Key);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
        });
        Scene scene= new Scene(grid, 500, 475);
        StackPane root = new StackPane();
        decrypt_stage.setScene(scene);
        decrypt_stage.show();
    }





public static void CryptoTime(String Filepath, String FileName, String key)throws NoSuchAlgorithmException{
	File inputFile = new File(Filepath + "/" + FileName + "_encrypted");
	File encryptedFile = new File(Filepath + "/" + FileName);

	MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(key.getBytes());
    byte[] digest = md.digest();
    String Password = DatatypeConverter.printHexBinary(digest).toUpperCase().substring(0,16);

	try {
	    CryptoUtils.decrypt(Password, inputFile, encryptedFile);

	} catch (CryptoException ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
	}
	inputFile.delete();

}
}