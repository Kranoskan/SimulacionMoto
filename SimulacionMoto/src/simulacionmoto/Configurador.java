/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionmoto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ismae
 */
public class Configurador {
    
    ArrayList<String> rutaCircuito;
    ArrayList<String> rutaMBMS;
    ArrayList<String> rutaPiloto;
    ArrayList<String> rutaMoto;
    ArrayList<Integer> nBMS;
    ArrayList<Integer> nPilotos;
    ArrayList<Float> pesoMoto;
    ArrayList<Float> adherencia;
    
    Configurador(String ruta){
        rutaCircuito = new ArrayList<>();
        rutaMoto = new ArrayList<>();
        rutaMBMS = new ArrayList<>();
        rutaPiloto = new ArrayList<>();
        nBMS = new ArrayList<>();
        nPilotos = new ArrayList<>();
        pesoMoto = new ArrayList<>();
        adherencia = new ArrayList<>();
        FileReader f=null;
        String linea;
        try{
            f= new FileReader(ruta);
            BufferedReader b=new BufferedReader(f);
            while((linea=b.readLine())!=null){
                String[] split=linea.split("=");
                switch(split[0]){
                    case "rutaCircuito":
                        String[] v=split[1].split(";");
                        for(int i=0;i<v.length;i++){
                            rutaCircuito.add(v[i]);
                        }
                        break;
                    case "rutaMotoyBMS":
                        String[] v2=split[1].split(";");
                        for(int i=0;i<v2.length;i++){
                            rutaMBMS.add((v2[i]));
                        }
                        break;
                    case "rutaPiloto":
                        String[] v3=split[1].split(";");
                        for(int i=0;i<v3.length;i++){
                            rutaPiloto.add(v3[i]);
                        }
                        break;
                    case "nPilotos":
                        String[] v4=split[1].split(";");
                        for(int i=0;i<v4.length;i++){
                            nPilotos.add(Integer.parseInt(v4[i]));
                        }
                        break;
                    case "nBMS":
                        String[] v5=split[1].split(";");
                        for(int i=0;i<v5.length;i++){
                            nBMS.add(Integer.parseInt(v5[i]));
                        }
                        break;
                    case "pesoMoto":
                        String[] v6=split[1].split(";");
                        for(int i=0;i<v6.length;i++){
                            pesoMoto.add(Float.parseFloat(v6[i]));
                        }
                        break;
                    case "adherencia":
                        String[] v7=split[1].split(";");
                        for(int i=0;i<v7.length;i++){
                            adherencia.add(Float.parseFloat(v7[i]));
                        }
                        break;
                    case "rutaMoto":
                        String[] v8=split[1].split(";");
                        for(int i=0;i<v8.length;i++){
                            rutaPiloto.add(v8[i]);
                        }
                        break;
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    String getRutaCircuito(){
        return this.rutaCircuito.get(0);
    }
    
    String getRutaMoto(){
        return this.rutaMoto.get(0);
    }
    
    String getRutaMotoYBMS(){
        return this.rutaMBMS.get(0);
    }

    String getRutaPiloto() {
        return this.rutaPiloto.get(0);
    }
    
    int getNPilotos() {
        return this.nPilotos.get(0);
    }

    int getNBMS() {
        return this.nBMS.get(0);
    }
    
    Float getPesoMoto() {
        return this.pesoMoto.get(0);
    }

    Float getAdherencia() {
        return this.adherencia.get(0);
    }
}
