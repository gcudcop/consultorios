/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Cliente;
import candelaria.logica.clases.Detalle_Factura;
import candelaria.logica.clases.Factura;
import candelaria.logica.clases.Producto;
import candelaria.logica.funciones.FCliente;
import candelaria.logica.funciones.FDetalleFactura;
import candelaria.logica.funciones.FFactura;
import candelaria.logica.funciones.FProducto;
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
public class DetalleFacturaControlador {

    private Factura objFactura;
    private Detalle_Factura objDetalleFactura;
    private Detalle_Factura detalleFacturaSel;
    private Producto productoSel;
    private ArrayList<Detalle_Factura> lstDetalleFactura;
    private ArrayList<Producto> lstProductos;
    private ArrayList<Factura> facturaUltima;
    private ArrayList<Cliente> lstClientes;
    private Factura facturaSel;
    private boolean mostrarActualizar;
    private int valorProductoSeleccionado;
    private int cantidad;
    private double resultado;
    private double precio;
    private String fecha_cambiada;
    private int valorFSeleccionado;
    private int valorSSeleccionado;
    private double totalHoja;
    private double totalFactura;
    private double impuestoFactura;

    public ArrayList<Cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(ArrayList<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
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

    public Factura getObjFactura() {
        return objFactura;
    }

    public void setObjFactura(Factura objFactura) {
        this.objFactura = objFactura;
    }

    public Producto getProductoSel() {
        return productoSel;
    }

    public void setProductoSel(Producto productoSel) {
        this.productoSel = productoSel;
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

    public Factura getFacturaSel() {
        return facturaSel;
    }

    public void setFacturaSel(Factura facturaSel) {
        this.facturaSel = facturaSel;
    }

    public ArrayList<Factura> getFacturaUltima() {
        return facturaUltima;
    }

    public void setFacturaUltima(ArrayList<Factura> facturaUltima) {
        this.facturaUltima = facturaUltima;
    }

    public int getValorProductoSeleccionado() {
        return valorProductoSeleccionado;
    }

    public void setValorProductoSeleccionado(int valorProductoSeleccionado) {
        this.valorProductoSeleccionado = valorProductoSeleccionado;
    }

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
        reinit();
    }

    public void reinit() {
        this.objDetalleFactura = new Detalle_Factura();
        this.detalleFacturaSel = new Detalle_Factura();
        this.facturaSel = new Factura();
        this.productoSel = new Producto();
        this.lstDetalleFactura = new ArrayList<Detalle_Factura>();
        this.lstClientes = new ArrayList<Cliente>();
        this.lstProductos = new ArrayList<Producto>();
        this.facturaUltima = new ArrayList<Factura>();
        cargarDetalleFactura();
        cargarProductos();
        cargarFacturaUltima();
        cargarClientes();
    }

    public void cargarProductos() {
        try {
            this.lstProductos = FProducto.ObtenerProductos();
            System.out.println(lstProductos.get(0).getId_producto());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCategoria dice: " + e.getMessage());
            System.out.println("private void cargarCategoria dice: " + e.getMessage());
        }
    }

    public void cargarFacturaUltima() {
        try {
            this.facturaUltima = FFactura.ObtenerFacturaUltima();
            this.facturaSel = facturaUltima.get(0);
            System.out.println(facturaUltima.get(0).getId_factura());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFactura dice: " + e.getMessage());
            System.out.println("private void cargarFactura dice: " + e.getMessage());
        }
    }
    
    public void cargarClientes() {
        try {
            this.lstClientes = FCliente.ObtenerClientes();
            //this.facturaSel = facturaUltima.get(0);
            System.out.println(lstClientes.get(0).getId_cliente());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCliente dice: " + e.getMessage());
            System.out.println("private void cargarCliente dice: " + e.getMessage());
        }
    }

    public void cargarDetalleFactura() {
        try {
            this.lstDetalleFactura = FDetalleFactura.ObtenerDetalle_Facturas();
            this.detalleFacturaSel = lstDetalleFactura.get(0);
            System.out.println(lstDetalleFactura.get(0).getId_producto());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarDetalleFactura dice: " + e.getMessage());
            System.out.println("private void cargarDetalleFactura dice: " + e.getMessage());
        }
    }

    public void insertarDetalleFactura() {
        try {

            Producto producto = new Producto();
            producto.setId_producto(valorProductoSeleccionado);
            objDetalleFactura.setId_producto(producto);

            if (FDetalleFactura.Insertar(objDetalleFactura)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoDetalleFactura.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarDetalleFactura dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarDetalleFactura dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarDetalleFactura dice: " + e.getMessage());
            System.out.println("private void insertarDetalleFactura dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarDetalleFactura() {
        try {
            detalleFacturaSel.setId_producto(FProducto.ObtenerProductoDadoCodigo(detalleFacturaSel.getId_producto().getId_producto()));

            if (FDetalleFactura.actualizar(detalleFacturaSel)) {
                detalleFacturaSel = new Detalle_Factura();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarDetalleFactura.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarDetalleFactura dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarDetalleFactura dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarDetalleFactura dice: " + e.getMessage());
            System.out.println("private void actualizarDetalleFactura dice: " + e.getMessage());
        }
    }

    public void eliminarDetalleFactura() {
        try {
            if (FDetalleFactura.eliminar((int) detalleFacturaSel.getId_detalle_factura())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarDetalleFactura.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarDetalleFactura dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarDetalleFactura dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarDetalleFactura dice: " + e.getMessage());
            System.out.println("private void eliminarDetalleFactura dice: " + e.getMessage());
        }

    }

    public double sumaColumaPrecio() {
        totalHoja = 0.0;
        try {
            this.lstDetalleFactura = FDetalleFactura.ObtenerDetalleDadoCodigoFactura(facturaSel.getId_factura());
            //int size = lstDetalles.size();
            for (int x = 0; x < lstDetalleFactura.size(); x++) {
                totalHoja = totalHoja + lstDetalleFactura.get(x).getId_producto().getId_categoria().getPrecio_producto();
                //System.out.println(al.get(x));
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarDetalle dice: " + e.getMessage());
            System.out.println("private void actualizarDetalle dice: " + e.getMessage());
        }

        return totalHoja;
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
