/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.utiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controlador.PersonaControlador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JComboBox;
import modelo.Persona;
import modelo.enums.TipoGenero;

/**
 *
 * @author SONY VAIO
 */
public class Utilidades {
    public static JComboBox cargarComboGenero(JComboBox cbx){
        cbx.removeAllItems();
        for(TipoGenero genero : TipoGenero.values()){
            cbx.addItem(genero);
        }
        return cbx;
    }
    
    public static TipoGenero getGeneroTipo(JComboBox cbx){
        return (TipoGenero) cbx.getSelectedItem();
    }
    
    public static JComboBox cargarComboPersonas(JComboBox cbx, PersonaControlador pc){
        cbx.removeAllItems();
        for(int i = 0; i < pc.getPersonas().length ; i++){
            cbx.addItem(pc.getPersonas()[i]);
        }
        return cbx;
    }
    
    public static Persona getPersonaCombo(JComboBox cbx){
        return (Persona)cbx.getSelectedItem();
    }
    
    public static TipoGenero getGeneroPersona(Persona persona){
        return TipoGenero.valueOf(persona.getGenero());
    }
    
    public static boolean guardarArchivo(Persona[] personas){
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(personas);
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("personas.json"))){
            bw.write(jsonString);
            bw.close();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        
    }    
        
    public static Persona[] cargarPersonas(){
        Persona[] personas = null;
        String json = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("personas.json"));
            String linea;
            while((linea = br.readLine()) != null){
                json += linea;
            }
            br.close();
            personas = new Gson().fromJson(json, Persona[].class);
        }catch(Exception e){
            System.out.println(e);
        }
        return personas;
    }
}
