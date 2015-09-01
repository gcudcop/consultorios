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
public class Caso {

    private int id_caso;
    private Date fecha_inicio;
    private String numero_caso;
    private String juzgado;
    private String area;
    private Docente id_docente;
    private Estudiante id_estudiante;
    private Victima id_victima;
    private Agresor id_agresor;
    private String descripcion;
    private String problema_juridico;
    private String observaciones_tutor;

    /*
     Constructores
     */
    public Caso() {
    }

    public Caso(int id_caso, Date fecha_inicio, String numero_caso, String juzgado, String area, Docente id_docente, Estudiante id_estudiante, Victima id_victima, Agresor id_agresor, String descripcion, String problema_juridico, String observaciones_tutor) {
        this.id_caso = id_caso;
        this.fecha_inicio = fecha_inicio;
        this.numero_caso = numero_caso;
        this.juzgado = juzgado;
        this.area = area;
        this.id_docente = id_docente;
        this.id_estudiante = id_estudiante;
        this.id_victima = id_victima;
        this.id_agresor = id_agresor;
        this.descripcion = descripcion;
        this.problema_juridico = problema_juridico;
        this.observaciones_tutor = observaciones_tutor;
    }

    /*
     getters y setters
     */
    
    public int getId_caso() {
        return id_caso;
    }

    public void setId_caso(int id_caso) {
        this.id_caso = id_caso;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getNumero_caso() {
        return numero_caso;
    }

    public void setNumero_caso(String numero_caso) {
        this.numero_caso = numero_caso;
    }

    public String getJuzgado() {
        return juzgado;
    }

    public void setJuzgado(String juzgado) {
        this.juzgado = juzgado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Docente getId_docente() {
        return id_docente;
    }

    public void setId_docente(Docente id_docente) {
        this.id_docente = id_docente;
    }

    public Estudiante getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Estudiante id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public Victima getId_victima() {
        return id_victima;
    }

    public void setId_victima(Victima id_victima) {
        this.id_victima = id_victima;
    }

    public Agresor getId_agresor() {
        return id_agresor;
    }

    public void setId_agresor(Agresor id_agresor) {
        this.id_agresor = id_agresor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProblema_juridico() {
        return problema_juridico;
    }

    public void setProblema_juridico(String problema_juridico) {
        this.problema_juridico = problema_juridico;
    }

    public String getObservaciones_tutor() {
        return observaciones_tutor;
    }

    public void setObservaciones_tutor(String observaciones_tutor) {
        this.observaciones_tutor = observaciones_tutor;
    }

}
