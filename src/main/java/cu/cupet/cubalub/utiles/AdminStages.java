
package cu.cupet.cubalub.utiles;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author Eduardo Noel <enoel.corebsd@gmail.com>
 */
public class AdminStages {

    final Stage stage_visco_final = new Stage();
    final Stage stage_porcentaje_mezcla = new Stage();
    final Stage stage_validar_numero = new Stage();
    final Stage stage_iv = new Stage();
    final Stage stage_iv_40 = new Stage();
    final Stage stage_iv_100 = new Stage();
    final Stage stage_cenizas = new Stage();

    private AdminStages() {
    }

    public static AdminStages Singleton() {

        return AdminStagesHolder.INSTANCE;

    }

    private static class AdminStagesHolder {

        private static final AdminStages INSTANCE = new AdminStages();
    }

    public void mostrarViscoFinal() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Visco.fxml"));

        Scene scene = new Scene(root);

        stage_visco_final.setScene(scene);

        stage_visco_final.setTitle("Cálculo de la viscosidad final de una mezcla");
        stage_visco_final.setResizable(false);
        stage_visco_final.show();

    }

    public void cerrarViscoFinal(){

        stage_visco_final.close();

    }

    public void mostrarValidarNumeros() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ValidarNumero.fxml"));

        Scene scene = new Scene(root);

        stage_validar_numero.setScene(scene);

        stage_validar_numero.setTitle("Error de datos");
        stage_validar_numero.setResizable(false);
        stage_validar_numero.show();

    }

    public void cerrarValidar(){

        stage_validar_numero.close();

    }

    public void mostrarPorcentajeMezcla() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Porcentaje_Mezcla.fxml"));

        Scene scene = new Scene(root);

        stage_porcentaje_mezcla.setScene(scene);

        stage_porcentaje_mezcla.setTitle("Cálculo de porcentaje de mezcla");
        stage_porcentaje_mezcla.setResizable(false);
        stage_porcentaje_mezcla.show();

    }

    public void cerrarPorcentajeMezcla(){

        stage_porcentaje_mezcla.close();

    }

    public void mostrarIndiceViscosidad() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/IV.fxml"));

        Scene scene = new Scene(root);

        stage_iv.setScene(scene);

        stage_iv.setTitle("Cálculo de Índice de Viscosidad");
        stage_iv.setResizable(false);
        stage_iv.show();

    }

    public void cerrarIndiceViscosidad(){

        stage_iv.close();

    }

    public void mostrarIndiceViscosidad40() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/IV40.fxml"));

        Scene scene = new Scene(root);

        stage_iv_40.setScene(scene);

        stage_iv_40.setTitle("Calcular la Viscosidad cSt a 40ºC ");
        stage_iv_40.setResizable(false);
        stage_iv_40.show();

    }

    public void cerrarIndiceViscosidad40(){

        stage_iv_40.close();

    }

    public void mostrarIndiceViscosidad100() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/IV100.fxml"));

        Scene scene = new Scene(root);

        stage_iv_100.setScene(scene);

        stage_iv_100.setTitle("Calcular la Viscosidad cSt a 100ºC ");
        stage_iv_100.setResizable(false);
        stage_iv_100.show();

    }

    public void cerrarIndiceViscosidad100(){

        stage_iv_100.close();

    }

    public void mostrarCenizas() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CalculoCenizas.fxml"));

        Scene scene = new Scene(root);

        stage_cenizas.setScene(scene);

        stage_cenizas.setTitle("Calcular cenizas sulfatadas");
        stage_cenizas.setResizable(false);
        stage_cenizas.show();

    }

    public void cerrarCenizas(){

        stage_cenizas.close();

    }

}
