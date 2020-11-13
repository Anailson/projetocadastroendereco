package br.com.transparencia.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

 

@Entity
public class Endereco implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@NotNull(message = "Nome não pode ser Nulo!")
	@NotNull(message = "Preenchimento obrigatório")
	@NotEmpty(message ="Preenchimento obrigatório")
	@Size(min = 9, max = 10) //  72307-621
	//@Min(value = 9, message = "Cep minimo 9" )
	//@Max(value = 10, message = "Cep maximo 10")
	private String cep;
	
	@NotNull(message = "Preenchimento obrigatório")
	@NotEmpty(message ="Preenchimento obrigatório")
	@Size(min = 3, max = 100)
	private String logradouro;
	
	
	@Size(min = 3, max = 50)
	private String Bairro;
	
	@NotNull(message = "Preenchimento obrigatório")
	@NotEmpty(message ="Preenchimento obrigatório")
	@Size(min = 1, max = 100)
	private String Numero;
	
	@NotNull(message = "Preenchimento obrigatório")
	@NotEmpty(message ="Preenchimento obrigatório")
	@Size(min = 3, max = 50)
	private String Cidade;
	
	@NotNull(message = "Preenchimento obrigatório")
	@NotEmpty(message ="Preenchimento obrigatório")
	@Size(min = 2, max = 2)
	private String uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

}
