/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Cliente;
import candelaria.logica.clases.Factura;
import candelaria.logica.funciones.FCliente;
import candelaria.logica.funciones.FDetalleFactura;
import candelaria.logica.funciones.FFactura;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    Date fecha = new java.util.Date();
    private Factura objFactura;
    private Factura facturaSel;
    private ArrayList<Factura> lstFacturas;
    private ArrayList<Cliente> lstClientes;
    private boolean mostrarActualizar;
    private int cantidad;
    private double resultado;
    private double precio;
    private String fecha_cambiada;
    private String fechaLetras;
    private int valorFSeleccionado;
    private int valorSSeleccionado;
    private double totalHoja;
    private double impuestoFactura;
    private double totalFactura;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaLetras() {
        return fechaLetras;
    }

    public void setFechaLetras(String fechaLetras) {
        this.fechaLetras = fechaLetras;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public double getImpuestoFactura() {
        return impuestoFactura;
    }

    public void setImpuestoFactura(double impuestoFactura) {
        this.impuestoFactura = impuestoFactura;
    }

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

    public FacturaControlador() {
        reinit();
    }

    public void reinit() {
        this.objFactura = new Factura();
        this.facturaSel = new Factura();
        this.lstFacturas = new ArrayList<Factura>();
        this.lstClientes = new ArrayList<Cliente>();
        cargarFacturas();
        cargarClientes();
    }

    public void cargarFacturas() {
        java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("dd-MM-yyyy");
        fecha_cambiada = sdf1.format(fecha);
        DateFormat sdf2 = DateFormat.getDateInstance(DateFormat.FULL);
        
        try {
            this.lstFacturas = FFactura.ObtenerFacturaUltima();
            this.facturaSel = lstFacturas.get(0);
            fechaLetras = sdf2.format(facturaSel.getFecha());
            System.out.println(lstFacturas.get(0).getId_factura());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFacturas dice: " + e.getMessage());
            System.out.println("private void cargarFacturas dice: " + e.getMessage());
        }
    }

    public void cargarClientes() {
        try {
            this.lstClientes = FCliente.ObtenerClientes();
            //this.facturaSel = lstFacturas.get(0);
            System.out.println(lstClientes.get(0).getId_cliente());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarClientes dice: " + e.getMessage());
            System.out.println("private void cargarClientes dice: " + e.getMessage());
        }
    }

    public double Iva() {
        //impuestoFactura=0.0;
        impuestoFactura = totalHoja * 0.12;

        return impuestoFactura;
    }

    public double Total() {
        totalFactura = 0.0;
        totalFactura = totalHoja + impuestoFactura;

        return totalFactura;
    }

    public void insertarFactura() {

        try {
            Cliente cliente = new Cliente();
            cliente.setId_cliente(valorSSeleccionado);
            objFactura.setId_cliente(cliente);
            //objFactura.setFecha(sdf2.parse(fecha_cambiada));
            objFactura.setSubtotal(0.0);
            objFactura.setPrecisiontotal(0.0);

            if (FFactura.Insertar(objFactura)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaFactura.hide()");
                Util.addSuccessMessage("Factura creada con Exito");
                System.out.println("public void insertarFactura dice: Factura Creada ");
            } else {

                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarFactura dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarFactura dice: " + e.getMessage());
            System.out.println("private void insertarFactura dice: " + e.getMessage());
        }
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

}
