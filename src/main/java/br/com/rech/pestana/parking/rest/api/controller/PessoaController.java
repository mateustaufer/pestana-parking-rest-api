package br.com.rech.pestana.parking.rest.api.controller;

import br.com.rech.pestana.parking.rest.api.controller.dto.PessoaRq;
import br.com.rech.pestana.parking.rest.api.controller.dto.PessoaRs;
import br.com.rech.pestana.parking.rest.api.model.PessoaModel;
import br.com.rech.pestana.parking.rest.api.repository.PessoaCustomRepository;
import br.com.rech.pestana.parking.rest.api.repository.PessoaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;
    private final PessoaCustomRepository pessoaCustomRepository;

    public PessoaController(PessoaRepository pessoaRepository, PessoaCustomRepository pessoaCustomRepository) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaCustomRepository = pessoaCustomRepository;
    }

    @GetMapping("/")
    public List<PessoaRs> findAll() {
        var pessoas = pessoaRepository.findAll();
        return pessoas
                .stream()
                .map(PessoaRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PessoaRs findById(@PathVariable("id") Integer id) {
        var pessoa = pessoaRepository.getById(id);
        return PessoaRs.converter(pessoa);
    }

    @PostMapping("/")
    public void savePerson(@RequestBody PessoaRq pessoa) {
        var p = new PessoaModel();
        p.setNome(pessoa.getNome());
        p.setCpf(pessoa.getCpf());
        p.setCpf(pessoa.getApartamento());
        p.setCpf(pessoa.getData_nascimento());
        p.setCpf(pessoa.getTelefone());
        pessoaRepository.save(p);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") Integer id, @RequestBody PessoaRq pessoa) throws Exception {
        var p = pessoaRepository.findById(id);

        if (p.isPresent()) {
            var pessoaSave = p.get();
            pessoaSave.setNome(pessoa.getNome());
            pessoaSave.setCpf(pessoa.getCpf());
            pessoaSave.setCpf(pessoa.getApartamento());
            pessoaSave.setCpf(pessoa.getData_nascimento());
            pessoaSave.setCpf(pessoa.getTelefone());
            pessoaRepository.save(pessoaSave);
        } else {
            throw new Exception("Pessoa Não encontrada");
        }
    }

    @GetMapping("/filter")
    public List<PessoaRs> findPersonByName(@RequestParam("name") String name) {
        return this.pessoaRepository.findByNomeContains(name)
                .stream()
                .map(PessoaRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/filter/custom")
    public List<PessoaRs> findPersonByCustom(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "cpf", required = false) String cpf
    ) {
        return this.pessoaCustomRepository.find(id, nome, cpf)
                .stream()
                .map(PessoaRs::converter)
                .collect(Collectors.toList());
    }

}