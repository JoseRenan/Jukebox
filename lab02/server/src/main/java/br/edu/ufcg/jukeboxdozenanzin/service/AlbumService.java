package br.edu.ufcg.jukeboxdozenanzin.service;

import br.edu.ufcg.jukeboxdozenanzin.entity.Album;
import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import br.edu.ufcg.jukeboxdozenanzin.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album cadastrarAlbumSeNaoExistir(Album album) {
        if (album.getIdAlbum() != null) {
            Album albumDb = albumRepository.findAlbumByNome(album.getNome());
            if (albumDb != null) {
                return albumDb;
            }
        }
        return albumRepository.save(album);
    }

    public Album buscaAlbumPorNome(String nome) {
        return albumRepository.findAlbumByNome(nome);
    }
}
