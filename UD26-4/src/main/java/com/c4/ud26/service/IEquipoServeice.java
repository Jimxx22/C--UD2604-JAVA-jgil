package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Equipo;

public interface IEquipoServeice {
	
	public List<Equipo> listarEquipos();
	
	public Equipo guardarEquipo(Equipo equipo);
	
	public Equipo equipoXID(String id);
	
	public Equipo actualizarEquipo(Equipo equipo);
	
	public void eliminarEquipo(String id);

}
