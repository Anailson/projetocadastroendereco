package br.com.transparencia.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.transparencia.model.Endereco;

@Repository
@Transactional
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
	
	

	//@Query("select p from Endereco p where p.logradouro like %?1%")
	//@Query("select p from Endereco p where UPPER(p.logradouro) = UPPER(?1)")
	@Query("SELECT p FROM Endereco p WHERE LOWER(p.logradouro) LIKE LOWER('%'||?1||'%')")  
	//CONSULTA QUE  PESQUISA POR QQL PARTE DO REGISTRO

	List<Endereco> findEnderecoByLogradouro(String logradouro);
	
	
	//findByNameContainingIgnoreCase where UPPER(x.firstname) = UPPER(?1)

}
