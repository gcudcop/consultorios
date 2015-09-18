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
import juridico.entidades.clases.Agresor;

/**
 *
 * @author servidor
 */
public class FAgresor {
    
    public static boolean Insertar(Agresor agresor) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_insert_agresor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, agresor.getApellidos_agresor()));
            lstP.add(new Parametro(2, agresor.getNombres_agresor()));
            lstP.add(new Parametro(3, agresor.getCi_identidad()));
            lstP.add(new Parametro(4, agresor.getEdad_agresor()));
            lstP.add(new Parametro(5, agresor.getSexo_agresor()));
            lstP.add(new Parametro(6, agresor.getEtnia_agresor()));
            lstP.add(new Parametro(7, agresor.getEstado_civil()));           
            lstP.add(new Parametro(8, agresor.getInstruccion_agresor()));
            lstP.add(new Parametro(9, agresor.getOcupacion_agresor()));
            lstP.add(new Parametro(10, agresor.getTrabajo_remunerado()));
            lstP.add(new Parametro(11, agresor.getIngresos_mensuales()));
            lstP.add(new Parametro(12, agresor.getDireccion_domicilio()));
            lstP.add(new Parametro(13, agresor.getNum_telefonico_domicilio()));            
            lstP.add(new Parametro(14, agresor.getDireccion_trabajo()));
            lstP.add(new Parametro(15, agresor.getNum_telefonico_trabajo()));
           
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

    public static boolean actualizar(Agresor agresor) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_update_agresor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, agresor.getApellidos_agresor()));
            lstP.add(new Parametro(2, agresor.getNombres_agresor()));
            lstP.add(new Parametro(3, agresor.getCi_identidad()));
            lstP.add(new Parametro(4, agresor.getEdad_agresor()));
            lstP.add(new Parametro(5, agresor.getSexo_agresor()));
            lstP.add(new Parametro(6, agresor.getEtnia_agresor()));
            lstP.add(new Parametro(7, agresor.getEstado_civil()));           
            lstP.add(new Parametro(8, agresor.getInstruccion_agresor()));
            lstP.add(new Parametro(9, agresor.getOcupacion_agresor()));
            lstP.add(new Parametro(10, agresor.getTrabajo_remunerado()));
            lstP.add(new Parametro(11, agresor.getIngresos_mensuales()));
            lstP.add(new Parametro(12, agresor.getDireccion_domicilio()));
            lstP.add(new Parametro(13, agresor.getNum_telefonico_domicilio()));            
            lstP.add(new Parametro(14, agresor.getDireccion_trabajo()));
            lstP.add(new Parametro(15, agresor.getNum_telefonico_trabajo()));            
            lstP.add(new Parametro(16, agresor.getId_agresor()));

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
            String sql = "select * from juridico.f_delete_agresor(?)";
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

    public static ArrayList<Agresor> llenarAgresor(ConjuntoResultado rs) throws Exception {
        ArrayList<Agresor> lst = new ArrayList<Agresor>();
        Agresor agresor = null;
        try {
            while (rs.next()) {
                agresor = new Agresor(rs.getInt("pid_agresor"), rs.getString("papellidos_agresor"), rs.getString("pnombres_agresor"),
                        rs.getString("pci_identidad"), rs.getInt("pedad_agresor"), rs.getString("psexo_agresor"), rs.getString("petnia_agresor"),
                        rs.getString("pestado_civil"), rs.getString("pinstruccion_agresor"), rs.getString("pocupacion_agresor"), 
                        rs.getString("ptrabajo_remunerado"),
                        rs.getDouble("pingresos_mensuales"), rs.getString("pdireccion_domicilio"), rs.getString("pnum_telefonico_domicilio"),
                        rs.getString("pdireccion_trabajo"), rs.getString("pnum_teelefonico_trabajo"));
                lst.add(agresor);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Agresor> ObtenerAgresors() throws Exception {
        ArrayList<Agresor> lst = new ArrayList<Agresor>();
        try {
            String sql = "select * from juridico.f_select_agresor()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarAgresor(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Agresor ObtenerAgresorDadoCodigo(int codigo) throws Exception {
        Agresor lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_agresor_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Agresor();
            lst = llenarAgresor(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Agresor> obtenerAgresorDadoCedula(String cedula) throws Exception {
        ArrayList<Agresor> lst = new ArrayList<Agresor>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_agresor_dado_cedula(?)";
            lstP.add(new Parametro(1, cedula));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarAgresor(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
}
