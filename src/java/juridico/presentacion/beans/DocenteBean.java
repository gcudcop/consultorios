/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.presentacion.beans;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import juridico.entidades.clases.Docente;
import juridico.entidades.funciones.FDocente;
import master.logica.clases.Escuela;
import master.logica.clases.Facultad;
import master.logica.clases.Rol;
import master.logica.clases.Usuario;
import master.logica.clases.UsuarioRol;
import master.logica.funciones.FEscuela;
import master.logica.funciones.FFacultad;
import master.logica.funciones.FUsuario;
import org.primefaces.context.DefaultRequestContext;
import recursos.StringToDate;
import recursos.Tools;
import recursos.Util;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class DocenteBean {

    /**
     * Creates a new instance of DocenteBean
     */
    private Docente objDocente;
    private Docente docenteSel;
    private Usuario objUsuario;
    private UsuarioRol objUsuarioRol;
    private ArrayList<Docente> lstDocentes;
    private ArrayList<Escuela> lstEscuelas;
    private ArrayList<Facultad> lstFacultades;
    private boolean mostrarActualizar;

    private java.util.Date fechaModificacion;
    private java.util.Date primerAcceso;
    private java.util.Date ultimoAcceso;

    private String nombresDocente;
    private String apellidosDocente;
    private String identificacionDocente;

    private String nombresUsuario;
    private String apellidosUsuario;
    private String identificacionUsuario;

    private String nombreCorto;
    private String clave;
    private String clavePregunta;
    private String claveRespuesta;
    private String mail;

    private Date fechaIngreso;
    private Date fechaSalida;
    private String txtFechaIngreso;
    private String txtFechaSalida;
    private int escuelaSeleccionada;
    private int faculatadSeleccionana;
    private int estado;
    private String sexo;
    private String cedulaBusqueda;

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClavePregunta() {
        return clavePregunta;
    }

    public void setClavePregunta(String clavePregunta) {
        this.clavePregunta = clavePregunta;
    }

    public String getClaveRespuesta() {
        return claveRespuesta;
    }

    public void setClaveRespuesta(String claveRespuesta) {
        this.claveRespuesta = claveRespuesta;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public UsuarioRol getObjUsuarioRol() {
        return objUsuarioRol;
    }

    public void setObjUsuarioRol(UsuarioRol objUsuarioRol) {
        this.objUsuarioRol = objUsuarioRol;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getPrimerAcceso() {
        return primerAcceso;
    }

    public void setPrimerAcceso(Date primerAcceso) {
        this.primerAcceso = primerAcceso;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public String getNombresDocente() {
        return nombresDocente;
    }

    public void setNombresDocente(String nombresDocente) {
        this.nombresDocente = nombresDocente;
    }

    public String getApellidosDocente() {
        return apellidosDocente;
    }

    public void setApellidosDocente(String apellidosDocente) {
        this.apellidosDocente = apellidosDocente;
    }

    public String getIdentificacionDocente() {
        return identificacionDocente;
    }

    public void setIdentificacionDocente(String identificacionDocente) {
        this.identificacionDocente = identificacionDocente;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public String getCedulaBusqueda() {
        return cedulaBusqueda;
    }

    public void setCedulaBusqueda(String cedulaBusqueda) {
        this.cedulaBusqueda = cedulaBusqueda;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getFaculatadSeleccionana() {
        return faculatadSeleccionana;
    }

    public void setFaculatadSeleccionana(int faculatadSeleccionana) {
        this.faculatadSeleccionana = faculatadSeleccionana;
    }

    public ArrayList<Facultad> getLstFacultades() {
        return lstFacultades;
    }

    public void setLstFacultades(ArrayList<Facultad> lstFacultades) {
        this.lstFacultades = lstFacultades;
    }

    public ArrayList<Escuela> getLstEscuelas() {
        return lstEscuelas;
    }

    public void setLstEscuelas(ArrayList<Escuela> lstEscuelas) {
        this.lstEscuelas = lstEscuelas;
    }

    public int getEscuelaSeleccionada() {
        return escuelaSeleccionada;
    }

    public void setEscuelaSeleccionada(int escuelaSeleccionada) {
        this.escuelaSeleccionada = escuelaSeleccionada;
    }

    public Docente getObjDocente() {
        return objDocente;
    }

    public void setObjDocente(Docente objDocente) {
        this.objDocente = objDocente;
    }

    public Docente getDocenteSel() {
        return docenteSel;
    }

    public void setDocenteSel(Docente docenteSel) {
        this.docenteSel = docenteSel;
    }

    public ArrayList<Docente> getLstDocentes() {
        return lstDocentes;
    }

    public void setLstDocentes(ArrayList<Docente> lstDocentes) {
        this.lstDocentes = lstDocentes;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getTxtFechaIngreso() {
        return txtFechaIngreso;
    }

    public void setTxtFechaIngreso(String txtFechaIngreso) {
        this.txtFechaIngreso = txtFechaIngreso;
    }

    public String getTxtFechaSalida() {
        return txtFechaSalida;
    }

    public void setTxtFechaSalida(String txtFechaSalida) {
        this.txtFechaSalida = txtFechaSalida;
    }

    public DocenteBean() {
        reinit();
    }

    private void reinit() {
        this.objDocente = new Docente();
        this.objUsuario = new Usuario();
        this.objUsuarioRol = new UsuarioRol();
        this.docenteSel = new Docente();
        fechaModificacion = new Date();
        primerAcceso = new Date();
        ultimoAcceso = new Date();
        this.lstDocentes = new ArrayList<Docente>();
        this.lstFacultades = new ArrayList<Facultad>();
        this.lstEscuelas = new ArrayList<Escuela>();
        this.cargarDocente();
        this.cargarFacultad();
        this.cargarEscuelas();

    }

    public void cargarDocente() {
        try {
            this.lstDocentes = FDocente.ObtenerDocentes();
            this.docenteSel = lstDocentes.get(0);
            System.out.println(lstDocentes.get(0).getId_docente());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarDocente dice: " + e.getMessage());
            System.out.println("private void cargarDocente dice: " + e.getMessage());
        }
    }

    public void obtenerDocenteDadoCedula() {
        try {
            this.lstDocentes = FDocente.ObtenerDocenteDadoCedula(cedulaBusqueda);
            this.docenteSel = lstDocentes.get(0);
            System.out.println(lstDocentes.get(0).getId_docente());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarDocenteDadoCedula dice: " + e.getMessage());
            System.out.println("private void cargarDocenteDadoCedula dice: " + e.getMessage());
        }
    }

    public void cargarEscuelas() {
        try {
            this.lstEscuelas = FEscuela.ObtenerEscuelas();
            System.out.println(lstEscuelas.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEscuelas dice: " + e.getMessage());
            System.out.println("private void cargarEscuelas dice: " + e.getMessage());
        }
    }

    private void cargarFacultad() {
        try {
            this.lstFacultades = FFacultad.ObtenerFacultades();
            System.out.println(lstFacultades.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFacultad dice: " + e.getMessage());
            System.out.println("private void cargarFacultad dice: " + e.getMessage());
        }
    }

    public void obtenerEscuelasDadoCodigoFacultad() {
        try {
            lstEscuelas.clear();
            lstEscuelas = FEscuela.ObtenerEscuelaDadoCodigoFacultad(faculatadSeleccionana);
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
            System.out.println("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
        }
    }

    public void insertarDocente() {

        try {
            //Datos Docente
            Escuela escuela = new Escuela();
            escuela.setCodigo(escuelaSeleccionada);
            objDocente.setId_escuela(escuela);
            Facultad facultad = new Facultad();
            facultad.setCodigo(faculatadSeleccionana);
            objDocente.setId_facultad(facultad);
            objDocente.setFecha_ingreso(StringToDate.devolverFecha(fechaIngreso));
            objDocente.setFecha_salida(StringToDate.devolverFecha(fechaSalida));
            objDocente.setSexo(sexo);
            objDocente.setEstado(estado);
            objDocente.setApellidos(apellidosDocente);
            objDocente.setNombres(nombresDocente);
            objDocente.setIdentificacion(identificacionDocente);

            //Datos Usuario
            objUsuario.setUltima_ip("127.0.0.1");
            objUsuario.setCodigo_salt("unach2014");
            objUsuario.setRuta_firma("firma");
            objUsuario.setFecha_modificacion(new java.sql.Timestamp(fechaModificacion.getTime()));
            objUsuario.setPrimer_acceso(new java.sql.Timestamp(primerAcceso.getTime()));
            objUsuario.setUtimo_acceso(new java.sql.Timestamp(ultimoAcceso.getTime()));
            objUsuario.setEstado(1);
            objUsuario.setApellidos(apellidosDocente);
            objUsuario.setNombres(nombresDocente);
            objUsuario.setIdentificacion(identificacionDocente);
            objUsuario.setNombre_corto(nombreCorto);
            objUsuario.setClave(clave);
            objUsuario.setClave_pregunta(clavePregunta);
            objUsuario.setClave_respuesta(claveRespuesta);
            objUsuario.setMail(mail);
            Rol rol = new Rol();
            rol.setCodigo(18);
            objUsuarioRol.setCodigo_rol(rol);
            objUsuarioRol.setCodigo_usuario(objUsuario);
            objUsuarioRol.setEstado(1);

            if ((FDocente.Insertar(objDocente)) && (FUsuario.Insertar(objUsuario, objUsuarioRol) > 0)) {
                this.reinit();
                
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoDocente.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarDocente dice: Error al guardar la información");

            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarDocente dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarDocente dice: " + e.getMessage());
            System.out.println("private void insertarDocente dice: " + e.getMessage());
        }

    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarDocente() {
        try {

            if (FDocente.actualizar(docenteSel)) {
                docenteSel = new Docente();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarDocente.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarDocente dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarDocente dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarDocente dice: " + e.getMessage());
            System.out.println("private void actualizarDocente dice: " + e.getMessage());
        }
    }

    public void eliminarDocente() {
        try {
            if (FDocente.eliminar((int) docenteSel.getId_docente())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarDocente.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarDocente dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarDocente dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarDocente dice: " + e.getMessage());
            System.out.println("private void eliminarDocente dice: " + e.getMessage());
        }

    }

}
