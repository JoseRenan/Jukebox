package br.edu.ufcg.jukeboxdozenanzin.repository;

import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistaReposotory extends CrudRepository<Artista, Integer> {
    List<Artista> findArtistasByNomeContains(String nome);
    Artista findArtistaByNome(String nome);
}
