/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.presentacion.beans;

import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import juridico.entidades.clases.Agresor;
import juridico.entidades.clases.Caso;
import juridico.entidades.clases.Docente;
import juridico.entidades.clases.Estudiante;
import juridico.entidades.clases.Victima;
import juridico.entidades.funciones.FAgresor;
import juridico.entidades.funciones.FCaso;
import juridico.entidades.funciones.FDocente;
import juridico.entidades.funciones.FVictima;
import master.logica.funciones.FEstudiante;
import master.logica.funciones.FUsuario;
import master.presentacion.beans.SesionUsuarioDataManager;
import org.primefaces.context.DefaultRequestContext;
import recursos.StringToDate;
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
    private ArrayList<Docente> lstDocenteDadoEstudiante;
    private ArrayList<Victima> lstVictima;
    private ArrayList<Agresor> lstAgresor;
    private ArrayList<Caso> lstCasos;
    private boolean mostrarActualizar;
    private Date fechaInicio;
    private String cedulaSesion;
    private int valorESeleccionada;
    private int valorDSeleccionada;
    private int valorVSeleccionada;
    private int valorASeleccionada;
    private String txtFechaInicio;
    private String juzgado;
    private String numeroCaso;
    private String area;
    private String criterioBusqueda;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;

    public String getCriterioBusqueda() {
        return criterioBusqueda;
    }

    public void setCriterioBusqueda(String criterioBusqueda) {
        this.criterioBusqueda = criterioBusqueda;
    }

    public int getValorESeleccionada() {
        return valorESeleccionada;
    }

    public void setValorESeleccionada(int valorESeleccionada) {
        this.valorESeleccionada = valorESeleccionada;
    }

    public int getValorDSeleccionada() {
        return valorDSeleccionada;
    }

    public void setValorDSeleccionada(int valorDSeleccionada) {
        this.valorDSeleccionada = valorDSeleccionada;
    }

    public int getValorVSeleccionada() {
        return valorVSeleccionada;
    }

    public void setValorVSeleccionada(int valorVSeleccionada) {
        this.valorVSeleccionada = valorVSeleccionada;
    }

    public int getValorASeleccionada() {
        return valorASeleccionada;
    }

    public void setValorASeleccionada(int valorASeleccionada) {
        this.valorASeleccionada = valorASeleccionada;
    }

    public String getTxtFechaInicio() {
        return txtFechaInicio;
    }

    public void setTxtFechaInicio(String txtFechaInicio) {
        this.txtFechaInicio = txtFechaInicio;
    }

    public String getJuzgado() {
        return juzgado;
    }

    public void setJuzgado(String juzgado) {
        this.juzgado = juzgado;
    }

    public String getNumeroCaso() {
        return numeroCaso;
    }

    public void setNumeroCaso(String numeroCaso) {
        this.numeroCaso = numeroCaso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public ArrayList<Docente> getLstDocenteDadoEstudiante() {
        return lstDocenteDadoEstudiante;
    }

    public void setLstDocenteDadoEstudiante(ArrayList<Docente> lstDocenteDadoEstudiante) {
        this.lstDocenteDadoEstudiante = lstDocenteDadoEstudiante;
    }

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

    public CasosEstudianteBean() {
        this.reinit();

    }

    @PostConstruct
    public void postCasosDacenteBean() {
        this.cargarCasosUsuario();
    }

    private void reinit() {
        this.objCaso = new Caso();
        this.casoSel = new Caso();
        this.lstDocente = new ArrayList<Docente>();
        this.lstVictima = new ArrayList<Victima>();
        this.lstAgresor = new ArrayList<Agresor>();
        this.lstCasos = new ArrayList<Caso>();
//        this.capturaCedulaSesion();
        //this.cargarCasosUsuario();
        this.cargarVictimas();
        this.cargarDocentes();
        this.cargarAgresores();
    }

    /*
     ** Capturar la cedula de la sesion de usuario
     */
//    public void capturaCedulaSesion() {
//        try {
//            this.cedulaSesion = FUsuario.Obtener;
//        } catch (Exception e) {
//            Util.addErrorMessage("private void capturaCedulaSesion dice: " + e.getMessage());
//            System.out.println("private void capturaCedulaSesion dice: " + e.getMessage());
//        }
//    }
    public void cargarCasosUsuario() {
        try {
            this.lstCasos = FCaso.obtenerCasosDadoCedulaEstudiante(dm.getSesionEstudianteActual().getIdentificacion());

            //this.lstCasos = FCaso.obtenerCasosDadoCedulaEstudiante("0604792549");
            this.casoSel = lstCasos.get(0);
            System.out.println(lstCasos.get(0).getId_caso());
        } catch (Exception e) {
            Util.addErrorMessage("public void cargarCasosUsuario() dice: " + e.getMessage());
            System.out.println("public void cargarCasosUsuario() dice: " + e.getMessage());
        }
    }

    public void cargarDocentes() {
        try {
            this.lstDocente = FDocente.ObtenerDocentes();
            System.out.println(lstDocente.get(0).getId_docente());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarDocentes dice: " + e.getMessage());
            System.out.println("private void cargarDocentes dice: " + e.getMessage());
        }
    }

    public void cargarDocenteDadoSessionEstudiante() {
        try {
            this.lstDocenteDadoEstudiante = FDocente.ObtenerDocenteDadoCedulaEstudiante(dm.getSesionEstudianteActual().getIdentificacion());
            //this.lstEstudianteDadoDocente = FEstudiante.obtenerEstudianteDadoCedulaDocente("1803874310");
            System.out.println(lstDocenteDadoEstudiante.get(0).getId_docente());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEstudiante dice: " + e.getMessage());
            System.out.println("private void cargarEstudiante dice: " + e.getMessage());
        }
    }

//    public void cargarDocentes() {
//        try {
//            this.lstDocente = FDocente.ObtenerDocentes();
//            
//            System.out.println(lstDocente.get(0).getId_docente());
//        } catch (Exception e) {
//            Util.addErrorMessage("public void cargarDocentes() dice: " + e.getMessage());
//            System.out.println("public void cargarDocentes() dice: " + e.getMessage());
//        }
//    }
    public void cargarVictimas() {
        try {
            this.lstVictima = FVictima.ObtenerVictimas();
            System.out.println(lstVictima.get(0).getId_victima());
        } catch (Exception e) {
            Util.addErrorMessage("public void cargarVictimas() dice: " + e.getMessage());
            System.out.println("public void cargarVictimas() dice: " + e.getMessage());
        }
    }

    public void cargarAgresores() {
        try {
            this.lstAgresor = FAgresor.ObtenerAgresors();
            System.out.println(lstAgresor.get(0).getId_agresor());
        } catch (Exception e) {
            Util.addErrorMessage(" public void cargarAgresores() dice: " + e.getMessage());
            System.out.println(" public void cargarAgresores() dice: " + e.getMessage());
        }
    }

    /*
     * insertar caso
     */
    public void insertarCaso() {

        try {

            Docente docente = new Docente();
            docente.setId_docente(valorESeleccionada);

            Estudiante estudiante = new Estudiante();
            estudiante.setId_estudiante(lstCasos.get(0).getId_estudiante().getId_estudiante());

            Victima victima = new Victima();
            victima.setId_victima(valorVSeleccionada);

            Agresor agresor = new Agresor();
            agresor.setId_agresor(valorASeleccionada);

            objCaso.setFecha_inicio(StringToDate.devolverFecha(fechaInicio));
            objCaso.setId_docente(docente);
            objCaso.setId_estudiante(estudiante);
            objCaso.setId_victima(victima);
            objCaso.setId_agresor(agresor);
            objCaso.setJuzgado(juzgado);

            if (FCaso.insertarCaso(objCaso)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCaso.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarCaso dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarCaso dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarCaso dice: " + e.getMessage());
            System.out.println("private void insertarCaso dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    /*
     * Editar caso
     */
    public void actualizarCaso() {
        try {

            if (FCaso.actualizarCaso(casoSel)) {
                casoSel = new Caso();

                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarCaso.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarCaso dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarCaso dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("public void actualizarCaso dice: " + e.getMessage());
            System.out.println("public void actualizarCaso dice: " + e.getMessage());
        }
    }

    public void obtenerCasosPorNumero() {
        try {
            this.lstCasos = FCaso.obtenerCasosDadoCedulaDocente(dm.getSesionDocenteActual().getIdentificacion()); //descomentar esta linea

            this.lstCasos = FCaso.obtenerCasosDadoCedulaDocenteNumero(dm.getSesionDocenteActual().getIdentificacion(), criterioBusqueda); //descomentar esta linea
            //this.lstCasos = FCaso.obtenerCasosDadoCedulaDocenteNumero("1803874310", this.criterioBusqueda);
            this.casoSel = lstCasos.get(0);
            System.out.println(lstCasos.get(0).getId_caso());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerCasosPorNumero() dice: " + e.getMessage());
            System.out.println("public void obtenerCasosPorNumero() dice: " + e.getMessage());
        }
    }

}
