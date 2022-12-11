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

    public Moto(RestriccionesMotoYBMS restricciones) {
        velocidad=0;
        aceleracion=0;
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
    
        //Convertir la aceleracion a incremento
        Float incremento=incremetoEnVoltMax(aceleracion);
        
        incrementarTemperatura(incremento);
        incrementarVoltaje(incremento);
        consumirbateria(incremento);

        return 0;
    }

    float frenar(float distanciaFrenada,float nuevaVelocidad) {
        
        Float tiempo=distanciaFrenada/nuevaVelocidad;
        Float velocidadAnterior=velocidad;
        Float deceleracion=((nuevaVelocidad-velocidadAnterior)/tiempo)/100;
        
        
        this.velocidad=nuevaVelocidad;
        //Convertir la aceleracion a incremento
        Float incremento=incremetoEnVoltMax(deceleracion);
        
        incrementarTemperatura(incremento);
        incrementarVoltaje(incremento);
        consumirbateria(incremento);
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
    
    boolean esFactible(){
        
        return true;
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
        System.out.println("Mayor velocidad alcanzada: "+this.mayorVelocidadAlcanzada);
        System.out.println("Mayor aceleración alcanzada: "+this.mayorAceleracionRealizada);
        System.out.println("Mayor temperatura alcanzada: "+this.mayorTemperaturaAlcanzada);
        System.out.println("Consumo: "+this.getConsumo());
        System.out.println("Mayor voltaje alcanzado: "+this.mayorVoltajeAlcanzado);
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
