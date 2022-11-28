/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.enums.TipoEdad;
import modelo.enums.TipoGenero;

/**
 *
 * @author SONY VAIO
 */
public class Persona {
    private Integer id;
    private Integer edad;
    private String nombre;
    private TipoGenero genero;
    private Date fechaNacimiento;
    private Date fechaActual;
    private TipoEdad clasificacionEdad;
    private String fechaNacimientoFormateada;
    
    public Persona(){

    }
    
    public Persona(String nombre, TipoGenero tG, Date fechaNacimiento){
        fechaActual = new Date();
        this.nombre = nombre;
        this.genero = tG;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaNacimientoFormateada = "" +  fechaNacimiento.getDate() +"-"+ (fechaNacimiento.getMonth()+1) + "-"
                + (fechaNacimiento.getYear() +1900);
        System.out.println("fechaNacimoent" + this.fechaNacimientoFormateada);
        calcularEdad();
        getEdad();
        clasificarPersona();
    }
    
    public Persona(TipoGenero genero, Date fechaNacimiento){
        String fechaS = fechaNacimiento.toString();
        this.fechaNacimientoFormateada = "" +  fechaNacimiento.getDate() +"-"+ (fechaNacimiento.getMonth()+1) + ""
                + (fechaNacimiento.getYear());
        System.out.println("fecha formateaada " + this.fechaNacimientoFormateada);
        this.genero = genero;
        fechaActual = new Date();
    }
    
    public Integer getEdad() {
        if(edad == null){
            edad = this.calcularEdad();
        }
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoGenero getGenero() {
        return genero;
    }

    public void setGenero(TipoGenero genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void clasificarPersona(){
        if(edad>=65){
            clasificacionEdad = TipoEdad.TERCERAEDAD;
        }
        if(edad >= 30 && edad < 65){
            clasificacionEdad = TipoEdad.ADULTO;
        }
        if(edad >= 14 && edad <= 29){
            clasificacionEdad = TipoEdad.JOVEN;
        }
        if (edad < 14){
            clasificacionEdad = TipoEdad.NIÑO;
        }
    }
    
    
    public int calcularEdad(){
        int edadPersona = fechaActual.getYear() - fechaNacimiento.getYear();
        if(fechaActual.getMonth() < fechaNacimiento.getMonth() ){
            edadPersona = edadPersona -1;
        }else{
            if(fechaActual.getMonth() == fechaNacimiento.getMonth()){
                if( fechaNacimiento.getDate() > fechaActual.getDate()){
                    edadPersona = edadPersona - 1;
                }
            }
        }
        return edadPersona;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public TipoEdad getClasificacionEdad() {
        if(clasificacionEdad == null){
            clasificarPersona();
        }
        return clasificacionEdad;
    }

    public void setClasificacionEdad(TipoEdad clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaNacimientoFormateada() {
        return fechaNacimientoFormateada;
    }

    public void setFechaNacimientoFormateada(String fechaNacimientoFormateada) {
        this.fechaNacimientoFormateada = fechaNacimientoFormateada;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
}
