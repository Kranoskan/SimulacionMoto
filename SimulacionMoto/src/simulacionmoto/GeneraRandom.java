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
 * @author Pc
 */
public class GeneraRandom {
    
    ArrayList<Float> parDistanciaEIntensidadGenerado;
    Random random;

    public GeneraRandom() {
        this.parDistanciaEIntensidadGenerado=new ArrayList();
        random=new Random();
    }
    
    ArrayList<Float> generarAceleracionAleatoria(Float distanciaSector,Float velocidadActual, Double velocidadMaximaSector){
        ArrayList<Float> solucion=new ArrayList();

        //Calculo de la distancia acelerada(un random entre 0 y distanciaSector)
        Float distanciaAcelerada=random.nextFloat() * (distanciaSector - 0) + 0;
        solucion.add(Float.valueOf(distanciaAcelerada.toString()));
        
        //Calculo de la nueva velocidad,Generamos un random entre la velocidad actual y la velocidad maxima
        Float velocidad=random.nextFloat() * (Float.valueOf(velocidadMaximaSector.toString()) - velocidadActual) + velocidadActual;
    
        solucion.add(velocidad);
        
        return solucion;
    }
    
    
    ArrayList<Float> generarFrenadaAleatoria(Float distanciaSector,Float velocidadActual, Double velocidadMaximaSector){
        ArrayList<Float> solucion=new ArrayList();
        
        Float distanciaFrenada=random.nextFloat() * (distanciaSector - 0) + 0;
        solucion.add(Float.valueOf(distanciaFrenada.toString()));
        
        Float velocidad=random.nextFloat() * (velocidadActual - 0) + 0;
        
        return solucion;
    }
}
