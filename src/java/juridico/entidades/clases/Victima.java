/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.entidades.clases;

/**
 *
 * @author servidor
 */
public class Victima {

    private int id_victima;
    private String apellidos_victima;
    private String nombres_victima;
    private String ci_identidad;
    private int edad_victima;
    private String sexo_victima;
    private String etnia_victima;
    private String estado_civil;
    private String situacion_relacion;
    private String tiempo_relacion;
    private String instruccion_victima;
    private String ocupacion_victima;
    private String trabajo_remunerado;
    private double ingresos_mensuales;
    private String direccion_domicilio;
    private String num_telefonico_domicilio;
    private String situacion_vivienda;
    private String direccion_trabajo;
    private String num_telefonico_trabajo;
    private int num_hijos_varones;
    private int num_hijos_mujeres;

    public Victima() {
    }

    public Victima(int id_victima, String apellidos_victima, String nombres_victima, String ci_identidad, int edad_victima, String sexo_victima, String etnia_victima, String estado_civil, String situacion_relacion, String tiempo_relacion, String instruccion_victima, String ocupacion_victima, String trabajo_remunerado, double ingresos_mensuales, String direccion_domicilio, String num_telefonico_domicilio, String situacion_vivienda, String direccion_trabajo, String num_telefonico_trabajo, int num_hijos_varones, int num_hijos_mujeres) {
        this.id_victima = id_victima;
        this.apellidos_victima = apellidos_victima;
        this.nombres_victima = nombres_victima;
        this.ci_identidad = ci_identidad;
        this.edad_victima = edad_victima;
        this.sexo_victima = sexo_victima;
        this.etnia_victima = etnia_victima;
        this.estado_civil = estado_civil;
        this.situacion_relacion = situacion_relacion;
        this.tiempo_relacion = tiempo_relacion;
        this.instruccion_victima = instruccion_victima;
        this.ocupacion_victima = ocupacion_victima;
        this.trabajo_remunerado = trabajo_remunerado;
        this.ingresos_mensuales = ingresos_mensuales;
        this.direccion_domicilio = direccion_domicilio;
        this.num_telefonico_domicilio = num_telefonico_domicilio;
        this.situacion_vivienda = situacion_vivienda;
        this.direccion_trabajo = direccion_trabajo;
        this.num_telefonico_trabajo = num_telefonico_trabajo;
        this.num_hijos_varones = num_hijos_varones;
        this.num_hijos_mujeres = num_hijos_mujeres;
    }

    public int getId_victima() {
        return id_victima;
    }

    public void setId_victima(int id_victima) {
        this.id_victima = id_victima;
    }

    public String getApellidos_victima() {
        return apellidos_victima;
    }

    public void setApellidos_victima(String apellidos_victima) {
        this.apellidos_victima = apellidos_victima;
    }

    public String getNombres_victima() {
        return nombres_victima;
    }

    public void setNombres_victima(String nombres_victima) {
        this.nombres_victima = nombres_victima;
    }

    public String getCi_identidad() {
        return ci_identidad;
    }

    public void setCi_identidad(String ci_identidad) {
        this.ci_identidad = ci_identidad;
    }

    public int getEdad_victima() {
        return edad_victima;
    }

    public void setEdad_victima(int edad_victima) {
        this.edad_victima = edad_victima;
    }

    public String getSexo_victima() {
        return sexo_victima;
    }

    public void setSexo_victima(String sexo_victima) {
        this.sexo_victima = sexo_victima;
    }

    public String getEtnia_victima() {
        return etnia_victima;
    }

    public void setEtnia_victima(String etnia_victima) {
        this.etnia_victima = etnia_victima;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getSituacion_relacion() {
        return situacion_relacion;
    }

    public void setSituacion_relacion(String situacion_relacion) {
        this.situacion_relacion = situacion_relacion;
    }

    public String getTiempo_relacion() {
        return tiempo_relacion;
    }

    public void setTiempo_relacion(String tiempo_relacion) {
        this.tiempo_relacion = tiempo_relacion;
    }

    public String getInstruccion_victima() {
        return instruccion_victima;
    }

    public void setInstruccion_victima(String instruccion_victima) {
        this.instruccion_victima = instruccion_victima;
    }

    public String getOcupacion_victima() {
        return ocupacion_victima;
    }

    public void setOcupacion_victima(String ocupacion_victima) {
        this.ocupacion_victima = ocupacion_victima;
    }

    public String getTrabajo_remunerado() {
        return trabajo_remunerado;
    }

    public void setTrabajo_remunerado(String trabajo_remunerado) {
        this.trabajo_remunerado = trabajo_remunerado;
    }

    public double getIngresos_mensuales() {
        return ingresos_mensuales;
    }

    public void setIngresos_mensuales(double ingresos_mensuales) {
        this.ingresos_mensuales = ingresos_mensuales;
    }

    public String getDireccion_domicilio() {
        return direccion_domicilio;
    }

    public void setDireccion_domicilio(String direccion_domicilio) {
        this.direccion_domicilio = direccion_domicilio;
    }

    public String getNum_telefonico_domicilio() {
        return num_telefonico_domicilio;
    }

    public void setNum_telefonico_domicilio(String num_telefonico_domicilio) {
        this.num_telefonico_domicilio = num_telefonico_domicilio;
    }

    public String getSituacion_vivienda() {
        return situacion_vivienda;
    }

    public void setSituacion_vivienda(String situacion_vivienda) {
        this.situacion_vivienda = situacion_vivienda;
    }

    public String getDireccion_trabajo() {
        return direccion_trabajo;
    }

    public void setDireccion_trabajo(String direccion_trabajo) {
        this.direccion_trabajo = direccion_trabajo;
    }

    public String getNum_telefonico_trabajo() {
        return num_telefonico_trabajo;
    }

    public void setNum_telefonico_trabajo(String num_telefonico_trabajo) {
        this.num_telefonico_trabajo = num_telefonico_trabajo;
    }

    public int getNum_hijos_varones() {
        return num_hijos_varones;
    }

    public void setNum_hijos_varones(int num_hijos_varones) {
        this.num_hijos_varones = num_hijos_varones;
    }

    public int getNum_hijos_mujeres() {
        return num_hijos_mujeres;
    }

    public void setNum_hijos_mujeres(int num_hijos_mujeres) {
        this.num_hijos_mujeres = num_hijos_mujeres;
    }

}
