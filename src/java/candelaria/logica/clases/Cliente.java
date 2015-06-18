/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.clases;

/**
 *
 * @author Pato
 */
public class Cliente {
    
  private Integer id_cliente;
  private String nombres_cliente;
  private String apellidos_cliente;
  private String direccion_cliente;
  private String telefono_cliente;
  private String email_cliente;
  private String nombre_empresa;
  private String ruc_cliente;

    public Cliente() {
    }

    public Cliente(Integer id_cliente, String nombres_cliente, String apellidos_cliente, String direccion_cliente, String telefono_cliente, String email_cliente, String nombre_empresa, String ruc_cliente) {
        this.id_cliente = id_cliente;
        this.nombres_cliente = nombres_cliente;
        this.apellidos_cliente = apellidos_cliente;
        this.direccion_cliente = direccion_cliente;
        this.telefono_cliente = telefono_cliente;
        this.email_cliente = email_cliente;
        this.nombre_empresa = nombre_empresa;
        this.ruc_cliente = ruc_cliente;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public String getNombres_cliente() {
        return nombres_cliente;
    }

    public String getApellidos_cliente() {
        return apellidos_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public String getRuc_cliente() {
        return ruc_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNombres_cliente(String nombres_cliente) {
        this.nombres_cliente = nombres_cliente;
    }

    public void setApellidos_cliente(String apellidos_cliente) {
        this.apellidos_cliente = apellidos_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public void setRuc_cliente(String ruc_cliente) {
        this.ruc_cliente = ruc_cliente;
    }
  
  
    
}
