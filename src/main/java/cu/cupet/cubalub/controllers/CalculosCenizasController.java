package cu.cupet.cubalub.controllers;

import cu.cupet.cubalub.interfaces.bo.CalculosBO;
import cu.cupet.cubalub.interfaces.bo.ValidarBO;
import cu.cupet.cubalub.interfaces.impl.CalculosImpl;
import cu.cupet.cubalub.interfaces.impl.ValidarImpl;
import cu.cupet.cubalub.utiles.AdminStages;
import cu.cupet.cubalub.utiles.TGraficos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

@Controller(value = "cenizas")
public class CalculosCenizasController implements Serializable, Initializable {

    private Double masa_fijada;

    @Autowired
    private CalculosBO calculos;

    @Autowired
    private ValidarBO validar;

    @FXML
    private TextField text_fijarmasa;

    @FXML
    private TextField text_masa_elemento;

    @FXML
    private TextField text_final;

    @FXML
    private ComboBox<String> combo_elemento;

    @FXML
    private TableView<ElementosTabla> tabla_temp = new TableView<ElementosTabla>();

    @FXML
    private TableColumn<ElementosTabla, String> tabla_col_elemento;

    @FXML
    private TableColumn<ElementosTabla, Double> tabla_col_resultado;

    @FXML
    private Button btn_fijar;

    @FXML
    private Button btn_calcular;

    @FXML
    private Button btn_cerrar;

    @FXML
    private Button btn_final;

    @FXML
    private void cerrarCalculo(){

        AdminStages.Singleton().cerrarCenizas();

    }

    @FXML
    private void fijar_masa(){

        if (!text_fijarmasa.getText().isEmpty()){

            masa_fijada = Double.parseDouble(text_fijarmasa.getText());

            text_fijarmasa.setEditable(false);

            text_fijarmasa.setStyle("-fx-text-fill: red; -fx-border-color: blue");

            btn_fijar.setDisable(true);

        }

    }

    @FXML
    private void calc_temp(){

        String elemento = "";
        Double porciento_elemento = 0D;

        if (!text_masa_elemento.getText().isEmpty() && !combo_elemento.getSelectionModel().isEmpty() && !text_fijarmasa.isEditable()){

            elemento = combo_elemento.getSelectionModel().getSelectedItem();

            porciento_elemento = Double.parseDouble(text_masa_elemento.getText());

            Double valor = calculos.calcCenizasSulfatadas(elemento,porciento_elemento,masa_fijada);

            ElementosTabla temp = new ElementosTabla(elemento,valor);

            tabla_temp.getItems().add(temp);
            tabla_temp.refresh();

            combo_elemento.getItems().remove(elemento);

            this.reset();

        }

    }

    @FXML
    private void calculo_final(){


        Boolean v = validar.validarCenizasSulfatadas(tabla_temp.getItems().size());

        if (v){

            ObservableList<ElementosTabla> lista = tabla_temp.getItems();

            Double resultado = 0D;

            for ( ElementosTabla elem : lista) {

                resultado += elem.resultado;

            }

            Double valor_final = Precision.round(resultado,3);

            text_final.setText(valor_final.toString());
            text_final.setEditable(false);
            text_final.setStyle("-fx-text-fill: red; -fx-border-color: blue");

        }

    }

    private void reset(){

        text_masa_elemento.setText("");
        combo_elemento.getSelectionModel().clearSelection();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        text_fijarmasa.setOnKeyPressed(e->validar.validarNumeros(e));
        text_fijarmasa.setOnKeyReleased(e->validar.validarNumeros(e));

        combo_elemento.getItems().add("Zinc");
        combo_elemento.getItems().add("Bario");
        combo_elemento.getItems().add("Sodio");
        combo_elemento.getItems().add("Calcio");
        combo_elemento.getItems().add("Magnesio");
        combo_elemento.getItems().add("Boro");
        combo_elemento.getItems().add("Potasio");
        combo_elemento.getItems().add("Litio");
        combo_elemento.getItems().add("Manganesio");
        combo_elemento.getItems().add("Molibdeno");
        combo_elemento.getItems().add("Cobre");
        combo_elemento.getItems().add("Plomo");

        masa_fijada = 0D;

        btn_cerrar.setGraphic(TGraficos.Singleton().getCerrar());

        tabla_col_elemento.setCellValueFactory(new PropertyValueFactory("elemento"));
        tabla_col_resultado.setCellValueFactory(new PropertyValueFactory("resultado"));

        tabla_temp.setItems(FXCollections.observableArrayList());

    }

    public CalculosCenizasController() {

        this.calculos = new CalculosImpl();
        this.validar = new ValidarImpl();

    }

    public class ElementosTabla{

        private String elemento;
        private Double resultado;

        public String getElemento() {
            return elemento;
        }

        public void setElemento(String elemento) {
            this.elemento = elemento;
        }

        public Double getResultado() {
            return resultado;
        }

        public void setResultado(Double resultado) {
            this.resultado = resultado;
        }

        public ElementosTabla(String elemento, Double resultado) {
            this.elemento = elemento;
            this.resultado = resultado;
        }
    }
}
