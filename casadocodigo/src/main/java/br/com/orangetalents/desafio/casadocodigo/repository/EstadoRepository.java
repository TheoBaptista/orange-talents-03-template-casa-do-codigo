package br.com.orangetalents.desafio.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orangetalents.desafio.casadocodigo.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	 Estado findByNome(String estado);

}
