/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.presentacion.beans;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import juridico.entidades.clases.Agresor;
import juridico.entidades.clases.Caso;
import juridico.entidades.clases.Docente;
import juridico.entidades.clases.Estudiante;
import juridico.entidades.clases.RevisionDocente;
import juridico.entidades.clases.Seguimiento;
import juridico.entidades.clases.Victima;
import juridico.entidades.funciones.FCaso;
import juridico.entidades.funciones.FDocente;
import juridico.entidades.funciones.FRevisionDocente;
import juridico.entidades.funciones.FSeguimiento;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import recursos.StringToDate;
import recursos.Util;

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class RevisionesBean {

    /**
     * Creates a new instance of RevisionesBean
     */
    private RevisionDocente objRevision;
    private RevisionDocente revisionSel;
    private ArrayList<Estudiante> lstEstudiante;
    private ArrayList<Docente> lstDocente;
    private ArrayList<Victima> lstVictima;
    private ArrayList<Agresor> lstAgresor;
    private ArrayList<Caso> lstCasos;
    private boolean mostrarActualizar;
    private int valorDSeleccionado;
    private int valorVSeleccionada;
    private int valorASeleccionado;
    private Date fechaInicio;
    private ArrayList<RevisionDocente> lstRevisiones;
    private int valorCSeleccionado;
    private ArrayList<Seguimiento> lstSeguimiento;
    private ArrayList<Seguimiento> lstSeguimientoDadoCaso;
    private Seguimiento seguimientoSel;
    private int idSeguimientoSel;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdSeguimientoSel() {
        return idSeguimientoSel;
    }

    public void setIdSeguimientoSel(int idSeguimientoSel) {
        this.idSeguimientoSel = idSeguimientoSel;
    }

    public Seguimiento getSeguimientoSel() {
        return seguimientoSel;
    }

    public void setSeguimientoSel(Seguimiento seguimientoSel) {
        this.seguimientoSel = seguimientoSel;
    }

    public ArrayList<Seguimiento> getLstSeguimientoDadoCaso() {
        return lstSeguimientoDadoCaso;
    }

    public void setLstSeguimientoDadoCaso(ArrayList<Seguimiento> lstSeguimientoDadoCaso) {
        this.lstSeguimientoDadoCaso = lstSeguimientoDadoCaso;
    }

    public int getValorCSeleccionado() {
        return valorCSeleccionado;
    }

    public void setValorCSeleccionado(int valorCSeleccionado) {
        this.valorCSeleccionado = valorCSeleccionado;
    }

    public RevisionDocente getObjRevision() {
        return objRevision;
    }

    public void setObjRevision(RevisionDocente objRevision) {
        this.objRevision = objRevision;
    }

    public RevisionDocente getRevisionSel() {
        return revisionSel;
    }

    public void setRevisionSel(RevisionDocente revisionSel) {
        this.revisionSel = revisionSel;
    }

    public ArrayList<Estudiante> getLstEstudiante() {
        return lstEstudiante;
    }

    public void setLstEstudiante(ArrayList<Estudiante> lstEstudiante) {
        this.lstEstudiante = lstEstudiante;
    }

    public ArrayList<Docente> getLstDocente() {
        return lstDocente;
    }

    public void setLstDocente(ArrayList<Docente> lstDocente) {
        this.lstDocente = lstDocente;
    }

    public ArrayList<Victima> getLstVictima() {
        return lstVictima;
    }

    public void setLstVictima(ArrayList<Victima> lstVictima) {
        this.lstVictima = lstVictima;
    }

    public ArrayList<Agresor> getLstAgresor() {
        return lstAgresor;
    }

    public void setLstAgresor(ArrayList<Agresor> lstAgresor) {
        this.lstAgresor = lstAgresor;
    }

    public ArrayList<Caso> getLstCasos() {
        return lstCasos;
    }

    public void setLstCasos(ArrayList<Caso> lstCasos) {
        this.lstCasos = lstCasos;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorDSeleccionado() {
        return valorDSeleccionado;
    }

    public void setValorDSeleccionado(int valorDSeleccionado) {
        this.valorDSeleccionado = valorDSeleccionado;
    }

    public int getValorVSeleccionada() {
        return valorVSeleccionada;
    }

    public void setValorVSeleccionada(int valorVSeleccionada) {
        this.valorVSeleccionada = valorVSeleccionada;
    }

    public int getValorASeleccionado() {
        return valorASeleccionado;
    }

    public void setValorASeleccionado(int valorASeleccionado) {
        this.valorASeleccionado = valorASeleccionado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public ArrayList<RevisionDocente> getLstRevisiones() {
        return lstRevisiones;
    }

    public void setLstRevisiones(ArrayList<RevisionDocente> lstRevisiones) {
        this.lstRevisiones = lstRevisiones;
    }

    public ArrayList<Seguimiento> getLstSeguimiento() {
        return lstSeguimiento;
    }

    public void setLstSeguimiento(ArrayList<Seguimiento> lstSeguimiento) {
        this.lstSeguimiento = lstSeguimiento;
    }

    /*
     * Inicialización de variables
     */
    private void reinit() {
        this.objRevision = new RevisionDocente();
        this.revisionSel = new RevisionDocente();
        this.lstEstudiante = new ArrayList<Estudiante>();
        this.lstDocente = new ArrayList<Docente>();
        this.lstVictima = new ArrayList<Victima>();
        this.lstAgresor = new ArrayList<Agresor>();
        this.lstCasos = new ArrayList<Caso>();
        this.lstSeguimiento = new ArrayList<Seguimiento>();

        cargarRevisiones();
        cargarCasos();
        cargarDocentes();
        obtenerSeguimientos();

    }

    public RevisionesBean() {
        this.reinit();
    }
    /*
     * Metodos
     */

    public void cargarRevisiones() {
        try {
            this.lstRevisiones = FRevisionDocente.obtenerRevisiones();
            this.revisionSel = lstRevisiones.get(0);
            System.out.println(lstRevisiones.get(0).getId_seguimiento() + "  " + lstRevisiones.get(0).getEstado_seguimiento());
        } catch (Exception e) {
            Util.addErrorMessage("public void cargarRevisiones dice: " + e.getMessage());
            System.out.println("public void cargarRevisiones dice: " + e.getMessage());
        }
    }

    public void cargarCasos() {
        try {
            this.lstCasos = FCaso.obtenerCasos();
            System.out.println(lstCasos.get(0).getId_caso() + " numero de caso: " + lstCasos.get(0).getNumero_caso());
        } catch (Exception e) {
            Util.addErrorMessage(" public void cargarCasos dice: " + e.getMessage());
            System.out.println(" public void cargarCasos dice: " + e.getMessage());
        }
    }

    public void cargarDocentes() {
        try {
            this.lstDocente = FDocente.ObtenerDocentes();
            System.out.println(lstDocente.get(0).getId_docente());
        } catch (Exception e) {
            Util.addErrorMessage(" public void cargarDocente dice: " + e.getMessage());
            System.out.println(" public void cargarDocente dice: " + e.getMessage());
        }
    }

    public void obtenerSeguimientos() {
        try {
            this.lstSeguimiento = FSeguimiento.obtenerSeguimientos();
            this.seguimientoSel = lstSeguimiento.get(0);
            System.out.println(lstSeguimiento.get(0).getDescripcion() + " id seguimiento: " + lstSeguimiento.get(0).getId_seguimiento());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerSeguimientos dice: " + e.getMessage());
            System.out.println("public void obtenerSeguimientos dice: " + e.getMessage());
        }
    }

    public void obtenerSeguimientoDadoCodigoCaso() {
        try {
            lstSeguimiento.clear();
            this.lstSeguimiento = FSeguimiento.obtenerLstSeguimientoDadoCodigoCaso(valorCSeleccionado);
            System.out.println(lstSeguimiento.get(0).getDescripcion() + " id seguimiento: " + lstSeguimiento.get(0).getId_seguimiento());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerSeguimientoDadoCodigoCaso: " + e.getMessage());
            System.out.println("public void obtenerSeguimientoDadoCodigoCaso: " + e.getMessage());
        }
    }

    public void insertarRevision() {
//        System.out.println("Id Seguimiento" + seguimientoSel.getId_seguimiento());
        System.out.println("Fecha" + StringToDate.devolverFecha(fechaInicio));
        System.out.println("Estado" + estado);
        System.out.println("Id Docente" + valorDSeleccionado);
        
        try {

            Docente docente = new Docente();
            docente.setId_docente(valorDSeleccionado);
            objRevision.setId_docente(docente);
            
            Seguimiento seguimiento = new Seguimiento();
            seguimiento.setId_seguimiento(valorVSeleccionada);
            objRevision.setId_seguimiento(seguimiento);
            
            objRevision.setFecha_revision(StringToDate.devolverFecha(fechaInicio));
            objRevision.setEstado_seguimiento(estado);

            if (FRevisionDocente.insertarRevision(objRevision)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaRevision.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarRevision dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarRevision dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarRevision dice: " + e.getMessage());
            System.out.println("private void insertarRevision dice: " + e.getMessage());
        }
    }

}
