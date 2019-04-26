package cu.cupet.cubalub.controllers;

import cu.cupet.cubalub.interfaces.bo.CalculosBO;
import cu.cupet.cubalub.interfaces.bo.ValidarBO;
import cu.cupet.cubalub.interfaces.impl.CalculosImpl;
import cu.cupet.cubalub.interfaces.impl.ValidarImpl;
import cu.cupet.cubalub.utiles.AdminStages;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Creado a las 20:28 del día 24/02/17.
 *
 * @author Eduardo Noel Núñez <enoel.corebsd@gmail.com>
 */
@Controller(value = "iv40")
public class IV40Controller implements Serializable, Initializable {

    @Autowired
    private CalculosBO calculos;

    @Autowired
    private ValidarBO validar;

    @FXML
    private TextField text_ivvisco;

    @FXML
    private TextField text_visco_100;

    @FXML
    private TextField text_resultado;

    @FXML
    private Button btn_calcular;

    @FXML
    private Button btn_reiniciar;

    @FXML
    private void cerrarIV(){

        AdminStages.Singleton().cerrarIndiceViscosidad40();

    }

    @FXML
    private void calcularIV(){

        Double vindex = null;
        Double kv100 = null;

        if(!text_ivvisco.getText().isEmpty()){

            vindex = Double.parseDouble(text_ivvisco.getText());

        }

        if (!text_visco_100.getText().isEmpty()){

            kv100 = Double.parseDouble(text_visco_100.getText());

        }

        Boolean v = validar.validarIV40(vindex,kv100);

        if(v){

            Double valor = calculos.calcKv40(vindex,kv100);

            if(valor < kv100 || valor < 2 || valor >= 2000){

                Alert alert = new Alert(Alert.AlertType.ERROR, "");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.getDialogPane().setContentText("Usted está fuera del rango útil de la ecuación");
                alert.getDialogPane().setHeaderText("Atención: Hay un problema con los datos");
                alert.showAndWait().filter(response -> response == ButtonType.OK);

            } else {

                text_resultado.setStyle("-fx-border-color: blue;");

                text_resultado.setText(valor.toString());

            }

        }

    }

    @FXML
    private void reset() {

        text_ivvisco.setText(null);
        text_visco_100.setText(null);
        text_resultado.setText(null);

        text_resultado.setStyle("-fx-border-color: inherit;");
        text_resultado.setText(null);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        text_ivvisco.setOnKeyPressed(e->validar.validarNumeros(e));
        text_ivvisco.setOnKeyReleased(e->validar.validarNumeros(e));

        text_visco_100.setOnKeyPressed(e->validar.validarNumeros(e));
        text_visco_100.setOnKeyReleased(e->validar.validarNumeros(e));

    }


    public IV40Controller() {

        this.calculos = new CalculosImpl();
        this.validar = new ValidarImpl();

    }
}
