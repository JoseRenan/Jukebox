package br.edu.ufcg.jukeboxdozenanzin.service;

import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.entity.AvaliacaoArtistaUsuario;
import br.edu.ufcg.jukeboxdozenanzin.entity.Usuario;
import br.edu.ufcg.jukeboxdozenanzin.repository.ArtistaReposotory;
import br.edu.ufcg.jukeboxdozenanzin.repository.AvaliacaoArtistaUsuarioRepository;
import br.edu.ufcg.jukeboxdozenanzin.repository.UsuarioRepository;
import br.edu.ufcg.jukeboxdozenanzin.validation.Validator;
import br.edu.ufcg.jukeboxdozenanzin.validation.error.JukeboxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaReposotory artistaReposotory;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AvaliacaoArtistaUsuarioRepository avaliacaoArtistaReposotory;

    @Autowired @Qualifier("artistaValidator")
    Validator artistaValidator;

    public Artista cadastraArtista(Artista artista) {
        artistaValidator.validaCadastro(artista);
        return artistaReposotory.save(artista);
    }

    public AvaliacaoArtistaUsuario avaliarArtista(Integer idArtista, String emailUsuario, AvaliacaoArtistaUsuario avaliacao) {
        AvaliacaoArtistaUsuario avaliacaoArtistaUsuarioDb = buscarAvaliacaoArtistaOuCria(idArtista, emailUsuario);
        if (avaliacao.getNota() != null) {
            avaliacaoArtistaUsuarioDb.setNota(avaliacao.getNota());
        }
        if (avaliacao.getFavorito() != null) {
            avaliacaoArtistaUsuarioDb.setFavorito(avaliacao.getFavorito());
        }
        avaliacaoArtistaReposotory.save(avaliacaoArtistaUsuarioDb);
        return avaliacaoArtistaUsuarioDb;
    }

    public AvaliacaoArtistaUsuario buscarAvaliacaoArtistaOuCria(Integer idArtista, String emailUsuario) {
        Artista artista = buscarArtista(idArtista);
        if (artista == null) {
            throw new JukeboxException("Artista não cadastrado");
        }
        AvaliacaoArtistaUsuario avaliacaoArtistaUsuario = avaliacaoArtistaReposotory.findAvaliacaoArtistaUsuarioByArtistaAndUsuarioEmail(artista, emailUsuario);
        if (avaliacaoArtistaUsuario == null) {
            Usuario usuario = usuarioRepository.findUsuarioByEmail(emailUsuario);
            avaliacaoArtistaUsuario = new AvaliacaoArtistaUsuario(usuario, artista, false, 0);
            avaliacaoArtistaReposotory.save(avaliacaoArtistaUsuario);
        }
        return avaliacaoArtistaUsuario;
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
