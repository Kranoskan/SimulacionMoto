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
    
    public GeneradorPilotos(Circuito circuito, int numPilotos, RestriccionesMotoYBMS restricciones,ArrayList<Piloto> pilotos) {
        this.circuito = circuito;
        this.numPilotos = numPilotos;
        this.restricciones = restricciones;
        this.pilotos=pilotos;
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
    }
    
    void generarDadoUnBMS(BMS bms){
        pilotos=new ArrayList<>();
        for (int i = 0; i < numPilotos; i++) {
            Float temMax=bms.getTemperaturaMax();
            Float voltajeMax=bms.getVoltajeMax();
            restricciones.volt_max_bateria=voltajeMax;
            restricciones.temperatura_max=temMax;
            Piloto newPiloto= new Piloto(restricciones);
            newPiloto.setBMSQ(true);
            newPiloto.setComportamiento(circuito);
            newPiloto.calcularTiempoVuelta(circuito);
            pilotos.add(newPiloto);
                
            
        }
    }
    
}