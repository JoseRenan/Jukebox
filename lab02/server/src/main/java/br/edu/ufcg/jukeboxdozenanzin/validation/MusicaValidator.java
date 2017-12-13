package br.edu.ufcg.jukeboxdozenanzin.validation;

import br.edu.ufcg.jukeboxdozenanzin.entity.Album;
import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import br.edu.ufcg.jukeboxdozenanzin.service.AlbumService;
import br.edu.ufcg.jukeboxdozenanzin.service.MusicaService;
import br.edu.ufcg.jukeboxdozenanzin.validation.error.JukeboxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component @Qualifier("musicaValidator")
public class MusicaValidator implements Validator<Musica> {

    @Autowired
    private MusicaService musicaService;

    @Autowired
    private AlbumService albumService;

    @Autowired @Qualifier("artistaValidator")
    private Validator artistaValidator;

    @Override
    public void validaCadastro(Musica musica) {
        musicaJaExisteEmAlbum(musica.getNome(), musica.getAlbum());
        artistaExiste(musica.getAlbum().getArtista());
    }

    @Override
    public boolean entidadeExiste(Musica musica) {
        if (musica.getMusicaId() != null) {
            return musicaService.buscaMusica(musica.getMusicaId()) != null;
        }
        return false;
    }

    private void musicaJaExisteEmAlbum(String nome, Album album) {
        Album albumDb = albumService.buscaAlbumPorNome(album.getNome());
        if (albumDb != null) {
            Musica musica = musicaService.buscaMusicasPorNomeEmAlbum(nome, albumDb);
            if (musica != null) {
                throw new JukeboxException("Música de mesmo nome já foi cadastrada nesse álbum.");
            }
        }
    }

    private void artistaExiste(Artista artista) {
        if (!artistaValidator.entidadeExiste(artista)) {
            throw new JukeboxException("Artista não está cadastrado.");
        }
    }

}
