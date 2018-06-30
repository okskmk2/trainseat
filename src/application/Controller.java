package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import jssc.SerialPortException;

public class Controller implements Initializable{

	@FXML
	private TextArea buslogview;

	@FXML
	private Button seat11;
	@FXML
	private Button seat12;
	@FXML
	private Button seat13;
	
	@FXML
	private ComboBox<String> busCombo;
	
	@FXML
	private void onchange(ActionEvent event) {
		System.out.println(busCombo.getValue());
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("initialize");
		try {
			new SerialConnector(buslogview, seat11, seat12, seat13);
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}
	
}
