package com.victxl.projetomongo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComentarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String comentario;
    private Date data;
    private AutorDTO autor;

    private List<ComentarioDTO> comentarios = new ArrayList<>();



    public ComentarioDTO() {}

    public ComentarioDTO(String comentario, Date data, AutorDTO autor) {
        this.comentario = comentario;
        this.data = data;
        this.autor = autor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public AutorDTO getAutor() {
        return autor;
    }

    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }

}
