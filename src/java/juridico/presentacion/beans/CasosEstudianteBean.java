/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.presentacion.beans;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import juridico.entidades.clases.Agresor;
import juridico.entidades.clases.Caso;
import juridico.entidades.clases.Docente;
import juridico.entidades.clases.Victima;
import juridico.entidades.funciones.FCaso;
import master.logica.funciones.FEstudiante;
import master.logica.funciones.FUsuario;
import master.presentacion.beans.SesionUsuarioDataManager;
import recursos.Util;

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class CasosEstudianteBean {

    private Caso objCaso;
    private Caso casoSel;
    private ArrayList<Docente> lstDocente;
    private ArrayList<Victima> lstVictima;
    private ArrayList<Agresor> lstAgresor;
    private ArrayList<Caso> lstCasos;
    private boolean mostrarActualizar;
    private Date fechaInicio;
    private String cedulaSesion;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public String getCedulaSesion() {
        return cedulaSesion;
    }

    public void setCedulaSesion(String cedulaSesion) {
        this.cedulaSesion = cedulaSesion;
    }

    public Caso getObjCaso() {
        return objCaso;
    }

    public void setObjCaso(Caso objCaso) {
        this.objCaso = objCaso;
    }

    public Caso getCasoSel() {
        return casoSel;
    }

    public void setCasoSel(Caso casoSel) {
        this.casoSel = casoSel;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    private void reinit() {
        this.objCaso = new Caso();
        this.casoSel = new Caso();
        this.lstDocente = new ArrayList<Docente>();
        this.lstVictima = new ArrayList<Victima>();
        this.lstAgresor = new ArrayList<Agresor>();
        this.lstCasos = new ArrayList<Caso>();
        this.capturaCedulaSesion();
        this.cargarCasosUsuario();
    }

    public CasosEstudianteBean() {
        this.reinit();

    }

    /*
     ** Capturar la cedula de la sesion de usuario
     */
    public void capturaCedulaSesion() {
        try {
            this.cedulaSesion = FUsuario.ObtenerUsuarioDadoCodigo(dm.getSesionUsuario().getCodigo()).getIdentificacion();
        } catch (Exception e) {
            Util.addErrorMessage("private void capturaCedulaSesion dice: " + e.getMessage());
            System.out.println("private void capturaCedulaSesion dice: " + e.getMessage());
        }
    }

    public void cargarCasosUsuario() {
        try {
            this.lstCasos = FCaso.obtenerCasosDadoCedulaEstudiante(cedulaSesion);

            //this.lstCasos = FCaso.obtenerCasosDadoCedulaEstudiante("0604792549");
            this.casoSel = lstCasos.get(0);
            System.out.println(lstCasos.get(0).getId_caso());
        } catch (Exception e) {
            Util.addErrorMessage("public void cargarCasosUsuario() dice: " + e.getMessage());
            System.out.println("public void cargarCasosUsuario() dice: " + e.getMessage());
        }
    }

}
