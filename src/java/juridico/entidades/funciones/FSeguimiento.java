/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.entidades.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import juridico.entidades.clases.Seguimiento;

/**
 *
 * @author servidor
 */
public class FSeguimiento {
    
    public static ArrayList<Seguimiento> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Seguimiento> lst = new ArrayList<Seguimiento>();
        Seguimiento seguimiento = null;
        try {
            while (rs.next()) {
                seguimiento = new Seguimiento(rs.getInt("pid_seguimiento"),rs.getString("pdescripcion"),
                rs.getDate("pfecha_inicio"),rs.getDate("pfecha_fin"),rs.getInt("pestado"),
                        FCaso.ObtenerCasoDadoId(rs.getInt("pid_caso")),rs.getString("ppath"),
                rs.getString("pdependencia"),rs.getString("presponsable_dependencia"),FDocente.ObtenerDocenteDadoCodigo(rs.getInt("pid_docente")),
                FEstudiante.ObtenerEstudianteDadoCodigo(rs.getInt("pid_estudiante")));
                
                
                lst.add(seguimiento);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Seguimiento> obtenerSeguimientos() throws Exception {
        ArrayList<Seguimiento> lst = new ArrayList<Seguimiento>();
        try {
            String sql = "select * from juridico.f_select_seguimiento()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Seguimiento ObtenerSeguimientoDadoId(int id) throws Exception {
        Seguimiento lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_seguimiento_dado_codigo(?)";
            lstP.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Seguimiento();
            lst = llenarDatos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean eliminarSeguimiento(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_delete_seguimiento(?)";
            lstP.add(new Parametro(1, codigo));
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

    /*
     * Insertar seguimientos
     */
    public static boolean insertarSeguimiento(Seguimiento seguimiento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_insert_seguimiento(?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, seguimiento.getDescripcion()));
            lstP.add(new Parametro(2, seguimiento.getFecha_inicio()));
            lstP.add(new Parametro(3, seguimiento.getFecha_fin()));
            lstP.add(new Parametro(4, seguimiento.getEstado()));
            lstP.add(new Parametro(5, seguimiento.getId_caso().getId_caso()));
            lstP.add(new Parametro(6, seguimiento.getPath()));
            lstP.add(new Parametro(7, seguimiento.getDependencia()));
            lstP.add(new Parametro(8, seguimiento.getResponsable_dependencia()));
            lstP.add(new Parametro(9, seguimiento.getId_docente().getId_docente()));
            lstP.add(new Parametro(10, seguimiento.getId_estudiante().getId_estudiante()));
            
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

    /*
     ** Actualizar Seguimiento
     */
    public static boolean actualizarSeguimiento(Seguimiento seguimiento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_update_seguimiento(?,?,?,?,?,?,?,?,?,?,?)";
           lstP.add(new Parametro(1, seguimiento.getDescripcion()));
            lstP.add(new Parametro(2, seguimiento.getFecha_inicio()));
            lstP.add(new Parametro(3, seguimiento.getFecha_fin()));
            lstP.add(new Parametro(4, seguimiento.getEstado()));
            lstP.add(new Parametro(5, seguimiento.getId_caso().getId_caso()));
            lstP.add(new Parametro(6, seguimiento.getPath()));
            lstP.add(new Parametro(7, seguimiento.getDependencia()));
            lstP.add(new Parametro(8, seguimiento.getResponsable_dependencia()));
            lstP.add(new Parametro(9, seguimiento.getId_docente().getId_docente()));
            lstP.add(new Parametro(10, seguimiento.getId_estudiante().getId_estudiante()));
            lstP.add(new Parametro(11, seguimiento.getId_seguimiento()));

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
    
    public static Seguimiento obtenerSeguimientoDadoIdCaso(int id) throws Exception {
        Seguimiento lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_seguimiento_dado_codigo_caso(?)";
            lstP.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Seguimiento();
            lst = llenarDatos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static ArrayList<Seguimiento> obtenerLstSeguimientoDadoCodigoCaso(int codigo) throws Exception {
        ArrayList<Seguimiento> lst = new ArrayList<Seguimiento>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_seguimiento_dado_codigo_caso(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
}
