/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Detalle_Factura;
import candelaria.logica.clases.Producto;
import candelaria.logica.funciones.FProducto;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import recursos.Util;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class DetalleFacturaControlador {

    private Detalle_Factura objDetalleFactura;
    private Detalle_Factura detalleFacturaSel;
    private ArrayList<Detalle_Factura> lstDetalleFactura;
    private ArrayList<Producto> lstProductos;
    private boolean mostrarActualizar;

    public ArrayList<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(ArrayList<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public Detalle_Factura getObjDetalleFactura() {
        return objDetalleFactura;
    }

    public void setObjDetalleFactura(Detalle_Factura objDetalleFactura) {
        this.objDetalleFactura = objDetalleFactura;
    }

    public Detalle_Factura getDetalleFacturaSel() {
        return detalleFacturaSel;
    }

    public void setDetalleFacturaSel(Detalle_Factura detalleFacturaSel) {
        this.detalleFacturaSel = detalleFacturaSel;
    }

    public ArrayList<Detalle_Factura> getLstDetalleFactura() {
        return lstDetalleFactura;
    }

    public void setLstDetalleFactura(ArrayList<Detalle_Factura> lstDetalleFactura) {
        this.lstDetalleFactura = lstDetalleFactura;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public DetalleFacturaControlador() {
    }


public void cargarProductos(){
    try {
            this.lstProductos = FProducto.ObtenerProductos();
            System.out.println(lstProductos.get(0).getId_producto());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCategoria dice: " + e.getMessage());
            System.out.println("private void cargarCategoria dice: " + e.getMessage());
        }
}
}
