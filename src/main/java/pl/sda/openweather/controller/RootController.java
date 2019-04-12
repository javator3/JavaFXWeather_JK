package pl.sda.openweather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import pl.sda.openweather.model.Weather;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    private String finalURL = "http://api.apixu.com/v1/current.json?key=a147a586068c46f2b4e90949191002&q=";

    @FXML
    private Button search;

    @FXML
    private TextField city;

    @FXML
    private Label tempResult;

    @FXML
    private Label feelTempResult;

    @FXML
    private ImageView weatherImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        city.setText("nazwa miasta");
    }

    public void setCity(ActionEvent actionEvent) {
        try {
            URL jsonURL = new URL(finalURL + city.getText());


            ObjectMapper objectMapper = new ObjectMapper();
            Weather weather = objectMapper.readValue(jsonURL, Weather.class);
            feelTempResult.setText(String.valueOf(weather.getCurrent().getFeelslike_c()));
            tempResult.setText(String.valueOf(weather.getCurrent().getTemp_c()));
            Image image = new Image("http:" + weather.getCurrent().getCondition().getIcon(),true);

            weatherImage.setImage(image);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
