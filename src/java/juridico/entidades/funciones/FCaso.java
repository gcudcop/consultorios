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
import juridico.entidades.clases.Caso;

/**
 *
 * @author Oscunach
 */
public class FCaso {

    public static ArrayList<Caso> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Caso> lst = new ArrayList<Caso>();
        Caso caso = null;
        try {
            while (rs.next()) {
                caso = new Caso(rs.getInt("pid_caso"),
                        rs.getDate("pfecha_inicio"),
                        rs.getString("pnumero_caso"),
                        rs.getString("pjuzgado"),
                        rs.getString("parea"),
                        FDocente.ObtenerDocenteDadoCodigo(rs.getInt("pid_docente")),
                        FEstudiante.ObtenerEstudianteDadoCodigo(rs.getInt("pid_estudiante")),
                        FVictima.ObtenerVictimaDadoCodigo(rs.getInt("pid_victima")),
                        FAgresor.ObtenerAgresorDadoCodigo(rs.getInt("pid_agresor")),
                        rs.getString("pdescripcion"),
                        rs.getString("pproblema_juridico"),
                        rs.getString("pobservaciones_tutor"),
                        rs.getString("pestado"));
                lst.add(caso);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Caso> obtenerCasos() throws Exception {
        ArrayList<Caso> lst = new ArrayList<Caso>();
        try {
            String sql = "select * from juridico.f_select_caso()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Caso ObtenerCasoDadoId(int id) throws Exception {
        Caso lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_caso_dado_codigo(?)";
            lstP.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Caso();
            lst = llenarDatos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean eliminarCaso(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_delete_caso(?)";
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
     * Insertar casos
     */
    public static boolean insertarCaso(Caso caso) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_insert_caso(?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, caso.getFecha_inicio()));
            lstP.add(new Parametro(2, caso.getNumero_caso()));
            lstP.add(new Parametro(3, caso.getJuzgado()));
            lstP.add(new Parametro(4, caso.getArea()));
            lstP.add(new Parametro(5, caso.getId_docente().getId_docente()));
            lstP.add(new Parametro(6, caso.getId_estudiante().getId_estudiante()));
            lstP.add(new Parametro(7, caso.getId_victima().getId_victima()));
            lstP.add(new Parametro(8, caso.getId_agresor().getId_agresor()));
            lstP.add(new Parametro(9, caso.getDescripcion()));
            lstP.add(new Parametro(10, caso.getProblema_juridico()));
            lstP.add(new Parametro(11, caso.getObservaciones_tutor()));
            lstP.add(new Parametro(12, caso.getEstado()));
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
     ** Actualizar Caso
     */
    public static boolean actualizarCaso(Caso caso) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_update_caso(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, caso.getFecha_inicio()));
            lstP.add(new Parametro(2, caso.getNumero_caso()));
            lstP.add(new Parametro(3, caso.getJuzgado()));
            lstP.add(new Parametro(4, caso.getArea()));
            lstP.add(new Parametro(5, caso.getId_docente().getId_docente()));
            lstP.add(new Parametro(6, caso.getId_estudiante().getId_estudiante()));
            lstP.add(new Parametro(7, caso.getId_victima().getId_victima()));
            lstP.add(new Parametro(8, caso.getId_agresor().getId_agresor()));
            lstP.add(new Parametro(9, caso.getDescripcion()));
            lstP.add(new Parametro(10, caso.getProblema_juridico()));
            lstP.add(new Parametro(11, caso.getObservaciones_tutor()));
            lstP.add(new Parametro(12, caso.getEstado()));
            lstP.add(new Parametro(13, caso.getId_caso()));

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

}
