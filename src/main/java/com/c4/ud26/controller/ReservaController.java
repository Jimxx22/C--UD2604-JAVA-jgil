package com.c4.ud26.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c4.ud26.dto.Reserva;
import com.c4.ud26.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {
	
	@Autowired 
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/reservas")
	public List<Reserva> listarVantas(){
		return reservaServiceImpl.listarReservas();
	}
	
	@PostMapping("/reservas")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	@GetMapping("/reservas/{id}")
	public Reserva asignadoAXID(@PathVariable(name="id") Long id) {
		
		Reserva reservaXID = new Reserva();
		
		reservaXID=reservaServiceImpl.reservaXID(id);
		
		return reservaXID;
	}

	@PutMapping("/reservas/{id}")
	public Reserva actualizarReserva(@PathVariable(name="id") Long id, @RequestBody Reserva reserva) {
		
		Reserva reservaSel = new Reserva();
		Reserva reservaAct = new Reserva();
		
		reservaSel=reservaServiceImpl.reservaXID(id);
		
		reservaSel.setEquipo(reserva.getEquipo());
		reservaSel.setInvestigador(reserva.getInvestigador());
		
		reservaAct = reservaServiceImpl.actualitzarReserva(reservaSel);
		
		return reservaAct;		
	}
	
	@DeleteMapping("/reservas/{id}")
	public void eliminsarReserva(@PathVariable(name="id") Long id) {
		reservaServiceImpl.eliminarReserva(id);
	}
}
