package br.edu.ufcg.jukeboxdozenanzin.repository;

import br.edu.ufcg.jukeboxdozenanzin.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Usuario findUsuarioByEmail(String email);
}
