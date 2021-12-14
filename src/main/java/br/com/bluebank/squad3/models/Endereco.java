package br.com.bluebank.squad3.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @ApiModelProperty(value = "Código do Endereço")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco", nullable = false)
    private Long id_endereco;

    @ApiModelProperty(value = "Rua do Endereço")
    @Column(name = "rua", nullable = false)
    private String rua;

    @ApiModelProperty(value = "Número do Endereço")
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @ApiModelProperty(value = "Bairro do Endereço")
    @Column(name = "bairro", nullable = false)
    private String bairro;

    @ApiModelProperty(value = "CEP do Endereço")
    @Column(name = "cep", nullable = false)
    private String cep;

    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}