/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.presentacion.beans;

import com.cursojsf.validadores.Cedula;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import juridico.entidades.clases.Estudiante;
import juridico.entidades.funciones.FEstudiante;
import master.logica.clases.Escuela;
import master.logica.clases.Facultad;
import master.logica.clases.Rol;
import master.logica.clases.Usuario;
import master.logica.clases.UsuarioRol;
import master.logica.funciones.FEscuela;
import master.logica.funciones.FFacultad;
import master.logica.funciones.FUsuario;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
import recursos.StringToDate;

/**
 *
 * @author Geovanny Cudco
 */
@ManagedBean
@RequestScoped
public class EstudianteBean {

    private Estudiante objEstudiante;
    private Estudiante estudianteSel;
    private Usuario objUsuario;
    private UsuarioRol objUsuarioRol;
    private ArrayList<Estudiante> lstEstudiantes;
    private ArrayList<Escuela> lstEscuelas;
    private ArrayList<Escuela> listEscuelas;
    private ArrayList<Facultad> lstFacultades;
    private boolean mostrarActualizar;
    private int valorESeleccionada;
    private int valorFSeleccionada;

    private java.util.Date fechaModificacion;
    private java.util.Date primerAcceso;
    private java.util.Date ultimoAcceso;

    private Date fechaNacimiento;
    private String txtFechaNacimiento;
    private int nivel;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String txtFechaIngreso;
    private String txtFechaSalida;
    private int estado;
    private String sexo;
    private String estadoStr;
    @Cedula(message = "Cédula Incorrecta")
    private String busquedaCedula;

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

    public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
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

    public String getBusquedaCedula() {
        return busquedaCedula;
    }

    public void setBusquedaCedula(String busquedaCedula) {
        this.busquedaCedula = busquedaCedula;
    }

    public ArrayList<Escuela> getListEscuelas() {
        return listEscuelas;
    }

