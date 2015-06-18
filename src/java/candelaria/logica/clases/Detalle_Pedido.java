/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.clases;

/**
 *
 * @author Usuario
 */
public class Detalle_Pedido {

    private int id_detalle_pedido;
    private Producto id_producto;
    private Pedido id_pedido;
    private int unidades_producto;
    private double costo_unidad;
    private double costo_total;

    public Detalle_Pedido() {
    }

    public Detalle_Pedido(int id_detalle_pedido, Producto id_producto, Pedido id_pedido, int unidades_producto, double costo_unidad, double costo_total) {
        this.id_detalle_pedido = id_detalle_pedido;
        this.id_producto = id_producto;
        this.id_pedido = id_pedido;
        this.unidades_producto = unidades_producto;
        this.costo_unidad = costo_unidad;
        this.costo_total = costo_total;
    }

    public int getId_detalle_pedido() {
        return id_detalle_pedido;
    }

    public void setId_detalle_pedido(int id_detalle_pedido) {
        this.id_detalle_pedido = id_detalle_pedido;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public Pedido getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Pedido id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getUnidades_producto() {
        return unidades_producto;
    }

    public void setUnidades_producto(int unidades_producto) {
        this.unidades_producto = unidades_producto;
    }

    public double getCosto_unidad() {
        return costo_unidad;
    }

    public void setCosto_unidad(double costo_unidad) {
        this.costo_unidad = costo_unidad;
    }

    public double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        this.costo_total = costo_total;
    }
    
    
}
