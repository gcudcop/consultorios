/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Categoria;
import candelaria.logica.clases.Control_Mozarela;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class FCategoria {
    public static boolean Insertar(Categoria categoria) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_insert_categoria(?,?,?)";
            lstP.add(new Parametro(1, categoria.getNombre_producto()));
            lstP.add(new Parametro(2, categoria.getDescripcion_producto()));
            lstP.add(new Parametro(3, categoria.getPrecio_producto()));
            
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
    
     public static boolean actualizar(Categoria categoria) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_update_categoria(?,?,?,?)";
            lstP.add(new Parametro(1, categoria.getId_categoria()));
            lstP.add(new Parametro(2, categoria.getNombre_producto()));
            lstP.add(new Parametro(3, categoria.getDescripcion_producto()));
            lstP.add(new Parametro(4, categoria.getPrecio_producto()));
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
        String sql = "select * from sgflc.f_delete_categoria(?)";
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
    
    
     public static ArrayList<Categoria> llenarCategoria(ConjuntoResultado rs) throws Exception {
        ArrayList<Categoria> lst = new ArrayList<Categoria>();
        Categoria categoria = null;
        try {
            while (rs.next()) {
                categoria= new Categoria(rs.getInt("pid_categoria"), rs.getString("pnombre_producto"), rs.getString("pdescripcion_producto"), 
                        rs.getDouble("pprecio_producto"));
                lst.add(categoria);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
     

     public static ArrayList<Categoria> ObtenerlistaMozarela() throws Exception {
        ArrayList<Categoria> lst = new ArrayList<Categoria>();
        try {
            String sql = "select * from sgflc.f_select_categoria_lista_queso_mozarela()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCategoria(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }  
     
     public static ArrayList<Categoria> ObtenerlistaQueso() throws Exception {
        ArrayList<Categoria> lst = new ArrayList<Categoria>();
        try {
            String sql = "select * from sgflc.f_select_categoria_lista_queso()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCategoria(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }  
     
    public static ArrayList<Categoria> ObtenerCategoria() throws Exception {
        ArrayList<Categoria> lst = new ArrayList<Categoria>();
        try {
            String sql = "select * from sgflc.f_select_categoria()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCategoria(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Categoria ObtenerCategoriaDadoCodigo(int codigo) throws Exception {
        Categoria lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_categoria_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Categoria();
            lst = llenarCategoria(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
