/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Empleado;
import candelaria.logica.funciones.FEmpleado;
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
public class EmpleadoControlador {
    private Empleado objEmpleado;
    private String estadoCivil; 
    private Empleado empleadoSel;
    private ArrayList<Empleado> lstEmpleado;
    private boolean mostrarActualizar;

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    

    public Empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(Empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public Empleado getEmpleadoSel() {
        return empleadoSel;
    }

    public void setEmpleadoSel(Empleado empleadoSel) {
        this.empleadoSel = empleadoSel;
    }

    public ArrayList<Empleado> getLstEmpleado() {
        return lstEmpleado;
    }

    public void setLstEmpleado(ArrayList<Empleado> lstEmpleado) {
        this.lstEmpleado = lstEmpleado;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public EmpleadoControlador() {
        reinit();
    }
    private void reinit(){
        this.objEmpleado = new Empleado();
        this.empleadoSel = new Empleado();
        this.lstEmpleado = new ArrayList<Empleado>();
//        this.LstPeriodos = new ArrayList<Periodos>();  
//        this.lstFacultades = new ArrayList<Facultad>();
//        this.lstEscuelas = new ArrayList<Escuela>();
//        this.lstNiveles = new ArrayList<Nivel>();
        //this.ProveedorSel = this.lstProveedors.get(0);
        this.cargarEmpleado();
        //this.cargarNiveles();
//        this.cargarPeriodos();
//        this.cargarFacultad();
        
    }
    public void cargarEmpleado() {
        try {
            this.lstEmpleado = FEmpleado.ObtenerEmpleado();
            this.empleadoSel = lstEmpleado.get(0);
            System.out.println(lstEmpleado.get(0).getId_empleado());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEmpleado dice: " + e.getMessage());
            System.out.println("private void cargarEmpleado dice: " + e.getMessage());
        }
     }
            
        public void insertarEmpleado() {
        try {
            
                        
            if (FEmpleado.Insertar(objEmpleado)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoEmpleado.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarEmpleado dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarEmpleado dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarEmpleado dice: " + e.getMessage());
            System.out.println("private void insertarEmpleado dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarEmpleado() {
        try {
            
                       
            if (FEmpleado.actualizar(empleadoSel)) {
                empleadoSel = new Empleado();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarEmpleado.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarEmpleado dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarEmpleado dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarEmpleado dice: " + e.getMessage());
            System.out.println("private void actualizarEmpleado dice: " + e.getMessage());
        }
    }

    public void eliminarEmpleado() {
        try {
            if (FEmpleado.eliminar((int) empleadoSel.getId_empleado())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarEmpleado.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarEmpleado dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarEmpleado dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarEmpleado dice: " + e.getMessage());
            System.out.println("private void eliminarEmpleado dice: " + e.getMessage());
        }
        
    }
    
}
