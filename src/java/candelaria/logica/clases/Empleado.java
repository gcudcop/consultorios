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
public class Empleado {
  private Integer id_empleado;
  private String nombres_empleado;
  private String apellido_paterno;
  private String apellido_materno;
  private Integer numero_credencial;
  private String estado_civil;
  private String email_empleado;
  private String telefono_empleado;
  private String cedula_empleado;

    public Empleado() {
    }

    public Empleado(Integer id_empleado, String nombres_empleado, String apellido_paterno, String apellido_materno, Integer numero_credencial, String estado_civil, String email_empleado, String telefono_empleado, String cedula_empleado) {
        this.id_empleado = id_empleado;
        this.nombres_empleado = nombres_empleado;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.numero_credencial = numero_credencial;
        this.estado_civil = estado_civil;
        this.email_empleado = email_empleado;
        this.telefono_empleado = telefono_empleado;
        this.cedula_empleado = cedula_empleado;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public String getNombres_empleado() {
        return nombres_empleado;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public Integer getNumero_credencial() {
        return numero_credencial;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public String getEmail_empleado() {
        return email_empleado;
    }

    public String getTelefono_empleado() {
        return telefono_empleado;
    }

    public String getCedula_empleado() {
        return cedula_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setNombres_empleado(String nombres_empleado) {
        this.nombres_empleado = nombres_empleado;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public void setNumero_credencial(Integer numero_credencial) {
        this.numero_credencial = numero_credencial;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public void setEmail_empleado(String email_empleado) {
        this.email_empleado = email_empleado;
    }

    public void setTelefono_empleado(String telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

    public void setCedula_empleado(String cedula_empleado) {
        this.cedula_empleado = cedula_empleado;
    }
  
  
    
}
