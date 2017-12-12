package br.edu.ufcg.jukeboxdozenanzin.rest;

import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import br.edu.ufcg.jukeboxdozenanzin.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musicas")
public class MusicaRest {

    @Autowired
    MusicaService musicaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Musica recuperarArtistaPorNome(@PathVariable Integer id) {
        return musicaService.buscaMusica(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Musica> listarArtistasPorNome(@RequestParam(value="nome", required = false) String nome) {
        if (nome != null) {
            return musicaService.buscaMusicasPorNome(nome);
        } else {
            return musicaService.listarMusicas();
        }
    }

}
