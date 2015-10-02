/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

import juridico.entidades.clases.Docente;

/**
 *
 * @author servidor
 */
public class UsuarioDocente {

    private int codigo;
    private Usuario idUsuario;
    private Docente idDocente;

    public UsuarioDocente() {
    }

    public UsuarioDocente(int codigo, Usuario idUsuario, Docente idDocente) {
        this.codigo = codigo;
        this.idUsuario = idUsuario;
        this.idDocente = idDocente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Docente getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Docente idDocente) {
        this.idDocente = idDocente;
    }

}
