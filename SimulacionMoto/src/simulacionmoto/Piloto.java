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
class Piloto {
    ArrayList<pilotoMicrosector> comportamiento;
    Moto moto;
    float velocidadMax;
    float aceleracionMax;
    float voltajeMax;
    float temperaturaMax;
    float consumo;

    Piloto(Moto m) {
        moto = new Moto();
        moto=m;
        velocidadMax=0;
        aceleracionMax=0;
        voltajeMax=0;
        temperaturaMax=0;
        consumo=0;
    }

    void setConfiguracion(ArrayList<ArrayList<Float>> circuito, float rand) {
        moto.iniciar();
        comportamiento = new ArrayList<>();
        circuito.forEach(circuito1 -> {
            pilotoMicrosector newMicroSector= new pilotoMicrosector();
            if(moto.getVelocidad()<circuito1.get(0) && moto.hayBateria()){
                newMicroSector.set(moto.acelerar(rand));
            }else{
                newMicroSector.set(moto.frenar(rand));
            }
            comportamiento.add(newMicroSector);
        });
        actualizarEstado();
    }

    private void actualizarEstado() {
        velocidadMax=moto.getVelocidadMax();
        aceleracionMax=moto.getAceleracionMax();
        voltajeMax=moto.getVoltajeMax();
        temperaturaMax=moto.getTemMax();
        consumo= moto.getConsumo();
    }
    
}
