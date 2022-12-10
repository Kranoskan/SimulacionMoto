/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionmoto;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ismae
 */
public class LectorArchivos {
    
    ArrayList<ArrayList<Float>> circuito;
    public ArrayList<Integer> valores_motoybms;
    public int volt_max_bateria;
    public int volt_max_celulas;
    public int intensidad;
    public int velocidad_max;
    public int potencia_motor;
    public int temperatura_max;
    public int peso;
    public int capacidad;
    
    public LectorArchivos(){
        circuito = new ArrayList<>();
        valores_motoybms = new ArrayList<>();
        
    }
    
    
    
    public void cargaDatosCircuito(String ruta){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        circuito.clear();         //se borra el circuito anterior, si lo hubiese
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (ruta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea = null;
            while((linea=br.readLine())!=null){
                String[] fila=linea.split(",");   //separamos por la tabulación
                ArrayList<Float> nuevo=new ArrayList<>();
                for (int i = 0; i < fila.length; i++) {
                    nuevo.add(Float.valueOf(fila[i]));
                }
                circuito.add(nuevo);
            }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    }
    
    public void cargaDatosMotoYBMS(String ruta){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        this.valores_motoybms.clear();   
        //se borra el circuito anterior, si lo hubiese
        System.out.println(ruta);
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (ruta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea = null;
            while((linea=br.readLine())!=null){
                String[] fila=linea.split(",");   //separamos por coma
                Integer valor=null;
                
                valor=(Integer.valueOf(fila[1]));
                System.out.print(fila[0]+": ");
                System.out.println(fila[1]);
                
                this.valores_motoybms.add(valor);
            }
            this.volt_max_bateria=this.valores_motoybms.get(0);
            this.volt_max_celulas=this.valores_motoybms.get(1);
            this.intensidad=this.valores_motoybms.get(2);
            this.velocidad_max=this.valores_motoybms.get(3);
            this.potencia_motor=this.valores_motoybms.get(4);
            this.temperatura_max=this.valores_motoybms.get(5);
            this.peso=this.valores_motoybms.get(6);
            this.capacidad=this.valores_motoybms.get(7);
            
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    }
    
    public ArrayList<ArrayList<Float>> getCircuito(){
        return circuito;
    }

    public ArrayList<Integer> getValores_motoybms() {
        return valores_motoybms;
    }

    public int getVolt_max_bateria() {
        return volt_max_bateria;
    }

    public int getVolt_max_celulas() {
        return volt_max_celulas;
    }

    public int getIntensidad() {
        return intensidad;
    }

    public int getVelocidad_max() {
        return velocidad_max;
    }

    public int getPotencia_motor() {
        return potencia_motor;
    }

    public int getTemperatura_max() {
        return temperatura_max;
    }

    public int getPeso() {
        return peso;
    }

    public int getCapacidad() {
        return capacidad;
    }
    
    void cargaDatosPiloto(ArrayList<Pilotos> pilotosBase, String rutaPiloto) {
        
    }
}
