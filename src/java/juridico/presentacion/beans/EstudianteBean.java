/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import juridico.entidades.clases.Estudiante;
import juridico.entidades.funciones.FEstudiante;
import master.logica.clases.Escuela;
import master.logica.clases.Facultad;
import master.logica.funciones.FEscuela;
import master.logica.funciones.FFacultad;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Geovanny Cudco
 */
@ManagedBean
@RequestScoped
public class EstudianteBean {

    private Estudiante objEstudiante;
    private Estudiante estudianteSel;
    private ArrayList<Estudiante> lstEstudiantes;
    private ArrayList<Escuela> lstEscuelas;
    private ArrayList<Facultad> lstFacultades;
    private boolean mostrarActualizar;
    private int valorESeleccionada;
    private int valorFSeleccionada;

    /*
     * Métodos Get y Set
     */
    public Estudiante getObjEstudiante() {
        return objEstudiante;
    }

    public void setObjEstudiante(Estudiante objEstudiante) {
        this.objEstudiante = objEstudiante;
    }

    public Estudiante getEstudianteSel() {
        return estudianteSel;
    }

    public void setEstudianteSel(Estudiante estudianteSel) {
        this.estudianteSel = estudianteSel;
    }

    public ArrayList<Estudiante> getLstEstudiantes() {
        return lstEstudiantes;
    }

    public void setLstEstudiantes(ArrayList<Estudiante> lstEstudiantes) {
        this.lstEstudiantes = lstEstudiantes;
    }

    public ArrayList<Escuela> getLstEscuelas() {
        return lstEscuelas;
    }

    public void setLstEscuelas(ArrayList<Escuela> lstEscuelas) {
        this.lstEscuelas = lstEscuelas;
    }

    public ArrayList<Facultad> getLstFacultades() {
        return lstFacultades;
    }

    public void setLstFacultades(ArrayList<Facultad> lstFacultades) {
        this.lstFacultades = lstFacultades;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorESeleccionada() {
        return valorESeleccionada;
    }

    public void setValorESeleccionada(int valorESeleccionada) {
        this.valorESeleccionada = valorESeleccionada;
    }

    public int getValorFSeleccionada() {
        return valorFSeleccionada;
    }

    public void setValorFSeleccionada(int valorFSeleccionada) {
        this.valorFSeleccionada = valorFSeleccionada;
    }

    /*
     * inicialización de las variables y métodos
     */
    private void reinit() {
        this.estudianteSel = new Estudiante();
        this.objEstudiante = new Estudiante();
        this.lstEstudiantes = new ArrayList<Estudiante>();
        this.lstFacultades = new ArrayList<Facultad>();
        this.lstEscuelas = new ArrayList<Escuela>();
        this.cargarEstudiantes();
        this.cargarFacultad();
        this.obtenerEscuelasDadoCodigoFacultad();
    }

    public EstudianteBean() {
        this.reinit();
    }

    private void cargarEstudiantes() {
        try {
            this.lstEstudiantes = FEstudiante.obtenerEstudiantes();
            this.estudianteSel = lstEstudiantes.get(0);
            System.out.println(lstEstudiantes.get(0).getId_estudiante());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEstudiante dice: " + e.getMessage());
            System.out.println("private void cargarEstudiante dice: " + e.getMessage());
        }
    }

    private void cargarFacultad() {
        try {
            this.lstFacultades = FFacultad.ObtenerFacultades();
            System.out.println(lstFacultades.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFacultad dice: " + e.getMessage());
            System.out.println("private void cargarFacultad dice: " + e.getMessage());
        }
    }

    private void obtenerEscuelasDadoCodigoFacultad() {
        try {
            lstEscuelas.clear();
            lstEscuelas = FEscuela.ObtenerEscuelaDadoCodigoFacultad(valorFSeleccionada);
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
            System.out.println("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
        }
    }

    public void insertarEstudiante() {
        try {
            if (FEstudiante.insertarEstudiante(objEstudiante)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoEstudiante.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarEstudiante dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarEstudiante dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarEstudiante dice: " + e.getMessage());
            System.out.println("private void insertarEstudiante dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarEstudiante() {
        try {

            if (FEstudiante.actualizarEstudiante(estudianteSel)) {
                estudianteSel = new Estudiante();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarEstudiante.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarEstudiante dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarEstudiante dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarEstudiante dice: " + e.getMessage());
            System.out.println("private void actualizarEstudiante dice: " + e.getMessage());
        }
    }
    
    public void eliminarEstudiante() {
        try {
            if (FEstudiante.eliminarEstudiante((int) estudianteSel.getId_estudiante())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarEstudiante.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarEstudiante dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarEstudiante dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarEstudiante dice: " + e.getMessage());
            System.out.println("private void eliminarEstudiante dice: " + e.getMessage());
        }
        
    }
    
    

}
