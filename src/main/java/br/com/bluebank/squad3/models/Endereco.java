package br.com.bluebank.squad3.models;

import javax.persistence.*;

@Table(name = "endereco")
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_endereco;
}