/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.Persona;

/**
 *
 * @author SONY VAIO
 */
public class PersonaDao extends AdaptadorDao<Persona>{
    private Persona persona;
    
    public PersonaDao(){
        super(Persona.class);
    }
    
    public Persona getPersona(){
        if(persona == null){
            persona = new Persona();
        }
        return persona;
    }
    
    public void setPersona(Persona persona){
        this.persona = persona;
    }
    
    public boolean guardar() throws Exception { 
        this.persona.setId(generarId());
        guardar(this.persona);
        return true;
    }
    
    
    public Integer generarId(){
        return listar().getSize()+1;
    }
}
