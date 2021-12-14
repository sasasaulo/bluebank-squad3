package br.com.bluebank.squad3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bluebank.squad3.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
//    @Query(value = "SELECT * FROM contatb WHERE conta = ?1", nativeQuery = true)
    Conta findByConta(Long conta);

}
