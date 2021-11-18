package br.com.bluebank.squad3.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @NotNull
    @Size(max = 120)
    @Column
    private String nome;

    @NotNull
    @Size(max = 11)
    @Column
    private String cpf;

    @NotNull
    @Size(max = 100)
    @Column
    private String telefone;


    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco id_endereco;

    public Cliente(Long id_cliente, String nome, String cpf, String telefone, String email, Endereco endereco) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // Getters and Setters (Omitted for brevity)
}