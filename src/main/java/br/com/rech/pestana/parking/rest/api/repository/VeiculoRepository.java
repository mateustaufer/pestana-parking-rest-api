package br.com.rech.pestana.parking.rest.api.repository;

import br.com.rech.pestana.parking.rest.api.model.VeiculoModel;
import org.springframework.data.repository.CrudRepository;

public interface VeiculoRepository extends CrudRepository<VeiculoModel, Integer> {
}
