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
        //Declaracion de variables
        Configurador confi=new Configurador(args[0]);
        ArrayList<ArrayList<Float>> circuito= new ArrayList<>();
        int nPilotos= confi.getNPilotos();
        int nBMS= confi.getNBMS();
        ArrayList<Piloto> pilotos= new ArrayList<>();
        ArrayList<Piloto> pilotosBase= new ArrayList<>();
        ArrayList<BMS> controladores= new ArrayList<>();
        GeneradorPilotos generadorPilotos = new GeneradorPilotos();
        GeneradorBMS generadorControl = new GeneradorBMS();
        Moto moto= new Moto();
        Carrera simulador= new Carrera();
        
        //lectura de datos
        String rutaCircuito=confi.getRutaCircuito();
        EditorArchivos editor = new EditorArchivos();
        editor.cargaDatosCircuito(rutaCircuito);
        
        String rutaPiloto=confi.getRutaPiloto();
        editor.cargaDatosPiloto(pilotosBase, rutaPiloto);
        
        editor.leerDatosMoto(confi.getRutaMoto());
        
        //carga y creacion de datos
        moto.setParametros(editor.getMoto());
        circuito.add((ArrayList<Float>) editor.getCircuito().clone());
        
        generadorPilotos.Generar(pilotos,nPilotos,circuito,pilotosBase, moto);
        
        generadorControl.Generar(controladores,pilotos,moto);
        
        simulador.Optimizar(circuito,pilotos,controladores,moto);
        
        simulador.Simular(circuito,pilotos,controladores,moto);
        simulador.Resultado();
    }
    
}
