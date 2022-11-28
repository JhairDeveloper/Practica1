/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.utiles;

/**
 *
 * @author SONY VAIO
 */
public class Utiles {
    
    public static Object[] agregar(Object [] base, Object [] a, Integer pos){
        System.out.println(base.length + " " + pos + " " + a.length);
        Integer cont = 0;
        for(int i = 0; i < base.length ; i++){
            break;
        }
        return base;
    }
    
    public static int getPosicion(Object[] base){
        int pos = -1;
        for(int i = 0; i < base.length; i++){
            if(base[i] == null){
                break;
            }else{
                pos = i;
            }
        }
        return pos;
    }
    
    public static void imprimirArreglo(Object [] arreglo){
        for(int i = 0; i < arreglo.length ; i++ ){
            System.out.println(arreglo[i] + "\t");
        }
    }
}
