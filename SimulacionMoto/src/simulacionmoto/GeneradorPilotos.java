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
class GeneradorPilotos {
    
    Circuito circuito;
    int numPilotos;
    RestriccionesMotoYBMS restricciones;
    Random random;
    ArrayList<Piloto> pilotos;
    ArrayList<Piloto> pilotosBMS;
    /**
     * StringBuilder con el Logger
     */
    private final StringBuilder logComportamiento;
    private final StringBuilder logBMS;
    

    
    public GeneradorPilotos(Circuito circuito, int numPilotos, RestriccionesMotoYBMS restricciones,ArrayList<Piloto> pilotos) {
        this.circuito = circuito;
        this.numPilotos = numPilotos;
        this.restricciones = restricciones;
        this.pilotos=pilotos;
        pilotosBMS=new ArrayList<>();
        logComportamiento = new StringBuilder();
        logBMS=new StringBuilder();
    }

    void generarSinBMS() {
        
        for (int i = 0; i < numPilotos; i++) {
            Piloto newPiloto= new Piloto(restricciones);
            newPiloto.setComportamiento(circuito);
            if(newPiloto.esFactible(newPiloto.getBms(),restricciones)){
                newPiloto.calcularTiempoVuelta(circuito);
                pilotos.add(newPiloto);
                
            }
        }
        System.out.println("Total pilotos generados: "+this.numPilotos);
        System.out.println("Pilotos factibles generados: "+this.pilotos.size());
    }
    
    void generarDadoUnBMS(BMS bms){
        for (int i = 0; i < numPilotos; i++) {
            restricciones = new RestriccionesMotoYBMS();
            Float temMax=bms.getTemperaturaMax();
            Float voltajeMax=bms.getVoltajeMax();
            restricciones.volt_max_bateria=voltajeMax;
            restricciones.temperatura_max=temMax;
            Piloto newPiloto= new Piloto(restricciones);
            newPiloto.setBMSQ(true);
            newPiloto.setComportamiento(circuito);
            if(newPiloto.esFactible(newPiloto.getBms(),restricciones)){
                newPiloto.calcularTiempoVuelta(circuito);
                pilotos.add(newPiloto);
                pilotosBMS.add(newPiloto);
            }
            
        }
        System.out.println("Total pilotos dado un BMS generados: "+this.numPilotos);
        System.out.println("Pilotos factibles generados: "+this.pilotos.size());
    }
    
    //Algoritmo ordenacion burbuja
    void ordenarPilotosTiempo(ArrayList<Piloto> todosPilotos){
        Piloto temporal;
        for(int i=1;i<todosPilotos.size();i++){
            for(int j=0;j<todosPilotos.size()-1;j++){
                if(todosPilotos.get(j).getTiempoVuelta()>todosPilotos.get(j+1).getTiempoVuelta()){
                    temporal=todosPilotos.get(j);
                    todosPilotos.set(j,todosPilotos.get(j+1));
                    todosPilotos.set(j+1, temporal);
                }
            }
        }
    }
    
    void mostrarXMejoresPilotos(ArrayList<Piloto> todosPilotos,int numero){
        System.out.println("Ordenados por mejores tiempos");
        for(int i=0;i<numero;i++){
            System.out.print(todosPilotos.get(i).getTiempoVuelta()+" s "+todosPilotos.get(i).getBms().toString()+
                    " Distancia acelerada por sector"+todosPilotos.get(i).distanciaAceleradaSector.toString()+
                    " Distancia Frenada por sector"+todosPilotos.get(i).distanciaFrenadaSector.toString()+" Velocidad por sector "+todosPilotos.get(i).velocidadSector.toString());
            todosPilotos.get(i).mostrarComportamiento();
            //Logs BMS
            logBMS.append("MEJOR PILOTO  ").append(i+1).append(" ;").append("\n");
            logBMS.append("TIEMPO: ").append(";").append(redondear((double)todosPilotos.get(i).getTiempoVuelta())).append("\n");
            logBMS.append("TemperaturaMax").append(";");
            logBMS.append("TemperaturaSegura").append(";");
            logBMS.append("VoltajeMax").append(";");
            logBMS.append("VoltajeMaxCelulas").append(";");
            logBMS.append("VoltajeReactivacion").append(";");
            logBMS.append("\n");
            
            logBMS.append(redondear((double)todosPilotos.get(i).getBms().getTemperaturaMax())).append(";");
            logBMS.append(redondear((double)todosPilotos.get(i).getBms().getTemperaturaSegura())).append(";");
            logBMS.append(redondear((double)todosPilotos.get(i).getBms().getVoltajeMax())).append(";");
            logBMS.append(redondear((double)todosPilotos.get(i).getBms().getVoltajeMaxCelulas())).append(";");;
            logBMS.append(redondear((double)todosPilotos.get(i).getBms().getVoltajeReactivación())).append(";");;
            logBMS.append("\n");
            //Los Comportamiento
            logComportamiento.append("MEJOR PILOTO : ").append(i).append(" \n");
            logComportamiento.append("DISTANCIA ACELERADA SECTOR: ").append(";");
            for(int j=0;j<todosPilotos.get(i).distanciaAceleradaSector.size();j++){
                logComportamiento.append(redondear((double)todosPilotos.get(i).distanciaAceleradaSector.get(j))).append(";");
            }
            logComportamiento.append("\n");
            logComportamiento.append("DISTANCIA FRENADA SECTOR: ").append(";");
            for(int j=0;j<todosPilotos.get(i).distanciaFrenadaSector.size();j++){
                logComportamiento.append(redondear((double)todosPilotos.get(i).distanciaFrenadaSector.get(j))).append(";");
            }
            logComportamiento.append("\n");
            logComportamiento.append("VELOCIDAD POR SECTOR: ").append(";");
            for(int j=0;j<todosPilotos.get(i).velocidadSector.size();j++){
                logComportamiento.append(redondear((double)todosPilotos.get(i).velocidadSector.get(j))).append(";");
            }
            logComportamiento.append("\n");
            
            System.out.println();
 
        }
    }
    
    /**
     * @Brief Getter del log
     * @return Un StringBuilder con las cadenas de texto insertadas en el log comportamiento
     */
    public StringBuilder getLogComportamiento() {
        return logComportamiento;
    }
    
    /**
     * @Brief Getter del log
     * @return Un StringBuilder con las cadenas de texto insertadas en el log BMS
     */
    public StringBuilder getLogBMS() {
        return logBMS;
    }
    
    Double redondear(Double numero){
        return Math.round(numero*100.0)/100.0;   
    }
}
