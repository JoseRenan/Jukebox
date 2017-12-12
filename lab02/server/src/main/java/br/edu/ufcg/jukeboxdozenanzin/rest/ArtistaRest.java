package br.edu.ufcg.jukeboxdozenanzin.rest;

import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.service.ArtistaService;
import br.edu.ufcg.jukeboxdozenanzin.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artistas")
public class ArtistaRest {

    @Autowired
    private ArtistaService artistaService;

    @RequestMapping(method = RequestMethod.POST)
    public Artista cadastraArtista(@RequestBody Artista artista) {
        Artista novoArtista = artistaService.cadastraArtista(artista);
        return novoArtista;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Artista> listarArtistasPorNome(@RequestParam(value="nome", required = false) String nome) {
        if (nome != null) {
            return artistaService.buscarArtistasPorNome(nome);
        } else {
            return artistaService.listarArtistas();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Artista recuperarArtista(@PathVariable Integer id) {
        return artistaService.buscarArtista(id);
    }
}
