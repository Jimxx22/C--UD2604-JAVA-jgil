package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Investigador;

public interface IInvestigadorService {

	public List<Investigador> listarInvestigadors();
	
	public Investigador guardarInvestigador(Investigador investigador);
	
	public Investigador investigadorXID(String id);
	
	public Investigador actulizarInvestigador(Investigador investigador);
	
	public void eliminarInvestigador(String id);
}
