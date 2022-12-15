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
        //circuito.mostrarPorPantalla();
        
        System.out.println("-----------------GENERANDO COMPORTAMIENTO PILOTOS--------------------");
        int numPilotos= confi.getNPilotos();
        ArrayList<Piloto> pilotosFactibles= new ArrayList<>();
        
        GeneradorPilotos generadorPilotos = new GeneradorPilotos(circuito,numPilotos,restricciones,pilotosFactibles);
        generadorPilotos.generarSinBMS();
        //Pilotos que cumplen las restricciones maximas de lamoto y bms
        System.out.println("-----------------PILOTOS FACTIBLES--------------------");
        for(int i=0;i<pilotosFactibles.size();i++){
            System.out.println("+++++++++++++++Piloto Factble "+i+" ++++++++++++: ");
            pilotosFactibles.get(i).moto.mostrarMayoresValores();
            System.out.println("Tiempo de vuelta: "+pilotosFactibles.get(i).tiempo+" s");
            //pilotosFactibles.get(i).mostrarComportamiento();
        }
        //Por cada bms de cada piloto factible generamos mas pilotosFactibles aleatorios dados ese bms
        //En un futuro se podria implementar con los pilotos que generen mejor tiempo pero actualmente genera muy pocos factibles
        System.out.println("-----------------GENERANDO PILOTOS DADOS LOS BMS DE LOS MEJORES PILOTOS--------------------");
        ArrayList<Piloto> pilotosFactibles2= new ArrayList<>();
        ArrayList<BMS> configuracionesBMS=  new ArrayList<>();
        for(int i=0;i<pilotosFactibles.size();i++){
            configuracionesBMS.add(pilotosFactibles.get(i).getBms());
            System.out.println("---------Generando pilotos para el siguiente BMS");
            pilotosFactibles.get(i).getBms().toString();
            GeneradorPilotos generadorPilotos2 = new GeneradorPilotos(circuito,numPilotos,restricciones,pilotosFactibles2);
            generadorPilotos2.generarDadoUnBMS(configuracionesBMS.get(i));
        }
        
        System.out.println("----------------------FIN-------------------");
    
    }
}