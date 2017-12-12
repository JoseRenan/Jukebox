package br.edu.ufcg.jukeboxdozenanzin.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_musica")
public class Musica {

    private Integer musicaId;
    private String nome;
    private String duracao;
    private Album album;

    public Musica() {}

    public Musica(String nome, String duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_musica")
    public Integer getMusicaId() {
        return musicaId;
    }

    public void setMusicaId(Integer musicaId) {
        this.musicaId = musicaId;
    }

    @Column(name = "nm_musica")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "duracao")
    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @ManyToOne
    @JoinColumn(name = "fk_album")
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
