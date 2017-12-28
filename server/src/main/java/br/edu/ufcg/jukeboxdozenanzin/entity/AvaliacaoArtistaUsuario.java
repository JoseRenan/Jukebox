package br.edu.ufcg.jukeboxdozenanzin.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_avaliacao_artista_usuario")
public class AvaliacaoArtistaUsuario {

    private Integer avaliacaoId;
    private Usuario usuario;
    private Artista artista;
    private Boolean isFavorito;
    private Integer nota;

    public AvaliacaoArtistaUsuario(Usuario usuario, Artista artista, Boolean isFavorito, Integer nota) {
        this.usuario = usuario;
        this.artista = artista;
        this.isFavorito = isFavorito;
        this.nota = nota;
    }

    public AvaliacaoArtistaUsuario() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_avaliacao")
    public Integer getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(Integer avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JoinColumn(name = "fk_artista")
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Column(name = "is_favorito", columnDefinition = "bool default false")
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
