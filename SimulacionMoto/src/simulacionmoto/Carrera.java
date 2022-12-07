/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionmoto;

import java.util.ArrayList;

/**
 *
 * @author ismae
 */
class Carrera {

    void Simular(ArrayList<ArrayList<Float>> circuito, ArrayList<Pilotos> pilotos, ArrayList<BMS> controladores, Moto moto) {
        //La idea es probar cada configuración del BMS (parametros de la simulacion
        //con cada piloto (población, entidades...)
        //usando el circuito como función de evaulacion
        //y guardar los resultados
    }

    void Resultado() {
    
    }

    void Optimizar(ArrayList<ArrayList<Float>> circuito, ArrayList<Pilotos> pilotos, ArrayList<BMS> controladores, Moto moto) {
        //genera nuevas cinfiguraciones del BMS 
        //para ello sigue alguna tecnica heuristica (cruces, vecino más cercano, greedy...)
        //para cada nueva configuración elimina las que no sean posibles o ajuasta los parámetros
        //y hace una simulación del circuito como función de evaulación
    }
    
}
