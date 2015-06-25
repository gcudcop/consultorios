/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Proveedor;
import candelaria.logica.funciones.FProveedor;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Yolanda
 */
@ManagedBean
@ViewScoped
public class ProveedorControlador {
    private Proveedor objProveedor;
    private Proveedor proveedorSel;
    private ArrayList<Proveedor> lstProveedor;
//    private ArrayList<Periodos> LstPeriodos;
//    private ArrayList<Nivel> lstNiveles;
//    private ArrayList<Escuela> lstEscuelas;
//    private ArrayList<Facultad> lstFacultades;
    private boolean mostrarActualizar;
//    private int valorPSeleccionado;
//    private int valorNSeleccionado;
//    private int valorESeleccionada;
//    private int valorFSeleccionada;  

    public Proveedor getObjProveedor() {
        return objProveedor;
    }

    public void setObjProveedor(Proveedor objProveedor) {
        this.objProveedor = objProveedor;
    }

    public Proveedor getProveedorSel() {
        return proveedorSel;
    }

    public void setProveedorSel(Proveedor proveedorSel) {
        this.proveedorSel = proveedorSel;
    }

    public ArrayList<Proveedor> getLstProveedor() {
        return lstProveedor;
    }

    public void setLstProveedor(ArrayList<Proveedor> lstProveedor) {
        this.lstProveedor = lstProveedor;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }
    
      public ProveedorControlador() {
          reinit();
    }
      
      private void reinit(){
        this.objProveedor = new Proveedor();
        this.proveedorSel = new Proveedor();
        this.lstProveedor = new ArrayList<Proveedor>();
//        this.LstPeriodos = new ArrayList<Periodos>();  
//        this.lstFacultades = new ArrayList<Facultad>();
//        this.lstEscuelas = new ArrayList<Escuela>();
//        this.lstNiveles = new ArrayList<Nivel>();
        //this.ProveedorSel = this.lstProveedors.get(0);
        this.cargarProveedor();
        //this.cargarNiveles();
//        this.cargarPeriodos();
//        this.cargarFacultad();
        
    }
    
    public void cargarProveedor() {
        try {
            this.lstProveedor = FProveedor.ObtenerProveedor();
            this.proveedorSel = lstProveedor.get(0);
            System.out.println(lstProveedor.get(0).getId_proveedor());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarProveedor dice: " + e.getMessage());
            System.out.println("private void cargarProveedor dice: " + e.getMessage());
        }
     }
    
    
//    private void cargarPeriodos(){
//        try {
//            this.LstPeriodos= FPeriodos.ObtenerPeriodos();
//            System.out.println(LstPeriodos.get(0).getNombre());
//        } catch (Exception e) {
//            Util.addErrorMessage("private void cargarPeriodos dice: " + e.getMessage());
//            System.out.println("private void cargarPeriodos dice: " + e.getMessage());
//            }
//        }
//    
//    private void cargarNiveles(){
//        try {
//            this.lstNiveles = FNivel.ObtenerNiveles();
//            System.out.println(lstNiveles.get(0).getNombre());
//        } catch (Exception e) {
//            Util.addErrorMessage("private void cargarNiveles dice: " + e.getMessage());
//            System.out.println("private void cargarNiveles dice: " + e.getMessage());
//            }
//        }
//    
//    private void cargarFacultad() {
//        try {
//            this.lstFacultades = FFacultad.ObtenerFacultades();
//            System.out.println(lstFacultades.get(0).getNombre());
//        } catch (Exception e) {
//            Util.addErrorMessage("private void cargarFacultad dice: " + e.getMessage());
//            System.out.println("private void cargarFacultad dice: " + e.getMessage());
//        }
//    }
//        
//     public void obtenerEscuelasDadoCodigoFacultad() {
//        try {
//            lstEscuelas.clear();
//            lstEscuelas = FEscuela.ObtenerEscuelaDadoCodigoFacultad(valorFSeleccionada);
//        } catch (Exception e) {
//            Util.addErrorMessage("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
//            System.out.println("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
//        }
//    }
     
//        public void obtenerNivelDadoCodigoEscuela() {
//        try {
//            lstNiveles.clear();
//            lstNiveles = FNivel.ObtenerNivelesDadoCodigoEscuela(valorESeleccionada);
//        } catch (Exception e) {
//            Util.addErrorMessage("private void obtenerNivelDadoCodigoEscuela: " + e.getMessage());
//            System.out.println("private void obtenerNivelDadoCodigoEscuela: " + e.getMessage());
//        }
//    }
//        
        
        public void insertarProveedor() {
        try {
            
                        
            if (FProveedor.Insertar(objProveedor)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoProveedor.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarProveedor dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarProveedor dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarProveedor dice: " + e.getMessage());
            System.out.println("private void insertarProveedor dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarProveedor() {
        try {
            
                       
            if (FProveedor.actualizar(proveedorSel)) {
                proveedorSel = new Proveedor();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarProveedor.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarProveedor dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarProveedor dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarProveedor dice: " + e.getMessage());
            System.out.println("private void actualizarProveedor dice: " + e.getMessage());
        }
    }

    public void eliminarProveedor() {
        try {
            if (FProveedor.eliminar((int) proveedorSel.getId_proveedor())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarProveedor.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarProveedor dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarProveedor dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarProveedor dice: " + e.getMessage());
            System.out.println("private void eliminarProveedor dice: " + e.getMessage());
        }
        
    }
    
}
