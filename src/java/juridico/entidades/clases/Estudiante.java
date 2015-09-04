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
public class Estudiante {

    private int id_estudiante;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String sexo;
    private Date fecha_nacimiento;
    private Escuela id_escuela;
    private int nivel;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private int estado;
    private Facultad id_facultad;

    public Estudiante() {
    }

    public Estudiante(int id_estudiante, String nombres, String apellidos, String identificacion, String sexo, Date fecha_nacimiento, Escuela id_escuela, int nivel, Date fecha_ingreso, Date fecha_salida, int estado, Facultad id_facultad) {
        this.id_estudiante = id_estudiante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_escuela = id_escuela;
        this.nivel = nivel;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.estado = estado;
        this.id_facultad = id_facultad;
    }

    

    public Facultad getId_facultad() {
        return id_facultad;
    }

    public void setId_facultad(Facultad id_facultad) {
        this.id_facultad = id_facultad;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Escuela getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(Escuela id_escuela) {
        this.id_escuela = id_escuela;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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

}
