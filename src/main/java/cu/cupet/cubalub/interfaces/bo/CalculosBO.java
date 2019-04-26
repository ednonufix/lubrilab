package cu.cupet.cubalub.interfaces.bo;

import java.util.HashMap;

/**
 * Creado a las 0:43 del día 22/02/17.
 *
 * @author Eduardo Noel Núñez <enoel.corebsd@gmail.com>
 */
public interface CalculosBO {

    public Double calcularViscosidad(Double kv1, Double kv2, Double x1, Double k);
    public HashMap<String,Double> calcularPorcentajeMezcla(Double kv1, Double kv2, Double kv, Double k);
    public Double calcIndiceViscosidad(Double Q1, Double Q2);
    public Double calcKv40(Double vindex, Double kv100);
    public Double calcKv100(Double vindex, Double kv40);
    public Double calcCenizasSulfatadas(String elemento, Double porciento_elemento,Double masa_fijada);

}
