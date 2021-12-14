package br.com.bluebank.squad3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bluebank.squad3.models.Transacoes;

import java.util.List;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {
//   @Query(value = "SELECT * FROM transacoes WHERE id_contaenvia= ?1", nativeQuery = true)
    List<Transacoes> findByidcontaenvia(Long idcontaenvia);
//    @Query(value = "SELECT * FROM transacoes WHERE contarecebe= ?1", nativeQuery = true)
    List<Transacoes> findBycontarecebe(Long contarecebe);

}
