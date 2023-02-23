/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmosflight;

import java.io.IOException;

/**
 *
 * @author jalvarezbretana
 */
public class Atmosflight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        inicio inicio = new inicio();
        inicio.show();
        
        listar listar = new listar();
    }
    
}