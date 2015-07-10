/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Categoria;
import candelaria.logica.funciones.FCategoria;
import candelaria.logica.funciones.FControl_Mozarela;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class CategoriaControlador {
    private Categoria objCategoria;
    private Categoria categoriaSel;
    private ArrayList<Categoria> lstCategoria;
    private ArrayList<Categoria> lstQuesoMozarela;

    public ArrayList<Categoria> getLstQuesoMozarela() {
        return lstQuesoMozarela;
    }

    public void setLstQuesoMozarela(ArrayList<Categoria> lstQuesoMozarela) {
        this.lstQuesoMozarela = lstQuesoMozarela;
    }

    private boolean mostrarActualizar;

    public Categoria getObjCategoria() {
        return objCategoria;
    }

    public void setObjCategoria(Categoria objCategoria) {
        this.objCategoria = objCategoria;
    }

    public Categoria getCategoriaSel() {
        return categoriaSel;
    }

    public void setCategoriaSel(Categoria categoriaSel) {
        this.categoriaSel = categoriaSel;
    }

    public ArrayList<Categoria> getLstCategoria() {
        return lstCategoria;
    }

    public void setLstCategoria(ArrayList<Categoria> lstCategoria) {
        this.lstCategoria = lstCategoria;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

   

    public CategoriaControlador() {
    }
    
    public void reinit(){
        this.objCategoria=new Categoria();
        this.categoriaSel=new Categoria();
        this.cargarMozarela();
        this.lstCategoria=new ArrayList<Categoria>();
        this.lstQuesoMozarela=new ArrayList<Categoria>();

    }
    
    public void cargarMozarela() {
        try {
            this.lstQuesoMozarela = FCategoria.ObtenerlistaMozarela();
            this.categoriaSel = lstQuesoMozarela.get(0);
            System.out.println(lstQuesoMozarela.get(0).getId_categoria());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarMozarela dice: " + e.getMessage());
            System.out.println("private void cargarMozarela dice: " + e.getMessage());
        }
     }
    
    public void cargarCategorias(){
        try {
            this.lstCategoria = FCategoria.ObtenerCategoria();
            this.categoriaSel = lstCategoria.get(0);
            System.out.println(lstCategoria.get(0).getId_categoria());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCategoria dice: " + e.getMessage());
            System.out.println("private void cargarCategoria dice: " + e.getMessage());
        }
    }
    
    public void insertarCategoria() {
        try {
            
                        
            if (FCategoria.Insertar(objCategoria)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaCategoria.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarCategoria dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarCategoria dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarCategoria dice: " + e.getMessage());
            System.out.println("private void insertarCategoria dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarCategoria() {
        try {
            
                       
            if (FCategoria.actualizar(categoriaSel)) {
                categoriaSel = new Categoria();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarCategoria.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarCategoria dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarCategoria dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarCategoria dice: " + e.getMessage());
            System.out.println("private void actualizarCategoria dice: " + e.getMessage());
        }
    }

    public void eliminarCategoria() {
        try {
            if (FCategoria.eliminar((int) categoriaSel.getId_categoria())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCategoria.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarPedido dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarCategoria dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarCategoria dice: " + e.getMessage());
            System.out.println("private void eliminarCategoria dice: " + e.getMessage());
        }
        
    }
}
