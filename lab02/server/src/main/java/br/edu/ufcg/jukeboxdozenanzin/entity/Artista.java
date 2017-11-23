package br.edu.ufcg.jukeboxdozenanzin.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_artista")
public class Artista {

    private Integer artistaId;
    private String nome;
    private String linkFoto;

    public Artista() {}

    public Artista(String nome, String linkFoto) {
        this.nome = nome;
        this.linkFoto = linkFoto;
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
}
