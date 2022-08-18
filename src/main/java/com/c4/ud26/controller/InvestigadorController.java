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

import com.c4.ud26.dto.Investigador;
import com.c4.ud26.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigadors(){
		return investigadorServiceImpl.listarInvestigadors();
	}
	
	@PostMapping("/investigadores")
	public Investigador guardarInvestigador(@RequestBody Investigador investigador) {
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}
	
	@GetMapping("/investigadores/{dni}")
	public Investigador investigadorXID(@PathVariable(name="dni") String id) {
		return investigadorServiceImpl.investigadorXID(id);
	}
	
	@PutMapping("/investigadores/{dni}")
	public Investigador actualizarInvestigador(@PathVariable(name="dni") String id, @RequestBody Investigador investigador) {
		Investigador investigadorSel= new Investigador();
		Investigador investigadorAct= new Investigador();
		
		investigadorSel=investigadorServiceImpl.investigadorXID(id);
		
		investigadorSel.setDni(investigador.getDni());
		investigadorSel.setNom_apels(investigador.getNom_apels());
		investigadorSel.setFacultad(investigador.getFacultad());
		
		investigadorAct= investigadorServiceImpl.actulizarInvestigador(investigadorSel);
		
		return investigadorAct;
		
	}
	
	@DeleteMapping("/investigadores/{dni}")
	public String eliminarInvestigador(@PathVariable(name="dni") String id) {
		try {
			investigadorServiceImpl.eliminarInvestigador(id);
			return "Investigador eliminado";
		}catch (Exception e) {
			return "Error: no puedes borrar este investigador ya que tiene reservas asignadas";
		}
		
	}
}
