/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the lector.
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
        //Declaracion de variables
        System.out.println("-----------------INICIO--------------------");
        Configurador confi=new Configurador("Parametros.txt");
        Circuito circuito=new Circuito();

        //Lectura de datos circuito
        String rutaCircuito=confi.getRutaCircuito();
        LectorArchivos lector = new LectorArchivos();
        lector.cargaDatosCircuito(rutaCircuito);
        
        
        
        
        int nPilotos= confi.getNPilotos();
        int nBMS= confi.getNBMS();
        ArrayList<Pilotos> pilotos= new ArrayList<>();
        ArrayList<Pilotos> pilotosBase= new ArrayList<>();
        ArrayList<BMS> controladores= new ArrayList<>();
        GeneradorPilotos generadorPilotos = new GeneradorPilotos();
        GeneradorBMS generadorControl = new GeneradorBMS();
        Moto moto= new Moto();
        Carrera simulador= new Carrera();
        
        
        
        //Lectura de datos motoyBMS
        lector.cargaDatosMotoYBMS(confi.getRutaMotoYBMS());
        
        String rutaPiloto=confi.getRutaPiloto();
        lector.cargaDatosPiloto(pilotosBase, rutaPiloto);
        
        
        
        //carga y creacion de datos
        //circuito.add((ArrayList<Float>) lector.getCircuito().clone());
        //generadorPilotos.Generar(pilotos,nPilotos,circuito,pilotosBase);
        //generadorControl.Generar(controladores,pilotos,moto);
        
        //simulador.Optimizar(circuito,pilotos,controladores,moto);
        
        //simulador.Simular(circuito,pilotos,controladores,moto);
        //simulador.Resultado();
        System.out.println("----------------------FIN-------------------");
    }
    
}
