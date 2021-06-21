package br.com.rech.pestana.parking.rest.api.controller.dto;

import br.com.rech.pestana.parking.rest.api.model.PessoaModel;

public class PessoaRs {

    private Integer id;
    private String nome;
    private String cpf;
    private String apartamento;
    private String data_nascimento;
    private String telefone;

    public static PessoaRs converter(PessoaModel p) {
        var pessoa = new PessoaRs();
        pessoa.setId(p.getId());
        pessoa.setNome(p.getNome());
        pessoa.setCpf(p.getCpf());
        return pessoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}