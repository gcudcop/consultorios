/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import juridico.entidades.funciones.FDocente;
import master.logica.clases.UsuarioDocente;

/**
 *
 * @author servidor
 */
public class FUsuarioDocente {

    public static boolean insertar(UsuarioDocente usuarioDocente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_insert_usuario_docente(?,?)";
            lstP.add(new Parametro(1, usuarioDocente.getIdUsuario().getCodigo()));
            lstP.add(new Parametro(2, usuarioDocente.getIdDocente().getId_docente()));

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

    public static boolean actualizar(UsuarioDocente usuarioDocente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_update_usuario_docente(?,?,?)";
            lstP.add(new Parametro(1, usuarioDocente.getIdUsuario().getCodigo()));
            lstP.add(new Parametro(2, usuarioDocente.getIdDocente().getId_docente()));
            lstP.add(new Parametro(3, usuarioDocente.getCodigo()));

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

    public static ArrayList<UsuarioDocente> llenarUsuarioDocente(ConjuntoResultado rs) throws Exception {
        ArrayList<UsuarioDocente> lst = new ArrayList<UsuarioDocente>();
        UsuarioDocente udocente = null;
        try {
            while (rs.next()) {
                udocente = new UsuarioDocente(rs.getInt("pcodigo"),
                        FUsuario.ObtenerUsuarioDadoCodigo(rs.getLong("pcodigo_usuario")),
                        FDocente.ObtenerDocenteDadoCodigo(rs.getInt("pid_docente")));
                lst.add(udocente);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<UsuarioDocente> obtenerUsuarioDocente() throws Exception {
        ArrayList<UsuarioDocente> lst = new ArrayList<UsuarioDocente>();
        try {
            String sql = "select * from juridico.f_select_usuario_docente()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarUsuarioDocente(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static UsuarioDocente obtenerUsuarioDocenteDadoCodigo(int codigo) throws Exception {
        UsuarioDocente lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_usuario_docente_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new UsuarioDocente();
            lst = llenarUsuarioDocente(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static UsuarioDocente obtenerUsuarioDocenteDadoCodigoUsuario(long codigo) throws Exception {
        UsuarioDocente lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_usuario_docente_dado_codigo_usuario1(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new UsuarioDocente();
            lst = llenarUsuarioDocente(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
//=======
//

    public static UsuarioDocente obtenerUsuarioDocenteDadoCodigoDocente(long codigo) throws Exception {
        UsuarioDocente lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_usuario_docente_dado_codigo_docente(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new UsuarioDocente();
            lst = llenarUsuarioDocente(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
