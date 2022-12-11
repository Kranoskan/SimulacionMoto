/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionmoto;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ismae
 */
class Piloto {
    BMS bms;
    ArrayList<Float> distanciaAceleradaSector;
    ArrayList<Float> aceleracionSector;
    ArrayList<Float> distanciaFrenadaSector;
    ArrayList<Float> frenadaSector;
    
    ArrayList<Float> bateriaUsadaRefrigeracionSector;
    int tiempo;//tiempo en segundos
    Float bateriaRestante;
    Moto moto;

    public Piloto(RestriccionesMotoYBMS restricciones) {
        this.distanciaAceleradaSector = new ArrayList<>();
        this.aceleracionSector = new ArrayList<>();
        this.distanciaFrenadaSector = new ArrayList<>();
        this.frenadaSector=new ArrayList<>();
        this.bateriaUsadaRefrigeracionSector = new ArrayList<>();
            
        this.tiempo = 0;
        //this.bateriaRestante = bateriaRestante;
        moto=new Moto(restricciones);
        
        
    }
    

    void setComportamiento(Circuito circuito) {
        //inicalizamos los vectores
        for(int i=0;i<circuito.getNumSectores();i++){
            this.distanciaAceleradaSector.add(Float.valueOf(0));
            this.distanciaFrenadaSector.add(Float.valueOf(0));
            this.aceleracionSector.add(Float.valueOf(0));
            this.bateriaUsadaRefrigeracionSector.add(Float.valueOf(0));
        }
        
        Random generaRand;
        GeneraRandom generadorRandom=new GeneraRandom();
        for(int i=0;i<circuito.getDistanciaSectores().size();i++){
            Double velocidadMaximaSector=circuito.getVelocidadMaximaCalculada().get(i);
            Float velocidadActual=moto.getVelocidad();
            Float distanciaSector=circuito.getDistanciaSectores().get(i);
            if(velocidadActual<velocidadMaximaSector && moto.hayBateria()){
                ArrayList<Float> aceleracion=generadorRandom.generarAceleracionAleatoria(distanciaSector,velocidadActual,velocidadMaximaSector);
                
                distanciaAceleradaSector.add(i,aceleracion.get(0));
                aceleracionSector.add(i,aceleracion.get(1));
                moto.acelerar(aceleracion.get(0),aceleracion.get(1));
                
            }else{
                ArrayList<Float> frenada=generadorRandom.generarFrenadaAleatoria(distanciaSector,velocidadActual,velocidadMaximaSector);
                

                distanciaFrenadaSector.add(i,frenada.get(0));
                //frenadaSector.add(i,frenada.get(1));
                //moto.frenar(frenada.get(0),frenada.get(1));

            }
            
            
        }
        this.mostrarComportamiento();
        //System.out.println(distanciaAceleradaSector.toString());
        //actualizarEstado();
      
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

    public ArrayList<Float> getTiempoAceleradoSector() {
        return aceleracionSector;
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

    public void setTiempoAceleradoSector(ArrayList<Float> bateriaUsadaAceleracioSector) {
        this.aceleracionSector = bateriaUsadaAceleracioSector;
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
    
    void mostrarComportamiento(){
        System.out.println("Distancia acelerada en los sectores");
        System.out.println(this.distanciaAceleradaSector.toString());
        System.out.println("Intesidad de la aceleracion en el sector (% de bateria usado)");
        System.out.println(this.aceleracionSector.toString());
        System.out.println("Distancia distancia frenada en los sectores");
        System.out.println(this.distanciaFrenadaSector.toString());
    }
 
}
