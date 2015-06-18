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
public class Factura {

    private int id_factura;
    private Cliente id_cliente;
    private Date fecha;
    private double subtotal;
    private double precisiontotal;

    public Factura() {
    }

    public Factura(int id_factura, Cliente id_cliente, Date fecha, double subtotal, double precisiontotal) {
        this.id_factura = id_factura;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.precisiontotal = precisiontotal;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getPrecisiontotal() {
        return precisiontotal;
    }

    public void setPrecisiontotal(double precisiontotal) {
        this.precisiontotal = precisiontotal;
    }
    
    
}
