package dad.javafx.ventana;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VentanaController implements Initializable {

	@FXML
	private VBox view;

	@FXML
	private Slider redSlider;

	@FXML
	private Slider greenSlider;

	@FXML
	private Slider blueSlider;

	private VentanaModel model = new VentanaModel();

	String rutaPerfil = System.getProperty("user.home");

	public VentanaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VentanaView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model.redProperty().bindBidirectional(redSlider.valueProperty());
		model.greenProperty().bindBidirectional(greenSlider.valueProperty());
		model.blueProperty().bindBidirectional(blueSlider.valueProperty());

		model.redProperty().addListener((o, ov, nv) -> {
			Color colores = Color.rgb(model.getRed(), model.getGreen(), model.getBlue());
			view.setBackground(new Background(new BackgroundFill(colores, CornerRadii.EMPTY, Insets.EMPTY)));
		});

		model.greenProperty().addListener((o, ov, nv) -> {
			Color colores = Color.rgb(model.getRed(), model.getGreen(), model.getBlue());
			view.setBackground(new Background(new BackgroundFill(colores, CornerRadii.EMPTY, Insets.EMPTY)));
		});

		model.blueProperty().addListener((o, ov, nv) -> {
			Color colores = Color.rgb(model.getRed(), model.getGreen(), model.getBlue());
			view.setBackground(new Background(new BackgroundFill(colores, CornerRadii.EMPTY, Insets.EMPTY)));
		});
	}

	public void crearArchivo() {
		try (OutputStream output = new FileOutputStream(rutaPerfil + "/.VentanaConMemoria/ventana.config")) {
			Properties prop = new Properties();

			prop.setProperty("background.red", model.getRed() + "");
			prop.setProperty("background.blue", model.getBlue() + "");
			prop.setProperty("background.green", model.getGreen() + "");
			prop.setProperty("size.width", view.getWidth() + "");
			prop.setProperty("size.height", view.getHeight() + "");
			prop.setProperty("location.x", view.getScene().getWindow().getX() + "");
			prop.setProperty("location.y", view.getScene().getWindow().getY() + "");

			prop.store(output, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarArchivo() {
		try (InputStream input = new FileInputStream(rutaPerfil + "/.VentanaConMemoria/ventana.config")) {
			Properties prop = new Properties();

			prop.load(input);

			prop.getProperty("background.red", model.getRed() + "");
			prop.getProperty("background.blue", model.getBlue() + "");
			prop.getProperty("background.green", model.getGreen() + "");
			prop.getProperty("size.width", view.getWidth() + "");
			prop.getProperty("size.height", view.getHeight() + "");
			prop.getProperty("location.x", view.getScene().getWindow().getX() + "");
			prop.getProperty("location.y", view.getScene().getWindow().getY() + "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public VBox getView() {
		return view;
	}

}
