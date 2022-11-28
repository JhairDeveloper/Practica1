/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.utiles;

import com.sun.xml.internal.ws.client.ContentNegotiation;
import controlador.PersonaControlador;
import controlador.utiles.Utiles;
import javax.swing.JComboBox;

/**
 *
 * @author SONY VAIO
 */
public class ConjuntoPersonasUtilidad {
    public static boolean estaLleno(PersonaControlador[] personas){
        return Utiles.getPosicion(personas) + 1 == personas.length;
    }
    
    public static void loadCmbBolsas(JComboBox cmb, PersonaControlador[] personas){
        cmb.removeAllItems();
        for(PersonaControlador persona : personas){
            cmb.addItem(persona);
        }
    }
    
    public static PersonaControlador getPersonaControladorByIndex(int index){
        throw new UnsupportedOperationException("No soported");
    }
}
