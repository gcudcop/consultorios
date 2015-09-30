/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import juridico.presentacion.beans.EstudianteBean;
import master.logica.clases.Rol;
//import master.logica.clases.Persona;
import master.logica.clases.Usuario;
import master.logica.clases.UsuarioRol;
//import master.logica.funciones.FLazyPersonasDataModel;
//import master.logica.funciones.FPersona;
import master.logica.funciones.FUsuario;
//import master.presentacion.funciones.beans.consultas.GestionPersonaConsultasC;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.model.LazyDataModel;
import recursos.Util;

/**
 *
 * @author cfviteris
 */
@ManagedBean
@ViewScoped
public class usuarioControlador {

    private Usuario objUsuario;
    private Usuario usuarioSel;
    private UsuarioRol objUsuarioRol;
    private java.util.Date fechaModificacion;
    private java.util.Date primerAcceso;
    private java.util.Date ultimoAcceso;
    private String ultimaIp;
    private Integer estado;
    private String codigoSalt;
    private String rutaFirma;
    private ArrayList<Usuario> lstUsuario;
    private int valorRolSeleccioando;
    private long valorRolUsuarioSeleccionado;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String nombre_corto;
    private String clave;
    private String clave_pregunta;
    private String clave_respuesta;
    private String mail;

    public usuarioControlador() {

        lstUsuario = new ArrayList<Usuario>();
        this.objUsuario = new Usuario();
        this.objUsuarioRol = new UsuarioRol();

        fechaModificacion = new Date();
        primerAcceso = new Date();
        ultimoAcceso = new Date();
        cargarUsuarios();
        valorRolSeleccioando = 0;
        valorRolUsuarioSeleccionado = 0;

    }

    public String getNombre_corto() {
        return nombre_corto;
    }

