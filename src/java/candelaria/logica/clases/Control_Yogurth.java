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
public class Control_Yogurth {
  private Integer id_control_yogurth;
  private Integer id_producto;
  private Double agua_yogurth;
  private Double proteinas_yogurth;
  private Double lipidos_yogurth;
  private Double glucidos_yogurth;
  private Double acidos_organicos;
  private Double cenizas_yogurth;
  private Double fibras_yogurth;
  private Double contenido_energetico;

    public Control_Yogurth() {
    }

    public Control_Yogurth(Integer id_control_yogurth, Integer id_producto, Double agua_yogurth, Double proteinas_yogurth, Double lipidos_yogurth, Double glucidos_yogurth, Double acidos_organicos, Double cenizas_yogurth, Double fibras_yogurth, Double contenido_energetico) {
        this.id_control_yogurth = id_control_yogurth;
        this.id_producto = id_producto;
        this.agua_yogurth = agua_yogurth;
        this.proteinas_yogurth = proteinas_yogurth;
        this.lipidos_yogurth = lipidos_yogurth;
        this.glucidos_yogurth = glucidos_yogurth;
        this.acidos_organicos = acidos_organicos;
        this.cenizas_yogurth = cenizas_yogurth;
        this.fibras_yogurth = fibras_yogurth;
        this.contenido_energetico = contenido_energetico;
    }

    public Integer getId_control_yogurth() {
        return id_control_yogurth;
    }

    public void setId_control_yogurth(Integer id_control_yogurth) {
        this.id_control_yogurth = id_control_yogurth;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Double getAgua_yogurth() {
        return agua_yogurth;
    }

    public void setAgua_yogurth(Double agua_yogurth) {
        this.agua_yogurth = agua_yogurth;
    }

    public Double getProteinas_yogurth() {
        return proteinas_yogurth;
    }

    public void setProteinas_yogurth(Double proteinas_yogurth) {
        this.proteinas_yogurth = proteinas_yogurth;
    }

    public Double getLipidos_yogurth() {
        return lipidos_yogurth;
    }

    public void setLipidos_yogurth(Double lipidos_yogurth) {
        this.lipidos_yogurth = lipidos_yogurth;
    }

    public Double getGlucidos_yogurth() {
        return glucidos_yogurth;
    }

    public void setGlucidos_yogurth(Double glucidos_yogurth) {
        this.glucidos_yogurth = glucidos_yogurth;
    }

    public Double getAcidos_organicos() {
        return acidos_organicos;
    }

    public void setAcidos_organicos(Double acidos_organicos) {
        this.acidos_organicos = acidos_organicos;
    }

    public Double getCenizas_yogurth() {
        return cenizas_yogurth;
    }

    public void setCenizas_yogurth(Double cenizas_yogurth) {
        this.cenizas_yogurth = cenizas_yogurth;
    }

    public Double getFibras_yogurth() {
        return fibras_yogurth;
    }

    public void setFibras_yogurth(Double fibras_yogurth) {
        this.fibras_yogurth = fibras_yogurth;
    }

    public Double getContenido_energetico() {
        return contenido_energetico;
    }

    public void setContenido_energetico(Double contenido_energetico) {
        this.contenido_energetico = contenido_energetico;
    }

}