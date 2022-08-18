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

import com.c4.ud26.dto.Facultad;
import com.c4.ud26.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	
	@GetMapping("/facultades")
	public List<Facultad> listarFacultads(){
		return facultadServiceImpl.listarFacultads();
	}
	
	@PostMapping("/facultades")
	public Facultad guardarFacultad(@RequestBody Facultad facultad) {
		return facultadServiceImpl.guardarFacultad(facultad);
	}
	
	@GetMapping("/facultades/{codigo}")
	public Facultad facultadXID(@PathVariable(name="codigo") Long id) {
		return facultadServiceImpl.facultadXID(id);
	}
	
	@PutMapping("/facultades/{codigo}")
	public Facultad actualizarFacultad(@PathVariable(name="codigo") Long id, @RequestBody Facultad facultad) {
		Facultad facultadSel= new Facultad();
		Facultad facultadAct= new Facultad();
		
		facultadSel=facultadServiceImpl.facultadXID(id);
		
		facultadSel.setNombre(facultad.getNombre());
		
		facultadAct= facultadServiceImpl.actulizarFacultad(facultadSel);
		
		return facultadAct;
	}
	
	@DeleteMapping("/facultades/{codigo}")
	public String eliminarFacultad(@PathVariable(name="codigo") Long id) {
		try {
			facultadServiceImpl.eliminarFacultad(id);
			return "Facultad eliminada";
		}catch (Exception e) {
			return "Error: no puedes borrar esta facultad ya que tiene investigadores o equipos asignados";
		}
		
	}
}
