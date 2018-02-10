package br.edu.ufcg.jukeboxdozenanzin.service;

import br.edu.ufcg.jukeboxdozenanzin.entity.Album;
import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistaService artistaService;

    public Album cadastrarAlbumSeNaoExistir(Album album) {
        if (album.getNome() != null) {
            Album albumDb = albumRepository.findAlbumByNome(album.getNome());
            if (albumDb != null) {
                return albumDb;
            }
        } else if (album.getIdAlbum() != null) {
            return albumRepository.findOne(album.getIdAlbum());
        }
        return albumRepository.save(album);
    }

    public Album buscaAlbumPorNome(String nome) {
        return albumRepository.findAlbumByNome(nome);
    }

    public List<Album> listarAlbumPorArtista(Integer id) {
        Artista artista = artistaService.buscarArtista(id);
        return albumRepository.findAlbumsByArtista(artista);
    }
}
