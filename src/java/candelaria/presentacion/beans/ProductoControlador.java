package candelaria.presentacion.beans;

import candelaria.logica.clases.Categoria;
import candelaria.logica.clases.Producto;
import candelaria.logica.funciones.FCategoria;
import candelaria.logica.funciones.FProducto;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ROGES
 */
@ManagedBean
@ViewScoped
public class ProductoControlador {

    //Date fecha = new java.util.Date();

    private Producto objProducto;
    private Producto productoSel;
    private ArrayList<Producto> lstProducto;
    private ArrayList<Categoria> lstCategoria;
    private boolean mostrarActualizar;
    private int valorCategoriaSeleccionado;
    private Date fecha_fa, fecha_cad;
    private String fecha_cambiada;
    private String fecha_cambiada1;
    private String peso_producto;

    public String getPeso_producto() {
        return peso_producto;
    }

    public void setPeso_producto(String peso_producto) {
        this.peso_producto = peso_producto;
    }

    public String getFecha_cambiada1() {
        return fecha_cambiada1;
    }

    public void setFecha_cambiada1(String fecha_cambiada1) {
        this.fecha_cambiada1 = fecha_cambiada1;
    }

    public String getFecha_cambiada() {
        return fecha_cambiada;
    }

    public void setFecha_cambiada(String fecha_cambiada) {
        this.fecha_cambiada = fecha_cambiada;
    }

//    public Date getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(Date fecha) {
//        this.fecha = fecha;
//    }
    public Date getFecha_fa() {
        return fecha_fa;
    }

    public void setFecha_fa(Date fecha_fa) {
        this.fecha_fa = fecha_fa;
    }

    public Date getFecha_cad() {
        return fecha_cad;
    }

    public void setFecha_cad(Date fecha_cad) {
        this.fecha_cad = fecha_cad;
    }

    public ArrayList<Categoria> getLstCategoria() {
        return lstCategoria;
    }

    public void setLstCategoria(ArrayList<Categoria> lstCategoria) {
        this.lstCategoria = lstCategoria;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorCategoriaSeleccionado() {
        return valorCategoriaSeleccionado;
    }

    public void setValorCategoriaSeleccionado(int valorCategoriaSeleccionado) {
        this.valorCategoriaSeleccionado = valorCategoriaSeleccionado;
    }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }

    public Producto getProductoSel() {
        return productoSel;
    }

    public void setProductoSel(Producto productoSel) {
        this.productoSel = productoSel;
    }

    public ArrayList<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(ArrayList<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public ProductoControlador() {
        reinit();
    }

    private void reinit() {
        this.objProducto = new Producto();
        this.productoSel = new Producto();
        this.lstProducto = new ArrayList<Producto>();
        this.lstCategoria = new ArrayList<Categoria>();

//        this.LstPeriodos = new ArrayList<Periodos>();  
//        this.lstFacultades = new ArrayList<Facultad>();
//        this.lstEscuelas = new ArrayList<Escuela>();
//        this.lstNiveles = new ArrayList<Nivel>();
        //this.ProveedorSel = this.lstProveedors.get(0);
        this.cargarProducto();
        this.cargarCategoria();
        //this.cargarNiveles();
//        this.cargarPeriodos();
//        this.cargarFacultad();

    }

    public void cargarProducto() {

        try {
            this.lstProducto = FProducto.ObtenerProductos();
            this.productoSel = lstProducto.get(0);
            System.out.println(lstProducto.get(0).getId_producto());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarProducto dice: " + e.getMessage());
            System.out.println("private void cargarProducto dice: " + e.getMessage());
        }
    }

    public void cargarCategoria() {
        try {
            this.lstCategoria = FCategoria.ObtenerCategoria();

            System.out.println(lstCategoria.get(0).getId_categoria());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCategoria dice: " + e.getMessage());
            System.out.println("private void cargarCategoria dice: " + e.getMessage());
        }
    }

    public void insertarProducto() {

        

        try {
            java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("yyyy-MM-dd");
            fecha_cambiada = sdf1.format(fecha_cad);
            Date fecha = sdf1.parse(fecha_cambiada);
            java.sql.Date sqlDate1=new java.sql.Date(fecha.getTime());
            
            java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd");
            fecha_cambiada1 = sdf2.format(fecha_fa);
            Date fecha1 = sdf2.parse(fecha_cambiada);
            java.sql.Date sqlDate2=new java.sql.Date(fecha1.getTime());
            
            Categoria categoria = new Categoria();
            categoria.setId_categoria(valorCategoriaSeleccionado);
            objProducto.setId_categoria(categoria);
            objProducto.setFecha_fabricacion(sqlDate2);
            objProducto.setFecha_caducidad(sqlDate1);
            objProducto.setPeso_producto(peso_producto);

            if (FProducto.Insertar(objProducto)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoProducto.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarProducto dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarProducto dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarProducto dice: " + e.getMessage());
            System.out.println("private void insertarProducto dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarProducto() {
        try {

            productoSel.setId_categoria(FCategoria.ObtenerCategoriaDadoCodigo(productoSel.getId_categoria().getId_categoria()));
            if (FProducto.actualizar(productoSel)) {
                productoSel = new Producto();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarProducto.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarProducto dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarProducto dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarProducto dice: " + e.getMessage());
            System.out.println("private void actualizarProducto dice: " + e.getMessage());
        }
    }

    public void eliminarProducto() {
        try {
            if (FProducto.eliminar((int) productoSel.getId_producto())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarProducto.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarProducto dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarProducto dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarProducto dice: " + e.getMessage());
            System.out.println("private void eliminarProducto dice: " + e.getMessage());
        }

    }
    
    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "reportes" + File.separator + "productos.png";
         
        pdf.add(Image.getInstance(logo));
    }

    
    
}
