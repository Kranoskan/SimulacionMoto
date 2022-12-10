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
class Piloto {
    BMS bms;
    ArrayList<Float> bateriaUsadaAceleracioSector;
    ArrayList<Float> bateriaUsadaRefrigeracionSector;
    ArrayList<Float> distanciaAceleradaSector;
    ArrayList<Float> distanciaFrenadaSector;
    int tiempo;//tiempo en segundos
    Float bateriaRestante;

    public Piloto(BMS bms, Float bateriaRestante) {
        this.bms = bms;
        this.bateriaUsadaAceleracioSector = new ArrayList<>();
        this.bateriaUsadaRefrigeracionSector = new ArrayList<>();
        this.distanciaAceleradaSector = new ArrayList<>();
        this.distanciaFrenadaSector = new ArrayList<>();
        this.tiempo = 0;
        this.bateriaRestante = bateriaRestante;
    }
    
    Moto moto;
    

    void setConfiguracion(Circuito circuito, float rand) {
        moto.iniciar();
        for(int i=0;i<circuito.getDistanciaSectores().size();i++){
        
            //pilotoMicrosector newMicroSector= new pilotoMicrosector();
            if(moto.getVelocidad()<circuito1.get(0) && moto.hayBateria()){
                newMicroSector.set(moto.acelerar(rand));
            }else{
                newMicroSector.set(moto.frenar(rand));
            }
            comportamiento.add(newMicroSector);
        }
        actualizarEstado();
    }

    private void actualizarEstado() {
        //bms.s=moto.getVelocidadMax();
        //aceleracionMax=moto.getAceleracionMax();
        bms.setVoltajeMax(moto.getVoltajeMax());
        bms.setTemperaturaMax(moto.getTemMax());
        //consumo= moto.getConsumo();
    }

    /////////////////////GETTERS//////////////////////////
    public BMS getBms() {
        return bms;
    }

    public ArrayList<Float> getBateriaUsadaAceleracioSector() {
        return bateriaUsadaAceleracioSector;
    }

    public ArrayList<Float> getBateriaUsadaRefrigeracionSector() {
        return bateriaUsadaRefrigeracionSector;
    }

    public ArrayList<Float> getDistanciaAceleradaSector() {
        return distanciaAceleradaSector;
    }

    public ArrayList<Float> getDistanciaFrenadaSector() {
        return distanciaFrenadaSector;
    }

    public int getTiempo() {
        return tiempo;
    }

    public Float getBateriaRestante() {
        return bateriaRestante;
    }
    
    
    ////////////////////SETTERS/////////////////////////

    public void setBms(BMS bms) {
        this.bms = bms;
    }

    public void setBateriaUsadaAceleracioSector(ArrayList<Float> bateriaUsadaAceleracioSector) {
        this.bateriaUsadaAceleracioSector = bateriaUsadaAceleracioSector;
    }

    public void setBateriaUsadaRefrigeracionSector(ArrayList<Float> bateriaUsadaRefrigeracionSector) {
        this.bateriaUsadaRefrigeracionSector = bateriaUsadaRefrigeracionSector;
    }

    public void setDistanciaAceleradaSector(ArrayList<Float> distanciaAceleradaSector) {
        this.distanciaAceleradaSector = distanciaAceleradaSector;
    }

    public void setDistanciaFrenadaSector(ArrayList<Float> distanciaFrenadaSector) {
        this.distanciaFrenadaSector = distanciaFrenadaSector;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setBateriaRestante(Float bateriaRestante) {
        this.bateriaRestante = bateriaRestante;
    }
    
    
    
    
 
}
