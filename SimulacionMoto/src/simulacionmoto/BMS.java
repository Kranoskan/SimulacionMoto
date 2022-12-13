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

    Float voltajeMax;
    Float temperaturaMax;
    Float voltajeMaxCelulas;
    Float voltajeReactivación;
    Float temperaturaSegura;
    

    public BMS() {
        this.voltajeMax = 0.0f;
        this.temperaturaMax = 0.0f;
        this.voltajeMaxCelulas = 0.0f;
        this.voltajeReactivación = 0.0f;
        this.temperaturaSegura = 0.0f;
    }

    //////////////////////////GETTERS//////////////////////////
    public float getVoltajeMax() {
        return voltajeMax;
    }

    public float getTemperaturaMax() {
        return temperaturaMax;
    }

    public float getVoltajeMaxCelulas() {
        return voltajeMaxCelulas;
    }

    public float getVoltajeReactivación() {
        return voltajeReactivación;
    }

    public float getTemperaturaSegura() {
        return temperaturaSegura;
    }

    /////////////////////SETTERS//////////////////////
    public void setVoltajeMax(float voltajeMax) {
        this.voltajeMax = voltajeMax;
    }

    public void setTemperaturaMax(float temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public void setVoltajeMaxCelulas(float voltajeMaxCelulas) {
        this.voltajeMaxCelulas = voltajeMaxCelulas;
    }

    public void setVoltajeReactivación(float voltajeReactivación) {
        this.voltajeReactivación = voltajeReactivación;
    }

    public void setTemperaturaSegura(float temperaturaSegura) {
        this.temperaturaSegura = temperaturaSegura;
    }

    @Override
    public String toString() {
        return "BMS{" + "voltajeMax=" + voltajeMax + ", temperaturaMax=" + temperaturaMax + ", voltajeMaxCelulas=" + voltajeMaxCelulas + ", voltajeReactivaci\u00f3n=" + voltajeReactivación + ", temperaturaSegura=" + temperaturaSegura + '}';
    }
    
}