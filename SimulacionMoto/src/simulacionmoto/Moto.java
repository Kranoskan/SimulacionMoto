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
    float cargaTotalBateria;
    float velLimite;
    float tempLimite;
    float aceleracion;
    float tempIni;
    
    //parametros de simulacion, estos serán modificados por el piloto
    float bateriaActual;
    float mayorVelocidadAlcanzada;
    float mayorTemperaturaAlcanzada;
    float temperatura;
    float mayorAceleracionRealizada;
    float voltajeMaximo;
    float mayorVoltajeAlcanzado;
    boolean frenadaActiva;
    boolean refrigeracionActiva;
    float voltaje;
    float refrigerante;
    int cargasRefrigerante;

    public Moto(RestriccionesMotoYBMS restricciones) {
        velocidad=0;
        aceleracion=0;
        voltaje=0;
        voltajeMaximo=restricciones.getVolt_max_bateria();
        cargaTotalBateria=restricciones.getCapacidadBateria();
        velLimite=restricciones.getVelocidad_max();
        tempLimite=restricciones.getTemperatura_max();
        tempIni=restricciones.getTem_inicial();
        bateriaActual=cargaTotalBateria;
        
        mayorVelocidadAlcanzada=0;
        mayorTemperaturaAlcanzada=0;
        mayorAceleracionRealizada=0;
        mayorVoltajeAlcanzado=0;
        
        frenadaActiva=false;
        refrigeracionActiva=false;
        cargasRefrigerante=restricciones.getCapacidadEnfriado();
        refrigerante=restricciones.getFuerzaEnfriado();
    }
    
    boolean hayBateria() {
        if(bateriaActual/cargaTotalBateria >= 0.05){ //consideremos que esto es cargaTotalBateria baja 
                                       // y que si llega a este porcentaje 
                                       //entra en modo "ahorro de cargaTotalBateria"
                                       
            return true;
        }
        return false;
    }

    float acelerar(float distanciaAcelerada,float nuevaVelocidad) {
        //Explicado en el drive de datos y formulas->generacion de comportamiento
        Float tiempo=distanciaAcelerada/nuevaVelocidad;
        Float velocidadAnterior=velocidad;
        Float incrementoDeVelocidad=nuevaVelocidad-velocidadAnterior;
        //Dividimos entre 100 (factor de conversion) de vez en cuando salian unas aceleraciones muy raras
        Float aceleracion=((incrementoDeVelocidad)/tiempo)/100;
        
        this.nuevaVelocidad(nuevaVelocidad);//Establecemos la nueva velocidad
        this.nuevaAceleracion(aceleracion);//Establecemos la nueva aceleracion
    
        consumirbateria(aceleracion,tiempo);
        incrementarTemperatura(aceleracion,tiempo);
        incrementarVoltaje(aceleracion,tiempo);
        
        return 0;
    }

    float frenar(float distanciaFrenada,float nuevaVelocidad) {
        
        Float tiempo=distanciaFrenada/nuevaVelocidad;
        Float velocidadAnterior=velocidad;
        Float deceleracion=((nuevaVelocidad-velocidadAnterior)/tiempo)/100;
        
        //como la deceleración es negativa, un consumo es como una recarga
        consumirbateria(deceleracion,tiempo);//esto tendrá una eficiencia, pero no se sabe cual
        this.velocidad=nuevaVelocidad;
        return 0;
    }
    
    void nuevaVelocidad(Float nuevaVelocidad){
        //Comprobamos si es la menor aceleracion
        //Habrá casos que se supere la velocidad maxima de la moto, esto es porque es cuesta abajo
        if(nuevaVelocidad>this.mayorVelocidadAlcanzada){
            this.mayorVelocidadAlcanzada=nuevaVelocidad;
        }
        this.velocidad=nuevaVelocidad;
    }
    void nuevaAceleracion(Float nuevaAceleracion){
        //Comprobamos si es la mayor aceleracion
        if(nuevaAceleracion>this.mayorAceleracionRealizada){
            this.mayorAceleracionRealizada=nuevaAceleracion;
        }
        this.aceleracion=nuevaAceleracion;
    }
    
    //////////GETTERS//////////////////
    float getConsumo() {
        return cargaTotalBateria-bateriaActual;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public float getCargaTotalBateria() {
        return cargaTotalBateria;
    }

    public float getVelLimite() {
        return velLimite;
    }

    public float getTempLimite() {
        return tempLimite;
    }

    public float getAceleracion() {
        return aceleracion;
    }

    public float getTempIni() {
        return tempIni;
    }

    public float getBateriaActual() {
        return bateriaActual;
    }

    public float getMayorVelocidadAlcanzada() {
        return mayorVelocidadAlcanzada;
    }

    public float getMayorTemperaturaAlcanzada() {
        return mayorTemperaturaAlcanzada;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public float getMayorAceleracionRealizada() {
        return mayorAceleracionRealizada;
    }

    public float getVoltajeMaximo() {
        return voltajeMaximo;
    }

    public float getMayorVoltajeAlcanzado() {
        return mayorVoltajeAlcanzado;
    }
    
    void mostrarMayoresValores(){
        System.out.println("Mayor velocidad alcanzada: "+this.mayorVelocidadAlcanzada+" Km/h");
        System.out.println("Mayor aceleración alcanzada: "+this.mayorAceleracionRealizada+" m/s2");
        System.out.println("Mayor temperatura alcanzada: "+this.mayorTemperaturaAlcanzada +" ºC");
        System.out.println("Consumo: "+this.getConsumo()+ " A/h");
        System.out.println("Mayor voltaje alcanzado: "+this.mayorVoltajeAlcanzado+" V");
    }

    private void incrementarTemperatura(float aceleracion,float tiempo) {
        Float kwPotenciaMotor=48.0f;
        if(kwPotenciaMotor*tiempo*aceleracion>this.mayorTemperaturaAlcanzada){
            this.mayorTemperaturaAlcanzada=kwPotenciaMotor*tiempo;
        }
    }

    private void consumirbateria(float aceleracion,float tiempo) {
        Float voltios=120.0f;
        Float kwConsumoEnergia;
        Float kwPotenciaMotor=48.0f;
        Float constanteCoversion=10.0f;

        Float kwUsados=aceleracion*tiempo*(kwPotenciaMotor/5);
        Float amperiosUsados=1000*kwUsados/voltios;
        //System.out.println("kw"+kwUsados+" "+amperiosUsados);
        this.bateriaActual=this.bateriaActual-amperiosUsados;
    }
    private void incrementarVoltaje(float aceleracion,float tiempo) {
        Float kwPotenciaMotor=48.0f;
        Float constanteConversion=2.0f;
        voltaje=aceleracion*tiempo*kwPotenciaMotor;
       if(voltaje>this.mayorVoltajeAlcanzado){
           this.mayorVoltajeAlcanzado=voltaje;
       }
    }

    boolean cumpleRestriccionesBMS(BMS bms) {
        boolean lasCumple=true;
        if(refrigeracionActiva && temperatura<bms.getTemperaturaSegura()){
            refrigeracionActiva=false;
        }else{
            if(temperatura>bms.getTemperaturaMax()){
                refrigeracionActiva=true;
            }
            lasCumple=false;
        }
        if(frenadaActiva && voltaje<bms.getVoltajeReactivación()){
            frenadaActiva=false;
        }else{
            if(voltaje>bms.getVoltajeMax()){
                frenadaActiva=true;
            }
            lasCumple=false;
        }
        return lasCumple;
    }

    void chequeoRefrigeracion() {
        if(refrigeracionActiva && cargasRefrigerante>0){
            temperatura=temperatura-refrigerante;
            cargasRefrigerante--;
        }
    }
}
