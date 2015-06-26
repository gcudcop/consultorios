/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Control_Yogurth;
import candelaria.logica.clases.Producto;
import candelaria.logica.funciones.FControl_Yogurth;
import candelaria.logica.funciones.FProducto;
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
public class Control_yogurthControlador {
    private Control_Yogurth objControl_Yogurth;
    private Control_Yogurth control_yogurthSel;
    private ArrayList<Control_Yogurth> lstControl_Yougurth;
    private ArrayList<Producto> lstProducto;
    private int valorProductoSeleccionado;
    private Producto productoSel;
    private boolean mostrarActualizar;

    public Producto getProductoSel() {
        return productoSel;
    }

    public void setProductoSel(Producto productoSel) {
        this.productoSel = productoSel;
    }

    public int getValorProductoSeleccionado() {
        return valorProductoSeleccionado;
    }

    public void setValorProductoSeleccionado(int valorProductoSeleccionado) {
        this.valorProductoSeleccionado = valorProductoSeleccionado;
    }

    public ArrayList<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(ArrayList<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public Control_Yogurth getObjControl_Yogurth() {
        return objControl_Yogurth;
    }

    public void setObjControl_Yogurth(Control_Yogurth objControl_Yogurth) {
        this.objControl_Yogurth = objControl_Yogurth;
    }

    public Control_Yogurth getControl_yogurthSel() {
        return control_yogurthSel;
    }

    public void setControl_yogurthSel(Control_Yogurth control_yogurthSel) {
        this.control_yogurthSel = control_yogurthSel;
    }

    public ArrayList<Control_Yogurth> getLstControl_Yougurth() {
        return lstControl_Yougurth;
    }

    public void setLstControl_Yougurth(ArrayList<Control_Yogurth> lstControl_Yougurth) {
        this.lstControl_Yougurth = lstControl_Yougurth;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public Control_yogurthControlador() {
        reinit();
    }
     private void reinit(){
        this.objControl_Yogurth = new Control_Yogurth();
        this.control_yogurthSel = new Control_Yogurth();
        this.lstControl_Yougurth = new ArrayList<Control_Yogurth>();
//        this.LstPeriodos = new ArrayList<Periodos>();  
//        this.lstFacultades = new ArrayList<Facultad>();
//        this.lstEscuelas = new ArrayList<Escuela>();
//        this.lstNiveles = new ArrayList<Nivel>();
        //this.ProveedorSel = this.lstProveedors.get(0);
        this.cargarControl_Yogurth();
        this.cargarProducto();
        //this.cargarNiveles();
//        this.cargarPeriodos();
//        this.cargarFacultad();
        
    }
    
    public void cargarControl_Yogurth() {
        try {
            this.lstControl_Yougurth = FControl_Yogurth.ObtenerControl_Yogurth();
            this.control_yogurthSel = lstControl_Yougurth.get(0);
            System.out.println(lstControl_Yougurth.get(0).getId_control_yogurth());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarControl_Yogurth dice: " + e.getMessage());
            System.out.println("private void cargarControl_Yogurth dice: " + e.getMessage());
        }
     }
            
    public void cargarProducto() {
        try {
            this.lstProducto = FProducto.ObtenerProductos();
            System.out.println(lstProducto.get(0).getId_producto());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarProducto dice: " + e.getMessage());
            System.out.println("private void cargarProducto dice: " + e.getMessage());
        }
     }
        public void insertarControl_Yogurth() {
        try {
            
                        
            if (FControl_Yogurth.Insertar(objControl_Yogurth)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoControl_Yogurth.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarControl_Yogurth dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarControl_Yogurth dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarControl_Yogurth dice: " + e.getMessage());
            System.out.println("private void insertarControl_Yogurth dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarControl_Yogurth() {
        try {
            
                       
            if (FControl_Yogurth.actualizar(control_yogurthSel)) {
                control_yogurthSel = new Control_Yogurth();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarControl_Yogurth.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarControl_Yogurth dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarControl_Yogurth dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarControl_Yogurth dice: " + e.getMessage());
            System.out.println("private void actualizarControl_Yogurth dice: " + e.getMessage());
        }
    }

    public void eliminarControl_Yogurth() {
        try {
            if (FControl_Yogurth.eliminar((int) control_yogurthSel.getId_control_yogurth())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarControl_Yogurth.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarControl_Yogurth dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarControl_Yogurth dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarControl_Yogurth dice: " + e.getMessage());
            System.out.println("private void eliminarControl_Yogurth dice: " + e.getMessage());
        }
        
    }
    
}

    
    