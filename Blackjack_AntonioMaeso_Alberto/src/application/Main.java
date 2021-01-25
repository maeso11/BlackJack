package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@FXML Button btnPedir;
	@FXML Button btnPlantarse;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,1021,712);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			insertarImagen();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertarImagen() {
		URL imagen = getClass().getResource("/img/fondoBoton.jpg");
		Image fondo = new Image(imagen.toString(), 142, 31, false, true);
		btnPedir.setGraphic(new ImageView(fondo));
		btnPlantarse.setGraphic(new ImageView(fondo));
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
