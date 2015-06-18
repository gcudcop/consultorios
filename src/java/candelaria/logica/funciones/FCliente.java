/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pato
 */
public class FCliente {
    public static boolean Insertar(Cliente cliente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from candelaria.f_insert_cliente(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, cliente.getNombres_cliente()));
            lstP.add(new Parametro(2, cliente.getApellidos_cliente()));
            lstP.add(new Parametro(3, cliente.getDireccion_cliente()));
            lstP.add(new Parametro(4, cliente.getTelefono_cliente()));
            lstP.add(new Parametro(5, cliente.getEmail_cliente()));
            lstP.add(new Parametro(6, cliente.getNombre_empresa()));
            lstP.add(new Parametro(7, cliente.getRuc_cliente()));
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
    
     public static boolean actualizar(Cliente cliente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from candelaria.f_update_cliente(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, cliente.getId_cliente()));
            lstP.add(new Parametro(2, cliente.getNombres_cliente()));
            lstP.add(new Parametro(3, cliente.getApellidos_cliente()));
            lstP.add(new Parametro(4, cliente.getDireccion_cliente()));
            lstP.add(new Parametro(5, cliente.getTelefono_cliente()));
            lstP.add(new Parametro(6, cliente.getEmail_cliente()));
            lstP.add(new Parametro(7, cliente.getNombre_empresa()));
            lstP.add(new Parametro(8, cliente.getRuc_cliente()));
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
        String sql = "select * from candelaria.f_delete_cliente(?)";
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
    
    
     public static ArrayList<Cliente> llenarCliente(ConjuntoResultado rs) throws Exception {
        ArrayList<Cliente> lst = new ArrayList<Cliente>();
        Cliente cliente = null;
        try {
            while (rs.next()) {
                cliente = new Cliente(rs.getInt("pid_cliente"), rs.getString("pnombre_cliente"), rs.getString("papellidos_cliente"), 
                        rs.getString("pdireccion_cliente"), rs.getString("ptelefono_cliente"),rs.getString("pemail_cliente"),
                        rs.getString("pnombre_empresa"),rs.getString("pruc_cliente"));
                lst.add(cliente);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Cliente> ObtenerClientes() throws Exception {
        ArrayList<Cliente> lst = new ArrayList<Cliente>();
        try {
            String sql = "select * from master.f_select_cliente()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCliente(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Cliente ObtenerClienteDadoCodigo(int codigo) throws Exception {
        Cliente lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_estudiante_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Cliente();
            lst = llenarCliente(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
