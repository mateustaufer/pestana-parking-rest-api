package br.com.rech.pestana.parking.rest.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "vaga")
public class VagaModel {
    @Id
    public Integer vaga;

    @Column(nullable = false, length = 7)
    public String placa;

    public Integer getVaga() { return vaga; }

    public void setVaga(Integer vaga) {
        this.vaga = vaga;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
