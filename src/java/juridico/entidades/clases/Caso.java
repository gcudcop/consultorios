/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.entidades.clases;

import java.util.Date;

/**
 *
 * @author Oscunach
 */
public class Caso {
      private int id_caso;
  private Date fecha_inicio;
  private String numero_caso;
  private String juzgado;
  private String area;
  private Docente id_docente;
  private Estudiante id_estudiante;
  private Victima id_victima;
  private Agresor id_agresor;
  private String descripcion;
  private String problema_juridico;
  private String observaciones_tutor;
    
}
