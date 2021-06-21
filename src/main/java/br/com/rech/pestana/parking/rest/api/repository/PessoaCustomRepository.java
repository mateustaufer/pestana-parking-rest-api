package br.com.rech.pestana.parking.rest.api.repository;

import br.com.rech.pestana.parking.rest.api.model.PessoaModel;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PessoaCustomRepository {

    private final EntityManager em;

    public PessoaCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<PessoaModel> find(Long id, String nome, String cpf) {

        String query = "select P from pessoa P ";
        String condicao = "where";

        if(id != null) {
            query += condicao + " P.id = :id";
            condicao = " and ";
        }

        if(nome != null) {
            query += condicao + " P.nome = :nome";
            condicao = " and ";
        }

        if(cpf != null) {
            query += condicao + " P.cpf = :cpf";
        }

        var q = em.createQuery(query, PessoaModel.class);

        if(id != null) {
            q.setParameter("id", id);
        }

        if(nome != null) {
            q.setParameter("nome", nome);
        }

        if(cpf != null) {
            q.setParameter("cpf", cpf);
        }

        return q.getResultList();
    }

}