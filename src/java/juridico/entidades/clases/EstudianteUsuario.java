/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juridico.entidades.clases;

import master.logica.clases.Usuario;

/**
 *
 * @author Oscunach
 */
public class EstudianteUsuario {

    private int id_usuario_estudiante;
    private Estudiante id_estudiante;
    private Usuario id_usuario;

    /*
     ** constructores
     */
    public EstudianteUsuario(int id_usuario_estudiante, Estudiante id_estudiante, Usuario id_usuario) {
        this.id_usuario_estudiante = id_usuario_estudiante;
        this.id_estudiante = id_estudiante;
        this.id_usuario = id_usuario;
    }

    public EstudianteUsuario() {
        super();
    }

    /*
     ** Métodos Get y Set
     */
    public int getId_usuario_estudiante() {
        return id_usuario_estudiante;
    }

    public void setId_usuario_estudiante(int id_usuario_estudiante) {
        this.id_usuario_estudiante = id_usuario_estudiante;
    }

    public Estudiante getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Estudiante id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

}
