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
        System.out.println("-----------------LEYENDO DATOS--------------------");
        String rutaCircuito=confi.getRutaCircuito();
        LectorArchivos lector = new LectorArchivos();
        lector.cargaDatosCircuito(rutaCircuito,circuito);
        //Lectura de datos motoyBMS
        RestriccionesMotoYBMS restricciones= new RestriccionesMotoYBMS();
        lector.cargaDatosMotoYBMS(confi.getRutaMotoYBMS(),restricciones);
        restricciones.mostrarRestricciones();
        
        System.out.println("-----------------CALCULADO RANGO DE VELOCIDADES DE LOS SECTORES--------------------");
        circuito.calcularRangoVelocidades();
        circuito.mostrarPorPantalla();
        
        System.out.println("-----------------GENERANDO COMPORTAMIENTO PILOTOS--------------------");
        int numPilotos= confi.getNPilotos();
        GeneradorPilotos generadorPilotos = new GeneradorPilotos(circuito,numPilotos,restricciones);
        
        ArrayList<Piloto> pilotos= new ArrayList<>();
        
        //ArrayList<Piloto> pilotosBase= new ArrayList<>();
        //ArrayList<BMS> controladores= new ArrayList<>();
        
        //GeneradorBMS generadorControl = new GeneradorBMS();
        //Carrera simulador= new Carrera();
        
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
