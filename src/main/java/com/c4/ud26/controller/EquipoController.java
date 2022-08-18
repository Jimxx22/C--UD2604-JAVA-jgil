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

import com.c4.ud26.dto.Equipo;
import com.c4.ud26.service.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired 
	EquipoServiceImpl equipoServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipo> listarEquipos(){
		return equipoServiceImpl.listarEquipos();
	}
	
	@PostMapping("/equipos")
	public Equipo guardarEquipo(@RequestBody Equipo equipo) {
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	
	@GetMapping("/equipos/{num_serie}")
	public Equipo equipoXID(@PathVariable(name="num_serie") String id) {
		
		Equipo equipoXID = new Equipo();
		
		equipoXID=equipoServiceImpl.equipoXID(id);
		
		return equipoXID;
	}
	
	@PutMapping("/equipos/{num_serie}")
	public Equipo actualizarEquipo(@PathVariable(name="num_serie") String id, @RequestBody Equipo equipo) {
		
		Equipo equipoSel = new Equipo();
		Equipo equipoAct = new Equipo();
		
		equipoSel=equipoServiceImpl.equipoXID(id);
		
		equipoSel.setNum_serie(equipo.getNum_serie());
		equipoSel.setNombre(equipo.getNombre());
		equipoSel.setFacultad(equipo.getFacultad());
		
		equipoAct=equipoServiceImpl.actualizarEquipo(equipoSel);
		
		return equipoAct;
	}
	
	@DeleteMapping("/equipos/{num_serie}")
	public String eliminarEquipo(@PathVariable(name="num_serie") String id) {
		try {
			equipoServiceImpl.eliminarEquipo(id);
			return "Equipo eliminado";
		}catch (Exception e) {
			return "Error: no puedes borrar este equipo ya que tiene alguna reserva asiganda";
		}
	}
}
