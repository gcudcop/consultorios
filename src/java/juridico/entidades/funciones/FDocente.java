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
import juridico.entidades.clases.Docente;
import master.logica.funciones.FEscuela;
import master.logica.funciones.FFacultad;

/**
 *
 * @author servidor
 */
public class FDocente {
    
    public static boolean Insertar(Docente docente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_insert_docente(?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, docente.getNombres()));
            lstP.add(new Parametro(2, docente.getApellidos()));
            lstP.add(new Parametro(3, docente.getIdentificacion()));
            lstP.add(new Parametro(4, docente.getSexo()));
            lstP.add(new Parametro(5, docente.getTercer_nivel()));
            lstP.add(new Parametro(6, docente.getCuarto_nivel()));
            lstP.add(new Parametro(7, docente.getId_escuela().getCodigo()));
            lstP.add(new Parametro(8, docente.getFecha_ingreso()));
            lstP.add(new Parametro(9, docente.getFecha_salida()));
            lstP.add(new Parametro(10, docente.getEstado()));
            lstP.add(new Parametro(11, docente.getId_facultad().getCodigo()));

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

    public static boolean actualizar(Docente docente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_update_docente(?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, docente.getNombres()));
            lstP.add(new Parametro(2, docente.getApellidos()));
            lstP.add(new Parametro(3, docente.getIdentificacion()));
            lstP.add(new Parametro(4, docente.getSexo()));
            lstP.add(new Parametro(5, docente.getTercer_nivel()));
            lstP.add(new Parametro(6, docente.getCuarto_nivel()));
            lstP.add(new Parametro(7, docente.getId_escuela().getCodigo()));
            lstP.add(new Parametro(8, docente.getFecha_ingreso()));
            lstP.add(new Parametro(9, docente.getFecha_salida()));
            lstP.add(new Parametro(10, docente.getEstado()));
            lstP.add(new Parametro(11, docente.getId_facultad().getCodigo()));
            lstP.add(new Parametro(12, docente.getId_docente()));            

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

    public static boolean eliminar(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_delete_docente(?)";
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

    public static ArrayList<Docente> llenarDocente(ConjuntoResultado rs) throws Exception {
        ArrayList<Docente> lst = new ArrayList<Docente>();
        Docente docente = null;
        try {
            while (rs.next()) {
                docente = new Docente(rs.getInt("pid_docente"),rs.getString("pnombres"),rs.getString("papellidos"),
                rs.getString("pidentificacion"),rs.getString("psexo"),rs.getString("ptercer_nivel"),rs.getString("pcuarto_nivel"),
                FEscuela.ObtenerEscuelaDadoCodigo(rs.getInt("pid_escuela")),rs.getDate("pfecha_ingreso"),rs.getDate("pfecha_salida"),
                rs.getInt("pestado"),FFacultad.ObtenerFacultadDadoCodigo(rs.getInt("pid_facultad")));
                                
                lst.add(docente);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Docente> ObtenerDocentes() throws Exception {
        ArrayList<Docente> lst = new ArrayList<Docente>();
        try {
            String sql = "select * from juridico.f_select_docente()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDocente(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Docente ObtenerDocenteDadoCodigo(int codigo) throws Exception {
        Docente lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_docente_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Docente();
            lst = llenarDocente(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Docente> ObtenerDocenteDadoCedula(String cedula) throws Exception {
        ArrayList<Docente> lst= new ArrayList<Docente>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_docente_dado_identificacion(?)";
            lstP.add(new Parametro(1, cedula));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            //lst = new Docente();
            lst = llenarDocente(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    
}
