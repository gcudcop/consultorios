/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Empleado;
import candelaria.logica.clases.Producto;
import static candelaria.logica.funciones.FProducto.llenarProductos;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pato
 */
public class FEmpleado {
     public static boolean Insertar(Empleado empleado) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_insert_empleado(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, empleado.getNombres_empleado()));
            lstP.add(new Parametro(2, empleado.getApellido_paterno()));
            lstP.add(new Parametro(3, empleado.getApellido_materno()));
            lstP.add(new Parametro(4, empleado.getEstado_civil()));
            lstP.add(new Parametro(5, empleado.getEmail_empleado()));
            lstP.add(new Parametro(6, empleado.getTelefono_empleado()));
            lstP.add(new Parametro(7, empleado.getCedula_empleado()));
            lstP.add(new Parametro(8, empleado.getNumero_credencial()));
       
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
    
     public static boolean actualizar(Empleado empleado) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_update_empleado(?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, empleado.getId_empleado()));
            lstP.add(new Parametro(2, empleado.getNombres_empleado()));
            lstP.add(new Parametro(3, empleado.getApellido_paterno()));
            lstP.add(new Parametro(4, empleado.getApellido_materno()));
            lstP.add(new Parametro(5, empleado.getEstado_civil()));
            lstP.add(new Parametro(6, empleado.getEmail_empleado()));
            lstP.add(new Parametro(7, empleado.getTelefono_empleado()));
            lstP.add(new Parametro(8, empleado.getCedula_empleado()));
            lstP.add(new Parametro(9, empleado.getNumero_credencial()));
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
        String sql = "select * from sgflc.f_delete_empleado(?)";
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
    
    
     public static ArrayList<Empleado> llenarEmpleado(ConjuntoResultado rs) throws Exception {
        ArrayList<Empleado> lst = new ArrayList<Empleado>();
        Empleado empleado = null;
        try {
            while (rs.next()) {
                empleado = new Empleado(rs.getInt("pid_empleado"), rs.getString("pnombres_nombre_empleado"), rs.getString("papellido_paterno"), 
                        rs.getString("papellido_materno"), rs.getString("pestado_civil"),rs.getString("pemail_empleado"),
                        rs.getString("ptelefono_empleado"),rs.getString("pcedula_empleado"), rs.getString("pnumero_credencial"));
                lst.add(empleado);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Empleado> ObtenerEmpleado() throws Exception {
        ArrayList<Empleado> lst = new ArrayList<Empleado>();
        try {
            String sql = "select * from sgflc.f_select_empleado()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEmpleado(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static ArrayList<Empleado> ObtenerEmpleadoUltimo() throws Exception {
        ArrayList<Empleado> lst = new ArrayList<Empleado>();
        try {
            String sql = "select * from sgflc.f_select_empleado_ultimo()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEmpleado(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    public static Empleado ObtenerEmpleadoDadoCodigo(int codigo) throws Exception {
        Empleado lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_empleado_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Empleado();
            lst = llenarEmpleado(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
  

    
}
