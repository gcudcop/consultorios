/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candelaria.logica.clases;

/**
 *
 * @author Yolanda
 */
public class MateriaPrima {
    
    
        private Integer id_MateriaPrima;
        private String nombre_MateriaPrima;
        private String cantidad_Materiaprima;

    public MateriaPrima() {
    }

    public MateriaPrima(Integer id_MateriaPrima, String nombre_MateriaPrima, String cantidad_Materiaprima) {
        this.id_MateriaPrima = id_MateriaPrima;
        this.nombre_MateriaPrima = nombre_MateriaPrima;
        this.cantidad_Materiaprima = cantidad_Materiaprima;
    }

    public Integer getId_MateriaPrima() {
        return id_MateriaPrima;
    }

    public void setId_MateriaPrima(Integer id_MateriaPrima) {
        this.id_MateriaPrima = id_MateriaPrima;
    }

    public String getCantidad_Materiaprima() {
        return cantidad_Materiaprima;
    }

    public void setCantidad_Materiaprima(String cantidad_Materiaprima) {
        this.cantidad_Materiaprima = cantidad_Materiaprima;
    }

    public String getNombre_MateriaPrima() {
        return nombre_MateriaPrima;
    }

    public void setNombre_MateriaPrima(String nombre_MateriaPrima) {
        this.nombre_MateriaPrima = nombre_MateriaPrima;
    }
        
        
    
}
