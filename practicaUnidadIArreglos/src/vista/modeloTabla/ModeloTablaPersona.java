/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import com.google.gson.internal.LinkedTreeMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;
import modelo.enums.TipoEdad;
import modelo.enums.TipoGenero;
import modelo.enums.TipoMedicamentosAdulto;
import modelo.enums.TipoMedicamentosJoven;
import modelo.enums.TipoMedicamentosNinio;
import modelo.enums.TipoMedicamentosTerceraEdad;

/**
 *
 * @author SONY VAIO
 */
public class ModeloTablaPersona extends AbstractTableModel {

    private Persona personas[];

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    @Override
    public int getRowCount() {
        return personas.length;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Nombre";
            case 2:
                return "Genero";
            case 3:
                return "Edad";
            case 4:
                return "Clasificacion";
            case 5:
                return "Medicina";
            default:
                return null;
        }
    }
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        
//    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona p = null;
        String medicina = "";
        try {
            p = personas[rowIndex];
            System.out.println("index " + rowIndex + " edad" + p.getEdad());
        } catch (Exception e) {
            System.out.println(e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (p.getNombre().equals("NO DEFINIDO")) ? "No definido" : p.getNombre();
            case 2:
                return (p.getNombre().equals("NO DEFINIDO")) ? "No definido" : p.getGenero();
            case 3:
                return (p.getNombre().equals("NO DEFINIDO")) ? "No definido" : p.getEdad();
            case 4:
                return (p.getNombre().equals("NO DEFINIDO")) ? "No definido" : p.getClasificacionEdad();
            case 5:
                if (p.getNombre().equals("NO DEFINIDO")) {
                    return "No definido";
                }else{
                    if (p.getClasificacionEdad() == TipoEdad.NIÑO) {
                        TipoMedicamentosNinio lista[] = TipoMedicamentosNinio.values();
                        for (int i = 0; i < lista.length; i++) {
                            medicina += lista[i].toString() + " ";
                        }
                    }
                    if (p.getClasificacionEdad() == TipoEdad.JOVEN) {
                        TipoMedicamentosJoven lista[] = TipoMedicamentosJoven.values();
                        for (int i = 0; i < lista.length; i++) {
                            medicina += lista[i].toString() + "  ";
                        }
                    }
                    if (p.getClasificacionEdad() == TipoEdad.ADULTO) {
                        TipoMedicamentosAdulto lista[] = TipoMedicamentosAdulto.values();
                        for (int i = 0; i < lista.length; i++) {
                            medicina += lista[i].toString() + "   ";
                        }
                    }
                    if (p.getClasificacionEdad() == TipoEdad.TERCERAEDAD) {
                        TipoMedicamentosTerceraEdad lista[] = TipoMedicamentosTerceraEdad.values();
                        for (int i = 0; i < lista.length; i++) {
                            medicina += lista[i].toString() + "   ";
                        }
                    }

                    return medicina;                
                }
            default:
                return null;
        }
    }

}
