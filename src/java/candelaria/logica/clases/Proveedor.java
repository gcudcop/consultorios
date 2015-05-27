/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.clases;

/**
 *
 * @author Yolanda
 */
public class Proveedor {
    private Integer id_proveedor;
    private String nombre_proveedor;
    private String direcion_proveedor;
    private String ciudad_proveedor;
    private String telefono_provedor;
    private String producto_provedor;
    private double costo;

    public Proveedor() {
    }

    public Proveedor(Integer id_proveedor, String nombre_proveedor, String direcion_proveedor, String ciudad_proveedor, String telefono_provedor, String producto_provedor, double costo) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.direcion_proveedor = direcion_proveedor;
        this.ciudad_proveedor = ciudad_proveedor;
        this.telefono_provedor = telefono_provedor;
        this.producto_provedor = producto_provedor;
        this.costo = costo;
    }

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getDirecion_proveedor() {
        return direcion_proveedor;
    }

    public void setDirecion_proveedor(String direcion_proveedor) {
        this.direcion_proveedor = direcion_proveedor;
    }

    public String getCiudad_proveedor() {
        return ciudad_proveedor;
    }

    public void setCiudad_proveedor(String ciudad_proveedor) {
        this.ciudad_proveedor = ciudad_proveedor;
    }

    public String getTelefono_provedor() {
        return telefono_provedor;
    }

    public void setTelefono_provedor(String telefono_provedor) {
        this.telefono_provedor = telefono_provedor;
    }

    public String getProducto_provedor() {
        return producto_provedor;
    }

    public void setProducto_provedor(String producto_provedor) {
        this.producto_provedor = producto_provedor;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    
    
}
