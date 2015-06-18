/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Yolanda
 */
public class FProveedor {
 public static boolean Insertar(Proveedor proveedor) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_insert_proveedor(?,?,?,?,?,?,)";
            lstP.add(new Parametro(1, proveedor.getNombre_proveedor() ));
            lstP.add(new Parametro(2, proveedor.getDirecion_proveedor()));
            lstP.add(new Parametro(3, proveedor.getCiudad_proveedor()));
            lstP.add(new Parametro(4, proveedor.getTelefono_provedor()));
            lstP.add(new Parametro(5, proveedor.getProducto_provedor()));
            lstP.add(new Parametro(6, proveedor.getCosto()));
            
       
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
    
     public static boolean actualizar(Proveedor proveedor) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_update_proveedor(?,?,?,?,?,?,)";
            lstP.add(new Parametro(1, proveedor.getId_proveedor()));
            lstP.add(new Parametro(2, proveedor.getNombre_proveedor()));
            lstP.add(new Parametro(3, proveedor.getDirecion_proveedor()));
            lstP.add(new Parametro(4, proveedor.getCiudad_proveedor()));
            lstP.add(new Parametro(5, proveedor.getTelefono_provedor()));
            lstP.add(new Parametro(6, proveedor.getProducto_provedor()));
            lstP.add(new Parametro(7, proveedor.getCosto()));
            
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
        String sql = "select * from sgflc.f_delete_proveedor(?)";
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
    
    /**
     *
     * @param rs
     * @return
     * @throws Exception
     */
    public static ArrayList<Proveedor> llenarProveedor(ConjuntoResultado rs) throws Exception {
        ArrayList<Proveedor> lst = new ArrayList<Proveedor>();
        Proveedor proveedor = null;
        try {
            while (rs.next()) {
                proveedor = new Proveedor(rs.getInt("pid_proveedor"), rs.getString("pnombre_proveedor"), rs.getString("pdireccion_proveedor"), 
                        rs.getString("pciudad_proveedor"), rs.getString("ptelefono_proveedor"),rs.getString("pproducto_proveedor"),
                        rs.getDouble("pcosto"));
                lst.add(proveedor);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Proveedor> ObtenerProveedor() throws Exception {
        ArrayList<Proveedor> lst = new ArrayList<Proveedor>();
        try {
            String sql = "select * from  sgflc.f_select_proveedor()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarProveedor(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Proveedor ObtenerProveedorDadoCodigo(int codigo) throws Exception {
        Proveedor lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_proveedor_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Proveedor();
            lst = llenarProveedor(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
       
}
