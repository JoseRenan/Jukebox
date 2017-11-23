package br.edu.ufcg.jukeboxdozenanzin.service;

import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.repository.ArtistaReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaReposotory artistaReposotory;

    public Artista cadastraArtista(Artista artista) {
        return artistaReposotory.save(artista);
    }

    public Iterable<Artista> listarArtistas() {
        return artistaReposotory.findAll();
    }

    public Iterable<Artista> buscarArtistasPorNome(String nome) {
        return artistaReposotory.findArtistasByNomeContains(nome);
    }

    public Artista buscarArtista(Integer id) {
        return artistaReposotory.findOne(id);
    }
}
