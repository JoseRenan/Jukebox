package br.edu.ufcg.jukeboxdozenanzin.validation;

import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import br.edu.ufcg.jukeboxdozenanzin.entity.Playlist;
import br.edu.ufcg.jukeboxdozenanzin.service.PlaylistService;
import br.edu.ufcg.jukeboxdozenanzin.validation.error.JukeboxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component @Qualifier("playlistValidator")
public class PlaylistValidator implements Validator<Playlist>{

    @Autowired
    PlaylistService playlistService;

    @Override
    public void validaCadastro(Playlist playlist) {
        validaAtributos(playlist);
        playlistJaCadastrada(playlist);
        playlistSemMusicasRepetidas(playlist);
    }

    @Override
    public boolean entidadeExiste(Playlist playlist) {
        if (playlistService.buscaPlaylistPorNome(playlist.getNome()) != null) {
            return true;
        } else if (playlist.getPlaylistId() != null) {
            return playlistService.recuperaPlaylist(playlist.getPlaylistId()) != null;
        }
        return false;
    }

    private void playlistJaCadastrada(Playlist playlist) {
        if (entidadeExiste(playlist)) {
            throw new JukeboxException("Playlist já foi cadastrada.");
        }
    }

    private void playlistSemMusicasRepetidas(Playlist playlist) {
        for (Musica musica : playlist.getMusicas()) {
            int frequencia = Collections.frequency(playlist.getMusicas(), musica);
            if (frequencia > 1) {
                throw new JukeboxException("Playlist contém músicas repetidas.");
            }
        }
    }

    private void validaAtributos(Playlist playlist) {
        if (playlist.getNome() == null || playlist.getNome().trim().isEmpty()) {
            throw new JukeboxException("Playlist não pode ter nome vazio.");
        }
    }

}
