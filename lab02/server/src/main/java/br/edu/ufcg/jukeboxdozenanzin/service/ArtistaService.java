package br.edu.ufcg.jukeboxdozenanzin.service;

import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.repository.ArtistaReposotory;
import br.edu.ufcg.jukeboxdozenanzin.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaReposotory artistaReposotory;

    @Autowired @Qualifier("artistaValidator")
    Validator artistaValidator;

    public Artista cadastraArtista(Artista artista) {
        artistaValidator.validaCadastro(artista);
        return artistaReposotory.save(artista);
    }

    public Artista atualizaArtista(Integer idArtista, Artista artista) {
        Artista artistaBd = buscarArtista(idArtista);
        artistaBd.setFavorito(artista.getFavorito());
        artistaBd.setLinkFoto(artista.getLinkFoto());
        artistaBd.setNome(artista.getNome());
        artistaBd.setNota(artista.getNota());
        return artistaReposotory.save(artistaBd);
    }

    public Iterable<Artista> listarArtistas() {
        return artistaReposotory.findAll();
    }

    public List<Artista> buscarArtistasPorNome(String nome) {
        return artistaReposotory.findArtistasByNomeContaining(nome);
    }

    public Artista recuperaArtistaPorNome(String nome) {
        return artistaReposotory.findArtistaByNome(nome);
    }

    public Artista buscarArtista(Integer id) {
        return artistaReposotory.findOne(id);
    }
}
