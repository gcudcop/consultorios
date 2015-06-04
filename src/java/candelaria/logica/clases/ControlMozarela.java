/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.clases;

/**
 *
 * @author ROGES
 */
public class ControlMozarela {
  private Integer id_control_mozarela;
  private Integer id_producto;
  private String ph_mozarela;
  private String humedad_mozarela;
  private String cenizas_mozarela;
  private Double grasas_mozarela;
  private Double proteinas_mozarela;
  private Double solidos_totales;
  private Double rendimiento_mozarela;

    public ControlMozarela() {
            }

    public ControlMozarela(Integer id_control_mozarela, Integer id_producto, String ph_mozarela, String humedad_mozarela, String cenizas_mozarela, Double grasas_mozarela, Double proteinas_mozarela, Double solidos_totales, Double rendimiento_mozarela) {
        this.id_control_mozarela = id_control_mozarela;
        this.id_producto = id_producto;
        this.ph_mozarela = ph_mozarela;
        this.humedad_mozarela = humedad_mozarela;
        this.cenizas_mozarela = cenizas_mozarela;
        this.grasas_mozarela = grasas_mozarela;
        this.proteinas_mozarela = proteinas_mozarela;
        this.solidos_totales = solidos_totales;
        this.rendimiento_mozarela = rendimiento_mozarela;
    }

    public Integer getId_control_mozarela() {
        return id_control_mozarela;
    }

    public void setId_control_mozarela(Integer id_control_mozarela) {
        this.id_control_mozarela = id_control_mozarela;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getPh_mozarela() {
        return ph_mozarela;
    }

    public void setPh_mozarela(String ph_mozarela) {
        this.ph_mozarela = ph_mozarela;
    }

    public String getHumedad_mozarela() {
        return humedad_mozarela;
    }

    public void setHumedad_mozarela(String humedad_mozarela) {
        this.humedad_mozarela = humedad_mozarela;
    }

    public String getCenizas_mozarela() {
        return cenizas_mozarela;
    }

    public void setCenizas_mozarela(String cenizas_mozarela) {
        this.cenizas_mozarela = cenizas_mozarela;
    }

    public Double getGrasas_mozarela() {
        return grasas_mozarela;
    }

    public void setGrasas_mozarela(Double grasas_mozarela) {
        this.grasas_mozarela = grasas_mozarela;
    }

    public Double getProteinas_mozarela() {
        return proteinas_mozarela;
    }

    public void setProteinas_mozarela(Double proteinas_mozarela) {
        this.proteinas_mozarela = proteinas_mozarela;
    }

    public Double getSolidos_totales() {
        return solidos_totales;
    }

    public void setSolidos_totales(Double solidos_totales) {
        this.solidos_totales = solidos_totales;
    }

    public Double getRendimiento_mozarela() {
        return rendimiento_mozarela;
    }

    public void setRendimiento_mozarela(Double rendimiento_mozarela) {
        this.rendimiento_mozarela = rendimiento_mozarela;
    }
    
    
  
}
