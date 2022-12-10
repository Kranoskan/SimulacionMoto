/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionmoto;

/**
 *
 * @author ismae
 */
class Moto {

    //parametros iniciales, sirven para reiniciar los datos
    float velocidad;
    float bateria;
    float velLimite;
    float tempLimite;
    float aceleracion;
    float tempIni;
    
    //parametros de simulacion, estos serán modificados por el piloto
    float velocidad_S;
    float bateria_S;
    float velMax_S;
    float tempMax_S;
    float aceleracion_S;
    float temperatura;
    float aceleMax;
    float voltMax;

    public Moto(RestriccionesMotoYBMS restricciones) {
        velocidad=0;
        aceleracion =0;
        bateria=restricciones.getCapacidadBateria();
        velLimite=restricciones.getVelocidad_max();
        tempLimite=restricciones.getTemperatura_max();
        tempIni=restricciones.getTem_inicial();
        
        velMax_S=0;
        tempMax_S=0;
        aceleMax=0;
        voltMax=0;
        
        velocidad_S=velocidad;
        bateria_S=bateria;
        aceleracion_S=aceleracion;
        temperatura=tempIni;
    }
    Float getVelocidad() {
        return velocidad_S;
    }

    boolean hayBateria() {
        if(bateria_S/bateria >= 0.05){ //consideremos que esto es bateria baja 
                                       // y que si llega a este porcentaje 
                                       //entra en modo "ahorro de bateria"
            return true;
        }
        return false;
    }

    float acelerar(float rand) {
        //supongamos que la acceleracion máxima es 1, el 100%
        float newAceleracion =aceleracion_S+ rand;
        float incremento=0;
        if (newAceleracion>1){ //para que no tome valores fuera del rango
            newAceleracion=1;
        }
        incremento= newAceleracion-aceleracion_S;
        //acotar la aceleracion deltro del voltaje máximo
        incremento=incremetoEnVoltMax(incremento);
        if(incremento>aceleMax){
            aceleMax=incremento;
        }
        incrementarTemperatura(incremento);
        incrementarVoltaje(incremento);
        consumirbateria(incremento);
        aceleracion_S=newAceleracion;
        return incremento;
    }

    float frenar(float rand) {
        //supongamos que la frenada máxima es -1, el 100%
        float newAceleracion =aceleracion_S- rand;
        float decremento=0;
        if (newAceleracion<-1){
            newAceleracion=-1;
        }
        decremento= newAceleracion-aceleracion_S;
        if((-decremento)>aceleMax){
            aceleMax=-decremento;
        }
        consumirbateria(decremento);
        incrementarVoltaje(decremento);
        incrementarTemperatura(decremento);
        aceleracion_S=newAceleracion;
        return decremento;
    }

    float getVelocidadMax() {
        return velMax_S;
    }

    float getAceleracionMax() {
        return aceleMax;
    }

    float getTemMax() {
        return tempMax_S;
    }

    float getConsumo() {
        return bateria-bateria_S;
    }

    float getVoltajeMax() {
        return voltMax;
    }

    private void incrementarTemperatura(float incremento) {
        
    }

    private void consumirbateria(float incremento) {
        
    }

    private float incremetoEnVoltMax(float incremento) {
        return 0;
    }

    private void incrementarVoltaje(float incremento) {
       
    }
}
