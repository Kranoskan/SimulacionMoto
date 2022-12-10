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

    public GeneradorPilotos(Circuito circuito, int numPilotos, RestriccionesMotoYBMS restricciones) {
        this.circuito = circuito;
        this.numPilotos = numPilotos;
        this.restricciones = restricciones;
        this.pilotos=new ArrayList<>();
    }

    void Generar(ArrayList<Piloto> pilotos, Circuito circuito, ArrayList<Piloto> pilotosBase, Moto moto) {
        random= new Random();
        for (int i = 0; i < numPilotos; i++) {
            Piloto newPiloto= new Piloto(moto);
            newPiloto.setConfiguracion(circuito,random.nextFloat());
            pilotos.add(newPiloto);
        }
    }
     
}
