/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Detalle_Pedido;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class FDetallePedido {
    
   public static boolean Insertar(Detalle_Pedido detallepedido) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_insert_detalle_pedido(?,?,?,?,?)";
            lstP.add(new Parametro(1, detallepedido.getId_producto().getId_producto()));
            lstP.add(new Parametro(2, detallepedido.getId_pedido().getId_pedido()));
            lstP.add(new Parametro(3, detallepedido.getUnidades_producto()));
            lstP.add(new Parametro(4, detallepedido.getCosto_unidad()));
            lstP.add(new Parametro(5, detallepedido.getCosto_total()));

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

    public static boolean actualizar(Detalle_Pedido detallepedido) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_update_detalle_pedido(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, detallepedido.getId_detalle_pedido()));
            lstP.add(new Parametro(2, detallepedido.getId_producto().getId_producto()));
            lstP.add(new Parametro(3, detallepedido.getId_pedido().getId_pedido()));
            lstP.add(new Parametro(4, detallepedido.getUnidades_producto()));
            lstP.add(new Parametro(5, detallepedido.getCosto_unidad()));
            lstP.add(new Parametro(6, detallepedido.getCosto_total()));

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
            String sql = "select * from sgflc.f_delete_detalle_pedido(?)";
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

    
    public static ArrayList<Detalle_Pedido> llenarDetallePedido(ConjuntoResultado rs) throws Exception {
        ArrayList<Detalle_Pedido> lst = new ArrayList<Detalle_Pedido>();
        Detalle_Pedido detallepedido = null;
        try {
            while (rs.next()) {
                detallepedido = new Detalle_Pedido(rs.getInt("pid_detalle_pedido"),FProducto.ObtenerProductoDadoCodigo(rs.getInt("pid_producto")),
                FPedido.ObtenerPedidoDadoCodigo(rs.getInt("pid_pedido")),rs.getInt("pcantidad_producto"), rs.getDouble("pcosto_unidad"),rs.getDouble("pcosto_total"));
                lst.add(detallepedido);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Detalle_Pedido> ObtenerDetallePedido() throws Exception {
        ArrayList<Detalle_Pedido> lst = new ArrayList<Detalle_Pedido>();
        try {
            String sql = "select * from sgflc.f_select_detalle_factura()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDetallePedido(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Detalle_Pedido ObtenerDetallePedidoDadoCodigo(int codigo) throws Exception {
        Detalle_Pedido lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_detalle_pedido_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Detalle_Pedido();
            lst = llenarDetallePedido(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}


