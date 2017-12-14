package br.edu.ufcg.jukeboxdozenanzin.repository;

import br.edu.ufcg.jukeboxdozenanzin.entity.Playlist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {
    Playlist findPlaylistByNome(String nome);
    List<Playlist> findPlaylistsByNomeContaining(String nome);
}
