package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InicioController {
	@FXML
	private Button btnComienza;

	@FXML
	private void cambiarEscena (ActionEvent event) {

		try {

			Node source = (Node) event.getSource();
			Stage cierre = (Stage) this.btnComienza.getScene().getWindow(); 
		    cierre.close();
		    
		    
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
			Parent root = loader.load();
			SampleController control = loader.getController();
			Scene scene = new Scene(root,1021,712);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
