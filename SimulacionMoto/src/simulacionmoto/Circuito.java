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

    public Circuito() {
        this.distanciaSectores = new ArrayList();
        this.curvaSectores = new ArrayList();
        this.pendienteSectores = new ArrayList();
        this.velocidadMaximaCalculada = new ArrayList();
        this.velocidadMinimaCalculada = new ArrayList();
  
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
                System.out.print(" Velocidad min calculada: "+"NO CALCULADA");
                System.out.print(" Velocidad max calculada: "+"NO CALCULADA");
            }else{
                System.out.print(" Velocidad minima calculada: "+this.getVelocidadMinimaCalculada().get(i));
                System.out.print(" Velocidad maxima calculada: "+this.getVelocidadMaximaCalculada().get(i));
            }
            
            
            System.out.println();
        }
    }
    
    void calcularRangoVelocidades(){
        for(int i=0;i<this.distanciaSectores.size();i++){

            Float vmax=this.getPendienteSectores().get(i)*this.getCurvaSectores().get(i);
            //this.velocidadMaximaCalculada.add(i,vmax);
            
            System.out.println(vmax);
        }
        System.out.println("Rangos de velocidades calculado");
    }
    
}
