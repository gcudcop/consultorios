/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import juridico.entidades.clases.Victima;
import juridico.entidades.funciones.FVictima;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class ControladorVictima {

    /**
     * Creates a new instance of ControladorVictima
     */
    private Victima objVictima;
    private Victima victimaSel;
    private ArrayList<Victima> lstVictimas;
    private boolean mostrarActualizar;
    private String sexo;
    private String etnia;
    private String estadoCivil;
    private String situacion;
    private String tiempoRelacion;
    private String edad;
    private String instruccion;
    private String ocupacion;
    private String trabajoRemunerado;
    private String hijosVarones;
    private String hijosMujeres;
    private String salarioMensual;
    private String vivienda;
    private String cedulaBusqueda;

    public String getCedulaBusqueda() {
        return cedulaBusqueda;
    }

    public void setCedulaBusqueda(String cedulaBusqueda) {
        this.cedulaBusqueda = cedulaBusqueda;
    }

    private int edadInt, hijosV, hijosM;
    private double salarioM;

    public int getEdadInt() {
        return edadInt;
    }

    public void setEdadInt(int edadInt) {
        this.edadInt = edadInt;
    }

    public int getHijosV() {
        return hijosV;
    }

    public void setHijosV(int hijosV) {
        this.hijosV = hijosV;
    }

    public int getHijosM() {
        return hijosM;
    }

    public void setHijosM(int hijosM) {
        this.hijosM = hijosM;
    }

    public double getSalarioM() {
        return salarioM;
    }

    public void setSalarioM(double salarioM) {
        this.salarioM = salarioM;
    }

    public String getHijosVarones() {
        return hijosVarones;
    }

    public void setHijosVarones(String hijosVarones) {
        this.hijosVarones = hijosVarones;
    }

    public String getHijosMujeres() {
        return hijosMujeres;
    }

    public void setHijosMujeres(String hijosMujeres) {
        this.hijosMujeres = hijosMujeres;
    }

    public String getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(String salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public String getVivienda() {
        return vivienda;
    }

    public void setVivienda(String vivienda) {
        this.vivienda = vivienda;
    }

    public String getTrabajoRemunerado() {
        return trabajoRemunerado;
    }

    public void setTrabajoRemunerado(String trabajoRemunerado) {
        this.trabajoRemunerado = trabajoRemunerado;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTiempoRelacion() {
        return tiempoRelacion;
    }

    public void setTiempoRelacion(String tiempoRelacion) {
        this.tiempoRelacion = tiempoRelacion;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Victima getObjVictima() {
        return objVictima;
    }

    public void setObjVictima(Victima objVictima) {
        this.objVictima = objVictima;
    }

    public Victima getVictimaSel() {
        return victimaSel;
    }

    public void setVictimaSel(Victima victimaSel) {
        this.victimaSel = victimaSel;
    }

    public ArrayList<Victima> getLstVictimas() {
        return lstVictimas;
    }

    public void setLstVictimas(ArrayList<Victima> lstVictimas) {
        this.lstVictimas = lstVictimas;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public ControladorVictima() {
        reinit();
    }

    private void reinit() {
        this.objVictima = new Victima();
        this.victimaSel = new Victima();
        this.lstVictimas = new ArrayList<Victima>();

        this.cargarVictima();

    }

    public void cargarVictima() {
        try {
            this.lstVictimas = FVictima.ObtenerVictimas();
            this.victimaSel = lstVictimas.get(0);
            System.out.println(lstVictimas.get(0).getId_victima());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarVictima dice: " + e.getMessage());
            System.out.println("private void cargarVictima dice: " + e.getMessage());
        }
    }

    public void obtenerVictimaDadoCedula() {
        try {
            this.lstVictimas = FVictima.ObtenerVictimaDadoCedula(cedulaBusqueda);
            this.victimaSel = lstVictimas.get(0);
            System.out.println(lstVictimas.get(0).getId_victima());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarVictimaDadoCedula dice: " + e.getMessage());
            System.out.println("private void cargarVictimaDadoCedula dice: " + e.getMessage());
        }
    }

    public void insertarVictima() {

        try {
            edadInt = Integer.valueOf(edad).intValue();
            hijosV = Integer.valueOf(hijosVarones).intValue();
            hijosM = Integer.valueOf(hijosMujeres).intValue();
            salarioM = Double.valueOf(salarioMensual).doubleValue();
//            hijosV=Integer.parseInt(hijosVarones);
//            hijosM=Integer.parseInt(hijosMujeres);
//            salarioM=Double.parseDouble(salarioMensual);

            objVictima.setSexo_victima(sexo);
            objVictima.setEtnia_victima(etnia);
            objVictima.setEstado_civil(estadoCivil);
            objVictima.setSituacion_relacion(situacion);
            objVictima.setTiempo_relacion(tiempoRelacion);
            objVictima.setInstruccion_victima(instruccion);
            objVictima.setOcupacion_victima(ocupacion);
            objVictima.setSituacion_vivienda(vivienda);
            objVictima.setTrabajo_remunerado(trabajoRemunerado);
            objVictima.setEdad_victima(edadInt);
            objVictima.setNum_hijos_varones(hijosV);
            objVictima.setNum_hijos_mujeres(hijosM);
            objVictima.setIngresos_mensuales(salarioM);

            if (FVictima.Insertar(objVictima)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaVictima.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarVictima dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarVictima dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarVictima dice: " + e.getMessage());
            System.out.println("private void insertarVictima dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarVictima() {
        try {

            if (FVictima.actualizar(victimaSel)) {
                victimaSel = new Victima();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarVictima.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarVictima dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarVictima dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarVictima dice: " + e.getMessage());
            System.out.println("private void actualizarVictima dice: " + e.getMessage());
        }
    }

    public void eliminarVictima() {
        try {
            if (FVictima.eliminar((int) victimaSel.getId_victima())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarVictima.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarVictima dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarVictima dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarVictima dice: " + e.getMessage());
            System.out.println("private void eliminarVictima dice: " + e.getMessage());
        }

    }

}
