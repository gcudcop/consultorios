/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.entidades.clases;

import java.util.Date;

/**
 *
 * @author Oscunach
 */
public class RevisionDocente {

    private int id_revision;
    private Date fecha_revision;
    private String observaciones;
    private String estado_seguimiento;
    private Seguimiento id_seguimiento;
    private Docente id_docente;

    public RevisionDocente() {
    }

    public RevisionDocente(int id_revision, Date fecha_revision, String observaciones, String estado_seguimiento, Seguimiento id_seguimiento, Docente id_docente) {
        this.id_revision = id_revision;
        this.fecha_revision = fecha_revision;
        this.observaciones = observaciones;
        this.estado_seguimiento = estado_seguimiento;
        this.id_seguimiento = id_seguimiento;
        this.id_docente = id_docente;
    }

    public int getId_revision() {
        return id_revision;
    }

    public void setId_revision(int id_revision) {
        this.id_revision = id_revision;
    }

    public Date getFecha_revision() {
        return fecha_revision;
    }

    public void setFecha_revision(Date fecha_revision) {
        this.fecha_revision = fecha_revision;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado_seguimiento() {
        return estado_seguimiento;
    }

    public void setEstado_seguimiento(String estado_seguimiento) {
        this.estado_seguimiento = estado_seguimiento;
    }

    public Seguimiento getId_seguimiento() {
        return id_seguimiento;
    }

    public void setId_seguimiento(Seguimiento id_seguimiento) {
        this.id_seguimiento = id_seguimiento;
    }

    public Docente getId_docente() {
        return id_docente;
    }

    public void setId_docente(Docente id_docente) {
        this.id_docente = id_docente;
    }

}
