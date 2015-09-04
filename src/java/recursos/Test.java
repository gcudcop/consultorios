/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;
import java.util.Date;

/**
 *
 * @author Oscunach
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.sql.Date retornoFecha = null;
        Date fecha = new Date();
        retornoFecha=StringToDate.devolverFecha(fecha);
        System.out.println(fecha.toString());
        System.out.println(retornoFecha.toString());
    }
    
}
