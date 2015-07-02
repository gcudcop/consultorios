/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Cliente;
import candelaria.logica.clases.Factura;
import candelaria.logica.funciones.FCliente;
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
    private ArrayList<Cliente> lstClientes;
    private boolean mostrarActualizar;
    private int cantidad;
    private double resultado;
    private double precio;
    private String fecha_cambiada;
    private int valorFSeleccionado;
    private int valorSSeleccionado;
    private double totalHoja;

    public ArrayList<Cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(ArrayList<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha_cambiada() {
        return fecha_cambiada;
    }

    public void setFecha_cambiada(String fecha_cambiada) {
        this.fecha_cambiada = fecha_cambiada;
    }

    public int getValorFSeleccionado() {
        return valorFSeleccionado;
    }

    public void setValorFSeleccionado(int valorFSeleccionado) {
        this.valorFSeleccionado = valorFSeleccionado;
    }

    public int getValorSSeleccionado() {
        return valorSSeleccionado;
    }

    public void setValorSSeleccionado(int valorSSeleccionado) {
        this.valorSSeleccionado = valorSSeleccionado;
    }

    public double getTotalHoja() {
        return totalHoja;
    }

    public void setTotalHoja(double totalHoja) {
        this.totalHoja = totalHoja;
    }
    
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
    
    public void cargarClientes(){
         try {
            this.lstClientes = FCliente.ObtenerClientes();
            //this.facturaSel = lstFacturas.get(0);
            System.out.println(lstClientes.get(0).getId_cliente());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarClientes dice: " + e.getMessage());
            System.out.println("private void cargarClientes dice: " + e.getMessage());
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
