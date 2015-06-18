/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.clases;

/**
 *
 * @author Usuario
 */
public class Control_Queso {

    private int id_control_queso;
    private Producto id_producto;
    private String corteza_queso;
    private String olor_queso;
    private String sabor_queso;
    private String elasticidad_queso;
    private String masticabilidad_queso;
    private String acidez_queso;
    private String calidad_global;

    public Control_Queso() {
    }

    public Control_Queso(int id_control_queso, Producto id_producto, String corteza_queso, String olor_queso, String sabor_queso, String elasticidad_queso, String masticabilidad_queso, String acidez_queso, String calidad_global) {
        this.id_control_queso = id_control_queso;
        this.id_producto = id_producto;
        this.corteza_queso = corteza_queso;
        this.olor_queso = olor_queso;
        this.sabor_queso = sabor_queso;
        this.elasticidad_queso = elasticidad_queso;
        this.masticabilidad_queso = masticabilidad_queso;
        this.acidez_queso = acidez_queso;
        this.calidad_global = calidad_global;
    }

    public int getId_control_queso() {
        return id_control_queso;
    }

    public void setId_control_queso(int id_control_queso) {
        this.id_control_queso = id_control_queso;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public String getCorteza_queso() {
        return corteza_queso;
    }

    public void setCorteza_queso(String corteza_queso) {
        this.corteza_queso = corteza_queso;
    }

    public String getOlor_queso() {
        return olor_queso;
    }

    public void setOlor_queso(String olor_queso) {
        this.olor_queso = olor_queso;
    }

    public String getSabor_queso() {
        return sabor_queso;
    }

    public void setSabor_queso(String sabor_queso) {
        this.sabor_queso = sabor_queso;
    }

    public String getElasticidad_queso() {
        return elasticidad_queso;
    }

    public void setElasticidad_queso(String elasticidad_queso) {
        this.elasticidad_queso = elasticidad_queso;
    }

    public String getMasticabilidad_queso() {
        return masticabilidad_queso;
    }

    public void setMasticabilidad_queso(String masticabilidad_queso) {
        this.masticabilidad_queso = masticabilidad_queso;
    }

    public String getAcidez_queso() {
        return acidez_queso;
    }

    public void setAcidez_queso(String acidez_queso) {
        this.acidez_queso = acidez_queso;
    }

    public String getCalidad_global() {
        return calidad_global;
    }

    public void setCalidad_global(String calidad_global) {
        this.calidad_global = calidad_global;
    }

    
}
