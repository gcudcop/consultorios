/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Usuario;
import master.logica.funciones.*;
import recursos.Util;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import juridico.entidades.funciones.FDocente;
import juridico.entidades.funciones.FEstudiante;
import master.logica.clases.UsuarioRol;
import recursos.Tools;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class LoginUsuario {

    Usuario usuario;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private ArrayList<UsuarioRol> lstUsuariRol;
    private int i;
    private UsuarioRol objUsuariorol;

    public ArrayList<UsuarioRol> getLstUsuariRol() {
        return lstUsuariRol;
    }

    public void setLstUsuariRol(ArrayList<UsuarioRol> lstUsuariRol) {
        this.lstUsuariRol = lstUsuariRol;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public UsuarioRol getObjUsuariorol() {
        return objUsuariorol;
    }

    public void setObjUsuariorol(UsuarioRol objUsuariorol) {
        this.objUsuariorol = objUsuariorol;
    }

    public LoginUsuario() {
        lstUsuariRol = new ArrayList<UsuarioRol>();
        objUsuariorol = new UsuarioRol();
        usuario = new Usuario();
        this.i = 0;
    }
    @PostConstruct
    public void postLoginUsuario(){
        login();
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String login() {
        ResourceBundle recurso = ResourceBundle.getBundle("/recursos/mensajesSeguridad");
        try {
            this.dm.setSesionUsuario(FUsuario.autenticarUsuario(this.usuario.getIdentificacion(), this.usuario.getClave()));
            if (this.dm.getSesionUsuario() != null) {
                //this.dm.setSesionPersona(FUsuarioPersona.obtenerUsuarioPersonaDadoCodigoUsuario(this.dm.getSesionUsuario().getCodigo()));
                this.dm.setSesionUsuarioRoles(FUsuarioRol.obtenerRolesDadoUsuario(this.dm.getSesionUsuario().getCodigo()));
                lstUsuariRol=FUsuarioRol.obtenerRolesDadoUsuario(this.dm.getSesionUsuario().getCodigo());
                this.dm.setSesionPeriodos(FPeriodos.ObtenerPeriodoActual());
                
                for (UsuarioRol usuarioRol:lstUsuariRol){
                    if (usuarioRol.getCodigo_rol().getCodigo()==18){
                        this.dm.setSesionDocente(FDocente.ObtenerCodigoDocenteDadoIdentificacion(this.dm.getSesionUsuario().getIdentificacion()));
                        this.dm.setSesionDocenteActual(this.dm.getSesionDocente());
                        
                    }
                     if (usuarioRol.getCodigo_rol().getCodigo()==19){
                        this.dm.setSesionEstudiante(FEstudiante.ObtenerEstudianteDadoIdentificacion(this.dm.getSesionUsuario().getIdentificacion()));
                        this.dm.setSesionEstudianteActual(this.dm.getSesionEstudiante());                                                
                    }
                }

               
                this.dm.setValidado(Boolean.TRUE);
                if (this.dm.getSesionUsuarioRoles().isEmpty()) {
                    Util.addErrorMessage("El usuario no tiene perfiles asignados, comuniquese con el administrador del sistema");
                    return "/login";
                }

                this.dm.setSesionUsuarioRolActual(this.dm.getSesionUsuarioRoles().get(0));
                this.dm.setSesionPeriodoActual(this.dm.getSesionPeriodos().get(0));
                //this.dm.setSesionTutorActual(this.dm.getSesionTutor());

                //    FTutor.ObtenerCodigoTutorDadoIdentificacionUsuario(this.usuario);
                //this.dm.setSesionTutorActual(FTutor.ObtenerTutorDadoUsuarioRol(this.dm.getSesionUsuarioRolActual().getCodigo()));
                //this.dm.setIntSesionTutor(this.dm.getIntSesionTutor());
                //this.dm.getSesionUsuario().setUtimo_acceso(Tools.obtieneFechaActualSegundos()); //gettime devuelve el dato en long
                FUsuario.actualizarUltimoAccesoUsuario(Tools.obtieneFechaActualSegundos(), this.dm.getSesionUsuario().getCodigo());

                FNodoMenu objMenu = new FNodoMenu();
                this.dm.setMenu(objMenu.generarMenuUsuario(this.dm.getSesionUsuarioRolActual().getCodigo_rol().getCodigo())); //menu de usuario, arrays list
                this.dm.setPaginaActual("home.xhtml");

                return "/seguridad/index?faces-redirect=true"; // forzando q vaya a la parte interna/segura del sitio
            } else {
                Util.addErrorMessage(null, recurso.getString("login"));
                this.dm.setValidado(Boolean.FALSE);
                return "/login";
            }
        } catch (Exception e) {

            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "INCORRECTO", "Usuario o Contraseña Incorrecta");
            FacesMessage mensaje1 = new FacesMessage(FacesMessage.SEVERITY_FATAL, "VERIFICAR", "Solicitar Acceso");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            FacesContext.getCurrentInstance().addMessage(null, mensaje1);
            return "/login";
        }

    }

    public String cerrarSesion() {
        this.dm.destroy();
        return "/index.xhtml?faces-redirect=true";

    }
}
