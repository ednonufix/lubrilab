package cu.cupet.cubalub.interfaces.impl;

import cu.cupet.cubalub.interfaces.bo.ValidarBO;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;

/**
 * Creado a las 18:04 del día 22/02/17.
 *
 * @author Eduardo Noel Núñez <enoel.corebsd@gmail.com>
 */
@Repository
public class ValidarImpl implements Serializable, ValidarBO {

    @Override
    public void validarNumeros(KeyEvent e) {

        String type = e.getEventType().getName();
        KeyCode keyCode = e.getCode();

        if (e.getEventType() == KEY_PRESSED &&
                !(e.getCode() == KeyCode.DIGIT0 ||
                        e.getCode() == KeyCode.DIGIT1 ||
                        e.getCode() == KeyCode.DIGIT2 ||
                        e.getCode() == KeyCode.DIGIT3 ||
                        e.getCode() == KeyCode.DIGIT4 ||
                        e.getCode() == KeyCode.DIGIT5 ||
                        e.getCode() == KeyCode.DIGIT6 ||
                        e.getCode() == KeyCode.DIGIT7 ||
                        e.getCode() == KeyCode.DIGIT8 ||
                        e.getCode() == KeyCode.DIGIT9 ||
                        e.getCode() == KeyCode.NUMPAD0 ||
                        e.getCode() == KeyCode.NUMPAD1 ||
                        e.getCode() == KeyCode.NUMPAD2 ||
                        e.getCode() == KeyCode.NUMPAD3 ||
                        e.getCode() == KeyCode.NUMPAD4 ||
                        e.getCode() == KeyCode.NUMPAD5 ||
                        e.getCode() == KeyCode.NUMPAD6 ||
                        e.getCode() == KeyCode.NUMPAD7 ||
                        e.getCode() == KeyCode.NUMPAD8 ||
                        e.getCode() == KeyCode.NUMPAD9 ||
                        e.getCode() == KeyCode.PERIOD ||
                        e.getCode() == KeyCode.DECIMAL ||
                        e.getCode() == KeyCode.BACK_SPACE ||
                        e.getCode() == KeyCode.TAB)) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Solo debe incluir números en este campo");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

        }

    }

    @Override
    public Boolean validarIV(Double Q1, Double Q2) {

        if(Q1 == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico en el indice de viscosidad a 40ºC");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(Q2 == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico en el indice de viscosidad a 100ºC");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(Q1 <= 2){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("El indice de viscosidad a 40ºC no puede ser menor que 2");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(Q2 <= 2){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("El indice de viscosidad a 100ºC no puede ser menor que 2");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if (Q1 <= Q2){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("El indice de viscosidad a 40ºC tiene que ser mayor que a 100ºC");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);


            return false;
        }

        return true;

    }

    @Override
    public Boolean validarIV40(Double vindex, Double kv100) {

        if(vindex == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico para el indice de viscosidad");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(kv100 == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico en el indice de viscosidad a 100ºC");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(kv100 <= 2){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("El indice de viscosidad a 100ºC no puede ser menor que 2");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        return true;

    }

    @Override
    public Boolean validarIV100(Double vindex, Double kv40) {

        if(vindex == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico para el índice de viscosidad");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(kv40 == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico en el índice de viscosidad a 40ºC");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(kv40 <= 2){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("El indice de viscosidad a 40ºC no puede ser menor que 2");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        return true;

    }

    @Override
    public Boolean validarViscosidadFinal(Double kv1, Double kv2, Double kv, Double k) {

        if(kv1 == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico en el índice de viscosidad del Aceite 1");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(kv2 == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico en el índice de viscosidad del Aceite 2");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(kv == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico en porcentaje del Aceite 1");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(k == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico en la temperatura");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        return true;
    }

    @Override
    public Boolean validarPorcentajeMezcla(Double kv1, Double kv2, Double x1, Double k) {

        if(kv1 == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico en el índice de viscosidad del Aceite 1");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(kv2 == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico en el índice de viscosidad del Aceite 2");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(x1 == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico para la viscosidad deseada");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        if(k == null){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe introducir un valor numérico en la temperatura");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }


        return true;
    }

    @Override
    public Boolean validarCenizasSulfatadas(Integer cantidad) {

        if (cantidad.equals(0)){

            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("Debe haber calculado previamente el valor de algún elemento");
            alert.getDialogPane().setHeaderText("Atención: Usted está cometiendo un error al introducir los datos");
            alert.showAndWait().filter(response -> response == ButtonType.OK);

            return false;

        }

        return true;
    }
}
