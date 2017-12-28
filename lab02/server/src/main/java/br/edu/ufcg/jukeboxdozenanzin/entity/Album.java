package br.edu.ufcg.jukeboxdozenanzin.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_album")
public class Album {

    private Integer idAlbum;
    private Artista artista;
    private String nome;
    private Usuario usuario;

    public Album() {}

    public Album(Artista artista, String nome) {
        this.artista = artista;
        this.nome = nome;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_album")
    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    @ManyToOne
    @JoinColumn(name = "fk_artista")
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Column(name = "nm_album", unique = true)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
