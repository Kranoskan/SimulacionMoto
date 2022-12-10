/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionmoto;

import java.util.ArrayList;

/**
 *
 * @author ismae
 */
class BMS {

    int voltajeMax;
    int temperaturaMax;
    int voltajeMaxCelulas;
    int voltajeReactivación;
    int temperaturaSegura;

    public BMS() {
        this.voltajeMax = 0;
        this.temperaturaMax = 0;
        this.voltajeMaxCelulas = 0;
        this.voltajeReactivación =0;
        this.temperaturaSegura = 0;
    }

    //////////////////////////GETTERS//////////////////////////
    public int getVoltajeMax() {
        return voltajeMax;
    }

    public int getTemperaturaMax() {
        return temperaturaMax;
    }

    public int getVoltajeMaxCelulas() {
        return voltajeMaxCelulas;
    }

    public int getVoltajeReactivación() {
        return voltajeReactivación;
    }

    public int getTemperaturaSegura() {
        return temperaturaSegura;
    }

    /////////////////////SETTERS//////////////////////
    public void setVoltajeMax(int voltajeMax) {
        this.voltajeMax = voltajeMax;
    }

    public void setTemperaturaMax(int temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public void setVoltajeMaxCelulas(int voltajeMaxCelulas) {
        this.voltajeMaxCelulas = voltajeMaxCelulas;
    }

    public void setVoltajeReactivación(int voltajeReactivación) {
        this.voltajeReactivación = voltajeReactivación;
    }

    public void setTemperaturaSegura(int temperaturaSegura) {
        this.temperaturaSegura = temperaturaSegura;
    }

    @Override
    public String toString() {
        return "BMS{" + "voltajeMax=" + voltajeMax + ", temperaturaMax=" + temperaturaMax + ", voltajeMaxCelulas=" + voltajeMaxCelulas + ", voltajeReactivaci\u00f3n=" + voltajeReactivación + ", temperaturaSegura=" + temperaturaSegura + '}';
    }
    
}
