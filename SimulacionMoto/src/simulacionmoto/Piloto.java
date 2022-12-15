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
    Float tiempo;//tiempo en segundos
    Float bateriaRestante;
    Moto moto;
    int numVueltas;
    private boolean hayBMS;
    Float velocidadMedia;
    Circuito circuito;

    public Piloto(RestriccionesMotoYBMS restricciones) {
        this.distanciaAceleradaSector = new ArrayList<>();
        this.velocidadSector = new ArrayList<>();
        this.distanciaFrenadaSector = new ArrayList<>();
        this.frenadaSector=new ArrayList<>();
        this.bateriaUsadaRefrigeracionSector = new ArrayList<>();
        Float velodidadMedia=0.0f;
           
        this.tiempo = 0.0f;
        moto=new Moto(restricciones);
        bms=new BMS();
        numVueltas=6;
        hayBMS=false; // inicialmenta creamos el piloto sin BMS
        circuito=new Circuito();
    }
    

    void setComportamiento(Circuito circuito) {
        this.circuito=circuito;
        //inicalizamos los vectores
        for(int i=0;i<circuito.getNumSectores()*numVueltas;i++){
            this.distanciaAceleradaSector.add(Float.valueOf(0));
            this.distanciaFrenadaSector.add(Float.valueOf(0));
            this.velocidadSector.add(Float.valueOf(0));
            this.frenadaSector.add(Float.valueOf(0));
            this.bateriaUsadaRefrigeracionSector.add(Float.valueOf(0));
        }

        GeneraRandom generadorRandom=new GeneraRandom();
        for(int i=0;i<circuito.getNumSectores()*numVueltas;i++){//así se trienen en cuenta las vueltas
            Double velocidadMaximaSector=circuito.getVelocidadMaximaCalculada().get(i%numVueltas); 
            Float velocidadActual=moto.getVelocidad();
            Float distanciaSector=circuito.getDistanciaSectores().get(i%numVueltas);
            if(velocidadActual<velocidadMaximaSector && (!hayBMS || moto.cumpleRestriccionesBMS(bms))){
                //Array que contiene la distancia acelerada y la velocidad tras acelerar en el sector
                ArrayList<Float> aceleracion= (ArrayList<Float>)generadorRandom.generarAceleracionAleatoria(distanciaSector,velocidadActual,velocidadMaximaSector).clone();
                Float newDist=aceleracion.get(0);
                distanciaAceleradaSector.set(i,newDist);
                Float newVel=aceleracion.get(1);
                velocidadSector.set(i,newVel);
                moto.acelerar(aceleracion.get(0),aceleracion.get(1));
                    
            }else{
            //Array que contiene la distancia frenada y la velocidad tras frenar en el sector
                ArrayList<Float> frenada=(ArrayList<Float>) generadorRandom.generarFrenadaAleatoria(distanciaSector,velocidadActual,velocidadMaximaSector).clone();
                Float newFren=frenada.get(0);
                distanciaFrenadaSector.set(i,newFren);
                Float newVel=frenada.get(1);
                velocidadSector.set(i,newVel);
                if(hayBMS){
                    moto.chequeoRefrigeracion();
                }
                moto.frenar(frenada.get(0),frenada.get(1));

            }
            
        }
        this.calcularTiempoVuelta(circuito);
        //this.mostrarComportamiento();
        //moto.mostrarMayoresValores();

        crearBMS();
      
    }
    
    void calcularTiempoVuelta(Circuito circuito){
 
        Float sumaVelocidades=0.0f;
        //la velocidad media se hace con una media armónica
        for(int i=0;i<velocidadSector.size();i++){
            sumaVelocidades=sumaVelocidades+velocidadSector.get(i);
            
        }
        
        velocidadMedia=sumaVelocidades/velocidadSector.size();
        Float velocidadMS=velocidadMedia/3.6f;
        tiempo=(Float.valueOf(circuito.getDistanciaTotal(numVueltas).toString())/velocidadMS); //Pasamos metros segundo a km hora
        
    }
    
    float getTiempoVuelta(){
        return tiempo;
    }

    private void crearBMS() {
        bms.setTemperaturaMax(moto.getMayorTemperaturaAlcanzada());
        bms.setVoltajeMax(moto.getMayorVoltajeAlcanzado());
        bms.setTemperaturaSegura(moto.getTemperaturaSegura());
        bms.setVoltajeReactivación(moto.getVoltajeReactivacion());
    }
    //Comprobamos si son pilotos validos
    public boolean esFactible(BMS bms,RestriccionesMotoYBMS restricciones){
        if(moto.getMayorTemperaturaAlcanzada()<restricciones.getTemperatura_max()){
            if(moto.getMayorVoltajeAlcanzado()<restricciones.getVolt_max_bateria()){
                if(moto.getConsumo()<restricciones.getCapacidadBateria()){
                    return true;
                }
            }   
        }
        
        return false;
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

    public void setTiempo(Float tiempo) {
        this.tiempo = tiempo;
    }

    public void setBateriaRestante(Float bateriaRestante) {
        this.bateriaRestante = bateriaRestante;
    }
    
    void mostrarComportamiento(){
        System.out.println("-------------------------------------------------Comportamiento Piloto------------------------------------------");
        System.out.println("Distancia acelerada en cada sector");
        System.out.println(this.distanciaAceleradaSector.toString());
        System.out.println("Distancia distancia frenada en cada sector");
        System.out.println(this.distanciaFrenadaSector.toString());
        System.out.println("Velocidad en cada sector");
        System.out.println(this.velocidadSector.toString());
        System.out.println("velocidad media: "+velocidadMedia+" Km/H");
        System.out.println("DistanciaRecorrida: "+circuito.getDistanciaTotal(numVueltas)+" Metros");
        System.out.println("Tiempo: "+tiempo+" s");
        
    }

    void setBMSQ(boolean b) {
        this.hayBMS=b;
    }
    
    BMS getBMS(){
        return bms;
    }
 
}