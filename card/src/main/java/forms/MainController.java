package forms;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MainController implements Initializable {

	@FXML
	private Label lblHelloWord;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblHelloWord.setText("Xin chao cac ban");
	}

}
