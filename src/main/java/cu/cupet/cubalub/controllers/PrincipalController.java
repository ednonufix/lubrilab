package cu.cupet.cubalub.controllers;

import cu.cupet.cubalub.utiles.AdminStages;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Eduardo Noel <enoel.corebsd@gmail.com>
 */
public class PrincipalController implements Initializable {

    ImageView cerrar = new ImageView("/img/process-stop.png");

    @FXML
    private MenuItem menu_cerrar = new MenuItem();

    @FXML
    private MenuItem menu_viscosidad = new MenuItem();


    @FXML
    private void cerrarApp(){

        System.exit(0);

    }

    @FXML
    private void mostrarViscosidad(){

        try {

            AdminStages.Singleton().mostrarViscoFinal();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void mostrarPorcentajeMezcla(){

        try {

            AdminStages.Singleton().mostrarPorcentajeMezcla();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void mostrarIV(){

        try {

            AdminStages.Singleton().mostrarIndiceViscosidad();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void mostrarIV40(){

        try {

            AdminStages.Singleton().mostrarIndiceViscosidad40();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void mostrarIV100(){

        try {

            AdminStages.Singleton().mostrarIndiceViscosidad100();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void mostrarCenizas(){

        try {

            AdminStages.Singleton().mostrarCenizas();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        menu_cerrar.setGraphic(cerrar);

    }



}
