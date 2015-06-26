/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Control_Mozarela;
import candelaria.logica.funciones.FControl_Mozarela;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author ROGES
 */
@ManagedBean
@ViewScoped
public class Control_MozarelaControlador {
    private Control_Mozarela objControl_mozarela;
    private Control_Mozarela control_MozarelaSel;
    private ArrayList<Control_Mozarela> lstControl_Mozarela;
    private boolean mostrarActualizar;

    public Control_Mozarela getObjControl_mozarela() {
        return objControl_mozarela;
    }

    public void setObjControl_mozarela(Control_Mozarela objControl_mozarela) {
        this.objControl_mozarela = objControl_mozarela;
    }

    public Control_Mozarela getControl_MozarelaSel() {
        return control_MozarelaSel;
    }

    public void setControl_MozarelaSel(Control_Mozarela control_MozarelaSel) {
        this.control_MozarelaSel = control_MozarelaSel;
    }

    public ArrayList<Control_Mozarela> getLstControl_Mozarela() {
        return lstControl_Mozarela;
    }

    public void setLstControl_Mozarela(ArrayList<Control_Mozarela> lstControl_Mozarela) {
        this.lstControl_Mozarela = lstControl_Mozarela;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public Control_MozarelaControlador() {
        reinit();
    }
    
    private void reinit(){
        this.objControl_mozarela = new Control_Mozarela();
        this.control_MozarelaSel = new Control_Mozarela();
        this.lstControl_Mozarela = new ArrayList<Control_Mozarela>();
//        this.LstPeriodos = new ArrayList<Periodos>();  
//        this.lstFacultades = new ArrayList<Facultad>();
//        this.lstEscuelas = new ArrayList<Escuela>();
//        this.lstNiveles = new ArrayList<Nivel>();
        //this.ProveedorSel = this.lstProveedors.get(0);
        this.cargarControl_Mozarela();
        //this.cargarNiveles();
//        this.cargarPeriodos();
//        this.cargarFacultad();
        
    }
    
    public void cargarControl_Mozarela() {
        try {
            this.lstControl_Mozarela = FControl_Mozarela.ObtenerControl_Mozarelas();
            this.control_MozarelaSel = lstControl_Mozarela.get(0);
            System.out.println(lstControl_Mozarela.get(0).getId_control_mozarela());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarControl_Mozarela dice: " + e.getMessage());
            System.out.println("private void cargarControl_Mozarela dice: " + e.getMessage());
        }
     }
            
        public void insertarControl_Mozarela() {
        try {
            
                        
            if (FControl_Mozarela.Insertar(objControl_mozarela)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoControl_Mozarela.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarControl_Mozarela dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarControl_Mozarela dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarControl_Mozarela dice: " + e.getMessage());
            System.out.println("private void insertarControl_Mozarela dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarControl_Mozarela() {
        try {
            
                       
            if (FControl_Mozarela.actualizar(control_MozarelaSel)) {
                control_MozarelaSel = new Control_Mozarela();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarControl_Mozarela.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarControl_Mozarela dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarControl_Mozarela dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarControl_Mozarela dice: " + e.getMessage());
            System.out.println("private void actualizarControl_Mozarela dice: " + e.getMessage());
        }
    }

    public void eliminarControl_Mozarela() {
        try {
            if (FControl_Mozarela.eliminar((int) control_MozarelaSel.getId_control_mozarela())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarControl_Mozarela.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarControl_Mozarela dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarControl_Mozarela dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarControl_Mozarela dice: " + e.getMessage());
            System.out.println("private void eliminarControl_Mozarela dice: " + e.getMessage());
        }
        
    }
    
}
