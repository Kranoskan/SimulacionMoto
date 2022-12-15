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
    private final StringBuilder log;
    

    
    public GeneradorPilotos(Circuito circuito, int numPilotos, RestriccionesMotoYBMS restricciones,ArrayList<Piloto> pilotos) {
        this.circuito = circuito;
        this.numPilotos = numPilotos;
        this.restricciones = restricciones;
        this.pilotos=pilotos;
        pilotosBMS=new ArrayList<>();
        log = new StringBuilder();
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
            //todosPilotos.get(i).mostrarComportamiento();
            log.append("--------------------------------------MEJOR PILOTO nº: ").append(i).append(" \n");
            log.append("TIEMPO: ").append(todosPilotos.get(i).getTiempoVuelta()).append(" s\n");
            log.append("BMS: ").append(todosPilotos.get(i).getBms().toString()).append("\n");
            log.append("DISTANCIA ACELERADA SECTOR: ").append(todosPilotos.get(i).distanciaAceleradaSector.toString()).append("\n");
            log.append("DISTANCIA FRENADA SECTOR: ").append(todosPilotos.get(i).distanciaFrenadaSector.toString()).append("\n");
            log.append("VELOCIDAD POR SECTOR: ").append(todosPilotos.get(i).velocidadSector.toString()).append("\n");
            System.out.println();
            log.append("\n");
            
        }
    }
    
    /**
     * @Brief Getter del log
     * @return Un StringBuilder con las cadenas de texto insertadas en el log
     */
    public StringBuilder getLog() {
        return log;
    }
}