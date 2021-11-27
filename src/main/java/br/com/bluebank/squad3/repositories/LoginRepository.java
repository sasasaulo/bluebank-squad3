package br.com.bluebank.squad3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bluebank.squad3.models.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	public List<Login> findByEmail(String email);
		
}