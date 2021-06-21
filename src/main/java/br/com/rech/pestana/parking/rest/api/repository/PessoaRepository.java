package br.com.rech.pestana.parking.rest.api.repository;

import br.com.rech.pestana.parking.rest.api.model.PessoaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Integer> {
    List<PessoaModel> findByNomeContains(String name);
}