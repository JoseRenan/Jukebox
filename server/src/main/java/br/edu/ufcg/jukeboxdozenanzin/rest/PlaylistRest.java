package br.edu.ufcg.jukeboxdozenanzin.rest;

import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import br.edu.ufcg.jukeboxdozenanzin.entity.Playlist;
import br.edu.ufcg.jukeboxdozenanzin.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/playlists")
public class PlaylistRest {

    @Autowired
    PlaylistService playlistService;

    @RequestMapping(method = RequestMethod.POST)
    public Playlist adicionaPlaylist(@RequestBody Playlist playlist, Principal principal) {
        return playlistService.adicionaPlaylist(playlist, principal.getName());
    }

    @RequestMapping(value = "/{idPlaylist}/musicas", method = RequestMethod.POST)
    public Playlist adicionaMusicaNaPlaylist(@PathVariable Integer idPlaylist, @RequestBody Musica musica) {
        return playlistService.adicionaMusicaNaPlaylist(idPlaylist, musica);
    }

    @RequestMapping(value = "/{idPlaylist}/musicas/{idMusica}", method = RequestMethod.DELETE)
    public Playlist removerMusicaDaPlaylist(@PathVariable Integer idPlaylist, @PathVariable Integer idMusica) {
        return playlistService.removerMusicaDaPlaylist(idPlaylist, idMusica);
    }

    @RequestMapping(value = "/{playlistId}", method = RequestMethod.GET)
    public Playlist recuperaPlaylist(@PathVariable Integer playlistId) {
        return playlistService.recuperaPlaylist(playlistId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Playlist> listaPlaylists(Principal principal) {
        return playlistService.listarPlaylists(principal.getName());
    }

}
