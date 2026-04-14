package com.leandro.desafio_modelo_dominio.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_bloco")
public class Bloco implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private Instant inicio;
	
	@Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private Instant fim;
	
	@ManyToMany(mappedBy = "blocos")
	private Set<Atividade> atividades = new HashSet<>();
	
	public Bloco() {
		
	}
	
	public Bloco(Integer id, Instant inicio, Instant fim) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Instant getInicio() {
		return inicio;
	}
	
	public void setInicio(Instant inicio) {
		this.inicio = inicio;
	}
	
	public Instant getFim() {
		return fim;
	}
	
	public void setFim(Instant fim) {
		this.fim = fim;
	}
	
	public Set<Atividade> getAtividades() {
		return atividades;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloco other = (Bloco) obj;
		return Objects.equals(id, other.id);
	}
}
