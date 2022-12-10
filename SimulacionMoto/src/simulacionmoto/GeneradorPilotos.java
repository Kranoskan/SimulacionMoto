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
class GeneradorPilotos {
    
    Circuito circuito;
    int numPilotos;
    RestriccionesMotoYBMS restricciones;

    public GeneradorPilotos(Circuito circuito, int numPilotos, RestriccionesMotoYBMS restricciones) {
        this.circuito = circuito;
        this.numPilotos = numPilotos;
        this.restricciones = restricciones;
    }

    
    void Generar() {
        // a partir del piloto base genera pilotos similares a este
    }
    
}
