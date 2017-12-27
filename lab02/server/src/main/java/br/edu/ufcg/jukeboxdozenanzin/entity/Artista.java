package br.edu.ufcg.jukeboxdozenanzin.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "tb_artista")
public class Artista {

    private Integer artistaId;
    private String nome;
    private String linkFoto;
    private Boolean isFavorito;
    private Integer nota;

    public Artista() {}

    public Artista(String nome, String linkFoto, Boolean isFavorito, Integer nota) {
        this.artistaId = artistaId;
        this.nome = nome;
        this.linkFoto = linkFoto;
        this.isFavorito = isFavorito;
        this.nota = nota;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_artista")
    public Integer getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(Integer artistaId) {
        this.artistaId = artistaId;
    }

    @Column(name = "nm_artista")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "link_foto")
    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    @Column(name = "is_favorito", nullable = false, columnDefinition = "TINYINT(1)")
    public Boolean getFavorito() {
        return isFavorito;
    }

    public void setFavorito(Boolean favorito) {
        isFavorito = favorito;
    }

    @Column(name = "nota_artista")
    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
