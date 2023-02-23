/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gettiempo;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author jalvarezbretana
 */
public class Tiempo{
    public String tiempoHoy(String ciudad) throws IOException{
        Document doc = Jsoup.connect("https://www.tiempo.com/"+ciudad+".htm").userAgent("Mozilla").get();
        Elements temperatura = doc.getElementsByClass("dato-temperatura");
        return temperatura.text();
    }
    public String url(String ciudad) throws IOException{
        Document doc = Jsoup.connect("https://www.tiempo.com/"+ciudad+".htm").userAgent("Mozilla").get();
        String titulo = doc.title();
        return ". Datos extraídos del "+titulo;
    }
    public String tiempo(String ciudad) throws IOException{
        Document doc = Jsoup.connect("https://www.tiempo.com/"+ciudad+".htm").userAgent("Mozilla").get();
        Elements frase = doc.getElementsByClass("estado");
        return ". Datos extraídos del "+frase;
    }
    
}