    public void setNombre_corto(String nombre_corto) {
        this.nombre_corto = nombre_corto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave_pregunta() {
        return clave_pregunta;
    }

    public void setClave_pregunta(String clave_pregunta) {
        this.clave_pregunta = clave_pregunta;
    }

    public String getClave_respuesta() {
        return clave_respuesta;
    }

    public void setClave_respuesta(String clave_respuesta) {
        this.clave_respuesta = clave_respuesta;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getUltimaIp() {
        return ultimaIp;
    }

    public void setUltimaIp(String ultimaIp) {
        this.ultimaIp = ultimaIp;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getCodigoSalt() {
        return codigoSalt;
    }

    public void setCodigoSalt(String codigoSalt) {
        this.codigoSalt = codigoSalt;
    }

    public String getRutaFirma() {
        return rutaFirma;
    }

    public void setRutaFirma(String rutaFirma) {
        this.rutaFirma = rutaFirma;
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

    public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public Usuario getUsuarioSel() {
        return usuarioSel;
    }

    public void setUsuarioSel(Usuario usuarioSel) {
        this.usuarioSel = usuarioSel;
    }

    public ArrayList<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(ArrayList<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    public int getValorRolSeleccioando() {
        return valorRolSeleccioando;
    }

    public void setValorRolSeleccioando(int valorRolSeleccioando) {
        this.valorRolSeleccioando = valorRolSeleccioando;
    }

    public UsuarioRol getObjUsuarioRol() {
        return objUsuarioRol;
    }

    public void setObjUsuarioRol(UsuarioRol objUsuarioRol) {
        this.objUsuarioRol = objUsuarioRol;
    }

    public long getValorRolUsuarioSeleccionado() {
        return valorRolUsuarioSeleccionado;
    }

    public void setValorRolUsuarioSeleccionado(long valorRolUsuarioSeleccionado) {
        this.valorRolUsuarioSeleccionado = valorRolUsuarioSeleccionado;
    }

    public void cargarUsuarios() {
        try {
            this.lstUsuario = FUsuario.ObtenerUsuarios();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarUsuarios dice: " + e.getMessage());
            System.out.println("private void cargarUsuarios dice: " + e.getMessage());
        }
    }

    //insertar datos generales
    public int insertar() {
        int dd = 0;
        try {

            //setear los objetos que no se puedan setear en la vista
            objUsuario.setUltima_ip("127.0.0.1");
            objUsuario.setCodigo_salt("unach2014");
            objUsuario.setRuta_firma("firma");
            objUsuario.setFecha_modificacion(new java.sql.Timestamp(fechaModificacion.getTime()));
            objUsuario.setPrimer_acceso(new java.sql.Timestamp(primerAcceso.getTime()));
            objUsuario.setUtimo_acceso(new java.sql.Timestamp(ultimoAcceso.getTime()));
            objUsuario.setEstado(1);
            ///instancear Usuasio Rol
            Rol rol = new Rol();
            rol.setCodigo(valorRolSeleccioando);
            objUsuarioRol.setCodigo_rol(rol);
            objUsuarioRol.setCodigo_usuario(objUsuario);
            objUsuarioRol.setEstado(1);
            if (FUsuario.Insertar(objUsuario, objUsuarioRol) > 0) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("wdgNuevo.hide()");
                this.cargarUsuarios();
                this.objUsuario = new Usuario();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "ERROR", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
        return dd;
    }

    //insertar usuario
    public int insertarUsuario() {
        int dd = 0;
        try {
            objUsuario = new Usuario();
            //setear los objetos que no se puedan setear en la vista            
            objUsuario.setUltima_ip("127.0.0.1");
            objUsuario.setCodigo_salt("unach2014");
            objUsuario.setRuta_firma("firma");
            objUsuario.setFecha_modificacion(new java.sql.Timestamp(fechaModificacion.getTime()));
            objUsuario.setPrimer_acceso(new java.sql.Timestamp(primerAcceso.getTime()));
            objUsuario.setUtimo_acceso(new java.sql.Timestamp(ultimoAcceso.getTime()));
            objUsuario.setEstado(1);
            ///instancear Usuasio Rol
            Rol rol = new Rol();
            rol.setCodigo(19);
            objUsuarioRol.setCodigo_rol(rol);
            objUsuarioRol.setCodigo_usuario(objUsuario);
            objUsuarioRol.setEstado(1);

            objUsuario.setApellidos(apellidos);
            objUsuario.setNombres(nombres);
            objUsuario.setIdentificacion(identificacion);
            objUsuario.setNombre_corto(nombre_corto);
            objUsuario.setClave(clave);
            objUsuario.setClave_pregunta(clave_pregunta);
            objUsuario.setClave_respuesta(clave_respuesta);
            objUsuario.setMail(mail);

            if (FUsuario.Insertar(objUsuario, objUsuarioRol) > 0) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
//                DefaultRequestContext.getCurrentInstance().execute("wdgNuevo.hide()");
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoEstudiante.hide()");
                this.cargarUsuarios();
                this.objUsuario = new Usuario();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "ERROR", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
        return dd;
    }

    //Editar un usuario
    public void editar() {

        try {

            //setear los objetos que no se puedan setear en la vista
            objUsuario.setFecha_modificacion(new java.sql.Timestamp(fechaModificacion.getTime()));
            objUsuario.setPrimer_acceso(new java.sql.Timestamp(primerAcceso.getTime()));
            objUsuario.setUtimo_acceso(new java.sql.Timestamp(ultimoAcceso.getTime()));
            objUsuario.setCodigo_salt("");
            objUsuario.setUltima_ip("");
            objUsuario.setRuta_firma("");
            objUsuario.setEstado(1);
            ///editar Usuasio Rol
            Rol rol = new Rol();
            rol.setCodigo(valorRolSeleccioando);
            objUsuarioRol.setCodigo_rol(rol);
            objUsuarioRol.setCodigo_usuario(objUsuario);
            objUsuarioRol.setEstado(1);

            if (FUsuario.Editar(objUsuario, objUsuarioRol) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Correcto", "Datos Editados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("wdgEditar.hide()");
                this.cargarUsuarios();
                this.objUsuario = new Usuario();

            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Atención", "Datos no Editados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "ERROR", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }

    }

    // eliminar usuario
    public void eliminar() {

        try {

            if (FUsuario.Eliminar(objUsuario.getCodigo()) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Correcto", "Datos Eliminados con Exito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("wdgEliminar.hide()");
                this.cargarUsuarios();
                this.objUsuario = new Usuario();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Atención", "Datos no Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "ERROR", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }

    }

    //sirve para mostrar datos complejos
    public void mostrar() {

        fechaModificacion = objUsuario.getFecha_modificacion();
        primerAcceso = objUsuario.getPrimer_acceso();
        ultimoAcceso = objUsuario.getUtimo_acceso();
        ultimaIp = objUsuario.getUltima_ip();
        codigoSalt = objUsuario.getCodigo_salt();
        rutaFirma = objUsuario.getRuta_firma();
        estado = objUsuario.getEstado();

        valorRolSeleccioando = objUsuarioRol.getCodigo_rol().getCodigo();
        valorRolUsuarioSeleccionado = objUsuarioRol.getCodigo_usuario().getCodigo();
        estado = objUsuarioRol.getEstado();

    }

//     public void actualizarUsuario() {
//        try {
//            if (FUsuario.actualizar(usuarioSel)) {
//                this.reinit();
//                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarUsuario.hide()");
//                Util.addSuccessMessage("Información guardada con éxito");
//                System.out.println("public void actualizarUsuario dice: Información guardada con éxito!!");
//            } else {
//                Util.addErrorMessage("Error al guardar la información");
//                System.out.println("public void actualizarUsuario dice: Error al guardar la información");
//            }
//        } catch (Exception e) {
//            Util.addErrorMessage("private void actualizarUsuario dice: " + e.getMessage());
//            System.out.println("private void actualizarUsuario dice: " + e.getMessage());
//        }
//    }
//
//    public void eliminarFacultad() {
//        try {
//            if (FUsuario.Eliminar(usuarioSel)) {
//                this.reinit();
//                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarUsuario.hide()");
//                Util.addSuccessMessage("Información eliminada.");
//                System.out.println("public void eliminarUsuario dice: Información eliminada.");
//            } else {
//                Util.addErrorMessage("Error al eliminar la información.");
//                System.out.println("public void eliminarUsuario dice: Error al eliminar la información");
//            }
//        } catch (Exception e) {
//            Util.addErrorMessage("private void eliminarUsuario dice: " + e.getMessage());
//            System.out.println("private void eliminarUsuario dice: " + e.getMessage());
//        }
//    }
}
