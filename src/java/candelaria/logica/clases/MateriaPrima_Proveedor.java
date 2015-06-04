/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.clases;

import java.util.Date;



/**
 *
 * @author Yolanda
 */
public class MateriaPrima_Proveedor {
    private Integer codigoMateriaProveedor;
    private Proveedor codigoProveedor;
    private MateriaPrima codigoMateriaPrima;
    private Date fecha;
    private String obsevaciones;

    public MateriaPrima_Proveedor() {
    }

    public MateriaPrima_Proveedor(Integer codigoMateriaProveedor, Proveedor codigoProveedor, MateriaPrima codigoMateriaPrima, Date fecha, String obsevaciones) {
        this.codigoMateriaProveedor = codigoMateriaProveedor;
        this.codigoProveedor = codigoProveedor;
        this.codigoMateriaPrima = codigoMateriaPrima;
        this.fecha = fecha;
        this.obsevaciones = obsevaciones;
    }

    public Integer getCodigoMateriaProveedor() {
        return codigoMateriaProveedor;
    }

    public void setCodigoMateriaProveedor(Integer codigoMateriaProveedor) {
        this.codigoMateriaProveedor = codigoMateriaProveedor;
    }

    public Proveedor getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Proveedor codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public MateriaPrima getCodigoMateriaPrima() {
        return codigoMateriaPrima;
    }

    public void setCodigoMateriaPrima(MateriaPrima codigoMateriaPrima) {
        this.codigoMateriaPrima = codigoMateriaPrima;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObsevaciones() {
        return obsevaciones;
    }

    public void setObsevaciones(String obsevaciones) {
        this.obsevaciones = obsevaciones;
    }
    
    
    
}
