package dad.javafx.ventana;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private VentanaController controller;

	/*
	 * @Override public void init() throws Exception { controller = new
	 * VentanaController(); controller.cargarArchivo(); }
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new VentanaController();
		Scene scene = new Scene(controller.getView());

		/*primaryStage.setX(controller.getPosX());
		primaryStage.setY(controller.getPosY());*/
		primaryStage.setTitle("Ventana con memoria");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/*
	 * @Override public void stop() throws Exception { controller.crearArchivo(); }
	 */

	public static void main(String[] args) {
		launch(args);
	}
}
