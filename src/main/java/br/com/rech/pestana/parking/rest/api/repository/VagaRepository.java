package br.com.rech.pestana.parking.rest.api.repository;

import br.com.rech.pestana.parking.rest.api.model.VagaModel;
import org.springframework.data.repository.CrudRepository;

public interface VagaRepository extends CrudRepository<VagaModel, Integer> {

}
