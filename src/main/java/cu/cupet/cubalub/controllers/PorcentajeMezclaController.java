package cu.cupet.cubalub.controllers;

import cu.cupet.cubalub.interfaces.bo.CalculosBO;
import cu.cupet.cubalub.interfaces.bo.ValidarBO;
import cu.cupet.cubalub.interfaces.impl.CalculosImpl;
import cu.cupet.cubalub.interfaces.impl.ValidarImpl;
import cu.cupet.cubalub.utiles.AdminStages;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Creado a las 20:28 del día 24/02/17.
 *
 * @author Eduardo Noel Núñez <enoel.corebsd@gmail.com>
 */
@Controller(value = "porcentaje")
public class PorcentajeMezclaController implements Serializable, Initializable {

    @Autowired
    private CalculosBO calculos;

    @Autowired
    private ValidarBO validar;

    @FXML
    Spinner<Integer> temperatura;

    @FXML
    private TextField text_aceite1;

    @FXML
    private TextField text_aceite2;

    @FXML
    private TextField text_viscosidad_deseada;

    @FXML
    private TextField text_resultado_a1;

    @FXML
    private TextField text_resultado_a2;

    @FXML
    private Button btn_calcular;

    @FXML
    private Button btn_reiniciar;

    @FXML
    private void cerrarPorcentajeMezcla(){

        AdminStages.Singleton().cerrarPorcentajeMezcla();

    }

    @FXML
    private void calcularPorcentaje(){

        Double kv1 = null;
        Double kv2 = null;
        Double kv = null;
        Double k = null;

        if(!text_aceite1.getText().isEmpty()){

            kv1 = Double.parseDouble(text_aceite1.getText());

        }

        if (!text_aceite2.getText().isEmpty()){

            kv2 = Double.parseDouble(text_aceite2.getText());

        }

        if (!text_viscosidad_deseada.getText().isEmpty()){

            kv = Double.parseDouble(text_viscosidad_deseada.getText());

        }

        if (!temperatura.getValue().toString().isEmpty()){

            k = temperatura.getValue().doubleValue();

        }

        Boolean v = validar.validarPorcentajeMezcla(kv1,kv2,kv,k);

        if(v){

            HashMap<String,Double> valor = calculos.calcularPorcentajeMezcla(kv1,kv2,kv,k);

            text_resultado_a1.setStyle("-fx-border-color: blue;");
            text_resultado_a2.setStyle("-fx-border-color: blue;");

            text_resultado_a1.setText(valor.get("PA1").toString());

            text_resultado_a2.setText(valor.get("PA2").toString());

        }

    }

    @FXML
    private void reset() {

        text_aceite1.setText(null);
        text_aceite2.setText(null);
        text_viscosidad_deseada.setText(null);

        text_resultado_a1.setStyle("-fx-border-color: inherit;");
        text_resultado_a1.setText(null);

        text_resultado_a2.setStyle("-fx-border-color: inherit;");
        text_resultado_a2.setText(null);

        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(-50,400,0);

        temperatura.setValueFactory(svf);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(-50,400,0);

        temperatura.setValueFactory(svf);

        text_aceite1.setOnKeyPressed(e->validar.validarNumeros(e));
        text_aceite1.setOnKeyReleased(e->validar.validarNumeros(e));

        text_aceite2.setOnKeyPressed(e->validar.validarNumeros(e));
        text_aceite2.setOnKeyReleased(e->validar.validarNumeros(e));

        text_viscosidad_deseada.setOnKeyPressed(e->validar.validarNumeros(e));
        text_viscosidad_deseada.setOnKeyReleased(e->validar.validarNumeros(e));

    }

    public PorcentajeMezclaController() {

        this.calculos = new CalculosImpl();
        this.validar = new ValidarImpl();

    }

}
