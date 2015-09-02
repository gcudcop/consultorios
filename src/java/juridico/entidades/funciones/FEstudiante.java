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
import juridico.entidades.clases.Estudiante;
import master.logica.funciones.FEscuela;

/**
 *
 * @author Oscunach
 */
public class FEstudiante {

    public static ArrayList<Estudiante> llenarEstudiante(ConjuntoResultado rs) throws Exception {
        ArrayList<Estudiante> lst = new ArrayList<Estudiante>();
        Estudiante estudiante = null;
        try {
            while (rs.next()) {
                estudiante = new Estudiante(
                        rs.getInt("pid_estudiante"),
                        rs.getString("pnombres"),
                        rs.getString("papellidos"),
                        rs.getString("pidentificacion"),
                        rs.getString("psexo"),
                        rs.getDate("pfecha_nacimiento"),
                        FEscuela.ObtenerEscuelaDadoCodigo(rs.getInt("pid_escuela")),
                        rs.getInt("pnivel integer"),
                        rs.getDate("pfecha_ingreso date"),
                        rs.getDate("pfecha_salida date"),
                        rs.getInt("pestado integer"));
                lst.add(estudiante);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    /*
     obtener listado de estudiantes
     */
    public static ArrayList<Estudiante> obtenerEstudiantes() throws Exception {
        ArrayList<Estudiante> lst = new ArrayList<Estudiante>();
        try {
            String sql = "select * from juridico.f_select_estudiante()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEstudiante(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    /*
     *Insertar estudiante
     */
    public static boolean insertarEstudiante(Estudiante estudiante) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_insert_estudiante(?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, estudiante.getNombres()));
            lstP.add(new Parametro(2, estudiante.getApellidos()));
            lstP.add(new Parametro(3, estudiante.getIdentificacion()));
            lstP.add(new Parametro(4, estudiante.getSexo()));
            lstP.add(new Parametro(5, estudiante.getFecha_nacimiento()));
            lstP.add(new Parametro(6, estudiante.getId_escuela().getCodigo()));
            lstP.add(new Parametro(7, estudiante.getNivel()));
            lstP.add(new Parametro(8, estudiante.getFecha_ingreso()));
            lstP.add(new Parametro(9, estudiante.getFecha_salida()));
            lstP.add(new Parametro(10, estudiante.getEstado()));
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
     * Actualizar un estudiante
     */
    public static boolean actualizarEstudiante(Estudiante estudiante) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_update_estudiante(?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, estudiante.getNombres()));
            lstP.add(new Parametro(2, estudiante.getApellidos()));
            lstP.add(new Parametro(3, estudiante.getIdentificacion()));
            lstP.add(new Parametro(4, estudiante.getSexo()));
            lstP.add(new Parametro(5, estudiante.getFecha_nacimiento()));
            lstP.add(new Parametro(6, estudiante.getId_escuela().getCodigo()));
            lstP.add(new Parametro(7, estudiante.getNivel()));
            lstP.add(new Parametro(8, estudiante.getFecha_ingreso()));
            lstP.add(new Parametro(9, estudiante.getFecha_salida()));
            lstP.add(new Parametro(10, estudiante.getEstado()));
            lstP.add(new Parametro(11, estudiante.getId_estudiante()));
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
