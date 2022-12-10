/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionmoto;

import java.util.ArrayList;

/**
 *
 * @author Pc
 */
public class Circuito {
     ArrayList<Float> distanciaSectores;
     ArrayList<Float> curvaSector;
     ArrayList<Float> pendienteSector;
     ArrayList<Float> velocidadMaximaCalculada;
     ArrayList<Float> velocidadMinimaCalculada;

    public Circuito() {
        this.distanciaSectores = new ArrayList();
        this.curvaSector = new ArrayList();
        this.pendienteSector = new ArrayList();
        this.velocidadMaximaCalculada = new ArrayList();
        this.velocidadMinimaCalculada = new ArrayList();
    }

    public ArrayList<Float> getDistanciaSectores() {
        return distanciaSectores;
    }

    public ArrayList<Float> getCurvaSector() {
        return curvaSector;
    }

    public ArrayList<Float> getPendienteSector() {
        return pendienteSector;
    }

    public ArrayList<Float> getVelocidadMaximaCalculada() {
        return velocidadMaximaCalculada;
    }

    public ArrayList<Float> getVelocidadMinimaCalculada() {
        return velocidadMinimaCalculada;
    }

    public void setDistanciaSectores(ArrayList<Float> distanciaSectores) {
        this.distanciaSectores = distanciaSectores;
    }

    public void setCurvaSector(ArrayList<Float> curvaSector) {
        this.curvaSector = curvaSector;
    }

    public void setPendienteSector(ArrayList<Float> pendienteSector) {
        this.pendienteSector = pendienteSector;
    }

    public void setVelocidadMaximaCalculada(ArrayList<Float> velocidadMaximaCalculada) {
        this.velocidadMaximaCalculada = velocidadMaximaCalculada;
    }

    public void setVelocidadMinimaCalculada(ArrayList<Float> velocidadMinimaCalculada) {
        this.velocidadMinimaCalculada = velocidadMinimaCalculada;
    }

    
}
