/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Factura;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */

public class FFactura {

    public static boolean Insertar(Factura factura) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_insert_factura(?,?,?,?)";
            lstP.add(new Parametro(1, factura.getId_cliente().getId_cliente()));
            lstP.add(new Parametro(2, factura.getFecha()));
            lstP.add(new Parametro(3, factura.getSubtotal()));
            lstP.add(new Parametro(4, factura.getPrecisiontotal()));

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

    public static boolean actualizar(Factura factura) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_update_factura(?,?,?,?,?)";
            lstP.add(new Parametro(1, factura.getId_factura()));
            lstP.add(new Parametro(2, factura.getId_cliente().getId_cliente()));
            lstP.add(new Parametro(3, factura.getFecha()));
            lstP.add(new Parametro(4, factura.getSubtotal()));
            lstP.add(new Parametro(5, factura.getPrecisiontotal()));

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
            String sql = "select * from sgflc.f_delete_factura(?)";
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

    
    public static ArrayList<Factura> llenarFactura(ConjuntoResultado rs) throws Exception {
        ArrayList<Factura> lst = new ArrayList<Factura>();
        Factura factura = null;
        try {
            while (rs.next()) {
                factura = new Factura(rs.getInt("pid_factura"),FCliente.ObtenerClienteDadoCodigo(rs.getInt("pid_cliente")),
                        rs.getDate("pfecha"), rs.getDouble("psubtotal"),rs.getDouble("ptotal"));
                lst.add(factura);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Factura> ObtenerFacturas() throws Exception {
        ArrayList<Factura> lst = new ArrayList<Factura>();
        try {
            String sql = "select * from sgflc.f_select_factura()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarFactura(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
       public static ArrayList<Factura> ObtenerFacturaUltima() throws Exception {
        ArrayList<Factura> lst = new ArrayList<Factura>();
        try {
            String sql = "select * from sgflc.f_select_factura_ultima()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarFactura(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Factura ObtenerFacturaDadoCodigo(int codigo) throws Exception {
        Factura lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_factura_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Factura();
            lst = llenarFactura(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
