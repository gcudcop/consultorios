/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import juridico.entidades.clases.Agresor;
import juridico.entidades.funciones.FAgresor;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class AgresorBeans {

    /**
     * Creates a new instance of AgresorBeans
     */
    private Agresor objAgresor;
    private Agresor agresorSel;
    private ArrayList<Agresor> lstAgresores;
    private boolean mostrarActualizar;
    private String sexo;
    private String etnia;
    private String estadoCivil;
    private String edad;
    private String instruccion;
    private String ocupacion;
    private String trabajoRemunerado;
    private String salarioMensual;

    private int edadInt;
    private double salarioM;

    public int getEdadInt() {
        return edadInt;
    }

    public void setEdadInt(int edadInt) {
        this.edadInt = edadInt;
    }

    public double getSalarioM() {
        return salarioM;
    }

    public void setSalarioM(double salarioM) {
        this.salarioM = salarioM;
    }

    public Agresor getObjAgresor() {
        return objAgresor;
    }

    public void setObjAgresor(Agresor objAgresor) {
        this.objAgresor = objAgresor;
    }

    public Agresor getAgresorSel() {
        return agresorSel;
    }

    public void setAgresorSel(Agresor agresorSel) {
        this.agresorSel = agresorSel;
    }

    public ArrayList<Agresor> getLstAgresores() {
        return lstAgresores;
    }

    public void setLstAgresores(ArrayList<Agresor> lstAgresores) {
        this.lstAgresores = lstAgresores;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTrabajoRemunerado() {
        return trabajoRemunerado;
    }

    public void setTrabajoRemunerado(String trabajoRemunerado) {
        this.trabajoRemunerado = trabajoRemunerado;
    }

    public String getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(String salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public AgresorBeans() {
        reinit();
    }

    private void reinit() {
        this.objAgresor = new Agresor();
        this.agresorSel = new Agresor();
        this.lstAgresores = new ArrayList<Agresor>();

        this.cargarAgresor();

    }

    public void cargarAgresor() {
        try {
            this.lstAgresores = FAgresor.ObtenerAgresors();
            this.agresorSel = lstAgresores.get(0);
            System.out.println(lstAgresores.get(0).getId_agresor());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarAgresor dice: " + e.getMessage());
            System.out.println("private void cargarAgresor dice: " + e.getMessage());
        }
    }

    public void insertarAgresor() {

        try {
            edadInt = Integer.valueOf(edad).intValue();

            salarioM = Double.valueOf(salarioMensual).doubleValue();
//            hijosV=Integer.parseInt(hijosVarones);
//            hijosM=Integer.parseInt(hijosMujeres);
//            salarioM=Double.parseDouble(salarioMensual);

            objAgresor.setSexo_agresor(sexo);
            objAgresor.setEtnia_agresor(etnia);
            objAgresor.setEstado_civil(estadoCivil);

            objAgresor.setInstruccion_agresor(instruccion);
            objAgresor.setOcupacion_agresor(ocupacion);

            objAgresor.setTrabajo_remunerado(trabajoRemunerado);
            objAgresor.setEdad_agresor(edadInt);
            objAgresor.setIngresos_mensuales(salarioM);

            if (FAgresor.Insertar(objAgresor)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoAgresor.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarAgresor dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarAgresor dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarAgresor dice: " + e.getMessage());
            System.out.println("private void insertarAgresor dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarAgresor() {
        try {

            if (FAgresor.actualizar(agresorSel)) {
                agresorSel = new Agresor();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarAgresor.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarAgresor dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarAgresor dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarAgresor dice: " + e.getMessage());
            System.out.println("private void actualizarAgresor dice: " + e.getMessage());
        }
    }

    public void eliminarAgresor() {
        try {
            if (FAgresor.eliminar((int) agresorSel.getId_agresor())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarAgresor.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarAgresor dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarAgresor dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarAgresor dice: " + e.getMessage());
            System.out.println("private void eliminarAgresor dice: " + e.getMessage());
        }

    }

}
