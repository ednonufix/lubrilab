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
import java.util.ResourceBundle;

/**
 * Creado a las 20:28 del día 24/02/17.
 *
 * @author Eduardo Noel Núñez <enoel.corebsd@gmail.com>
 */
@Controller(value = "visco")
public class ViscoController implements Serializable, Initializable {

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
    private TextField text_resultado;

    @FXML
    private TextField text_porcentaje;

    @FXML
    private Button btn_calcular;

    @FXML
    private Button btn_reiniciar;

    @FXML
    private void cerrarViscoFinal(){

        AdminStages.Singleton().cerrarViscoFinal();

    }

    @FXML
    private void calcularMezcla(){

        Double kv1 = null;
        Double kv2 = null;
        Double x1 = null;
        Double k = null;

        if(!text_aceite1.getText().isEmpty()){

            kv1 = Double.parseDouble(text_aceite1.getText());

        }

        if (!text_aceite2.getText().isEmpty()){

            kv2 = Double.parseDouble(text_aceite2.getText());

        }

        if (!text_porcentaje.getText().isEmpty()){

            x1 = Double.parseDouble(text_porcentaje.getText())/100;

        }

        if (!temperatura.getValue().toString().isEmpty()){

            k = temperatura.getValue().doubleValue();

        }

        Boolean v = validar.validarViscosidadFinal(kv1,kv2,x1,k);

        if(v){

            Double valor = calculos.calcularViscosidad(kv1,kv2,x1,k);

            text_resultado.setStyle("-fx-border-color: blue;");

            text_resultado.setText(valor.toString());

        }

    }

    @FXML
    private void reset() {

        text_porcentaje.setText(null);
        text_aceite1.setText(null);
        text_aceite2.setText(null);

        text_resultado.setStyle("-fx-border-color: inherit;");
        text_resultado.setText(null);

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

        text_porcentaje.setOnKeyPressed(e->validar.validarNumeros(e));
        text_porcentaje.setOnKeyReleased(e->validar.validarNumeros(e));

    }

    public ViscoController() {

        this.calculos = new CalculosImpl();
        this.validar = new ValidarImpl();

    }
}
