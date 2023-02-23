/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atmosflight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jalvarezbretana
 */
public class listar {
    public static Map<Integer, String> buscar(String ciudad) throws FileNotFoundException{
        String idCiudad = "0";
        Map<Integer, String> vuelosResultado = new HashMap<>();
        File vuelos = new File("vuelos.txt");
        File ciudades = new File("ciudades.txt");
        
        // Obtener el id de una ciudad dado su nombre
        try (Scanner ler = new Scanner(ciudades).useDelimiter(",")) {
            while(ler.hasNextLine()){
                String id = ler.next();
                String nciudad = ler.next();
                String fciudad = ler.nextLine();
                if (nciudad.equals(ciudad)){
                    idCiudad = id;
                }
            } 
        }
        
        // Obtener todos los vuelos dado el id de la ciudad buscada
        try (Scanner ler = new Scanner(vuelos).useDelimiter(",")) {
            int cuentaKey = 0;
            while(ler.hasNextLine()){
                String id = ler.next();
                String compania = ler.next();
                String tipo = ler.next();
                String precio = ler.next();
                String personas = ler.next();
                String ida = ler.next();
                // Con el substring inicializamos el string en el segundo valor (el primero es 0 y sería la ,)
                String vuelta = ler.nextLine().substring(1);
                if(id.equals(idCiudad)){
                    cuentaKey++;
                    vuelosResultado.put(cuentaKey, "Compañia: "+compania+" | Tipo: "+tipo+" | Precio: "+precio+"€ | Personas: "+personas+" | Fecha ida: "+ida+" | Fecha vuelta: "+vuelta+"<br>");  
                }
            } 
        }
        
        return vuelosResultado;
    }
    
    public static Map<Integer, String> verCiudades() throws FileNotFoundException{
        Map<Integer, String> verCiudades = new HashMap<>();
        File ciudades = new File("ciudades.txt");
        
        // Obtener todas las ciudades
        try (Scanner ler = new Scanner(ciudades).useDelimiter(",")) {
            while(ler.hasNextLine()){
                String id = ler.next();
                String nciudad = ler.next();
                String fciudad = ler.nextLine();
                verCiudades.put(Integer.parseInt(id), nciudad);
            } 
        }
        return verCiudades;
    }
    
        public static Map<Integer, String> verVuelos() throws FileNotFoundException{
        Map<Integer, String> verVuelos = new HashMap<>();
        File vuelos = new File("vuelos.txt");
        // Obtener todos los vuelos 
        try (Scanner ler = new Scanner(vuelos).useDelimiter(",")) {
            int cuentaKey = 0;
            while(ler.hasNextLine()){
                String id = ler.next();
                String compania = ler.next();
                String tipo = ler.next();
                String precio = ler.next();
                String personas = ler.next();
                String ida = ler.next();
                // Con el substring inicializamos el string en el segundo valor (el primero es 0 y sería la ,)
                String vuelta = ler.nextLine().substring(1);
                cuentaKey++;
                verVuelos.put(cuentaKey, "Id ciudad: "+id+" | Compañia: "+compania+" | Tipo: "+tipo+" | Precio: "+precio+"€ | Personas: "+personas+" | Fecha ida: "+ida+" | Fecha vuelta: "+vuelta+"<br>");  
            } 
        }
        return verVuelos;
    }
}