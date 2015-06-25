/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Detalle_Factura;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class FDetalleFactura {
    public static boolean Insertar(Detalle_Factura detallefactura) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_insert_detalle_factura(?,?,?,?,?)";
            lstP.add(new Parametro(1, detallefactura.getId_factura().getId_factura()));
            lstP.add(new Parametro(2, detallefactura.getId_producto().getId_producto()));
            lstP.add(new Parametro(3, detallefactura.getCantidad()));
            lstP.add(new Parametro(4, detallefactura.getCosto_unidad()));
            lstP.add(new Parametro(5, detallefactura.getValor_total()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean actualizar(Detalle_Factura detallefactura) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_update_detalle_factura(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, detallefactura.getId_detalle_factura()));
            lstP.add(new Parametro(2, detallefactura.getId_factura().getId_factura()));
            lstP.add(new Parametro(3, detallefactura.getId_producto().getId_producto()));
            lstP.add(new Parametro(4, detallefactura.getCantidad()));
            lstP.add(new Parametro(5, detallefactura.getCosto_unidad()));
            lstP.add(new Parametro(6, detallefactura.getValor_total()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean eliminar(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_delete_detalle_factura(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    
    public static ArrayList<Detalle_Factura> llenarDetalle_Factura(ConjuntoResultado rs) throws Exception {
        ArrayList<Detalle_Factura> lst = new ArrayList<Detalle_Factura>();
        Detalle_Factura detallefactura = null;
        try {
            while (rs.next()) {
                detallefactura = new Detalle_Factura(rs.getInt("pid_detalle_factura"),FFactura.ObtenerFacturaDadoCodigo(rs.getInt("pid_factura")),
                FProducto.ObtenerProductoDadoCodigo(rs.getInt("pid_producto")),rs.getInt("pcantidad"), rs.getDouble("pcosto_unidad"),rs.getDouble("pvalor_total"));
                lst.add(detallefactura);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Detalle_Factura> ObtenerDetalle_Facturas() throws Exception {
        ArrayList<Detalle_Factura> lst = new ArrayList<Detalle_Factura>();
        try {
            String sql = "select * from sgflc.f_select_detalle_factura()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDetalle_Factura(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Detalle_Factura ObtenerDetalle_FacturaDadoCodigo(int codigo) throws Exception {
        Detalle_Factura lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_detalle_factura_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Detalle_Factura();
            lst = llenarDetalle_Factura(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
