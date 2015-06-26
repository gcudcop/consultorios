/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.MateriaPrima;
import candelaria.logica.funciones.FMateriaPrima;
import candelaria.logica.funciones.FMateriaPrima;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Yolanda
 */
@ViewScoped
@Named
public class MateriaPrimaControlador {
    private MateriaPrima objMateriaPrima;
    private MateriaPrima materiaPrimaSel;
    private ArrayList<MateriaPrima> lstMateriaPrima;
//    private ArrayList<Periodos> LstPeriodos;
//    private ArrayList<Nivel> lstNiveles;
//    private ArrayList<Escuela> lstEscuelas;
//    private ArrayList<Facultad> lstFacultades;
    private boolean mostrarActualizar;
//    private int valorPSeleccionado;
//    private int valorNSeleccionado;
//    private int valorESeleccionada;
//    private int valorFSeleccionada;  

    public MateriaPrima getObjMateriaPrima() {
        return objMateriaPrima;
    }

    public void setObjMateriaPrima(MateriaPrima objMateriaPrima) {
        this.objMateriaPrima = objMateriaPrima;
    }

    public MateriaPrima getMateriaPrimaSel() {
        return materiaPrimaSel;
    }

    public void setMateriaPrimaSel(MateriaPrima materiaPrimaSel) {
        this.materiaPrimaSel = materiaPrimaSel;
    }

    public ArrayList<MateriaPrima> getLstMateriaPrima() {
        return lstMateriaPrima;
    }

    public void setLstMateriaPrima(ArrayList<MateriaPrima> lstMateriaPrima) {
        this.lstMateriaPrima = lstMateriaPrima;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    
    
      public MateriaPrimaControlador() {
          reinit();
    }
      
      private void reinit(){
        this.objMateriaPrima = new MateriaPrima();
        this.materiaPrimaSel = new MateriaPrima();
        this.lstMateriaPrima = new ArrayList<MateriaPrima>();
//        this.LstPeriodos = new ArrayList<Periodos>();  
//        this.lstFacultades = new ArrayList<Facultad>();
//        this.lstEscuelas = new ArrayList<Escuela>();
//        this.lstNiveles = new ArrayList<Nivel>();
        //this.ProveedorSel = this.lstProveedors.get(0);
        this.cargarMateriaPrima();
        //this.cargarNiveles();
//        this.cargarPeriodos();
//        this.cargarFacultad();
        
    }
    
    public void cargarMateriaPrima() {
        try {
            this.lstMateriaPrima = FMateriaPrima.ObtenerMateriaPrima();
            this.materiaPrimaSel = lstMateriaPrima.get(0);
            System.out.println(lstMateriaPrima.get(0).getId_MateriaPrima());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarMateriaPrimadice: " + e.getMessage());
            System.out.println("private void cargarMateriaPrima dice: " + e.getMessage());
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
        
        public void insertarMateriaPrima() {
        try {
            
                        
            if (FMateriaPrima.Insertar(objMateriaPrima)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoMateriaPrima.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarMateriaprima dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarMateriaPrima dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarMateriaPrima dice: " + e.getMessage());
            System.out.println("private void insertarMateriaPrima dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarMateriaPrima() {
        try {
            
                       
            if (FMateriaPrima.actualizar(materiaPrimaSel)) {
                materiaPrimaSel = new MateriaPrima();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarMateriaPrima.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarProveedor dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarMateriaPrima dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarMateriaPrima dice: " + e.getMessage());
            System.out.println("private void actualizarMateriaPrima dice: " + e.getMessage());
        }
    }

    public void eliminarMateriaPrima() {
        try {
            if (FMateriaPrima.eliminar((int) materiaPrimaSel.getId_MateriaPrima())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarMateriaPrima.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarProveedor dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarProveedor dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarMateriaPrima dice: " + e.getMessage());
            System.out.println("private void eliminarMateriaPrima dice: " + e.getMessage());
        }
        
    }
    
}