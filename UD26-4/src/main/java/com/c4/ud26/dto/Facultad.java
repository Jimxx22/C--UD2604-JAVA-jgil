package com.c4.ud26.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facultades")
public class Facultad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="codigo_facultad")
	private List<Investigador> investigadores;
	
	@OneToMany
	@JoinColumn(name="codigo_facultad")
	private List<Equipo> equipos;

	public Facultad(Long codigo, String nombre, List<Investigador> investigadores, List<Equipo> equipos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.investigadores = investigadores;
		this.equipos = equipos;
	}

	public Facultad() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigador")
	public List<Investigador> getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(List<Investigador> investigadores) {
		this.investigadores = investigadores;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipo")
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "Facultad [codigo=" + codigo + ", nombre=" + nombre + ", investigadores=" + investigadores + ", equipos="
				+ equipos + "]";
	}	
}
