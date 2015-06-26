/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Control_Queso;
import candelaria.logica.funciones.FControl_Queso;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Pato
 */
@ManagedBean
@ViewScoped
public class Control_QuesoControlador {
    private Control_Queso objControl_Queso;
    private Control_Queso control_QuesoSel;
    private ArrayList<Control_Queso> lstControl_Queso;
    private boolean mostrarActualizar;

    public Control_Queso getObjControl_Queso() {
        return objControl_Queso;
    }

    public void setObjControl_Queso(Control_Queso objControl_Queso) {
        this.objControl_Queso = objControl_Queso;
    }

    public Control_Queso getControl_QuesoSel() {
        return control_QuesoSel;
    }

    public void setControl_QuesoSel(Control_Queso control_QuesoSel) {
        this.control_QuesoSel = control_QuesoSel;
    }

    public ArrayList<Control_Queso> getLstControl_Queso() {
        return lstControl_Queso;
    }

    public void setLstControl_Queso(ArrayList<Control_Queso> lstControl_Queso) {
        this.lstControl_Queso = lstControl_Queso;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public Control_QuesoControlador() {
        reinit();
    }
    private void reinit(){
        this.objControl_Queso = new Control_Queso();
        this.control_QuesoSel = new Control_Queso();
        this.lstControl_Queso = new ArrayList<Control_Queso>();
//        this.LstPeriodos = new ArrayList<Periodos>();  
//        this.lstFacultades = new ArrayList<Facultad>();
//        this.lstEscuelas = new ArrayList<Escuela>();
//        this.lstNiveles = new ArrayList<Nivel>();
        //this.ProveedorSel = this.lstProveedors.get(0);
        this.cargarControl_Queso();
        //this.cargarNiveles();
//        this.cargarPeriodos();
//        this.cargarFacultad();
        
    }
    
    public void cargarControl_Queso() {
        try {
            this.lstControl_Queso = FControl_Queso.ObtenerControl_Queso();
            this.control_QuesoSel = lstControl_Queso.get(0);
            System.out.println(lstControl_Queso.get(0).getId_control_queso());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarControl_Queso dice: " + e.getMessage());
            System.out.println("private void cargarControl_Queso dice: " + e.getMessage());
        }
     }
            
        public void insertarControl_Queso() {
        try {
            
                        
            if (FControl_Queso.Insertar(objControl_Queso)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoControl_Queso.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarControl_Queso dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarControl_Queso dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarControl_Queso dice: " + e.getMessage());
            System.out.println("private void insertarControl_Queso dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarControl_Queso() {
        try {
            
                       
            if (FControl_Queso.actualizar(control_QuesoSel)) {
                control_QuesoSel = new Control_Queso();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarControl_Queso.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarControl_Queso dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarControl_Queso dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarControl_Queso dice: " + e.getMessage());
            System.out.println("private void actualizarControl_Queso dice: " + e.getMessage());
        }
    }

    public void eliminarControl_Queso() {
        try {
            if (FControl_Queso.eliminar((int) control_QuesoSel.getId_control_queso())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarControl_Queso.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarControl_Queso dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarControl_Queso dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarControl_Queso dice: " + e.getMessage());
            System.out.println("private void eliminarControl_Queso dice: " + e.getMessage());
        }
        
    }
    
    
}
