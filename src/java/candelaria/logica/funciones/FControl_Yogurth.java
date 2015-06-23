/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Control_Yogurth;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class FControl_Yogurth {
    public static boolean Insertar(Control_Yogurth control_yogurth) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from candelaria.f_insert_control_yogurth(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, control_yogurth.getAgua_yogurth()));
            lstP.add(new Parametro(2, control_yogurth.getProteinas_yogurth()));
            lstP.add(new Parametro(3, control_yogurth.getLipidos_yogurth()));
            lstP.add(new Parametro(4, control_yogurth.getGlucidos_yogurth()));
            lstP.add(new Parametro(5, control_yogurth.getAcidos_organicos()));
            lstP.add(new Parametro(6, control_yogurth.getCenizas_yogurth()));
            lstP.add(new Parametro(7, control_yogurth.getFibras_yogurth()));
            lstP.add(new Parametro(8, control_yogurth.getContenido_energetico()));
            
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
    
     public static boolean actualizar(Control_Yogurth control_yogurth) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from candelaria.f_update_control_yogurth(?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, control_yogurth.getId_control_yogurth()));
            lstP.add(new Parametro(2, control_yogurth.getAgua_yogurth()));
            lstP.add(new Parametro(3, control_yogurth.getProteinas_yogurth()));
            lstP.add(new Parametro(4, control_yogurth.getLipidos_yogurth()));
            lstP.add(new Parametro(5, control_yogurth.getGlucidos_yogurth()));
            lstP.add(new Parametro(6, control_yogurth.getAcidos_organicos()));
            lstP.add(new Parametro(7, control_yogurth.getCenizas_yogurth()));
            lstP.add(new Parametro(8, control_yogurth.getFibras_yogurth()));
            lstP.add(new Parametro(9, control_yogurth.getContenido_energetico()));
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
        String sql = "select * from candelaria.f_delete_control_yogurth(?)";
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
    
    
     public static ArrayList<Control_Yogurth> llenarControl_Yogurths(ConjuntoResultado rs) throws Exception {
        ArrayList<Control_Yogurth> lst = new ArrayList<Control_Yogurth>();
        Control_Yogurth control_yogurth = null;
        try {
            while (rs.next()) {
                control_yogurth= new Control_Yogurth(rs.getInt("pid_control_yogurth"),FProducto.ObtenerProductoDadoCodigo(rs.getInt("pid_producto")), rs.getDouble("pagua_yogurth"), rs.getDouble("pproteinas_yogurth"), 
                        rs.getDouble("plipidos_yogurth"), rs.getDouble("pglucidos_yogurth"), rs.getDouble("pacidos_organicos"), rs.getDouble("pcenizas_yogurth"),
                rs.getDouble("pfibras_yogurth"), rs.getDouble("pcontenido_energetico"));
                lst.add(control_yogurth);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Control_Yogurth> ObtenerControl_Yogurth() throws Exception {
        ArrayList<Control_Yogurth> lst = new ArrayList<Control_Yogurth>();
        try {
            String sql = "select * from master.f_select_control_yogurth()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarControl_Yogurths(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Control_Yogurth ObtenerControl_YogurthDadoCodigo(int codigo) throws Exception {
        Control_Yogurth lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_control_yogurth_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Control_Yogurth();
            lst = llenarControl_Yogurths(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
