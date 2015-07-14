/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.MateriaPrima;
import candelaria.logica.clases.MateriaPrima_Proveedor;
import candelaria.logica.clases.Proveedor;
import candelaria.logica.funciones.FMateriaPrima;
import candelaria.logica.funciones.FMateriaPrima_Provedor;
import candelaria.logica.funciones.FProveedor;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
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
    private MateriaPrima_Proveedor objMateriaPrimaProveedor;
    private MateriaPrima_Proveedor materiaPrimaProveedorSel;
    private MateriaPrima materiaPrimaSel;
    private ArrayList<MateriaPrima> lstMateriaPrima;
    private ArrayList<MateriaPrima_Proveedor> lstMateriaPrimaPproveedor;
    private ArrayList<Proveedor> lstProveedor;
    private boolean mostrarActualizar;
    private int valorProveedorSeleccionado;
    private int valorMateriaSeleccionado;
    

    public MateriaPrima_Proveedor getObjMateriaPrimaProveedor() {
        return objMateriaPrimaProveedor;
    }

    public void setObjMateriaPrimaProveedor(MateriaPrima_Proveedor objMateriaPrimaProveedor) {
        this.objMateriaPrimaProveedor = objMateriaPrimaProveedor;
    }

    public MateriaPrima_Proveedor getMateriaPrimaProveedorSel() {
        return materiaPrimaProveedorSel;
    }

    public void setMateriaPrimaProveedorSel(MateriaPrima_Proveedor materiaPrimaProveedorSel) {
        this.materiaPrimaProveedorSel = materiaPrimaProveedorSel;
    }

    public ArrayList<MateriaPrima_Proveedor> getLstMateriaPrimaPproveedor() {
        return lstMateriaPrimaPproveedor;
    }

    public void setLstMateriaPrimaPproveedor(ArrayList<MateriaPrima_Proveedor> lstMateriaPrimaPproveedor) {
        this.lstMateriaPrimaPproveedor = lstMateriaPrimaPproveedor;
    }

    public int getValorProveedorSeleccionado() {
        return valorProveedorSeleccionado;
    }

    public void setValorProveedorSeleccionado(int valorProveedorSeleccionado) {
        this.valorProveedorSeleccionado = valorProveedorSeleccionado;
    }

    public int getValorMateriaSeleccionado() {
        return valorMateriaSeleccionado;
    }

    public void setValorMateriaSeleccionado(int valorMateriaSeleccionado) {
        this.valorMateriaSeleccionado = valorMateriaSeleccionado;
    }
    
    public ArrayList<Proveedor> getLstProveedor() {
        return lstProveedor;
    }

    public void setLstProveedor(ArrayList<Proveedor> lstProveedor) {
        this.lstProveedor = lstProveedor;
    }
    
    
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
        this.lstMateriaPrimaPproveedor=new ArrayList<MateriaPrima_Proveedor>();
        this.lstProveedor=new ArrayList<Proveedor>();
        this.cargarMateriaPrima();
        this.cargarProveedor();
        this.cargarMateriaPrimaProveedor();
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
    
    public void cargarMateriaPrimaProveedor() {
        try {
            this.lstMateriaPrimaPproveedor = FMateriaPrima_Provedor.ObtenerMateriaPrima_Proveedor();
            this.materiaPrimaProveedorSel = lstMateriaPrimaPproveedor.get(0);
            System.out.println(lstMateriaPrimaPproveedor.get(0).getCodigoMateriaProveedor());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarMateriaPrimaProveedor dice: " + e.getMessage());
            System.out.println("private void cargarMateriaPrimaProveedor dice: " + e.getMessage());
        }
     }
     
       public void cargarProveedor() {
        try {
            this.lstProveedor = FProveedor.ObtenerProveedor();
            //this.materiaPrimaSel = lstMateriaPrima.get(0);
            System.out.println(lstProveedor.get(0).getId_proveedor());
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
        
        public void insertarMateriaPrimaProveedor() {
        try {
            
                        
            if (FMateriaPrima_Provedor.Insertar(objMateriaPrimaProveedor)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoMateriaPrimaProveedor.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarMateriaprimaproveedor dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarMateriaPrimaproveedor dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarMateriaPrimaproveedor dice: " + e.getMessage());
            System.out.println("private void insertarMateriaPrimaproveedor dice: " + e.getMessage());
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
     
     public void actualizarMateriaPrimaProveedor() {
        try {
            
                       
            if (FMateriaPrima_Provedor.actualizar(materiaPrimaProveedorSel)) {
                materiaPrimaProveedorSel = new MateriaPrima_Proveedor();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarMateriaPrimaProveedor.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarMateriaPrimaProveedor dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarMateriaPrimaProveedor dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarMateriaPrimaProveedor dice: " + e.getMessage());
            System.out.println("private void actualizarMateriaPrimaProveedor dice: " + e.getMessage());
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
    
     public void eliminarMateriaPrimaProveedor() {
        try {
            if (FMateriaPrima_Provedor.eliminar((int) materiaPrimaProveedorSel.getCodigoMateriaProveedor())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarMateriaPrimaProveedor.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarMateriaPrimaProveedor dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarMateriPrimaProveedor dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarMateriaPrimaProveedor dice: " + e.getMessage());
            System.out.println("private void eliminarMateriaPrimaProveedor dice: " + e.getMessage());
        }
        
    }
     
     public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "reportes" + File.separator + "materiaprima.png";
         
        pdf.add(Image.getInstance(logo));
    }
    
}