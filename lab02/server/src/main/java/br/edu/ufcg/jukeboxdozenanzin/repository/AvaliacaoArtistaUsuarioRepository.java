package br.edu.ufcg.jukeboxdozenanzin.repository;

import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.entity.AvaliacaoArtistaUsuario;
import org.springframework.data.repository.CrudRepository;

public interface AvaliacaoArtistaUsuarioRepository extends CrudRepository<AvaliacaoArtistaUsuario, Integer> {
    AvaliacaoArtistaUsuario findAvaliacaoArtistaUsuarioByArtistaAndUsuarioEmail(Artista artista, String email);
}
