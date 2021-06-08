package br.com.rech.pestana.parking.rest.api.controller;

import br.com.rech.pestana.parking.rest.api.model.UsuarioModel;
import br.com.rech.pestana.parking.rest.api.model.VagaModel;
import br.com.rech.pestana.parking.rest.api.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VagaController {
    @Autowired
    private VagaRepository repository;

    @GetMapping(path = "/api/vaga/{vaga}")
    public ResponseEntity consultar(@PathVariable("vaga") Integer vaga){
        return repository.findById(vaga)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/api/vaga")
    public Iterable<VagaModel> listar() {
        return repository.findAll();
    }

    @PostMapping(path = "/api/vaga/salvar")
    public VagaModel salvar(@RequestBody VagaModel vaga){ return repository.save(vaga); }

    @PutMapping(path = "/api/vaga/atualizar")
    public VagaModel atualizar(@RequestBody VagaModel vaga){ return repository.save(vaga); }
}
