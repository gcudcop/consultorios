/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class FPedido {
        public static boolean Insertar(Pedido pedido) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_insert_pedido(?,?,?,?)";
            lstP.add(new Parametro(1, pedido.getId_cliente().getId_cliente()));
            lstP.add(new Parametro(2, pedido.getId_empleado().getId_empleado()));
            lstP.add(new Parametro(3, pedido.getFecha_pedido()));
            lstP.add(new Parametro(4, pedido.getCosto_total()));

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

    public static boolean actualizar(Pedido pedido) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_update_pedido(?,?,?,?,?)";
            lstP.add(new Parametro(1, pedido.getId_pedido()));
            lstP.add(new Parametro(2, pedido.getId_cliente().getId_cliente()));
            lstP.add(new Parametro(3, pedido.getId_empleado().getId_empleado()));
            lstP.add(new Parametro(4, pedido.getFecha_pedido()));
            lstP.add(new Parametro(5, pedido.getCosto_total()));

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
            String sql = "select * from sgflc.f_delete_pedido(?)";
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

    
    public static ArrayList<Pedido> llenarPedido(ConjuntoResultado rs) throws Exception {
        ArrayList<Pedido> lst = new ArrayList<Pedido>();
        Pedido pedido = null;
        try {
            while (rs.next()) {
                pedido = new Pedido(rs.getInt("pid_pedido"),FCliente.ObtenerClienteDadoCodigo(rs.getInt("pid_cliente")),
                        FEmpleado.ObtenerEmpleadoDadoCodigo(rs.getInt("pid_empleado")),
                        rs.getDate("pfecha_pedido"),rs.getDouble("pcosto_total"));
                lst.add(pedido);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Pedido> ObtenerPedidos() throws Exception {
        ArrayList<Pedido> lst = new ArrayList<Pedido>();
        try {
            String sql = "select * from sgflc.f_select_pedido()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPedido(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Pedido ObtenerPedidoDadoCodigo(int codigo) throws Exception {
        Pedido lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_pedido_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Pedido();
            lst = llenarPedido(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
