/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Producto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ROGES
 */
public class FProducto {
    private static Object FNivel;
    public static boolean Insertar(Producto producto) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_insert_producto(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, producto.getId_categoria().getId_categoria()));
            lstP.add(new Parametro(2, producto.getFecha_fabricacion()));
            lstP.add(new Parametro(3, producto.getFecha_caducidad()));
            lstP.add(new Parametro(4, producto.getPeso_producto()));
            lstP.add(new Parametro(5, producto.getColor_producto()));
            lstP.add(new Parametro(6, producto.getSabor_producto()));
            lstP.add(new Parametro(7, producto.getForma_producto()));
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
    
     public static boolean actualizar(Producto producto) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_update_producto(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, producto.getId_producto()));
            lstP.add(new Parametro(2, producto.getId_categoria().getId_categoria()));
            lstP.add(new Parametro(3, producto.getFecha_fabricacion()));
            lstP.add(new Parametro(4, producto.getFecha_caducidad()));
            lstP.add(new Parametro(5, producto.getPeso_producto()));
            lstP.add(new Parametro(6, producto.getColor_producto()));
            lstP.add(new Parametro(7, producto.getSabor_producto()));
            lstP.add(new Parametro(8, producto.getForma_producto()));
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
    
    public static  boolean eliminar (int codigo) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from sgflc.f_delete_producto(?)";
        lstP.add(new Parametro(1,codigo));
        ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
        while(rs.next() )
            {
              if(rs.getString(0).equals("true"));
                   eje=true;
            }
            } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return eje;
    }
    
    
     public static ArrayList<Producto> llenarProductos(ConjuntoResultado rs) throws Exception {
        ArrayList<Producto> lst = new ArrayList<Producto>();
        Producto producto = null;
        try {
            while (rs.next()) {
                producto = new Producto(rs.getInt("pid_producto"),FCategoria.ObtenerCategoriaDadoCodigo(rs.getInt("pid_categoria")), rs.getDate("pfecha_fabricacion"), 
                        rs.getDate("pfecha_caducidad"), rs.getString("ppeso_producto"), rs.getString("pcolor_producto"),
                        rs.getString("psabor_producto"),rs.getString("pforma_producto")) ;
                lst.add(producto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Producto> ObtenerProductos() throws Exception {
        ArrayList<Producto> lst = new ArrayList<Producto>();
        try {
            String sql = "select * from sgflc.f_select_producto()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarProductos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Producto> ObtenerProductosListaMozarela() throws Exception {
        ArrayList<Producto> lst = new ArrayList<Producto>();
        try {
            String sql = "select * from sgflc.f_select_producto_lista_mozarela()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarProductos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static ArrayList<Producto> ObtenerProductosListaYogurth() throws Exception {
        ArrayList<Producto> lst = new ArrayList<Producto>();
        try {
            String sql = "select * from sgflc.f_select_producto_lista_yogurth()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarProductos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    public static ArrayList<Producto> ObtenerProductosListaQueso() throws Exception {
        ArrayList<Producto> lst = new ArrayList<Producto>();
        try {
            String sql = "select * from sgflc.f_select_producto_lista_queso()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarProductos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
  

    public static Producto ObtenerProductoDadoCodigo(int codigo) throws Exception {
        Producto lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_producto_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Producto();
            lst = llenarProductos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Producto ObtenerProductoDadoCodigoCategoria(int codigo) throws Exception {
        Producto lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_producto_dado_codigo_categoria(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Producto();
            lst = llenarProductos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Producto> ObtenerProductoDadoCodigoCategoria1(int codigo) throws Exception {
       ArrayList<Producto> lst = new ArrayList<Producto>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_producto_dado_codigo_categoria(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
           // lst = new Producto();
            lst = llenarProductos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
}
