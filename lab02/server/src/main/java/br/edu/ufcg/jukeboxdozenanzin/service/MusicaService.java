package br.edu.ufcg.jukeboxdozenanzin.service;

import br.edu.ufcg.jukeboxdozenanzin.entity.Album;
import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import br.edu.ufcg.jukeboxdozenanzin.repository.MusicaRepository;
import br.edu.ufcg.jukeboxdozenanzin.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistaService artistaService;

    @Autowired @Qualifier("musicaValidator")
    Validator musicaValidator;

    public Musica adicionaMusica(Musica musica) {
        musicaValidator.validaCadastro(musica);
        Album album = albumService.cadastrarAlbumSeNaoExistir(musica.getAlbum());
        musica.setAlbum(album);
        return musicaRepository.save(musica);
    }

    public Musica buscaMusica(Integer id) {
        return musicaRepository.findOne(id);
    }

    public List<Musica> buscaMusicasPorArtista(Artista artista) {
        return musicaRepository.findMusicasByAlbumArtista(artista);
    }

    public List<Musica> buscaMusicasPorArtista(Integer idArtista) {
        Artista artista = artistaService.buscarArtista(idArtista);
        return buscaMusicasPorArtista(artista);
    }

    public Musica buscaMusicasPorNomeEmAlbum(String nome, Album album) {
        return musicaRepository.findMusicaByNomeAndAlbum(nome, album);
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
