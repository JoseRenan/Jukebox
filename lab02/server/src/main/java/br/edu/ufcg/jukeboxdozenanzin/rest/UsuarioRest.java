package br.edu.ufcg.jukeboxdozenanzin.rest;

import br.edu.ufcg.jukeboxdozenanzin.entity.Usuario;
import br.edu.ufcg.jukeboxdozenanzin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Usuario cadastraUsuario(@RequestBody Usuario artista) {
        return usuarioRepository.save(artista);
    }

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public Usuario cadastraUsuario(Principal usuario) {
        Usuario user = usuarioRepository.findUsuarioByEmail(usuario.getName());
        return user;
    }

}
