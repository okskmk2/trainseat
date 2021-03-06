package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jssc.SerialPortException;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException, SerialPortException {
		Parent root = FXMLLoader.load(getClass().getResource("design.fxml"));
		primaryStage.setTitle("지하철좌석알림시스템");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
