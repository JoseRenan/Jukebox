package br.edu.ufcg.jukeboxdozenanzin.service;

import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import br.edu.ufcg.jukeboxdozenanzin.entity.Playlist;
import br.edu.ufcg.jukeboxdozenanzin.entity.Usuario;
import br.edu.ufcg.jukeboxdozenanzin.repository.PlaylistRepository;
import br.edu.ufcg.jukeboxdozenanzin.repository.UsuarioRepository;
import br.edu.ufcg.jukeboxdozenanzin.validation.Validator;
import br.edu.ufcg.jukeboxdozenanzin.validation.error.JukeboxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    MusicaService musicaService;

    @Autowired @Qualifier("playlistValidator")
    Validator playlistValidator;

    @Autowired @Qualifier("musicaValidator")
    Validator musicaValidator;

    public Playlist adicionaPlaylist(Playlist playlist, String criadorEmail) {
        playlistValidator.validaCadastro(playlist);
        Usuario usuario = usuarioRepository.findUsuarioByEmail(criadorEmail);
        playlist.setCriador(usuario);
        playlistRepository.save(playlist);
        return playlist;
    }

    public Playlist buscaPlaylistPorNome(String nome) {
        return playlistRepository.findPlaylistByNome(nome);
    }

    public Playlist recuperaPlaylist(Integer idPlaylist) {
        return playlistRepository.findOne(idPlaylist);
    }

    public Iterable<Playlist> listarPlaylists(String criadorEmail) {
        return playlistRepository.findPlaylistsByCriadorEmail(criadorEmail);
    }

    public Playlist adicionaMusicaNaPlaylist(Integer idPlaylist, Musica musica) {
        Playlist playlist = this.recuperaPlaylist(idPlaylist);
        musica = musicaService.buscaMusica(musica.getMusicaId());
        if (musica == null) {
            throw new JukeboxException("Música não cadastrada");
        }
        if (Collections.frequency(playlist.getMusicas(), musica) > 0) {
            throw new JukeboxException("Música já está na playlist");
        }
        playlist.addMusica(musica);
        playlistRepository.save(playlist);
        return playlist;
    }

    public Playlist removerMusicaDaPlaylist(Integer idPlaylist, Integer idMusica) {
        Playlist playlist = this.recuperaPlaylist(idPlaylist);
        Musica musica = musicaService.buscaMusica(idMusica);
        if (musica == null) {
            throw new JukeboxException("Música não cadastrada");
        }
        if (!(Collections.frequency(playlist.getMusicas(), musica) > 0)) {
            throw new JukeboxException("Música não está na playlist");
        }
        playlist.removeMusica(musica);
        playlistRepository.save(playlist);
        return playlist;
    }
}
