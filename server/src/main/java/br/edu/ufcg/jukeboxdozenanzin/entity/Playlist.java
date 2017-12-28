package br.edu.ufcg.jukeboxdozenanzin.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_playlist")
public class Playlist {

    private Integer playlistId;
    private String nome;
    private List<Musica> musicas;
    private Usuario criador;

    public Playlist() {
        this.musicas = new ArrayList<Musica>();
    }

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<Musica>();
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_playlist")
    public Integer getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    @Column(name = "nm_playlist")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addMusica(Musica musica) {
        this.musicas.add(musica);
    }

    public void removeMusica(Musica musica) {
        this.musicas.remove(musica);
    }

    @ManyToMany
    @JoinTable(name = "tb_musica_playlist")
    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @ManyToOne
    @JoinColumn(name = "fk_usuario_criador")
    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }
}
