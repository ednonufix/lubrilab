package cu.cupet.cubalub.controllers;

import cu.cupet.cubalub.interfaces.bo.CalculosBO;
import cu.cupet.cubalub.interfaces.bo.ValidarBO;
import cu.cupet.cubalub.interfaces.impl.CalculosImpl;
import cu.cupet.cubalub.interfaces.impl.ValidarImpl;
import cu.cupet.cubalub.utiles.AdminStages;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
@Controller(value = "iv")
public class IVController implements Serializable, Initializable {

    @Autowired
    private CalculosBO calculos;

    @Autowired
    private ValidarBO validar;

    @FXML
    private TextField text_visco_40;

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

        AdminStages.Singleton().cerrarIndiceViscosidad();

    }

    @FXML
    private void calcularIV(){

        Double Q1 = null;
        Double Q2 = null;

        if(!text_visco_40.getText().isEmpty()){

            Q1 = Double.parseDouble(text_visco_40.getText());

        }

        if (!text_visco_100.getText().isEmpty()){

            Q2 = Double.parseDouble(text_visco_100.getText());

        }

        Boolean v = validar.validarIV(Q1,Q2);

        if(v){

            Double valor = calculos.calcIndiceViscosidad(Q1,Q2);

            text_resultado.setStyle("-fx-border-color: blue;");

            text_resultado.setText(valor.toString());

        }

    }

    @FXML
    private void reset() {

        text_visco_40.setText(null);
        text_visco_100.setText(null);
        text_resultado.setText(null);

        text_resultado.setStyle("-fx-border-color: inherit;");
        text_resultado.setText(null);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        text_visco_40.setOnKeyPressed(e->validar.validarNumeros(e));
        text_visco_40.setOnKeyReleased(e->validar.validarNumeros(e));

        text_visco_100.setOnKeyPressed(e->validar.validarNumeros(e));
        text_visco_100.setOnKeyReleased(e->validar.validarNumeros(e));

    }


    public IVController() {

        this.calculos = new CalculosImpl();
        this.validar = new ValidarImpl();

    }
}
