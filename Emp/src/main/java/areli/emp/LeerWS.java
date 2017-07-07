/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areli.emp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author asortega
 */
public class LeerWS {
    
    //WEBSERVICES PLACES
    
    int totalResultados;
    String vMensaje = "";
    String vActual;

    public String leerData(Reader r) {
        try {
            StringBuilder cadena = new StringBuilder();//donde vamos a almacenar la respuesta
            int cont;
            while ((cont = r.read()) != -1) {
                cadena.append((char) cont);
            }
            return cadena.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public JSONObject leerURL(String pUrl) throws IOException, JSONException {
        InputStream url = new URL(pUrl).openStream();
        try {
            BufferedReader datos = new BufferedReader(new InputStreamReader(url, Charset.forName("UTF-8")));
            String datosJSON = leerData(datos);
            JSONObject json = new JSONObject(datosJSON);
            return json;
        } finally {
            url.close();
        }
    }

    public LeerWS(String pUrl) {
        try {
            JSONObject resultado;
            resultado = leerURL(pUrl);

            //OBTENEMOS EL TOKEN
            //System.out.println("------------------TOKEN-------------------");
            //String next_page_token = resultado.getString("next_page_token");
            //System.out.println(next_page_token);
            //RESULTADOS
            //IMPRIME EL NOMBRE DE TODOS LOS ESTABLECIMIENTOS DE COMIDA CERCANOS
            System.out.println("------------------Lugares Para Comer Mas Cercanos-------------------");
            List<String> listaNombreLugares = new ArrayList<String>();
            JSONArray array = resultado.getJSONArray("results");
            for (int i = 0; i < array.length(); i++) {
                listaNombreLugares.add(array.getJSONObject(i).getString("name"));
                totalResultados = i;
                //CREAMOS LISTA ORDENADA
                vActual = listaNombreLugares.get(i);
                vMensaje = vMensaje + (i+1) + ". " + vActual + "\n";
                //System.out.println(vMensaje);
            }
            //LE AGREGO 1 POR QUE EMPIEZA EN 0
            totalResultados = totalResultados + 1;
            System.out.println("El numero de establecimientos de comida encontrados fue: " + totalResultados);
            //IMPRIME LA LISTA
            System.out.println(vMensaje);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LeerWS("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&rankby=distance&types=food&key=AIza.................");
    }

}
