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
     ArrayList<Float> velocidadMaximaCalculada;
     ArrayList<Float> velocidadMinimaCalculada;

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

    public ArrayList<Float> getVelocidadMaximaCalculada() {
        return velocidadMaximaCalculada;
    }

    
    public ArrayList<Float> getVelocidadMinimaCalculada() {    
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

    public void setVelocidadMaximaCalculada(ArrayList<Float> velocidadMaximaCalculada) {
        this.velocidadMaximaCalculada = velocidadMaximaCalculada;
    }

    public void setVelocidadMinimaCalculada(ArrayList<Float> velocidadMinimaCalculada) {
        this.velocidadMinimaCalculada = velocidadMinimaCalculada;
    }

    void mostrarPorPantalla(){
        for(int i=0;i<this.pendienteSectores.size();i++){
            System.out.print("Sector: "+i);
            System.out.print(" Dist: "+this.distanciaSectores.get(i));
            System.out.print(" Curvatura: "+this.curvaSectores.get(i));
            System.out.print(" Pendiente: "+this.getPendienteSectores().get(i));
            if(this.getVelocidadMinimaCalculada().size()==0){
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
        
    }
    
}
