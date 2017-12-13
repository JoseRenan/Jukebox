package br.edu.ufcg.jukeboxdozenanzin.validation;

import br.edu.ufcg.jukeboxdozenanzin.entity.Artista;
import br.edu.ufcg.jukeboxdozenanzin.service.ArtistaService;
import br.edu.ufcg.jukeboxdozenanzin.validation.error.JukeboxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("artistaValidator")
public class ArtistaValidator implements Validator<Artista> {

    @Autowired
    private ArtistaService artistaService;

    @Override
    public void validaCadastro(Artista artista) {
        validarAtributos(artista);
        validarExistenciaPorNome(artista.getNome());
    }

    @Override
    public boolean entidadeExiste(Artista artista) {
        if (artistaService.recuperaArtistaPorNome(artista.getNome()) != null) {
            return true;
        }
        if (artista.getArtistaId() != null) {
            Artista artistaDb = artistaService.buscarArtista(artista.getArtistaId());
            return artistaDb != null;
        }
        return false;
    }

    private void validarAtributos(Artista artista) {
        if (artista.getNome() == null || artista.getNome().trim().isEmpty()) {
            throw new JukeboxException("Nome do artista não pode ser vazio");
        }
    }

    private void validarExistenciaPorNome(String nomeArtista) {
        if (artistaService.recuperaArtistaPorNome(nomeArtista) != null) {
            throw new JukeboxException("Artista com esse nome já foi cadastrado");
        }
    }
}
