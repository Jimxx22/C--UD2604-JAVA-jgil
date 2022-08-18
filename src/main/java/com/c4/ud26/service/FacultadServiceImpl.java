package com.c4.ud26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4.ud26.dao.IFacultadDAO;
import com.c4.ud26.dto.Facultad;

@Service
public class FacultadServiceImpl implements IFacultadService{
	
	@Autowired
	IFacultadDAO iFacultadDAO;

	@Override
	public List<Facultad> listarFacultads() {
		// TODO Auto-generated method stub
		return iFacultadDAO.findAll();
	}

	@Override
	public Facultad guardarFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		return iFacultadDAO.save(facultad);
	}

	@Override
	public Facultad facultadXID(Long id) {
		// TODO Auto-generated method stub
		return iFacultadDAO.findById(id).get();
	}

	@Override
	public Facultad actulizarFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		return iFacultadDAO.save(facultad);
	}

	@Override
	public void eliminarFacultad(Long id) {
		iFacultadDAO.deleteById(id);	
	}

}
