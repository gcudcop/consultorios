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
import juridico.entidades.clases.Victima;

/**
 *
 * @author servidor
 */
public class FVictima {

    public static boolean Insertar(Victima victima) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_insert_victima(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, victima.getApellidos_victima()));
            lstP.add(new Parametro(2, victima.getNombres_victima()));
            lstP.add(new Parametro(3, victima.getCi_identidad()));
            lstP.add(new Parametro(4, victima.getEdad_victima()));
            lstP.add(new Parametro(5, victima.getSexo_victima()));
            lstP.add(new Parametro(6, victima.getEtnia_victima()));
            lstP.add(new Parametro(7, victima.getEstado_civil()));
            lstP.add(new Parametro(8, victima.getSituacion_relacion()));
            lstP.add(new Parametro(9, victima.getTiempo_relacion()));
            lstP.add(new Parametro(10, victima.getInstruccion_victima()));

            lstP.add(new Parametro(11, victima.getOcupacion_victima()));
            lstP.add(new Parametro(12, victima.getTrabajo_remunerado()));
            lstP.add(new Parametro(13, victima.getIngresos_mensuales()));
            lstP.add(new Parametro(14, victima.getDireccion_domicilio()));
            lstP.add(new Parametro(15, victima.getNum_telefonico_domicilio()));
            lstP.add(new Parametro(16, victima.getSituacion_vivienda()));
            lstP.add(new Parametro(17, victima.getDireccion_trabajo()));
            lstP.add(new Parametro(18, victima.getNum_telefonico_trabajo()));
            lstP.add(new Parametro(19, victima.getNum_hijos_varones()));
            lstP.add(new Parametro(20, victima.getNum_hijos_mujeres()));
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

    public static boolean actualizar(Victima victima) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_update_victima(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, victima.getApellidos_victima()));
            lstP.add(new Parametro(2, victima.getNombres_victima()));
            lstP.add(new Parametro(3, victima.getCi_identidad()));
            lstP.add(new Parametro(4, victima.getEdad_victima()));
            lstP.add(new Parametro(5, victima.getSexo_victima()));
            lstP.add(new Parametro(6, victima.getEtnia_victima()));
            lstP.add(new Parametro(7, victima.getEstado_civil()));
            lstP.add(new Parametro(8, victima.getSituacion_relacion()));
            lstP.add(new Parametro(9, victima.getTiempo_relacion()));
            lstP.add(new Parametro(10, victima.getInstruccion_victima()));

            lstP.add(new Parametro(11, victima.getOcupacion_victima()));
            lstP.add(new Parametro(12, victima.getTrabajo_remunerado()));
            lstP.add(new Parametro(13, victima.getIngresos_mensuales()));
            lstP.add(new Parametro(14, victima.getDireccion_domicilio()));
            lstP.add(new Parametro(15, victima.getNum_telefonico_domicilio()));
            lstP.add(new Parametro(16, victima.getSituacion_vivienda()));
            lstP.add(new Parametro(17, victima.getDireccion_trabajo()));
            lstP.add(new Parametro(18, victima.getNum_telefonico_trabajo()));
            lstP.add(new Parametro(19, victima.getNum_hijos_varones()));
            lstP.add(new Parametro(20, victima.getNum_hijos_mujeres()));
            lstP.add(new Parametro(21, victima.getId_victima()));

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
            String sql = "select * from juridico.f_delete_victima(?)";
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

    public static ArrayList<Victima> llenarVictima(ConjuntoResultado rs) throws Exception {
        ArrayList<Victima> lst = new ArrayList<Victima>();
        Victima victima = null;
        try {
            while (rs.next()) {
                victima = new Victima(rs.getInt("pid_victima"), rs.getString("papellidos_victima"), rs.getString("pnombres_victima"),
                        rs.getString("pci_identidad"), rs.getInt("pedad_victima"), rs.getString("psexo_victima"), rs.getString("petnia_victima"),
                        rs.getString("pestado_civil"), rs.getString("psituacion_relacion"), rs.getString("ptiempo_relacion"),
                        rs.getString("pinstruccion_victima"), rs.getString("pocupacion_victima"), rs.getString("ptrabajo_remunerado"),
                        rs.getDouble("pingresos_mensuales"), rs.getString("pdireccion_domicilio"), rs.getString("pnum_telefonico_domicilio"),
                        rs.getString("psituacion_vivienda"), rs.getString("pdireccion_trabajo"), rs.getString("pnum_teelefonico_trabajo"),
                        rs.getInt("pnum_hijos_varones"), rs.getInt("pnum_hijos_mujeres"));
                lst.add(victima);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Victima> ObtenerVictimas() throws Exception {
        ArrayList<Victima> lst = new ArrayList<Victima>();
        try {
            String sql = "select * from juridico.f_select_victima()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarVictima(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Victima ObtenerVictimaDadoCodigo(int codigo) throws Exception {
        Victima lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from juridico.f_select_victima_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Victima();
            lst = llenarVictima(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
