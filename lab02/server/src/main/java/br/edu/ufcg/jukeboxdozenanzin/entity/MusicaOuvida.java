package br.edu.ufcg.jukeboxdozenanzin.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_musica_ouvida")
public class MusicaOuvida {

    private Integer musicaOuvidaId;
    private Musica musica;
    private Artista artista;
    private Usuario usuario;

    public MusicaOuvida(Musica musica, Artista artista, Usuario usuario) {
        this.musica = musica;
        this.artista = artista;
        this.usuario = usuario;
    }

    public MusicaOuvida() {
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_musica_ouvida")
    public Integer getMusicaOuvidaId() {
        return musicaOuvidaId;
    }

    public void setMusicaOuvidaId(Integer musicaOuvidaId) {
        this.musicaOuvidaId = musicaOuvidaId;
    }

    @ManyToOne
    @JoinColumn(name = "fk_musica", unique = true, nullable = false)
    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    @ManyToOne
    @JoinColumn(name = "fk_artista")
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
