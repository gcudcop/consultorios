/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.entidades.clases;

import java.util.Date;

/**
 *
 * @author servidor
 */
public class Seguimiento {
    
  private int id_seguimiento;
  private String descripcion;
  private Date fecha_inicio;
  private Date fecha_fin ;
  private int estado ;
  private String docente_responsable ;
  private String estudiante_responsable;
  private Caso id_caso;
  private String path ;
  private String dependencia ;
  private String responsable_dependencia;

    public Seguimiento() {
    }

    public Seguimiento(int id_seguimiento, String descripcion, Date fecha_inicio, Date fecha_fin, int estado, String docente_responsable, String estudiante_responsable, Caso id_caso, String path, String dependencia, String responsable_dependencia) {
        this.id_seguimiento = id_seguimiento;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.docente_responsable = docente_responsable;
        this.estudiante_responsable = estudiante_responsable;
        this.id_caso = id_caso;
        this.path = path;
        this.dependencia = dependencia;
        this.responsable_dependencia = responsable_dependencia;
    }

    public int getId_seguimiento() {
        return id_seguimiento;
    }

    public void setId_seguimiento(int id_seguimiento) {
        this.id_seguimiento = id_seguimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDocente_responsable() {
        return docente_responsable;
    }

    public void setDocente_responsable(String docente_responsable) {
        this.docente_responsable = docente_responsable;
    }

    public String getEstudiante_responsable() {
        return estudiante_responsable;
    }

    public void setEstudiante_responsable(String estudiante_responsable) {
        this.estudiante_responsable = estudiante_responsable;
    }

    public Caso getId_caso() {
        return id_caso;
    }

    public void setId_caso(Caso id_caso) {
        this.id_caso = id_caso;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getResponsable_dependencia() {
        return responsable_dependencia;
    }

    public void setResponsable_dependencia(String responsable_dependencia) {
        this.responsable_dependencia = responsable_dependencia;
    }
  
  
    
}