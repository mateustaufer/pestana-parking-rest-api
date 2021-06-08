package br.com.rech.pestana.parking.rest.api.repository;

import br.com.rech.pestana.parking.rest.api.model.PessoaModel;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<PessoaModel, Integer> {
}
