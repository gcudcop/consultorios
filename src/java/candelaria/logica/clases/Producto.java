/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.clases;

import java.util.Date;

/**
 *
 * @author ROGES
 */
public class Producto {
  private Integer  id_producto;
  private Categoria id_categoria; 
  private Date fecha_fabricacion; 
  private Date fecha_caducidad;
  private String peso_producto;
  private String color_producto;
  private String sabor_producto;
  private String forma_producto;

    public Producto() {
    }

    public Producto(Integer id_producto, Categoria id_categoria, Date fecha_fabricacion, Date fecha_caducidad, String peso_producto, String color_producto, String sabor_producto, String forma_producto) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.fecha_fabricacion = fecha_fabricacion;
        this.fecha_caducidad = fecha_caducidad;
        this.peso_producto = peso_producto;
        this.color_producto = color_producto;
        this.sabor_producto = sabor_producto;
        this.forma_producto = forma_producto;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Categoria getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Date getFecha_fabricacion() {
        return fecha_fabricacion;
    }

    public void setFecha_fabricacion(Date fecha_fabricacion) {
        this.fecha_fabricacion = fecha_fabricacion;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public String getPeso_producto() {
        return peso_producto;
    }

    public void setPeso_producto(String peso_producto) {
        this.peso_producto = peso_producto;
    }

    public String getColor_producto() {
        return color_producto;
    }

    public void setColor_producto(String color_producto) {
        this.color_producto = color_producto;
    }

    public String getSabor_producto() {
        return sabor_producto;
    }

    public void setSabor_producto(String sabor_producto) {
        this.sabor_producto = sabor_producto;
    }

    public String getForma_producto() {
        return forma_producto;
    }

    public void setForma_producto(String forma_producto) {
        this.forma_producto = forma_producto;
    }

   
    
  
}
