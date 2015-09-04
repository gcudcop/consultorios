/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.entidades.clases;

import java.util.Date;
import master.logica.clases.Escuela;
import master.logica.clases.Facultad;

/**
 *
 * @author Oscunach
 */
public class Docente {

    private int id_docente;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String sexo;
    private String tercer_nivel;
    private String cuarto_nivel;
    private Escuela id_escuela;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private int estado;
    private Facultad id_facultad;

    /*
     Constructores
     */

    public Docente() {
    }

    public Docente(int id_docente, String nombres, String apellidos, String identificacion, String sexo, String tercer_nivel, String cuarto_nivel, Escuela id_escuela, Date fecha_ingreso, Date fecha_salida, int estado, Facultad id_facultad) {
        this.id_docente = id_docente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.sexo = sexo;
        this.tercer_nivel = tercer_nivel;
        this.cuarto_nivel = cuarto_nivel;
        this.id_escuela = id_escuela;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.estado = estado;
        this.id_facultad = id_facultad;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTercer_nivel() {
        return tercer_nivel;
    }

    public void setTercer_nivel(String tercer_nivel) {
        this.tercer_nivel = tercer_nivel;
    }

    public String getCuarto_nivel() {
        return cuarto_nivel;
    }

    public void setCuarto_nivel(String cuarto_nivel) {
        this.cuarto_nivel = cuarto_nivel;
    }

    public Escuela getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(Escuela id_escuela) {
        this.id_escuela = id_escuela;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Facultad getId_facultad() {
        return id_facultad;
    }

    public void setId_facultad(Facultad id_facultad) {
        this.id_facultad = id_facultad;
    }
    

}
