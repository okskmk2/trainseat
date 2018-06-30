package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Controller {

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
	
	
	
}
