package br.com.rech.pestana.parking.rest.api.controller;

import br.com.rech.pestana.parking.rest.api.model.PessoaModel;
import br.com.rech.pestana.parking.rest.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping(path = "/api/pessoa/{id}")
    public ResponseEntity consultar(@PathVariable("id") Integer id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/api/pessoa")
    public Iterable<PessoaModel> listar() {
        return repository.findAll();
    }

    @PostMapping(path = "/api/pessoa/salvar")
    public PessoaModel salvar(@RequestBody PessoaModel pessoa){
        return repository.save(pessoa);
    }

    @PutMapping(path = "/api/pessoa/atualizar")
    public PessoaModel atualizar(@RequestBody PessoaModel pessoa){
        return repository.save(pessoa);
    }

    @DeleteMapping(path = "/api/pessoa/{id}")
    public void excluir(@PathVariable("id") Integer id){ repository.deleteById(id); }

}
