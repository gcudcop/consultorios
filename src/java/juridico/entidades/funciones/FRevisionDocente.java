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
import juridico.entidades.clases.RevisionDocente;

/**
 *
 * @author Oscunach
 */
public class FRevisionDocente {

    public static ArrayList<RevisionDocente> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<RevisionDocente> lst = new ArrayList<RevisionDocente>();
        RevisionDocente revisionDocente = null;
        try {
            while (rs.next()) {
                revisionDocente = new RevisionDocente(rs.getInt("pid_revision"),
                        rs.getDate("pfecha_revision"),
                        rs.getString("pobservaciones"),
                        rs.getString("pestado_seguimiento"),
                        FSeguimiento.ObtenerSeguimientoDadoId(rs.getInt("pid_seguimiento")),
                        FDocente.ObtenerDocenteDadoCodigo(rs.getInt("pid_docente"))
                );
                lst.add(revisionDocente);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<RevisionDocente> obtenerRevisiones() throws Exception {
        ArrayList<RevisionDocente> lst = new ArrayList<RevisionDocente>();
        try {
            String sql = "select * from juridico.f_select_revision()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    public static boolean insertarRevision(RevisionDocente revisionDocente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_insert_revision(?,?,?,?,?)";
            lstP.add(new Parametro(1,revisionDocente.getFecha_revision()));
            lstP.add(new Parametro(2, revisionDocente.getObservaciones()));
            lstP.add(new Parametro(3, revisionDocente.getEstado_seguimiento()));
            lstP.add(new Parametro(4, revisionDocente.getId_docente().getId_docente()));
            lstP.add(new Parametro(5, revisionDocente.getId_seguimiento().getId_seguimiento()));           
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
    
    public static boolean actualizarRevision(RevisionDocente revisionDocente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_update_revision(?,?,?,?,?,?)";
            lstP.add(new Parametro(1,revisionDocente.getFecha_revision()));
            lstP.add(new Parametro(2, revisionDocente.getObservaciones()));
            lstP.add(new Parametro(3, revisionDocente.getEstado_seguimiento()));
            lstP.add(new Parametro(4, revisionDocente.getId_docente().getId_docente()));
            lstP.add(new Parametro(5, revisionDocente.getId_seguimiento().getId_seguimiento()));           
            lstP.add(new Parametro(6, revisionDocente.getId_revision())); 
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
    
    public static boolean eliminarRevision(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_delete_revision(?)";
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
