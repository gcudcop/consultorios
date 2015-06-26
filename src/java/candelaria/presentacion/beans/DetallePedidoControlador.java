/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Detalle_Pedido;
import candelaria.logica.clases.Producto;
import candelaria.logica.funciones.FDetallePedido;
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
public class DetallePedidoControlador {

    private Detalle_Pedido objDetallePedido;
    private Detalle_Pedido detallePedidoSel;
    private ArrayList<Detalle_Pedido> lstDetallePedido;
    private ArrayList<Producto> lstProductos;
    private boolean mostrarActualizar;
    private int valorProductoSeleccionado;

    public Detalle_Pedido getObjDetallePedido() {
        return objDetallePedido;
    }

    public void setObjDetallePedido(Detalle_Pedido objDetallePedido) {
        this.objDetallePedido = objDetallePedido;
    }

    public Detalle_Pedido getDetallePedidoSel() {
        return detallePedidoSel;
    }

    public void setDetallePedidoSel(Detalle_Pedido detallePedidoSel) {
        this.detallePedidoSel = detallePedidoSel;
    }

    public ArrayList<Detalle_Pedido> getLstDetallePedido() {
        return lstDetallePedido;
    }

    public void setLstDetallePedido(ArrayList<Detalle_Pedido> lstDetallePedido) {
        this.lstDetallePedido = lstDetallePedido;
    }

    public ArrayList<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(ArrayList<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorProductoSeleccionado() {
        return valorProductoSeleccionado;
    }

    public void setValorProductoSeleccionado(int valorProductoSeleccionado) {
        this.valorProductoSeleccionado = valorProductoSeleccionado;
    }

    public DetallePedidoControlador() {
    }

    public void reinit() {
        this.objDetallePedido = new Detalle_Pedido();
        this.detallePedidoSel = new Detalle_Pedido();
        this.lstDetallePedido = new ArrayList<Detalle_Pedido>();
        cargarDetallePedido();
        cargarProductos();
    }

    public void cargarProductos() {
        try {
            this.lstProductos = FProducto.ObtenerProductos();
            System.out.println(lstProductos.get(0).getId_producto());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarDetallePedido dice: " + e.getMessage());
            System.out.println("private void cargarDetallePedido dice: " + e.getMessage());
        }
    }

    public void cargarDetallePedido() {
        try {
            this.lstDetallePedido = FDetallePedido.ObtenerDetallePedido();
            this.detallePedidoSel = lstDetallePedido.get(0);
            System.out.println(lstDetallePedido.get(0).getId_detalle_pedido());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarDetallePedido dice: " + e.getMessage());
            System.out.println("private void cargarDetallePedido dice: " + e.getMessage());
        }
    }

    public void insertarDetallePedido() {
        try {

            Producto producto = new Producto();
            producto.setId_producto(valorProductoSeleccionado);
            objDetallePedido.setId_producto(producto);

            if (FDetallePedido.Insertar(objDetallePedido)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoDetallePedido.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarDetallePedido dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarDetallePedido dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarDetallePedido dice: " + e.getMessage());
            System.out.println("private void insertarDetallePedido dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarDetallePedido() {
        try {
            detallePedidoSel.setId_producto(FProducto.ObtenerProductoDadoCodigo(detallePedidoSel.getId_producto().getId_producto()));

            if (FDetallePedido.actualizar(detallePedidoSel)) {
                detallePedidoSel = new Detalle_Pedido();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarDetallePedido.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarDetallePedido dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarDetallePedido dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarDetallePedido dice: " + e.getMessage());
            System.out.println("private void actualizarDetallePedido dice: " + e.getMessage());
        }
    }

    public void eliminarDetallePedido() {
        try {
            if (FDetallePedido.eliminar((int) detallePedidoSel.getId_detalle_pedido())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarDetallePedido.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarDetallePedido dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarDetallePedido dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarDetallePedido dice: " + e.getMessage());
            System.out.println("private void eliminarDetallePedido dice: " + e.getMessage());
        }
    }
}
