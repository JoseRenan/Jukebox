package br.edu.ufcg.jukeboxdozenanzin.repository;

import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.entity.MusicaOuvida;
import org.springframework.data.repository.CrudRepository;

public interface MusicaOuvidaRepository extends CrudRepository<MusicaOuvida, Integer>{
    MusicaOuvida findMusicaOuvidaByArtistaAndUsuarioEmail(Artista artista, String email);
}
