/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Control_Mozarela;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pato
 */
public class FControl_Mozarela {
public static boolean Insertar(Control_Mozarela control_mozarela) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from candelaria.f_insert_control_mozarela(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, control_mozarela.getId_producto()));
            lstP.add(new Parametro(2, control_mozarela.getPh_mozarela()));
            lstP.add(new Parametro(3, control_mozarela.getHumedad_mozarela()));
            lstP.add(new Parametro(4, control_mozarela.getCenizas_mozarela()));
            lstP.add(new Parametro(5, control_mozarela.getGrasas_mozarela()));
            lstP.add(new Parametro(6, control_mozarela.getProteinas_mozarela()));
            lstP.add(new Parametro(7, control_mozarela.getSolidos_totales()));
            lstP.add(new Parametro(8, control_mozarela.getRendimiento_mozarela()));
                  
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
    
     public static boolean actualizar(Control_Mozarela control_mozarela) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from candelaria.f_update_control_mozarela(?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, control_mozarela.getId_control_mozarela()));
            lstP.add(new Parametro(2, control_mozarela.getId_producto()));
            lstP.add(new Parametro(3, control_mozarela.getPh_mozarela()));
            lstP.add(new Parametro(4, control_mozarela.getHumedad_mozarela()));
            lstP.add(new Parametro(5, control_mozarela.getCenizas_mozarela()));
            lstP.add(new Parametro(6, control_mozarela.getGrasas_mozarela()));
            lstP.add(new Parametro(7, control_mozarela.getProteinas_mozarela()));
            lstP.add(new Parametro(8, control_mozarela.getSolidos_totales()));
            lstP.add(new Parametro(9, control_mozarela.getRendimiento_mozarela()));
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
        String sql = "select * from candelaria.f_delete_control_mozarela(?)";
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
    
    
     public static ArrayList<Control_Mozarela> llenarControl_Mozarela(ConjuntoResultado rs) throws Exception {
        ArrayList<Control_Mozarela> lst = new ArrayList<Control_Mozarela>();
        Control_Mozarela control_mozarela = null;
        try {
            while (rs.next()) {
                control_mozarela = new Control_Mozarela(rs.getInt("pid_control_mozarela"), FProducto.("pid_producto"), rs.getString("pph_mozarela"), 
                        rs.getString("phumedad_mozarela"), rs.getString("pcenizas_mozarela"),rs.getDouble("pgrasas_mozarela"),
                        rs.getDouble("pproteinas_mozarela"),rs.getDouble(" psolidos_totales "), rs.getDouble("prendimiento_mozarela"));
                lst.add(control_mozarela);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Control_Mozarela> ObtenerControl_Mozarela() throws Exception {
        ArrayList<Control_Mozarela> lst = new ArrayList<Control_Mozarela>();
        try {
            String sql = "select * from candelaria.f_select_control_mozarela()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarControl_Mozarela(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Control_Mozarela ObtenerEmpleadoDadoCodigo(int codigo) throws Exception {
        Control_Mozarela lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_estudiante_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Control_Mozarela();
            lst = llenarControl_Mozarela(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
