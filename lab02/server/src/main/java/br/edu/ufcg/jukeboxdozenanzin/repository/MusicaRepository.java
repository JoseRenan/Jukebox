package br.edu.ufcg.jukeboxdozenanzin.repository;

import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import org.springframework.data.repository.CrudRepository;

public interface MusicaRepository extends CrudRepository<Musica, Integer> {

    Musica findMusicaByNome(String nome);

}
