/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.MateriaPrima;
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
    private boolean mostrarActualizar;

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
        this.cargarMateriaPrima();
        
    }
    
    public void cargarMateriaPrima() {
        try {
            this.lstMateriaPrima = FMateriaPrima.ObtenerMateriaPrima();
            this.materiaPrimaSel = lstMateriaPrima.get(0);
            System.out.println(lstMateriaPrima.get(0).getId_MateriaPrima());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarMateriaPrima dice: " + e.getMessage());
            System.out.println("private void cargarMateriaPrima dice: " + e.getMessage());
        }
     }
     
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