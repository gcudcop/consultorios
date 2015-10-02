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
import juridico.entidades.clases.EstudianteUsuario;
import master.logica.funciones.FUsuario;

/**
 *
 * @author Oscunach
 */
public class FEstudianteUsuario {

    public static ArrayList<EstudianteUsuario> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<EstudianteUsuario> lst = new ArrayList<EstudianteUsuario>();
        EstudianteUsuario est = null;
        try {
            while (rs.next()) {
                est = new EstudianteUsuario(
                        rs.getInt("pid_usuario_estudiante"),
                        FEstudiante.ObtenerEstudianteDadoCodigo(rs.getInt("pid_estudiante")),
                        FUsuario.ObtenerUsuarioDadoCodigo(rs.getInt("pid_usuario"))
                );
                lst.add(est);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<EstudianteUsuario> obtenerUsuariosEstudiantes() throws Exception {
        ArrayList<EstudianteUsuario> lst = new ArrayList<EstudianteUsuario>();
        try {
            String sql = "select * from juridico.f_select_estudiante()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean insertarUsuariosEstudiante(EstudianteUsuario estUser) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_insert_usuarios_estudiante(?,?)";
            lstP.add(new Parametro(1, estUser.getId_estudiante().getId_estudiante()));
            lstP.add(new Parametro(2, estUser.getId_usuario().getCodigo()));
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

    public static boolean actualizarEstudiante(EstudianteUsuario estUser) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_update_usuarios_estudiante(?,?,?)";
            lstP.add(new Parametro(1, estUser.getId_usuario_estudiante()));
            lstP.add(new Parametro(2, estUser.getId_estudiante().getId_estudiante()));
            lstP.add(new Parametro(3, estUser.getId_usuario().getCodigo()));
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

    public static boolean eliminarUsuariosEstudiante(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_delete_usuarios_estudiante(?)";
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
    
    
    
    
}
