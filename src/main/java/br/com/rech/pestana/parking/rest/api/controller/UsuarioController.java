package br.com.rech.pestana.parking.rest.api.controller;

import br.com.rech.pestana.parking.rest.api.model.UsuarioModel;
import br.com.rech.pestana.parking.rest.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping(path = "/api/usuario/{id}")
    public ResponseEntity consultar(@PathVariable("id") Integer id){

        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/api/usuario")
    public Iterable<UsuarioModel> listar() {
        return repository.findAll();
    }

    @PostMapping(path = "/api/usuario/salvar")
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario){
        return repository.save(usuario);
    }

    @PutMapping(path = "/api/usuario/atualizar")
    public UsuarioModel atualizar(@RequestBody UsuarioModel usuario){
        return repository.save(usuario);
    }

    @DeleteMapping(path = "/api/usuario/{id}")
    public void excluir(@PathVariable("id") Integer id){ repository.deleteById(id); }

}
