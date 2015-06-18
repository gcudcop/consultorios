/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.clases;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Pedido {

    private int id_pedido;
    private Cliente id_cliente;
    private Empleado id_empleado;
    private Date fecha_pedido;
    private double costo_total;

    public Pedido() {
    }

    public Pedido(int id_pedido, Cliente id_cliente, Empleado id_empleado, Date fecha_pedido, double costo_total) {
        this.id_pedido = id_pedido;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.fecha_pedido = fecha_pedido;
        this.costo_total = costo_total;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Empleado getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Empleado id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        this.costo_total = costo_total;
    }
    
    
}
