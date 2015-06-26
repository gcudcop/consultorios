/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Pedido;
import candelaria.logica.funciones.FPedido;
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
public class PedidoControlador {
     private Pedido objPedido;
    private Pedido pedidoSel;
    private ArrayList<Pedido> lstPedidos;
    private boolean mostrarActualizar;

    public Pedido getObjPedido() {
        return objPedido;
    }

    public void setObjPedido(Pedido objPedido) {
        this.objPedido = objPedido;
    }

    public Pedido getPedidoSel() {
        return pedidoSel;
    }

    public void setPedidoSel(Pedido pedidoSel) {
        this.pedidoSel = pedidoSel;
    }

    public ArrayList<Pedido> getLstPedidos() {
        return lstPedidos;
    }

    public void setLstPedidos(ArrayList<Pedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public PedidoControlador() {
        reinit();
    }
    
    public void reinit(){
        this.objPedido=new Pedido();
        this.pedidoSel=new Pedido();
        this.lstPedidos=new ArrayList<Pedido>();
        this.cargarPedidos();
    }
    
    public void cargarPedidos(){
        try {
            this.lstPedidos = FPedido.ObtenerPedidos();
            this.pedidoSel = lstPedidos.get(0);
            System.out.println(lstPedidos.get(0).getId_pedido());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarPedido dice: " + e.getMessage());
            System.out.println("private void cargarPedido dice: " + e.getMessage());
        }
    }
    
    public void insertarPedido() {
        try {
            
                        
            if (FPedido.Insertar(objPedido)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoPedido.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarPedido dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarPedido dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarPedido dice: " + e.getMessage());
            System.out.println("private void insertarPedido dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarProducto() {
        try {
            
                       
            if (FPedido.actualizar(pedidoSel)) {
                pedidoSel = new Pedido();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarPedido.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarPedido dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarPedido dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarPedido dice: " + e.getMessage());
            System.out.println("private void actualizarPedido dice: " + e.getMessage());
        }
    }

    public void eliminarProducto() {
        try {
            if (FPedido.eliminar((int) pedidoSel.getId_pedido())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarPedido.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarPedido dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarPedido dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarPedido dice: " + e.getMessage());
            System.out.println("private void eliminarPedido dice: " + e.getMessage());
        }
        
    }

}
