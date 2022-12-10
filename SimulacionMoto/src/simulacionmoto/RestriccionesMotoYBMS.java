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
    
    public int volt_max_bateria;
    public int volt_max_celulas;
    public int intensidad;
    public int velocidad_max;
    public int potencia_motor;
    public int temperatura_max;
    public int peso;
    public int capacidad;

    public RestriccionesMotoYBMS() {
        this.volt_max_bateria = 0;
        this.volt_max_celulas = 0;
        this.intensidad = 0;
        this.velocidad_max = 0;
        this.potencia_motor = 0;
        this.temperatura_max = 0;
        this.peso = 0;
        this.capacidad = 0;
    }

    ////////////////////////GETTERS//////////////////////////
    public int getVolt_max_bateria() {
        return volt_max_bateria;
    }

    public int getVolt_max_celulas() {
        return volt_max_celulas;
    }

    public int getIntensidad() {
        return intensidad;
    }

    public int getVelocidad_max() {
        return velocidad_max;
    }

    public int getPotencia_motor() {
        return potencia_motor;
    }

    public int getTemperatura_max() {
        return temperatura_max;
    }

    public int getPeso() {
        return peso;
    }

    public int getCapacidad() {
        return capacidad;
    }
    
    //////////////////////////SETTERS/////////////////////////////
    public void setVolt_max_bateria(int volt_max_bateria) {
        this.volt_max_bateria = volt_max_bateria;
    }

    public void setVolt_max_celulas(int volt_max_celulas) {
        this.volt_max_celulas = volt_max_celulas;
    }

    public void setIntensidad(int intensidad) {
        this.intensidad = intensidad;
    }

    public void setVelocidad_max(int velocidad_max) {
        this.velocidad_max = velocidad_max;
    }

    public void setPotencia_motor(int potencia_motor) {
        this.potencia_motor = potencia_motor;
    }

    public void setTemperatura_max(int temperatura_max) {
        this.temperatura_max = temperatura_max;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    void mostrarRestricciones(){
        System.out.println("RestriccionesMotoYBMS{" + "volt_max_bateria=" + volt_max_bateria + ", volt_max_celulas=" + volt_max_celulas + ",\n intensidad=" + intensidad + ", velocidad_max=" + velocidad_max + ", potencia_motor=" + potencia_motor + ", temperatura_max=" + temperatura_max + ", peso=" + peso + ", capacidad=" + capacidad + '}');
        
    }

    @Override
    public String toString() {
        return "RestriccionesMotoYBMS{" + "volt_max_bateria=" + volt_max_bateria + ", volt_max_celulas=" + volt_max_celulas + ", intensidad=" + intensidad + ", velocidad_max=" + velocidad_max + ", potencia_motor=" + potencia_motor + ", temperatura_max=" + temperatura_max + ", peso=" + peso + ", capacidad=" + capacidad + '}';
    }
    
    public boolean ConfiguracionPosible(){
        return false;
    }
}
