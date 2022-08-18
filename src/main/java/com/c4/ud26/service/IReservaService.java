package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Reserva;

public interface IReservaService {

	public List<Reserva> listarReservas();
	
	public Reserva guardarReserva(Reserva reserva);
	
	public Reserva reservaXID (Long id);
	
	public Reserva actualitzarReserva(Reserva reserva);
	
	public void eliminarReserva(Long id);
}
