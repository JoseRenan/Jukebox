package br.edu.ufcg.jukeboxdozenanzin.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_musica")
public class Musica {

    private Integer musicaId;
    private String nome;
    private String duracao;
    private String ano;
    private Album album;

    public Musica() {}

    public Musica(Integer musicaId, String nome, String duracao, String ano, Album album) {
        this.musicaId = musicaId;
        this.nome = nome;
        this.duracao = duracao;
        this.ano = ano;
        this.album = album;
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

    @Column(name = "ano")
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Musica)) return false;

        Musica musica = (Musica) o;

        if (!getMusicaId().equals(musica.getMusicaId()))return false;
        if (!getNome().equals(musica.getNome())) return false;
        if (!getDuracao().equals(musica.getDuracao())) return false;
        return getAlbum().equals(musica.getAlbum());
    }

    @Override
    public int hashCode() {
        int result = getMusicaId().hashCode();
        result = 31 * result + getNome().hashCode();
        result = 31 * result + getDuracao().hashCode();
        result = 31 * result + getAlbum().hashCode();
        return result;
    }
}
