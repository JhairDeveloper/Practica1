/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controlador.listas.ListaEnlazada;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;

/**
 *
 * @author SONY VAIO
 */
public class AdaptadorDao<T> implements InterfazDao<T> {
    
    private Class<T> clazz;
    public AdaptadorDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void guardar(T dato) throws FileNotFoundException, JAXBException {
        ListaEnlazada<T> lista = listar();
        lista.insertar(dato);
            
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try(PrintWriter pw = new PrintWriter(new File("personas.json"))){
            pw.write(jsonString);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void modificar(T dato, Integer pos) throws FileNotFoundException, JAXBException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListaEnlazada<T> listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        String json = "";
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("personas.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<T>>(){}.getType();
//            System.out.println("Tipolist " + tipoLista);
//            List a = stringToArray(json, Persona[].class);
//            System.out.println(a.size());
            lista = new Gson().fromJson(json, tipoLista);
//            for(int j = 0; j < arrayLista.length; j++){
//                System.out.println("-" + j + arrayLista[j]);
//            }
    //            lista.insertar(dato);
        } catch (IOException ex) {
            Logger.getLogger(AdaptadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
//    public static <T> List<T> stringToArray(String s, Class<T[]> clazz){
//       T[] array = new Gson().fromJson(s, clazz);
//       return Arrays.asList(array);
//    }
    @Override
    public T obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
