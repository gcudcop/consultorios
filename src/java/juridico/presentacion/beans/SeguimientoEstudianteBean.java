/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.presentacion.beans;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import juridico.entidades.clases.Caso;
import juridico.entidades.clases.Docente;
import juridico.entidades.clases.Estudiante;
import juridico.entidades.clases.Seguimiento;
import juridico.entidades.funciones.FCaso;
import juridico.entidades.funciones.FDocente;
import juridico.entidades.funciones.FEstudiante;
import juridico.entidades.funciones.FSeguimiento;
import master.logica.funciones.FUsuario;
import master.presentacion.beans.SesionUsuarioDataManager;
import org.apache.taglibs.standard.functions.Functions;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import recursos.StringToDate;
import recursos.Util;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class SeguimientoEstudianteBean {

    /**
     * Creates a new instance of SeguimientoEstudianteBean
     */
    private Seguimiento objSeguimiento;
    private Seguimiento seguimientoSel;
    private ArrayList<Seguimiento> lstSeguimientos;
    private ArrayList<Estudiante> lstEstudiante;
    private ArrayList<Docente> lstDocentes;
    private ArrayList<Caso> lstCasos;
    private boolean mostrarActualizar;
    private Date fechaInicio;
    private Date fechaFin;
    private int estudianteSeleccionada;
    private int docenteSeleccionado;
    private int casoSeleccionado;
    private int estado;
    private String path;
    private String criterioBusqueda;
    private String criterioBusqueda2;
    private String criterioBusqueda3;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private String cedulaSesion;
    //manejo de imagenes
    private String nombreDocumento;
    private UploadedFile archivoDocumento;
    //cargar configuracion del path
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("recursos.rutasMedia");

    public Seguimiento getObjSeguimiento() {
        return objSeguimiento;
    }

    public void setObjSeguimiento(Seguimiento objSeguimiento) {
        this.objSeguimiento = objSeguimiento;
    }

    public Seguimiento getSeguimientoSel() {
        return seguimientoSel;
    }

    public void setSeguimientoSel(Seguimiento seguimientoSel) {
        this.seguimientoSel = seguimientoSel;
    }

    public ArrayList<Seguimiento> getLstSeguimientos() {
        return lstSeguimientos;
    }

    public void setLstSeguimientos(ArrayList<Seguimiento> lstSeguimientos) {
        this.lstSeguimientos = lstSeguimientos;
    }

    public ArrayList<Estudiante> getLstEstudiante() {
        return lstEstudiante;
    }

    public void setLstEstudiante(ArrayList<Estudiante> lstEstudiante) {
        this.lstEstudiante = lstEstudiante;
    }

    public ArrayList<Docente> getLstDocentes() {
        return lstDocentes;
    }

    public void setLstDocentes(ArrayList<Docente> lstDocentes) {
        this.lstDocentes = lstDocentes;
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

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getEstudianteSeleccionada() {
        return estudianteSeleccionada;
    }

    public void setEstudianteSeleccionada(int estudianteSeleccionada) {
        this.estudianteSeleccionada = estudianteSeleccionada;
    }

    public int getDocenteSeleccionado() {
        return docenteSeleccionado;
    }

    public void setDocenteSeleccionado(int docenteSeleccionado) {
        this.docenteSeleccionado = docenteSeleccionado;
    }

    public int getCasoSeleccionado() {
        return casoSeleccionado;
    }

    public void setCasoSeleccionado(int casoSeleccionado) {
        this.casoSeleccionado = casoSeleccionado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCriterioBusqueda() {
        return criterioBusqueda;
    }

    public void setCriterioBusqueda(String criterioBusqueda) {
        this.criterioBusqueda = criterioBusqueda;
    }

    public String getCriterioBusqueda2() {
        return criterioBusqueda2;
    }

    public void setCriterioBusqueda2(String criterioBusqueda2) {
        this.criterioBusqueda2 = criterioBusqueda2;
    }

    public String getCriterioBusqueda3() {
        return criterioBusqueda3;
    }

    public void setCriterioBusqueda3(String criterioBusqueda3) {
        this.criterioBusqueda3 = criterioBusqueda3;
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

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public UploadedFile getArchivoDocumento() {
        return archivoDocumento;
    }

    public void setArchivoDocumento(UploadedFile archivoDocumento) {
        this.archivoDocumento = archivoDocumento;
    }

    public ResourceBundle getConfiguracion() {
        return Configuracion;
    }

    public void setConfiguracion(ResourceBundle Configuracion) {
        this.Configuracion = Configuracion;
    }
    
    public void capturaCedulaSesion() {
        try {
            this.cedulaSesion = FUsuario.ObtenerUsuarioDadoCodigo(dm.getSesionUsuario().getCodigo()).getIdentificacion();
        } catch (Exception e) {
            Util.addErrorMessage("private void capturaCedulaSesion dice: " + e.getMessage());
            System.out.println("private void capturaCedulaSesion dice: " + e.getMessage());
        }
    }
    
    public SeguimientoEstudianteBean() {
        reinit();
    }
    
    private void reinit() {
        this.objSeguimiento = new Seguimiento();
        this.seguimientoSel = new Seguimiento();
        this.lstSeguimientos = new ArrayList<Seguimiento>();
        this.lstDocentes = new ArrayList<Docente>();
        this.lstEstudiante = new ArrayList<Estudiante>();
        this.lstCasos = new ArrayList<Caso>();
//        this.cargarSeguimiento();
        this.cargarSeguimientoSesionUsuario();
        this.cargarCasosSesionUsuario();
//        this.cargarDocente();
        this.cargarDocente();

    }

    public void cargarSeguimientoSesionUsuario() {
        try {
            //this.lstSeguimiento=FSeguimiento.obtenerSeguimientoDadoCedulaDocente(FUsuario.ObtenerUsuarioDadoCodigo(dm.getSesionUsuario().getCodigo()).getIdentificacion());
            this.lstSeguimientos = FSeguimiento.obtenerSeguimientoDadoCedulaEstudiante("0604792549");
            this.seguimientoSel = lstSeguimientos.get(0);
            System.out.println(lstSeguimientos.get(0).getId_seguimiento());
        } catch (Exception e) {
            Util.addErrorMessage("public void cargarCasosSesionUsuario() dice: " + e.getMessage());
            System.out.println("public void cargarCasosSesionUsuario() dice: " + e.getMessage());
        }
    }

//    private void cargarSeguimiento() {
//        try {
//            this.lstSeguimientos = FSeguimiento.obtenerSeguimientos();
//            this.seguimientoSel = lstSeguimientos.get(0);
//            System.out.println(lstSeguimientos.get(0).getId_caso());
//        } catch (Exception e) {
//        }
//    }
    public void cargarCasosSesionUsuario() {
        try {
            //this.lstCasos=FCaso.obtenerCasosDadoCedulaDocente(FUsuario.ObtenerUsuarioDadoCodigo(dm.getSesionUsuario().getCodigo()).getIdentificacion());
            this.lstCasos = FCaso.obtenerCasosDadoCedulaEstudiante("0604792549");
            //this.casoSel = lstCasos.get(0);
            System.out.println(lstCasos.get(0).getId_caso());
        } catch (Exception e) {
            Util.addErrorMessage("public void cargarCasosSesionUsuario() dice: " + e.getMessage());
            System.out.println("public void cargarCasosSesionUsuario() dice: " + e.getMessage());
        }
    }

//    private void cargarCasos() {
//        try {
//            this.lstCasos = FCaso.obtenerCasos();
//
//            System.out.println(lstCasos.get(0).getId_caso());
//        } catch (Exception e) {
//            Util.addErrorMessage("private void cargarCasos dice: " + e.getMessage());
//            System.out.println("private void cargarCasos dice: " + e.getMessage());
//        }
//
//    }
//
//    public void cargarDocente() {
//        try {
//            this.lstDocentes = FDocente.ObtenerDocentes();
//
//            System.out.println(lstDocentes.get(0).getId_docente());
//        } catch (Exception e) {
//            Util.addErrorMessage("private void cargarDocente dice: " + e.getMessage());
//            System.out.println("private void cargarDocente dice: " + e.getMessage());
//        }
//    }
    public void cargarDocente() {
        try {
            this.lstDocentes = FDocente.ObtenerDocentes();
            System.out.println(lstDocentes.get(0).getNombres());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarDocente dice: " + e.getMessage());
            System.out.println("private void cargarDocente dice: " + e.getMessage());
        }
    }
    
    public void obtenerSeguimientosDadoCedulaDocenteCedulaEstudiante() {
        try {
            //this.lstCasos = FCaso.obtenerCasosDadoCedulaDocente(cedulaSesion); //descomentar esta linea

            //this.lstCasos=FSeguimiento.obtenerSeguimientoDadoCedulaDocenteCedulaEstudiante(cedulaSesion, criterioBusqueda); //descomentar esta linea
            this.lstSeguimientos = FSeguimiento.obtenerSeguimientoDadoCedulaDocenteCedulaEstudiante( criterioBusqueda,"0604792549");
            this.seguimientoSel = lstSeguimientos.get(0);
            System.out.println(lstSeguimientos.get(0).getId_seguimiento());
        } catch (Exception e) {
            Util.addErrorMessage("private void obtenerCasosDadoCedulaDocenteCedulaEstudiante dice: " + e.getMessage());
            System.out.println("private void obtenerCasosDadoCedulaDocenteCedulaEstudiante dice: " + e.getMessage());
        }
    }

    public void insertarSeguimiento() {

        try {
            Caso caso = new Caso();
            caso.setId_caso(casoSeleccionado);
            objSeguimiento.setId_caso(caso);
            
            Estudiante estudiante =new Estudiante();
            estudiante.setId_estudiante(seguimientoSel.getId_estudiante().getId_estudiante());
            objSeguimiento.setId_estudiante(estudiante);
            

//            Docente docente = new Docente();
//            docente.setId_docente(lstSeguimientos.get(0).getId_docente().getId_docente());
            
            Docente docente = new Docente();
            docente.setId_docente(estudianteSeleccionada);
            objSeguimiento.setId_docente(docente);

//            Estudiante estudiante = new Estudiante();
//            
//            estudiante.setId_estudiante(estudianteSeleccionada);
//            objSeguimiento.setId_estudiante(estudiante);

            objSeguimiento.setEstado(estado);
            objSeguimiento.setFecha_inicio(StringToDate.devolverFecha(fechaInicio));
            objSeguimiento.setFecha_fin(StringToDate.devolverFecha(fechaFin));
            objSeguimiento.setPath("/media/documento/MessagesAndDetails.pdf");

            if (FSeguimiento.insertarSeguimiento(objSeguimiento)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoSeguimiento.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarSeguimiento dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarSeguimiento dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarSeguimiento dice: " + e.getMessage());
            System.out.println("private void insertarSeguimiento dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarSeguimiento() {
        try {
            System.out.println(path);
            seguimientoSel.setId_caso(FCaso.ObtenerCasoDadoId(seguimientoSel.getId_caso().getId_caso()));
            seguimientoSel.setId_docente(FDocente.ObtenerDocenteDadoCodigo(seguimientoSel.getId_docente().getId_docente()));
            seguimientoSel.setId_estudiante(FEstudiante.ObtenerEstudianteDadoCodigo(seguimientoSel.getId_estudiante().getId_estudiante()));

            if (FSeguimiento.actualizarSeguimiento(seguimientoSel)) {
                seguimientoSel = new Seguimiento();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarSeguimiento.hide()");
                //Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarSeguimiento dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarSeguimiento dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarSeguimiento dice: " + e.getMessage());
            System.out.println("private void actualizarSEguimiento dice: " + e.getMessage());
        }
    }

    public void eliminarSeguimiento() {
        try {
            if (FSeguimiento.eliminarSeguimiento((int) seguimientoSel.getId_seguimiento())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarSeguimiento.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarSeguimiento dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarSeguimiento dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarSeguimiento dice: " + e.getMessage());
            System.out.println("private void eliminarSeguimiento dice: " + e.getMessage());
        }

    }

    public void cargarArchivoDocumento(FileUploadEvent e) {
        System.out.println("Entra al método cargar documento");
        UploadedFile file = e.getFile();
        this.archivoDocumento = file;
        System.out.println(file.getContentType());
        //objDocumento.setTipo(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreDocumento = file.getFileName();
        //byte[] contenido = file.getContents();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarArchivo(file.getFileName(), contenido)) {
                Util.addSuccessMessage("Documento cargado con éxito!!");
            } else {
                Util.addErrorMessage("Error al cargar el Documento");
            }
        } catch (IOException ex) {
            Logger.getLogger(SeguimientoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarArchivo(String nombre, byte[] contenido) {
        String rutaDocumentos = Configuracion.getString("rutaDocumentos");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaDocumentos + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            seguimientoSel.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            System.out.println(seguimientoSel.getPath());
            actualizarSeguimiento();
            path = seguimientoSel.getPath();
//            seguimientoSel.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            //objDocumento.setTitulo(nombre);
//            path=seguimientoSel.getPath();
//            path=path.replace('\\', '/');
            seguimientoSel.setPath(path);
            System.out.println("cargar objeto fos ");
            FileOutputStream fos = new FileOutputStream(f);
            System.out.println("escribir fos ");
            fos.write(contenido);

            return true;
        } catch (Exception e) {
            Util.mostrarMensaje(e.getMessage());
            return false;
        }
    }

    private byte[] getFileContents(InputStream in) {
        byte[] bytes = null;
        try {
            // write the inputStream to a FileOutputStream            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int read = 0;
            bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                bos.write(bytes, 0, read);
            }
            bytes = bos.toByteArray();
            in.close();
            in = null;
            bos.flush();
            bos.close();
            bos = null;
            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bytes;
    }
}
