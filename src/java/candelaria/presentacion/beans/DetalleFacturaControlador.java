/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.presentacion.beans;

import candelaria.logica.clases.Cliente;
import candelaria.logica.clases.Detalle_Factura;
import candelaria.logica.clases.Factura;
import candelaria.logica.clases.Producto;
import candelaria.logica.funciones.FCliente;
import candelaria.logica.funciones.FDetalleFactura;
import candelaria.logica.funciones.FFactura;
import candelaria.logica.funciones.FProducto;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.model.DualListModel;
import recursos.Util;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class DetalleFacturaControlador {

    Date fecha = new java.util.Date();
    private Factura objFactura;
    private Factura facturaSel;
    private Detalle_Factura objDetalleFactura;
    private Detalle_Factura detalleFacturaSel;
    private Producto productoSel;
    private ArrayList<Detalle_Factura> lstDetalleFactura;
    private DualListModel<Producto> Productos;
    private ArrayList<Producto> lstProductos;
    private ArrayList<Producto> lstProductosMozarela;
    private ArrayList<Producto> lstProductosYogurth;
    private ArrayList<Producto> droppedCars;
    private ArrayList<Factura> facturaUltima;
    private ArrayList<Cliente> lstClientes;
    private boolean mostrarActualizar;
    private int valorProductoSeleccionado;
    private int cantidad;
    private double resultado;
    private double precio;
    private double sumaTotalCantidad;
    private String fecha_cambiada;
    private String fechaLetras;
    private int valorFSeleccionado;
    private int valorSSeleccionado;
    private double totalHoja;
    private double totalFactura;
    private double impuestoFactura;
    private int valorDSeleccionado;
    private int codigoFactura;
    
    public double getSumaTotalCantidad() {
        return sumaTotalCantidad;
    }

    public void setSumaTotalCantidad(double sumaTotalCantidad) {
        this.sumaTotalCantidad = sumaTotalCantidad;
    }

    public ArrayList<Producto> getLstProductosMozarela() {
        return lstProductosMozarela;
    }

    public void setLstProductosMozarela(ArrayList<Producto> lstProductosMozarela) {
        this.lstProductosMozarela = lstProductosMozarela;
    }

    public ArrayList<Producto> getLstProductosYogurth() {
        return lstProductosYogurth;
    }

    public void setLstProductosYogurth(ArrayList<Producto> lstProductosYogurth) {
        this.lstProductosYogurth = lstProductosYogurth;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public int getValorDSeleccionado() {
        return valorDSeleccionado;
    }

    public void setValorDSeleccionado(int valorDSeleccionado) {
        this.valorDSeleccionado = valorDSeleccionado;
    }

    public ArrayList<Producto> getDroppedCars() {
        return droppedCars;
    }

    public void setDroppedCars(ArrayList<Producto> droppedCars) {
        this.droppedCars = droppedCars;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaLetras() {
        return fechaLetras;
    }

    public void setFechaLetras(String fechaLetras) {
        this.fechaLetras = fechaLetras;
    }

    public DualListModel<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(DualListModel<Producto> Productos) {
        this.Productos = Productos;
    }

    public ArrayList<Cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(ArrayList<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public double getImpuestoFactura() {
        return impuestoFactura;
    }

    public void setImpuestoFactura(double impuestoFactura) {
        this.impuestoFactura = impuestoFactura;
    }

    public Factura getObjFactura() {
        return objFactura;
    }

    public void setObjFactura(Factura objFactura) {
        this.objFactura = objFactura;
    }

    public Producto getProductoSel() {
        return productoSel;
    }

    public void setProductoSel(Producto productoSel) {
        this.productoSel = productoSel;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha_cambiada() {
        return fecha_cambiada;
    }

    public void setFecha_cambiada(String fecha_cambiada) {
        this.fecha_cambiada = fecha_cambiada;
    }

    public int getValorFSeleccionado() {
        return valorFSeleccionado;
    }

    public void setValorFSeleccionado(int valorFSeleccionado) {
        this.valorFSeleccionado = valorFSeleccionado;
    }

    public int getValorSSeleccionado() {
        return valorSSeleccionado;
    }

    public void setValorSSeleccionado(int valorSSeleccionado) {
        this.valorSSeleccionado = valorSSeleccionado;
    }

    public double getTotalHoja() {
        return totalHoja;
    }

    public void setTotalHoja(double totalHoja) {
        this.totalHoja = totalHoja;
    }

    public Factura getFacturaSel() {
        return facturaSel;
    }

    public void setFacturaSel(Factura facturaSel) {
        this.facturaSel = facturaSel;
    }

    public ArrayList<Factura> getFacturaUltima() {
        return facturaUltima;
    }

    public void setFacturaUltima(ArrayList<Factura> facturaUltima) {
        this.facturaUltima = facturaUltima;
    }

    public int getValorProductoSeleccionado() {
        return valorProductoSeleccionado;
    }

    public void setValorProductoSeleccionado(int valorProductoSeleccionado) {
        this.valorProductoSeleccionado = valorProductoSeleccionado;
    }

    public ArrayList<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(ArrayList<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public Detalle_Factura getObjDetalleFactura() {
        return objDetalleFactura;
    }

    public void setObjDetalleFactura(Detalle_Factura objDetalleFactura) {
        this.objDetalleFactura = objDetalleFactura;
    }

    public Detalle_Factura getDetalleFacturaSel() {
        return detalleFacturaSel;
    }

    public void setDetalleFacturaSel(Detalle_Factura detalleFacturaSel) {
        this.detalleFacturaSel = detalleFacturaSel;
    }

    public ArrayList<Detalle_Factura> getLstDetalleFactura() {
        return lstDetalleFactura;
    }

    public void setLstDetalleFactura(ArrayList<Detalle_Factura> lstDetalleFactura) {
        this.lstDetalleFactura = lstDetalleFactura;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public DetalleFacturaControlador() {
        reinit();

    }

    @PostConstruct
    private void reinit() {
        this.objDetalleFactura = new Detalle_Factura();
        this.detalleFacturaSel = new Detalle_Factura();
        this.facturaSel = new Factura();
        this.productoSel = new Producto();
        this.facturaUltima = new ArrayList<Factura>();

        this.lstClientes = new ArrayList<Cliente>();
        this.lstProductos = new ArrayList<Producto>();
        this.lstProductosMozarela = new ArrayList<Producto>();
        this.lstProductosYogurth = new ArrayList<Producto>();
        this.droppedCars = new ArrayList<Producto>();
        this.lstDetalleFactura = new ArrayList<Detalle_Factura>();
        cargarFacturaUltima();
        cargarProductos();
        cargarProductosMozarela();
        cargarProductosYogurth();
        cargarClientes();
        cargarDetalleFactura();
        sumaColumaPrecio();
        Iva();
        Total();

    }

    public void cargarProductos() {
        try {
            this.lstProductos = FProducto.ObtenerProductosListaQueso();
            // this.productoSel = lstProductos.get(0);
            System.out.println(lstProductos.get(0).getId_producto());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCategoria dice: " + e.getMessage());
            System.out.println("private void cargarCategoria dice: " + e.getMessage());
        }
    }

    public void cargarProductosMozarela() {
        try {
            this.lstProductosMozarela = FProducto.ObtenerProductosListaMozarela();
            //this.productoSel = lstProductos.get(0);
            System.out.println(lstProductos.get(0).getId_producto());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarMozarela dice: " + e.getMessage());
            System.out.println("private void cargarMozarela dice: " + e.getMessage());
        }
    }

    public void cargarProductosYogurth() {
        try {
            this.lstProductosYogurth = FProducto.ObtenerProductosListaYogurth();
            //this.productoSel = lstProductos.get(0);
            System.out.println(lstProductos.get(0).getId_producto());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarYogurth dice: " + e.getMessage());
            System.out.println("private void cargarYogurth dice: " + e.getMessage());
        }
    }

    public void cargarFacturaUltima() {
        java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("dd/MM/yyyy");
        fecha_cambiada = sdf1.format(fecha);
        DateFormat sdf2 = DateFormat.getDateInstance(DateFormat.FULL);
        fechaLetras = sdf2.format(fecha);
        try {
            this.facturaUltima = FFactura.ObtenerFacturaUltima();
            this.facturaSel = facturaUltima.get(0);
            //this.codigoFactura=facturaSel.getId_factura();
            System.out.println(facturaUltima.get(0).getId_factura());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFactura dice: " + e.getMessage());
            System.out.println("private void cargarFactura dice: " + e.getMessage());
        }
    }

    public void cargarClientes() {
        try {
            this.lstClientes = FCliente.ObtenerClientes();
            //this.facturaSel = facturaUltima.get(0);
            System.out.println(lstClientes.get(0).getId_cliente());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCliente dice: " + e.getMessage());
            System.out.println("private void cargarCliente dice: " + e.getMessage());
        }
    }

    public void cargarDetalleFactura() {
        try {
            this.lstDetalleFactura = FDetalleFactura.ObtenerDetalleDadoCodigoFactura(facturaSel.getId_factura());
            this.detalleFacturaSel = lstDetalleFactura.get(0);
            System.out.println(lstDetalleFactura.get(0).getId_producto());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarDetalleFactura dice: " + e.getMessage());
            System.out.println("private void cargarDetalleFactura dice: " + e.getMessage());
        }
    }

    public void insertarDetalleFacturaQueso() {

        try {
            sumaTotalCantidad = cantidad * FProducto.ObtenerProductoDadoCodigo(valorDSeleccionado).getId_categoria().getPrecio_producto();
            Producto producto = new Producto();
            producto.setId_producto(valorDSeleccionado);
            objDetalleFactura.setId_producto(producto);

            Factura fact = new Factura();
            fact.setId_factura(facturaSel.getId_factura());
            objDetalleFactura.setId_factura(fact);
            objDetalleFactura.setCantidad(cantidad);
            objDetalleFactura.setValor_total(sumaTotalCantidad);
            if (FDetalleFactura.Insertar(objDetalleFactura)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoQueso.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarDetalleFactura dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarDetalleFactura dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarDetalleFacturaQueso dice: " + e.getMessage());
            System.out.println("private void insertarDetalleFacturaQueso dice: " + e.getMessage());
        }
    }

    public void insertarDetalleFacturaMozarela() {

        try {
            sumaTotalCantidad = cantidad * FProducto.ObtenerProductoDadoCodigo(valorDSeleccionado).getId_categoria().getPrecio_producto();
            Producto producto = new Producto();
            producto.setId_producto(valorDSeleccionado);
            objDetalleFactura.setId_producto(producto);

            Factura fact = new Factura();
            fact.setId_factura(facturaSel.getId_factura());
            objDetalleFactura.setId_factura(fact);
            objDetalleFactura.setCantidad(cantidad);
            objDetalleFactura.setValor_total(sumaTotalCantidad);
            if (FDetalleFactura.Insertar(objDetalleFactura)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoMozarela.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarDetalleFacturaMozarela dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarDetalleFacturaMozarela dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarDetalleFacturaMozarela dice: " + e.getMessage());
            System.out.println("private void insertarDetalleFacturaMozarela dice: " + e.getMessage());
        }
    }

    public void insertarDetalleFacturaYogurth() {

        try {
            sumaTotalCantidad = cantidad * FProducto.ObtenerProductoDadoCodigo(valorDSeleccionado).getId_categoria().getPrecio_producto();
            Producto producto = new Producto();
            producto.setId_producto(valorDSeleccionado);
            objDetalleFactura.setId_producto(producto);

            Factura fact = new Factura();
            fact.setId_factura(facturaSel.getId_factura());
            objDetalleFactura.setId_factura(fact);
            objDetalleFactura.setCantidad(cantidad);
            objDetalleFactura.setValor_total(sumaTotalCantidad);
            if (FDetalleFactura.Insertar(objDetalleFactura)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoYogurth.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarDetalleFacturaYogurth dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarDetalleFacturaYogurth dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarDetalleFacturaYogurth dice: " + e.getMessage());
            System.out.println("private void insertarDetalleFacturaYogurth dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarDetalleFactura() {
        try {
            detalleFacturaSel.setId_producto(FProducto.ObtenerProductoDadoCodigo(detalleFacturaSel.getId_producto().getId_producto()));

            if (FDetalleFactura.actualizar(detalleFacturaSel)) {
                detalleFacturaSel = new Detalle_Factura();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarDetalle.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarDetalleFactura dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarDetalleFactura dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarDetalleFactura dice: " + e.getMessage());
            System.out.println("private void actualizarDetalleFactura dice: " + e.getMessage());
        }
    }

    public void eliminarDetalleFactura() {
        try {
            if (FDetalleFactura.eliminar((int) detalleFacturaSel.getId_detalle_factura())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarDetalle.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarDetalleFactura dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarDetalleFactura dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarDetalleFactura dice: " + e.getMessage());
            System.out.println("private void eliminarDetalleFactura dice: " + e.getMessage());
        }

    }

    public double sumaColumaPrecio() {

        totalHoja = 0.0;
        try {
            this.lstDetalleFactura = FDetalleFactura.ObtenerDetalleDadoCodigoFactura(facturaSel.getId_factura());
            //int size = lstDetalles.size();
            for (Detalle_Factura lstDetalleFactura : lstDetalleFactura) {
                totalHoja = totalHoja + lstDetalleFactura.getValor_total();
                //System.out.println(totalHoja);
            }

        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarDetalle dice: " + e.getMessage());
            System.out.println("private void actualizarDetalle dice: " + e.getMessage());
        }

        return totalHoja;
    }
    
    public double Iva() {
        //impuestoFactura=0.0;
        impuestoFactura = totalHoja * 0.12;

        return impuestoFactura;
    }

    public double Total() {
        totalFactura = 0.0;
        totalFactura = totalHoja + impuestoFactura;

        return totalFactura;
    }

    public void imprimirFac() {
        //DateFormat dfDateFull = DateFormat.getDateInstance(DateFormat.FULL);
        try {

            //Generamos el archivo PDF
            String directorioArchivos;
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            directorioArchivos = ctx.getRealPath("/") + "reports";
            String name = directorioArchivos + "/document-factura.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(name));
            //PdfWriter writer = PdfWriter.getInstance(document,
            //new FileOutputStream("C:"));

            Paragraph paragraph = new Paragraph();

            PdfPTable table = new PdfPTable(4);
            PdfPTable table1 = new PdfPTable(3);
            PdfPTable table2 = new PdfPTable(1);
            PdfPTable table3 = new PdfPTable(2);
            PdfPTable table5 = new PdfPTable(5);

            paragraph.add("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);

            document.open();

            //primera linea   
            PdfPCell cell5 = new PdfPCell(new Paragraph("Fecha: " + facturaSel.getFecha()));
            PdfPCell cell6 = new PdfPCell(new Paragraph(""));
            PdfPCell cell7 = new PdfPCell(new Paragraph("Cedula: " + facturaSel.getId_cliente().getRuc_cliente()));
            //segunda linea
            PdfPCell cell8 = new PdfPCell(new Paragraph("Nombre Cliente: " + facturaSel.getId_cliente().getNombres_cliente()));
            //tercera fila
            PdfPCell cell9 = new PdfPCell(new Paragraph("Dirección: " + facturaSel.getId_cliente().getDireccion_cliente()));
            PdfPCell cell10 = new PdfPCell(new Paragraph("Télefono: " + facturaSel.getId_cliente().getTelefono_cliente()));
            PdfPCell cell11 = new PdfPCell(new Paragraph("Cantidad"));
            PdfPCell cell12 = new PdfPCell(new Paragraph("Producto"));
            PdfPCell cell13 = new PdfPCell(new Paragraph("Precio"));
            PdfPCell cell14 = new PdfPCell(new Paragraph("Total"));

            cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setHorizontalAlignment(Element.ALIGN_RIGHT);

            cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell10.setHorizontalAlignment(Element.ALIGN_RIGHT);

            cell5.setBorder(Rectangle.NO_BORDER);
            cell6.setBorder(Rectangle.NO_BORDER);
            cell7.setBorder(Rectangle.NO_BORDER);
            cell8.setBorder(Rectangle.NO_BORDER);

            cell9.setBorder(Rectangle.NO_BORDER);
            cell10.setBorder(Rectangle.NO_BORDER);
            //cell7.setBorder(Rectangle.NO_BORDER);
            //cell8.setBorder(Rectangle.NO_BORDER);

            cell11.setBorder(Rectangle.NO_BORDER);
            cell12.setBorder(Rectangle.NO_BORDER);
            cell13.setBorder(Rectangle.NO_BORDER);
            cell14.setBorder(Rectangle.NO_BORDER);

            table1.addCell(cell5);
            table1.addCell(cell6);
            table1.addCell(cell7);
            //añadir segunda fila
            table2.addCell(cell8);
            //añadir tercera fila
            table3.addCell(cell9);
            table3.addCell(cell10);
            //añadir cuarta fila
            table5.addCell(cell11);
            table5.addCell(cell12);
            table5.addCell(cell13);
            table5.addCell(cell14);

            for (int x = 0; x < lstDetalleFactura.size(); x++) {

                PdfPCell cell1 = new PdfPCell(new Paragraph("" + lstDetalleFactura.get(x).getCantidad()));
                PdfPCell cell2 = new PdfPCell(new Paragraph("" + lstDetalleFactura.get(x).getId_producto().getId_categoria().getNombre_producto()));
                PdfPCell cell3 = new PdfPCell(new Paragraph("" + lstDetalleFactura.get(x).getId_producto().getId_categoria().getPrecio_producto()));
                PdfPCell cell4 = new PdfPCell(new Paragraph("" + lstDetalleFactura.get(x).getValor_total()));
                /* Chunk chunk = new Chunk(
                 "\n" + lstDetalles.get(x).getCantidadDet() + "       " + lstDetalles.get(x).getIdSer().getNombreSer() + "             " + lstDetalles.get(x).getIdSer().getPrecioSer()
                 + "                          " + lstDetalles.get(x).getPrecio());*/

                cell1.setBorder(Rectangle.NO_BORDER);
                cell2.setBorder(Rectangle.NO_BORDER);
                cell3.setBorder(Rectangle.NO_BORDER);
                cell4.setBorder(Rectangle.NO_BORDER);

                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell4.setHorizontalAlignment(Element.ALIGN_RIGHT);

                cell1.setMinimumHeight(10f);
                cell2.setMinimumHeight(5f);

                table.setTotalWidth(100f);
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                //añadir primera fila

                table.setSpacingBefore(30f);
                table.setSpacingAfter(50f);

                //paragraph4.add(chunk);
                //paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED_ALL);
            }

            document.add(paragraph);
            document.add(table1);
            document.add(table2);
            document.add(table3);
            document.add(table5);
            document.add(table);
            //document.setFooter(event);

            document.close();
            //----------------------------
            //Abrimos el archivo PDF
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition",
                    "inline=filename=" + name);
            try {
                response.getOutputStream().write(Util.getBytesFromFile(new File(name)));
                response.getOutputStream().flush();
                response.getOutputStream().close();
                context.responseComplete();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
