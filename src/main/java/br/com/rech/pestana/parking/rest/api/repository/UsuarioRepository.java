package br.com.rech.pestana.parking.rest.api.repository;

import br.com.rech.pestana.parking.rest.api.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
}
