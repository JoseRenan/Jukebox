package br.edu.ufcg.jukeboxdozenanzin.rest;

import br.edu.ufcg.jukeboxdozenanzin.entity.Album;
import br.edu.ufcg.jukeboxdozenanzin.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumRest {

    @Autowired
    AlbumService albumService;

    @RequestMapping(value = "/artistas/{idArtista}", method = RequestMethod.GET)
    public List<Album> listarAlbumsPorArtista(@PathVariable Integer idArtista) {
        return albumService.listarAlbumPorArtista(idArtista);
    }

}
