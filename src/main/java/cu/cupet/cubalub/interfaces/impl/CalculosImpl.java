package cu.cupet.cubalub.interfaces.impl;

import cu.cupet.cubalub.interfaces.bo.CalculosBO;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Creado a las 0:44 del día 22/02/17.
 *
 * @author Eduardo Noel Núñez <enoel.corebsd@gmail.com>
 */
public class CalculosImpl implements Serializable, CalculosBO {

    private HashMap<String, Double> factor_elemento = new HashMap<>();


    public CalculosImpl() {

        factor_elemento.put("Zinc", 1.5);
        factor_elemento.put("Bario", 1.7);
        factor_elemento.put("Sodio", 3.09);
        factor_elemento.put("Calcio", 3.40);
        factor_elemento.put("Magnesio", 4.95);
        factor_elemento.put("Boro", 3.22);
        factor_elemento.put("Potasio", 2.23);
        factor_elemento.put("Litio", 7.92);
        factor_elemento.put("Manganesio", 1.291);
        factor_elemento.put("Molibdeno", 1.5);
        factor_elemento.put("Cobre", 1.252);
        factor_elemento.put("Plomo", 1.464);

    }

    @Override
    public Double calcularViscosidad(Double kv1, Double kv2, Double x1, Double k) {

        Double valor = (100 * (Math.exp(Math.log(kv2 + k) * Math.exp(x1 * Math.log(Math.log(kv1 + k) / Math.log(kv2 + k)))) - k)) / 100;

        Double resultado = Precision.round(valor, 0);

        return resultado;

    }

    @Override
    public HashMap<String, Double> calcularPorcentajeMezcla(Double kv1, Double kv2, Double kv, Double k) {

        HashMap<String, Double> resultado = new HashMap<>();

        Double a = Math.log(kv + k);
        Double b = Math.log(kv1 + k);
        Double c = Math.log(kv2 + k);

        Double PA1 = (10000 * (Math.log(a / c) / Math.log(b / c))) / 100;
        Double PA2 = 100 - PA1;

        resultado.put("PA1", Precision.round(PA1, 0));
        resultado.put("PA2", Precision.round(PA2, 0));

        return resultado;

    }

    @Override
    public Double calcIndiceViscosidad(Double Q1, Double Q2) {

        Double Q3 = 0D;
        Double Q4 = 0D;
        Double Q5 = 0D;
        Double Q6 = 0D;
        Double Q7 = 0D;


        if (Q2 >= 2 && Q2 < 4) {
            Q3 = 0.827 * Math.pow(Q2, 2) + 1.632 * Q2 - 0.181;
            Q4 = 0.3094 * Math.pow(Q2, 2) + 0.182 * Q2;
            Q6 = (Q3 + Q4 - Q1) / Q4 * 100;
        }

        if (Q2 >= 4 && Q2 < 6.1) {
            Q3 = -2.6758 * Math.pow(Q2, 2) + 96.671 * Q2 - 269.664 * Math.sqrt(Q2) + 215.025;
            Q4 = -7.1955 * Math.pow(Q2, 2) + 241.992 * Q2 - 725.478 * Math.sqrt(Q2) + 603.88;
            Q6 = (Q3 + Q4 - Q1) / Q4 * 100;
        }

        if (Q2 >= 6.1 && Q2 < 7.2) {
            Q3 = 2.32 * Math.pow(Q2, 1.5626);
            Q4 = 2.838 * Math.pow(Q2, 2) - 27.35 * Q2 + 81.83;
            Q6 = (Q3 + Q4 - Q1) / Q4 * 100;
        }

        if (Q2 >= 7.2 && Q2 < 12.4) {
            Q3 = 0.1922 * Math.pow(Q2, 2) + 8.25 * Q2 - 18.728;
            Q4 = 0.5463 * Math.pow(Q2, 2) + 2.442 * Q2 - 14.16;
            Q6 = (Q3 + Q4 - Q1) / Q4 * 100;
        }

        if (Q2 >= 12.4 && Q2 <= 70) {
            Q3 = 1795.2 * Math.pow(Q2, (-2)) + 0.1818 * Math.pow(Q2, 2) + 10.357 *
                    Q2 - 54.547;
            Q4 = 0.6995 * Math.pow(Q2, 2) - 1.19 * Q2 + 7.6;
            Q6 = (Q3 + Q4 - Q1) / Q4 * 100;
        }

        if (Q2 > 70) {
            Q3 = 0.1684 * Math.pow(Q2, 2) + 11.85 * Q2 - 97;
            Q5 = 0.8353 * Math.pow(Q2, 2) + 14.67 * Q2 - 216;
            Q4 = 0.6669 * Math.pow(Q2, 2) + 2.82 * Q2 - 119;
            Q6 = (Q5 - Q1) / Q4 * 100;
        }


        if (Q6 >= 100) {

            Q7 = ((Math.log(Q3) / Math.log(10)) - (Math.log(Q1) / Math.log(10))) /
                    (Math.log(Q2) / Math.log(10));
            Q6 = ((Math.pow(10, Q7) - 1) / 0.00715) + 100;

        }

        Double valor = Precision.round(Q6 + 0.5, 0);

        return valor;

    }

    @Override
    public Double calcKv40(Double vindex, Double kv100) {

        Double Vi = 0D;

        Double n = kv100;

        do {

            Vi = calcIndiceViscosidad(n, kv100);
            n = n + 0.05;

        } while (Vi >= vindex && n <= 2000);

        n = (n * 100 + 0.1) / 100;

        return Precision.round(n, 2);
    }

    @Override
    public Double calcKv100(Double vindex, Double kv40) {

        Double Vi = 0D;

        Double n = 2D;

        do {

            Vi = calcIndiceViscosidad(kv40, n);
            n = n + 0.01;

        } while (Vi <= vindex && n <= 500);

        n = (n * 100 + 0.1) / 100;

        return Precision.round(n, 2);

    }

    @Override
    public Double calcCenizasSulfatadas(String elemento, Double porciento_elemento, Double masa_fijada) {

        Double valor = 0D;

        valor = (porciento_elemento*factor_elemento.get(elemento)*masa_fijada)/100;

        return valor;
    }
}
