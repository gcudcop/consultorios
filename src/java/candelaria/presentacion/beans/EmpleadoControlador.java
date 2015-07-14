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
    private String credencial1;
    private Empleado empleadoSel;
    private Empleado empleadoSel1;
    private ArrayList<Empleado> lstEmpleado;
    private ArrayList<Empleado> lstEmpleadoUltimo;
    private boolean mostrarActualizar;
    private Integer credencial;

    public Empleado getEmpleadoSel1() {
        return empleadoSel1;
    }

    public void setEmpleadoSel1(Empleado empleadoSel1) {
        this.empleadoSel1 = empleadoSel1;
    }
     
    
    public String getCredencial1() {
        return credencial1;
        
    }

    public void setCredencial1(String credencial1) {
        this.credencial1 = credencial1;
    }

    public ArrayList<Empleado> getLstEmpleadoUltimo() {
        return lstEmpleadoUltimo;
    }

    public void setLstEmpleadoUltimo(ArrayList<Empleado> lstEmpleadoUltimo) {
        this.lstEmpleadoUltimo = lstEmpleadoUltimo;
    }

    public Integer getCredencial() {
        return credencial;
    }

    public void setCredencial(Integer credencial) {
        this.credencial = credencial;
    }

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

    private void reinit() {
        this.objEmpleado = new Empleado();
        this.empleadoSel = new Empleado();
        this.empleadoSel1 = new Empleado();
        this.lstEmpleado = new ArrayList<Empleado>();
        this.lstEmpleadoUltimo = new ArrayList<Empleado>();

        this.cargarEmpleado();
//        this.cargarEmpleadoUltimo();


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

//    public void cargarEmpleadoUltimo() {
//        //this.credencial=Integer.parseInt(credencial1);
//        try {
//            this.lstEmpleadoUltimo = FEmpleado.ObtenerEmpleadoUltimo();
//            this.empleadoSel = lstEmpleadoUltimo.get(0);
//            credencial = ((empleadoSel1.getId_empleado()) + 1);
//            System.out.println(credencial);
//            System.out.println(lstEmpleadoUltimo.get(0).getId_empleado());
//        } catch (Exception e) {
//            Util.addErrorMessage("private void cargarEmpleadoUltimo dice: " + e.getMessage());
//            System.out.println("private void cargarEmpleadoUltimo dice: " + e.getMessage());
//        }
//    }

    public void insertarEmpleado() {
        //credencial = ((lstEmpleadoUltimo.get(0).getId_empleado()) + 1);
        //credencial = Integer.parseInt(credencial1);
        try {

            objEmpleado.setEstado_civil(estadoCivil);
            objEmpleado.setApellido_materno("N/A");
            //objEmpleado.setNumero_credencial(credencial1);

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

    public void cambiarEstadoMostrarActualizar() {
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
