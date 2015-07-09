/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Control_Queso;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pato
 */
public class FControl_Queso {
     public static boolean Insertar(Control_Queso control_queso) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_insert_control_queso(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, control_queso.getId_producto()));
            lstP.add(new Parametro(2, control_queso.getCorteza_queso()));
            lstP.add(new Parametro(3, control_queso.getOlor_queso()));
            lstP.add(new Parametro(4, control_queso.getSabor_queso()));
            lstP.add(new Parametro(5, control_queso.getElasticidad_queso()));
            lstP.add(new Parametro(6, control_queso.getMasticabilidad_queso()));
            lstP.add(new Parametro(7, control_queso.getAcidez_queso()));
            lstP.add(new Parametro(8, control_queso.getCalidad_global()));
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
    
     public static boolean actualizar(Control_Queso control_queso) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_update_contro_queso(?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, control_queso.getId_control_queso()));
            lstP.add(new Parametro(2, control_queso.getId_producto()));
            lstP.add(new Parametro(3, control_queso.getCorteza_queso()));
            lstP.add(new Parametro(4, control_queso.getOlor_queso()));
            lstP.add(new Parametro(5, control_queso.getSabor_queso()));
            lstP.add(new Parametro(6, control_queso.getElasticidad_queso()));
            lstP.add(new Parametro(7, control_queso.getMasticabilidad_queso()));
            lstP.add(new Parametro(8, control_queso.getAcidez_queso()));
            lstP.add(new Parametro(9, control_queso.getCalidad_global()));
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
        String sql = "select * from sgflc.f_delete_control_queso(?)";
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
    
    
     public static ArrayList<Control_Queso> llenarControl_Queso(ConjuntoResultado rs) throws Exception {
        ArrayList<Control_Queso> lst = new ArrayList<Control_Queso>();
        Control_Queso control_queso = null;
        try {
            while (rs.next()) {
                control_queso = new Control_Queso(rs.getInt("pid_control_queso"),FProducto.ObtenerProductoDadoCodigo(rs.getInt("pid_producto")), rs.getString("pcorteza_queso"), 
                        rs.getString("polor_queso"), 
                        rs.getString("psabor_queso"), rs.getString("pelasticidad_queso"),rs.getString("pmasticabilidad_queso"),
                        rs.getString("pacidez_queso"),rs.getString("pcalidad_global"));
                lst.add(control_queso);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Control_Queso> ObtenerControl_Queso() throws Exception {
        ArrayList<Control_Queso> lst = new ArrayList<Control_Queso>();
        try {
            String sql = "select * from sgflc.f_select_control_queso()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarControl_Queso(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Control_Queso ObtenerControl_QuesoDadoCodigo(int codigo) throws Exception {
        Control_Queso lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_control_queso_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Control_Queso();
            lst = llenarControl_Queso(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
}
