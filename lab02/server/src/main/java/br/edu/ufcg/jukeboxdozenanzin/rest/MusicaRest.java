package br.edu.ufcg.jukeboxdozenanzin.rest;

import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import br.edu.ufcg.jukeboxdozenanzin.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/musicas")
public class MusicaRest {

    @Autowired
    MusicaService musicaService;

    @RequestMapping(method = RequestMethod.POST)
    public Musica salvarMusica(@RequestBody Musica musica) {
        return musicaService.adicionaMusica(musica);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Musica recuperarArtista(@PathVariable Integer id) {
        return musicaService.buscaMusica(id);
    }

    @RequestMapping(value = "/{id}/ouvir", method = RequestMethod.GET)
    public Musica ouvirMusica(@PathVariable Integer id, Principal principal) {
        return musicaService.ouvirMusica(id, principal.getName());
    }

    @RequestMapping(value = "/artista/{id}/ouvidas", method = RequestMethod.GET)
    public Musica musicaOuvida(@PathVariable Integer id, Principal principal) {
        return musicaService.ultimaMusicaOuvidaPorIdArtista(id, principal.getName());
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Musica> listarArtistasPorNome(
            @RequestParam(value="nome", required = false) String nome,
            @RequestParam(value="idArtista", required = false) Integer idArtista) {
        if (nome != null) {
            return musicaService.buscaMusicasPorNome(nome);
        } else if (idArtista != null) {
            return musicaService.buscaMusicasPorArtista(idArtista);
        } else {
            return musicaService.listarMusicas();
        }
    }

}
