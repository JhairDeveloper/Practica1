/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Persona;
import modelo.enums.TipoGenero;

/**
 *
 * @author SONY VAIO
 */
public class PersonaControlador {
    public static String NCOMUN = "NO DEFINIDO";
    private Persona[] personas;
    private Persona persona;
    
    public PersonaControlador(Integer nro_personas){
        personas = new Persona[nro_personas];
        for(int i = 0; i < nro_personas; i++){
            Persona p = new Persona();
            p.setNombre(PersonaControlador.NCOMUN);
            personas[i] = p;
        }
    }
    public int verificarPosicion(){
        int pos = -1;
        for(int i = 0; i < getPersonas().length; i++){
            if(getPersonas()[i] == null){
                break;
            }else{
                pos = i;
            }
        }
        return pos;
    }
    
    public boolean estaLleno(){
        return getPersonas().length < verificarPosicion() - 1;
    }
    
    public boolean modificaPersona(Persona persona, Integer pos){
        getPersonas()[pos] = persona;
        return true;                
    }
    
    public boolean guardarElemento(Persona p){
        if(estaLleno()){
            return false;
        }else{
            getPersonas()[verificarPosicion() + 1] = p;
            return true;
        }
    }
    
    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
