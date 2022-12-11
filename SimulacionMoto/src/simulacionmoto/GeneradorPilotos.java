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

    void Generar() {
        
        for (int i = 0; i < numPilotos; i++) {
            Piloto newPiloto= new Piloto(restricciones);
            newPiloto.setComportamiento(circuito);
            
        }
    }
     
}
