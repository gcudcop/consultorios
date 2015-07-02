/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.MateriaPrima;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Yolanda
 */
public class FMateriaPrima {
    public static boolean Insertar(MateriaPrima materiaprima) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_insert_materia_prima(?,?)";
            lstP.add(new Parametro(1, materiaprima.getNombre_MateriaPrima()));
            lstP.add(new Parametro(2, materiaprima.getCantidad_Materiaprima()));           
       
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
    
     public static boolean actualizar(MateriaPrima materiaprima) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_update_materia_prima(?,?,?)";
            lstP.add(new Parametro(1, materiaprima.getId_MateriaPrima()));
            lstP.add(new Parametro(2, materiaprima.getNombre_MateriaPrima()));
            lstP.add(new Parametro(3, materiaprima.getCantidad_Materiaprima()));
            
            
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
        String sql = "select * from sgflc.f_delete_materia_prima(?)";
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
    
    public static ArrayList<MateriaPrima> llenarMateriaPrima(ConjuntoResultado rs) throws Exception {
        ArrayList<MateriaPrima> lst = new ArrayList<MateriaPrima>();
        MateriaPrima materiaprima = null;
        try {
            while (rs.next()) {
                materiaprima = new MateriaPrima(rs.getInt("pid_materia_prima"), rs.getString("pnombre_materia_prima"), rs.getInt("pcantidad_materia_prima")
                        );
                lst.add(materiaprima);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<MateriaPrima> ObtenerMateriaPrima() throws Exception {
        ArrayList<MateriaPrima> lst = new ArrayList<MateriaPrima>();
        try {
            String sql = "select * from  sgflc.f_select_materia_prima()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarMateriaPrima(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static MateriaPrima ObtenerMateriaPrimaDadoCodigo(int codigo) throws Exception {
        MateriaPrima lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_materia_prima_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new MateriaPrima();
            lst = llenarMateriaPrima(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
}
