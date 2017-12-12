package br.edu.ufcg.jukeboxdozenanzin.repository;

import br.edu.ufcg.jukeboxdozenanzin.entity.Album;
import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MusicaRepository extends CrudRepository<Musica, Integer> {

    Musica findMusicaByNome(String nome);

    List<Musica> findMusicasByAlbumArtista(Artista artista);

    List<Musica> findMusicasByNomeContaining(String nome);

    List<Musica> findMusicasByAlbum(Album album);

}
