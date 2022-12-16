/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionmoto;

import java.util.ArrayList;

/**
 *
 * @author Pc
 */
public class Circuito {
     ArrayList<Float> distanciaSectores;
     ArrayList<Float> curvaSectores;
     ArrayList<Float> pendienteSectores;
     ArrayList<Double> velocidadMaximaCalculada;
     ArrayList<Double> velocidadMinimaCalculada;
     private final StringBuilder logVelocidadLímite;

    public Circuito() {
        this.distanciaSectores = new ArrayList();
        this.curvaSectores = new ArrayList();
        this.pendienteSectores = new ArrayList();
        this.velocidadMaximaCalculada = new ArrayList();
        this.velocidadMinimaCalculada = new ArrayList();
        this.logVelocidadLímite=new StringBuilder();
  
    }
    
    ////////////////////////////////Getters/////////////////////////////
    public ArrayList<Float> getDistanciaSectores() {
        return distanciaSectores;
    }

    public ArrayList<Float> getCurvaSectores() {
        return curvaSectores;
    }

    public ArrayList<Float> getPendienteSectores() {
        return pendienteSectores;
    }

    public ArrayList<Double> getVelocidadMaximaCalculada() {
        return velocidadMaximaCalculada;
    }

    
    public ArrayList<Double> getVelocidadMinimaCalculada() {    
        return velocidadMinimaCalculada;
    }

    ////////////////////////////////Setters/////////////////////////////
    public void setDistanciaSectores(ArrayList<Float> distanciaSectores) {
        this.distanciaSectores = distanciaSectores;
    }

    public void setCurvaSector(ArrayList<Float> curvaSector) {
        this.curvaSectores = curvaSector;
    }

    public void setPendienteSector(ArrayList<Float> pendienteSector) {
        this.pendienteSectores = pendienteSector;
    }

    public void setVelocidadMaximaCalculada(ArrayList<Double> velocidadMaximaCalculada) {
        this.velocidadMaximaCalculada = velocidadMaximaCalculada;
    }

    public void setVelocidadMinimaCalculada(ArrayList<Double> velocidadMinimaCalculada) {
        this.velocidadMinimaCalculada = velocidadMinimaCalculada;
    }

    void mostrarPorPantalla(){
        for(int i=0;i<this.pendienteSectores.size();i++){
            System.out.print("Sector: "+i);
            System.out.print(" Distancia: "+this.distanciaSectores.get(i));
            System.out.print(" Curvatura: "+this.curvaSectores.get(i));
            System.out.print(" Pendiente: "+this.getPendienteSectores().get(i));
            if(this.getVelocidadMinimaCalculada().isEmpty()){
                System.out.print(" Vel min calculada: "+"NO CALCULADA");
                System.out.print(" Vel max calculada: "+"NO CALCULADA");
            }else{
                System.out.print(" Vel min calculada: "+this.getVelocidadMinimaCalculada().get(i));
                System.out.print(" Vel max calculada: "+this.getVelocidadMaximaCalculada().get(i));
            }
            
            
            System.out.println();
        }
    }
    
    void calcularRangoVelocidades(){
        for(int i=0;i<this.distanciaSectores.size();i++){
            //valor de aceleracion lateral de una moto
            Double aceleracionLateral=Double.valueOf("9");//buscado en tabla de datos de una pagina, parametrizar
            Double constante=Double.valueOf("3.6");//Constante fija de la formula
            Double AR=aceleracionLateral*this.getCurvaSectores().get(i);
            Double vmax;
            Double vmaxPendienteAplicada;
            if(AR<0){
                AR=AR*-1;
            }
            Double pendiente=Double.valueOf(this.pendienteSectores.get(i));
            if(AR==0){//Si es una recta establecemos la velocidad maxima de la moto
                
                if(pendiente<0){//Si es cuesta abajo
                    vmax=Double.valueOf("180");//aumentamos velocidad por la pendiente
                    vmaxPendienteAplicada=Double.valueOf("180")*(1-pendiente);
                }else{//Si es cuesta arriba
                    vmax=Double.valueOf("180");//disminuimos velocidad con por la pendiente
                    vmaxPendienteAplicada=Double.valueOf("180")*(1-pendiente);
                }
            }else{
          
                if(pendiente<0){//Si es cuesta abajo
                    vmax=constante*Math.sqrt(AR);//aumentamos velocidad por la pendiente
                    vmaxPendienteAplicada=constante*Math.sqrt(AR)*(1-pendiente);
                }else{//Si es cuesta arriba
                    vmax=constante*Math.sqrt(AR);//disminuimos velocidad con por la pendiente
                    vmaxPendienteAplicada=constante*Math.sqrt(AR)*(1-pendiente);
                }
                
            }

            vmaxPendienteAplicada=(double)Math.round(vmaxPendienteAplicada);
            this.velocidadMaximaCalculada.add(vmaxPendienteAplicada);
            this.velocidadMinimaCalculada.add(vmaxPendienteAplicada*Double.valueOf("0.5"));

            //System.out.print("Curvatura: "+this.getCurvaSectores().get(i)+" AR: "+AR+" Vmax "+vmax+" VmaxPendienteaplicada"+vmaxPendienteAplicada+" Pendiente: "+this.pendienteSectores.get(i));
            System.out.print("Pendiente: "+this.pendienteSectores.get(i)+" Vmax "+vmax+" pendiente aplicada -> "+vmaxPendienteAplicada);
            System.out.println();
        }
        System.out.println("Rangos de velocidades calculado");
    }
    
    public int getNumSectores(){
        return this.getCurvaSectores().size();
    }
    
    public Double getDistanciaTotal(int numVueltas){
        Double sumaDistancia=0.0;
        for(int i=0;i<this.distanciaSectores.size();i++){
            sumaDistancia=sumaDistancia+this.distanciaSectores.get(i);
        }
        return sumaDistancia*numVueltas;
    }
    
    /**
     * @Brief Getter del log
     * @return Un StringBuilder con las cadenas de texto insertadas en el log BMS
     */
    public StringBuilder getLogVelocidadesLimiteSectores() {
        this.logVelocidadLímite.append(this.velocidadMaximaCalculada.toString());
        return this.logVelocidadLímite;
    }
    
}