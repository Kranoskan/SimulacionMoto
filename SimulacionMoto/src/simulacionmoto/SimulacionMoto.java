/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionmoto;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author ismae
 */
public class SimulacionMoto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Inicio");
        //Declaracion de variables
        Parametros parametros = new Parametros();
        ArrayList<ArrayList<Float>> circuito= new ArrayList<>();
        int nPilotos= parametros.nPilotos;
        int nBMS= parametros.nBMS;
        ArrayList<Pilotos> pilotos= new ArrayList<>();
        ArrayList<Pilotos> pilotosBase= new ArrayList<>();
        ArrayList<BMS> controladores= new ArrayList<>();
        GeneradorPilotos generadorPilotos = new GeneradorPilotos();
        GeneradorBMS generadorControl = new GeneradorBMS();
        Moto moto= new Moto();
        Carrera simulador= new Carrera();
        
        //lectura de datos
        String rutaCircuito=parametros.rutaCircuito;
        EditorArchivos editor = new EditorArchivos();
        editor.cargaDatosCircuito(rutaCircuito);
        
        String rutaMotoyBMS=parametros.rutaMotoyBMS;
        editor.cargaDatosMotoYBMS(rutaMotoyBMS);
        
        String rutaPiloto=parametros.rutaPiloto;
        editor.cargaDatosPiloto(pilotosBase, rutaPiloto);
        
        
        
        
        
        //carga y creacion de datos
        circuito.add((ArrayList<Float>) editor.getCircuito().clone());
        generadorPilotos.Generar(pilotos,nPilotos,circuito,pilotosBase);
        generadorControl.Generar(controladores,pilotos,moto);
        
        simulador.Optimizar(circuito,pilotos,controladores,moto);
        
        simulador.Simular(circuito,pilotos,controladores,moto);
        simulador.Resultado();
        
        System.out.println("Fin");
    }
    
}