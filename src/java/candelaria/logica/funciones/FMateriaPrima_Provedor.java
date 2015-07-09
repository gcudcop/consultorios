/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.funciones;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import candelaria.logica.clases.MateriaPrima_Proveedor; 
import java.sql.SQLException; 
import java.util.ArrayList;
/**
 *
 * @author Alexandra
 */
public class FMateriaPrima_Provedor {
    
     public static boolean Insertar(MateriaPrima_Proveedor materia_proveedor) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_insert_materia_proveedor(?,?,?,?)";
            lstP.add(new Parametro(1, materia_proveedor.getCodigoMateriaPrima().getId_MateriaPrima()));
            lstP.add(new Parametro(2,materia_proveedor.getCodigoProveedor().getId_proveedor()));
            lstP.add(new Parametro(3,  materia_proveedor.getFecha()));
            lstP.add(new Parametro(4,  materia_proveedor.getObsevaciones()));
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
    
     public static boolean actualizar(MateriaPrima_Proveedor materia_proveedor) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
           String sql = "select * from sgflc.f_insert_materia_proveedor(?,?,?,?)";
            lstP.add(new Parametro(1, materia_proveedor.getCodigoMateriaPrima().getId_MateriaPrima()));
            lstP.add(new Parametro(2,materia_proveedor.getCodigoProveedor().getId_proveedor()));
            lstP.add(new Parametro(3,  materia_proveedor.getFecha()));
            lstP.add(new Parametro(4,  materia_proveedor.getObsevaciones()));
            
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
        String sql = "select * from sgflc.f_delete_materia_proveedor(?)";
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
    
    
     public static ArrayList<MateriaPrima_Proveedor> llenarMateriaPrima_Proveedor(ConjuntoResultado rs) throws Exception {
        ArrayList<MateriaPrima_Proveedor> lst = new ArrayList<MateriaPrima_Proveedor>();
        MateriaPrima_Proveedor materia_proveedor= null;
        try {
            while (rs.next()) {
                materia_proveedor= new MateriaPrima_Proveedor(rs.getInt("pid_materia_proveedor"),
                        FProveedor.ObtenerProveedorDadoCodigo(rs.getInt("pid_proveedor")),
                        FMateriaPrima.ObtenerMateriaPrimaDadoCodigo(rs.getInt("pid_materia_prima")),rs.getDate("pfecha"),rs.getString("pobservacion"));
                lst.add(materia_proveedor);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<MateriaPrima_Proveedor> ObtenerMateriaPrima_Proveedor() throws Exception {
        ArrayList<MateriaPrima_Proveedor> lst = new ArrayList<MateriaPrima_Proveedor>();
        try {
            String sql = "select * from sgflc.f_select_materia_proveedor()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarMateriaPrima_Proveedor(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static MateriaPrima_Proveedor ObtenerMateriaPrima_ProveedorDadoCodigo(int codigo) throws Exception {
        MateriaPrima_Proveedor lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from sgflc.f_select_materia_proveedor_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new MateriaPrima_Proveedor();
            lst = llenarMateriaPrima_Proveedor(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
    