    public void setListEscuelas(ArrayList<Escuela> listEscuelas) {
        this.listEscuelas = listEscuelas;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public void setTxtFechaNacimiento(String txtFechaNacimiento) {
        this.txtFechaNacimiento = txtFechaNacimiento;
    }

    public Estudiante getObjEstudiante() {
        return objEstudiante;
    }

    public void setObjEstudiante(Estudiante objEstudiante) {
        this.objEstudiante = objEstudiante;
    }

    public Estudiante getEstudianteSel() {
        return estudianteSel;
    }

    public void setEstudianteSel(Estudiante estudianteSel) {
        this.estudianteSel = estudianteSel;
    }

    public ArrayList<Estudiante> getLstEstudiantes() {
        return lstEstudiantes;
    }

    public void setLstEstudiantes(ArrayList<Estudiante> lstEstudiantes) {
        this.lstEstudiantes = lstEstudiantes;
    }

    public ArrayList<Escuela> getLstEscuelas() {
        return lstEscuelas;
    }

    public void setLstEscuelas(ArrayList<Escuela> lstEscuelas) {
        this.lstEscuelas = lstEscuelas;
    }

    public ArrayList<Facultad> getLstFacultades() {
        return lstFacultades;
    }

    public void setLstFacultades(ArrayList<Facultad> lstFacultades) {
        this.lstFacultades = lstFacultades;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorESeleccionada() {
        return valorESeleccionada;
    }

    public void setValorESeleccionada(int valorESeleccionada) {
        this.valorESeleccionada = valorESeleccionada;
    }

    public int getValorFSeleccionada() {
        return valorFSeleccionada;
    }

    public void setValorFSeleccionada(int valorFSeleccionada) {
        this.valorFSeleccionada = valorFSeleccionada;
    }

    public String getEstadoStr() {

        return estadoStr;
    }

    public void setEstadoStr(String estadoStr) {
        this.estadoStr = estadoStr;
    }

    /*
     * inicialización de las variables y métodos
     */
    public EstudianteBean() {
        this.reinit();
    }

    private void reinit() {
        this.objEstudiante = new Estudiante();
        this.estudianteSel = new Estudiante();
        this.objUsuario = new Usuario();
        this.objUsuarioRol = new UsuarioRol();
        fechaModificacion = new Date();
        primerAcceso = new Date();
        ultimoAcceso = new Date();
        this.lstEstudiantes = new ArrayList<Estudiante>();
        this.lstFacultades = new ArrayList<Facultad>();
        this.lstEscuelas = new ArrayList<Escuela>();
        this.cargarEstudiantes();
        this.cargarFacultad();
        this.obtenerEscuelas();
//        this.obtenerEscuelasDadoCodigoFacultad();
    }

    public void obtenerEscuelas() {
        try {
            this.lstEscuelas = FEscuela.ObtenerEscuelas();
            System.out.println(lstEscuelas.get(0).getCodigo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarEstudiantes() {
        try {
            this.lstEstudiantes = FEstudiante.obtenerEstudiantes();
            this.estudianteSel = lstEstudiantes.get(0);
            System.out.println(lstEstudiantes.get(0).getId_estudiante());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEstudiante dice: " + e.getMessage());
            System.out.println("private void cargarEstudiante dice: " + e.getMessage());
        }
    }

    public void cargarFacultad() {
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
            this.lstEscuelas = FEscuela.ObtenerEscuelaDadoCodigoFacultad(valorFSeleccionada);
            System.out.println(lstEscuelas.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void obtenerEscuelasDadoCodigoFacultad: " + e.getMessage());
            System.out.println("private void obtenerEscuelasDadoCodigoFacultad: " + e.getMessage());
        }
    }

    public void insertarEstudiante() {

        try {

            java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("yyyy-MM-dd");
            txtFechaNacimiento = sdf1.format(fechaNacimiento);
            Date fecha = sdf1.parse(txtFechaNacimiento);
            java.sql.Date varFechaNacimiento = new java.sql.Date(fecha.getTime());

            Escuela escuela = new Escuela();
            escuela.setCodigo(valorESeleccionada);
            objEstudiante.setId_escuela(escuela);
            Facultad facultad = new Facultad();
            facultad.setCodigo(valorFSeleccionada);

            objEstudiante.setId_facultad(facultad);
            objEstudiante.setFecha_nacimiento(varFechaNacimiento);
            objEstudiante.setFecha_ingreso(StringToDate.devolverFecha(fechaIngreso));
            objEstudiante.setFecha_salida(StringToDate.devolverFecha(fechaSalida));
            objEstudiante.setNivel(nivel);
            objEstudiante.setSexo(sexo);
            objEstudiante.setEstado(estado);
            objEstudiante.setApellidos(apellidosUsuario);
            objEstudiante.setNombres(nombresUsuario);
            objEstudiante.setIdentificacion(identificacionUsuario);
            //Datos Usuario
            objUsuario.setUltima_ip("127.0.0.1");
            objUsuario.setCodigo_salt("unach2015");
            objUsuario.setRuta_firma("firma");
            objUsuario.setFecha_modificacion(new java.sql.Timestamp(fechaModificacion.getTime()));
            objUsuario.setPrimer_acceso(new java.sql.Timestamp(primerAcceso.getTime()));
            objUsuario.setUtimo_acceso(new java.sql.Timestamp(ultimoAcceso.getTime()));
            objUsuario.setEstado(1);
            objUsuario.setApellidos(apellidosUsuario);
            objUsuario.setNombres(nombresUsuario);
            objUsuario.setIdentificacion(identificacionUsuario);
            objUsuario.setNombre_corto(nombreCorto);
            objUsuario.setClave(clave);
            objUsuario.setClave_pregunta(clavePregunta);
            objUsuario.setClave_respuesta(claveRespuesta);
            objUsuario.setMail(mail);
            Rol rol = new Rol();
            rol.setCodigo(19);
            objUsuarioRol.setCodigo_rol(rol);
            objUsuarioRol.setCodigo_usuario(objUsuario);
            objUsuarioRol.setEstado(1);
            

            if ((FEstudiante.insertarEstudiante(objEstudiante)) && (FUsuario.Insertar(objUsuario, objUsuarioRol) > 0)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoEstudiante.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarEstudiante dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarEstudiante dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarEstudiante dice: " + e.getMessage());
            System.out.println("private void insertarEstudiante dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarEstudiante() {

        try {
            estudianteSel.setId_escuela(FEscuela.ObtenerEscuelaDadoCodigo(estudianteSel.getId_escuela().getCodigo()));
            estudianteSel.setId_facultad(FFacultad.ObtenerFacultadDadoCodigo(estudianteSel.getId_facultad().getCodigo()));
            estudianteSel.setFecha_nacimiento(StringToDate.devolverFecha(fechaNacimiento));
            estudianteSel.setFecha_ingreso(StringToDate.devolverFecha(fechaIngreso));
            estudianteSel.setFecha_salida(StringToDate.devolverFecha(fechaSalida));

            if (FEstudiante.actualizarEstudiante(estudianteSel)) {
                estudianteSel = new Estudiante();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarEstudiante.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarEstudiante dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarEstudiante dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarEstudiante dice: " + e.getMessage());
            System.out.println("private void actualizarEstudiante dice: " + e.getMessage());
        }
    }

    public void eliminarEstudiante() {
        try {
            if (FEstudiante.eliminarEstudiante((int) estudianteSel.getId_estudiante())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarEstudiante.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarEstudiante dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarEstudiante dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarEstudiante dice: " + e.getMessage());
            System.out.println("private void eliminarEstudiante dice: " + e.getMessage());
        }

    }

    public void obtenerEstudianteDadoCedula() {
        try {
            this.lstEstudiantes = FEstudiante.obtenerEstudianteDadoCedula(busquedaCedula);
            this.estudianteSel = lstEstudiantes.get(0);
            System.out.println(lstEstudiantes.get(0).getId_estudiante());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerEstudianteDadoCedula dice: " + e.getMessage());
            System.out.println("public void obtenerEstudianteDadoCedula dice: " + e.getMessage());
        }
    }

}
