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
    Random random;

    void Generar(ArrayList<Piloto> pilotos, int nPilotos, ArrayList<ArrayList<Float>> circuito, ArrayList<Piloto> pilotosBase, Moto moto) {
        random= new Random();
        for (int i = 0; i < nPilotos; i++) {
            Piloto newPiloto= new Piloto(moto);
            newPiloto.setConfiguracion(circuito,random.nextFloat());
            pilotos.add(newPiloto);
        }
    }
    
}
