package br.edu.ufcg.jukeboxdozenanzin.repository;

import br.edu.ufcg.jukeboxdozenanzin.entity.Album;
import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
    List<Album> findAlbumsByArtista(Artista artista);
    List<Album> findAlbumsByNomeContaining(String nome);
    Album findAlbumByNome(String nome);
}
