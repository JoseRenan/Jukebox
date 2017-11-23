package br.edu.ufcg.jukeboxdozenanzin.rest;

import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import br.edu.ufcg.jukeboxdozenanzin.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicaRest {

    @Autowired
    MusicaRepository repository;

    @RequestMapping("/musica")
    public Musica getMusica() {
        repository.save(new Musica("Hue", "01:20"));
        return repository.findMusicaByNome("Hue");
    }

}
