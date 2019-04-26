package cu.cupet.cubalub.controllers;

import cu.cupet.cubalub.utiles.AdminStages;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Creado a las 18:35 del día 22/02/17.
 *
 * @author Eduardo Noel Núñez <enoel.corebsd@gmail.com>
 */
public class ValidarController implements Serializable,Initializable {

    @FXML
    public void cerrarValidar(){

        AdminStages.Singleton().cerrarValidar();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
