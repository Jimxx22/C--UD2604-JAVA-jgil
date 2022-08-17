package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Facultad;

public interface IFacultadService {

	public List<Facultad> listarFacultads();
	
	public Facultad guardarFacultad(Facultad facultad);
	
	public Facultad facultadXID(Long id);
	
	public Facultad actulizarFacultad(Facultad facultad);
	
	public void eliminarFacultad(Long id);
}
