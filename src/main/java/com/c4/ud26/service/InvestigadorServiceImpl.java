package com.c4.ud26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4.ud26.dao.IInvestigadorDAO;
import com.c4.ud26.dto.Investigador;

@Service
public class InvestigadorServiceImpl implements IInvestigadorService{
	
	@Autowired
	IInvestigadorDAO iInvestigadorDAO;

	@Override
	public List<Investigador> listarInvestigadors() {
		// TODO Auto-generated method stub
		return iInvestigadorDAO.findAll();
	}

	@Override
	public Investigador guardarInvestigador(Investigador investigador) {
		// TODO Auto-generated method stub
		return iInvestigadorDAO.save(investigador);
	}

	@Override
	public Investigador investigadorXID(String id) {
		// TODO Auto-generated method stub
		return iInvestigadorDAO.findById(id).get();
	}

	@Override
	public Investigador actulizarInvestigador(Investigador investigador) {
		// TODO Auto-generated method stub
		return iInvestigadorDAO.save(investigador);
	}

	@Override
	public void eliminarInvestigador(String id) {
		iInvestigadorDAO.deleteById(id);	
	}

}
