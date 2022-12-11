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
    ArrayList<Float> velocidadSector;
    ArrayList<Float> distanciaFrenadaSector;
    ArrayList<Float> frenadaSector;
    
    ArrayList<Float> bateriaUsadaRefrigeracionSector;
    int tiempo;//tiempo en segundos
    Float bateriaRestante;
    Moto moto;

    public Piloto(RestriccionesMotoYBMS restricciones) {
        this.distanciaAceleradaSector = new ArrayList<>();
        this.velocidadSector = new ArrayList<>();
        this.distanciaFrenadaSector = new ArrayList<>();
        this.frenadaSector=new ArrayList<>();
        this.bateriaUsadaRefrigeracionSector = new ArrayList<>();
           
        this.tiempo = 0;
        moto=new Moto(restricciones);
        bms=new BMS();
        
    }
    

    void setComportamiento(Circuito circuito) {
        //inicalizamos los vectores
        for(int i=0;i<circuito.getNumSectores();i++){
            this.distanciaAceleradaSector.add(Float.valueOf(0));
            this.distanciaFrenadaSector.add(Float.valueOf(0));
            this.velocidadSector.add(Float.valueOf(0));
            this.frenadaSector.add(Float.valueOf(0));
            this.bateriaUsadaRefrigeracionSector.add(Float.valueOf(0));
        }

        GeneraRandom generadorRandom=new GeneraRandom();
        for(int i=0;i<circuito.getNumSectores();i++){
            Double velocidadMaximaSector=circuito.getVelocidadMaximaCalculada().get(i);
            Float velocidadActual=moto.getVelocidad();
            Float distanciaSector=circuito.getDistanciaSectores().get(i);
            if(velocidadActual<velocidadMaximaSector){
                if(moto.hayBateria()){
                    //Array que contiene la distancia acelerada y la velocidad tras acelerar en el sector
                    ArrayList<Float> aceleracion=generadorRandom.generarAceleracionAleatoria(distanciaSector,velocidadActual,velocidadMaximaSector);
                    distanciaAceleradaSector.set(i,aceleracion.get(0));
                    velocidadSector.set(i,aceleracion.get(1));
                    moto.acelerar(aceleracion.get(0),aceleracion.get(1));
                }else{
                    
                }
                            
            }else{
                //Array que contiene la distancia frenada y la velocidad tras frenar en el sector
                ArrayList<Float> frenada=generadorRandom.generarFrenadaAleatoria(distanciaSector,velocidadActual,velocidadMaximaSector);
               
                distanciaFrenadaSector.set(i,frenada.get(0));
                velocidadSector.set(i,frenada.get(1));
                moto.frenar(frenada.get(0),frenada.get(1));

            }
            
            
        }
        this.mostrarComportamiento();
        moto.mostrarMayoresValores();
        
        //System.out.println(distanciaAceleradaSector.toString());
        actualizarEstado();
      
    }

    private void actualizarEstado() {
        //bms.s=moto.getVelocidadMax();
        //aceleracionMax=moto.getAceleracionMax();
        //bms.setVoltajeMax();
        //bms.setTemperaturaMax(moto.getTemMax());
        //consumo= moto.getConsumo();
        bms.setTemperaturaMax(moto.getMayorTemperaturaAlcanzada());
        bms.setVoltajeMax(moto.getMayorVoltajeAlcanzado());
    }

    /////////////////////GETTERS//////////////////////////
    public BMS getBms() {
        return bms;
    }

    public ArrayList<Float> getTiempoAceleradoSector() {
        return velocidadSector;
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
        this.velocidadSector = bateriaUsadaAceleracioSector;
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
        System.out.println("-------------------------------------------------Piloto generado------------------------------------------");
        System.out.println("Distancia acelerada en cada sector");
        System.out.println(this.distanciaAceleradaSector.toString());
        System.out.println("Distancia distancia frenada en cada sector");
        System.out.println(this.distanciaFrenadaSector.toString());
        System.out.println("Velocidad en cada sector");
        System.out.println(this.velocidadSector.toString());
        
    }
 
}
