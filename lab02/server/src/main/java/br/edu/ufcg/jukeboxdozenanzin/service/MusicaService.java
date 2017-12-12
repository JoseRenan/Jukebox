package br.edu.ufcg.jukeboxdozenanzin.service;

import br.edu.ufcg.jukeboxdozenanzin.entity.Album;
import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import br.edu.ufcg.jukeboxdozenanzin.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private AlbumService albumService;

    public Musica adicionaMusica(Musica musica) {
        albumService.cadastrarAlbumSeNaoExistir(musica.getAlbum());
        return musicaRepository.save(musica);
    }

    public Musica buscaMusica(Integer id) {
        return musicaRepository.findOne(id);
    }

    public List<Musica> buscaMusicasPorArtista(Artista artista) {
        return musicaRepository.findMusicasByAlbumArtista(artista);
    }

    public List<Musica> buscaMusicasPorNome(String nome) {
        return musicaRepository.findMusicasByNomeContaining(nome);
    }

    public List<Musica> buscaMusicasPorArtista(Album album) {
        return musicaRepository.findMusicasByAlbum(album);
    }

    public Iterable<Musica> listarMusicas () {
        return musicaRepository.findAll();
    }
}
