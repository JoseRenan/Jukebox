package br.edu.ufcg.jukeboxdozenanzin.auth;

import br.edu.ufcg.jukeboxdozenanzin.entity.Usuario;
import br.edu.ufcg.jukeboxdozenanzin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserAuthService implements UserDetailsService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findUsuarioByEmail(s);
        if (usuario == null) {
            throw new UsernameNotFoundException(s);
        }
        return new User(usuario.getEmail(), usuario.getPassword(), new ArrayList<GrantedAuthority>());
    }

}
