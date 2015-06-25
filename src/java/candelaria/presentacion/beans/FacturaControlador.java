/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Factura;
import candelaria.logica.funciones.FFactura;
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
public class FacturaControlador {
    private Factura objFactura;
    private Factura facturaSel;
    private ArrayList<Factura> lstFacturas;
    private boolean mostrarActualizar;

    public Factura getObjFactura() {
        return objFactura;
    }

    public void setObjFactura(Factura objFactura) {
        this.objFactura = objFactura;
    }

    public Factura getFacturaSel() {
        return facturaSel;
    }

    public void setFacturaSel(Factura facturaSel) {
        this.facturaSel = facturaSel;
    }

    public ArrayList<Factura> getLstFacturas() {
        return lstFacturas;
    }

    public void setLstFacturas(ArrayList<Factura> lstFacturas) {
        this.lstFacturas = lstFacturas;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public FacturaControlador(){
    reinit();
    }

    public void reinit(){
        this.objFactura=new Factura();
        this.facturaSel=new Factura();
        this.lstFacturas= new ArrayList<Factura>();
        
    }
    
    public void cargarFacturas(){
         try {
            this.lstFacturas = FFactura.ObtenerFacturas();
            this.facturaSel = lstFacturas.get(0);
            System.out.println(lstFacturas.get(0).getId_factura());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFacturas dice: " + e.getMessage());
            System.out.println("private void cargarFacturas dice: " + e.getMessage());
        }
    }
    
    public void insertarFactura() {
        try {
            
                        
            if (FFactura.Insertar(objFactura)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaFactura.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarFactura dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarFactura dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarFactura dice: " + e.getMessage());
            System.out.println("private void insertarFactura dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarFactura() {
        try {
            
                       
            if (FFactura.actualizar(facturaSel)) {
                facturaSel = new Factura();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarFactura.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarFactura dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarFactura dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarFactura dice: " + e.getMessage());
            System.out.println("private void actualizarFactura dice: " + e.getMessage());
        }
    }

    public void eliminarFactura() {
        try {
            if (FFactura.eliminar((int) facturaSel.getId_factura())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarFactura.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarFactura dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarFactura dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarFactura dice: " + e.getMessage());
            System.out.println("private void eliminarFactura dice: " + e.getMessage());
        }
        
    }
}
