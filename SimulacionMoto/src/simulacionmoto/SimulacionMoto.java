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
        System.out.println(restricciones.toString());
        
        System.out.println("-----------------CALCULADO RANGO DE VELOCIDADES DE LOS SECTORES--------------------");
        circuito.calcularRangoVelocidades();
        circuito.mostrarPorPantalla();
        
        System.out.println("-----------------GENERANDO COMPORTAMIENTO PILOTOS--------------------");
        int numPilotos= confi.getNPilotos();
        ArrayList<Piloto> pilotos= new ArrayList<>();
        
        GeneradorPilotos generadorPilotos = new GeneradorPilotos(circuito,numPilotos,restricciones,pilotos);
        generadorPilotos.Generar();
        System.out.println("-----------------PILOTOS FACTIBLES--------------------");
        for(int i=0;i<pilotos.size();i++){
            System.out.println("Piloto"+i);
            pilotos.get(i).moto.mostrarMayoresValores();
            System.out.println("tiempo"+pilotos.get(i).tiempo);
        }
        
        //ArrayList<Piloto> mejoresPilotos= generadorPilotos.;
        //simulador.Optimizar(circuito,pilotos,controladores,moto);
        
        //simulador.Simular(circuito,pilotos,controladores,moto);
        //simulador.Resultado();
        System.out.println("----------------------FIN-------------------");
    }
    
}
