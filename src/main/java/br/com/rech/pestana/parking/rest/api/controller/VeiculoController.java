package br.com.rech.pestana.parking.rest.api.controller;

import br.com.rech.pestana.parking.rest.api.model.VeiculoModel;
import br.com.rech.pestana.parking.rest.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @GetMapping(path = "/api/veiculo/{id}")
    public ResponseEntity consultar(@PathVariable("id") Integer id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/api/veiculo")
    public Iterable<VeiculoModel> listar() { return repository.findAll(); }

    /*@GetMapping(path = "/api/veiculo/pessoa/{cpf}")
    public Iterable<VeiculoModel> listarVeiculosPessoa(@PathVariable("cpf") String cpf) {
        ArrayList<VeiculoModel> listaVeiculos = new ArrayList<>();
        for (VeiculoModel veiculo : repository.findAll()){
            if (veiculo.getCpf() == cpf) {
                listaVeiculos.add(veiculo);
            }
        }
        return listaVeiculos;
    }*/

    @PostMapping(path = "/api/veiculo/salvar")
    public VeiculoModel salvar(@RequestBody VeiculoModel veiculo){
        return repository.save(veiculo);
    }

    @PutMapping(path = "/api/veiculo/atualizar")
    public VeiculoModel atualizar(@RequestBody VeiculoModel veiculo){
        return repository.save(veiculo);
    }

    @DeleteMapping(path = "/api/veiculo/{id}")
    public void excluir(@PathVariable("id") Integer id){ repository.deleteById(id); }

}
