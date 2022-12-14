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
class RestriccionesMotoYBMS {
    
    public Float volt_max_bateria;
    public Float volt_max_celulas;
    public Float intensidad;
    public Float velocidad_max;
    public Float potencia_motor;
    public Float temperatura_max;
    public Float peso;
    public Float capaciadBateria;
    public Float tem_inicial;
    public  int cargasRefigerante;
    public Float fuerzaRefirgerante;

    public RestriccionesMotoYBMS() {
        this.volt_max_bateria = 0f;
        this.volt_max_celulas = 0f;
        this.intensidad = 0f;
        this.velocidad_max = 0f;
        this.potencia_motor = 48f;
        this.temperatura_max = 0f;
        this.peso = 120f;
        this.capaciadBateria = 200f;
        this.tem_inicial=30f;
        cargasRefigerante=0;
        fuerzaRefirgerante=5f;
    }

    ////////////////////////GETTERS//////////////////////////
    public Float getVolt_max_bateria() {
        return volt_max_bateria;
    }

    public Float getVolt_max_celulas() {
        return volt_max_celulas;
    }

    public Float getIntensidad() {
        return intensidad;
    }

    public Float getVelocidad_max() {
        return velocidad_max;
    }

    public Float getPotencia_motor() {
        return potencia_motor;
    }

    public Float getTemperatura_max() {
        return temperatura_max;
    }

    public Float getPeso() {
        return peso;
    }

    public Float getCapacidadBateria() {
        return capaciadBateria;
    }

    public Float getTem_inicial() {
        return tem_inicial;
    }
    
    //////////////////////////SETTERS/////////////////////////////
    public void setVolt_max_bateria(Float volt_max_bateria) {
        this.volt_max_bateria = volt_max_bateria;
    }

    public void setVolt_max_celulas(Float volt_max_celulas) {
        this.volt_max_celulas = volt_max_celulas;
    }

    public void setIntensidad(Float intensidad) {
        this.intensidad = intensidad;
    }

    public void setVelocidad_max(Float velocidad_max) {
        this.velocidad_max = velocidad_max;
    }

    public void setPotencia_motor(Float potencia_motor) {
        this.potencia_motor = potencia_motor;
    }

    public void setTemperatura_max(Float temperatura_max) {
        this.temperatura_max = temperatura_max;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setCapacidad(Float capacidad) {
        this.capaciadBateria = capacidad;
    }


    public void setTem_inicial(Float tem_inicial) {
        this.tem_inicial = tem_inicial;
    }

    @Override
    public String toString() {
        return "RestriccionesMotoYBMS{" + "volt_max_bateria=" + volt_max_bateria + ", volt_max_celulas=" + volt_max_celulas + ", intensidad=" + intensidad + ", velocidad_max=" + velocidad_max + ", potencia_motor=" + potencia_motor + ", temperatura_max=" + temperatura_max + ", peso=" + peso + ", capaciadBateria=" + capaciadBateria + ", tem_inicial=" + tem_inicial + '}';
    }

    public boolean ConfiguracionPosible(){
        return false;
    }

    int getCapacidadEnfriado() {
        return this.cargasRefigerante;
    }

    float getFuerzaEnfriado() {
        return this.fuerzaRefirgerante;
    }
}