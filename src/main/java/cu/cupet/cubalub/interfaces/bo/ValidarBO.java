package cu.cupet.cubalub.interfaces.bo;

import javafx.scene.input.KeyEvent;

/**
 * Creado a las 18:06 del día 22/02/17.
 *
 * @author Eduardo Noel Núñez <enoel.corebsd@gmail.com>
 */
public interface ValidarBO {

    public void validarNumeros(KeyEvent e);
    public Boolean validarIV(Double Q1, Double Q2);
    public Boolean validarIV40(Double vindex, Double kv100);
    public Boolean validarIV100(Double vindex, Double kv40);
    public Boolean validarViscosidadFinal(Double kv1, Double kv2, Double x1, Double k);
    public Boolean validarPorcentajeMezcla(Double kv1, Double kv2, Double kv, Double k);
    public Boolean validarCenizasSulfatadas(Integer cantidad);

}

