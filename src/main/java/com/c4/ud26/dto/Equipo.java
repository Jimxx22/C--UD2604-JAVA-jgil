package com.c4.ud26.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="equipos")
public class Equipo {

	@Id
	@Column(name="num_serie")
	private String num_serie;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="codigo_facultad")
	private Facultad facultad;
	
	@OneToMany
	@JoinColumn(name="codigo_equipos")
	private List<Reserva> reservas;

	public Equipo() {
	}

	public Equipo(String num_serie, String nombre, Facultad facultad) {
		this.num_serie = num_serie;
		this.nombre = nombre;
		this.facultad = facultad;
	}

	public String getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Equipo [codigo=" + num_serie + ", nombre=" + nombre + ", facultad=" + facultad + ", reservas=" + reservas
				+ "]";
	}
}
