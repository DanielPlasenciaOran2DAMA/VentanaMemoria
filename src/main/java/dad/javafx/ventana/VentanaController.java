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
	private Double posX;
	private Double posY;

	private String ruta = System.getProperty("user.home");

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

	/*public void cargarArchivo() {
		try (InputStream input = new FileInputStream(ruta + "/ventana.config")) {
			Properties prop = new Properties();

			prop.load(input);

			this.model.setRed(Integer.parseInt(prop.getProperty("background.red")));
			this.model.setGreen(Integer.parseInt(prop.getProperty("background.green")));
			this.model.setBlue(Integer.parseInt(prop.getProperty("background.blue")));
			this.view.setPrefWidth(Double.parseDouble(prop.getProperty("size.width")));
			this.view.setPrefHeight(Double.parseDouble(prop.getProperty("size.height")));
			this.setPosX(Double.parseDouble(prop.getProperty("location.x")));
			this.setPosY(Double.parseDouble(prop.getProperty("location.y")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void crearArchivo() {
		try (OutputStream output = new FileOutputStream(ruta + "/ventana.config")) {
			Properties prop = new Properties();

			prop.setProperty("background.red", this.model.getRed() + "");
			prop.setProperty("background.blue", this.model.getBlue() + "");
			prop.setProperty("background.green", this.model.getGreen() + "");
			prop.setProperty("size.width", this.view.getWidth() + "");
			prop.setProperty("size.height", this.view.getHeight() + "");
			prop.setProperty("location.x", getX() + "");
			prop.setProperty("location.y", getY() + "");

			prop.store(output, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	private Double getX() {
		return this.view.getScene().getWindow().getX();
	}

	private Double getY() {
		return this.view.getScene().getWindow().getY();
	}

	public Double getPosX() {
		return posX;
	}

	public void setPosX(Double posX) {
		this.posX = posX;
	}

	public Double getPosY() {
		return posY;
	}

	public void setPosY(Double posY) {
		this.posY = posY;
	}

	public VBox getView() {
		return view;
	}

}
