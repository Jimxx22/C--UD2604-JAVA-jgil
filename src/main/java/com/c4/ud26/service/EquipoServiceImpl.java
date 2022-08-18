package com.c4.ud26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4.ud26.dao.IEquipoDAO;
import com.c4.ud26.dto.Equipo;

@Service
public class EquipoServiceImpl implements IEquipoServeice{
	
	@Autowired
	IEquipoDAO iEquipoDAO;

	@Override
	public List<Equipo> listarEquipos() {
		// TODO Auto-generated method stub
		return iEquipoDAO.findAll();
	}

	@Override
	public Equipo guardarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		return iEquipoDAO.save(equipo);
	}

	@Override
	public Equipo equipoXID(String id) {
		// TODO Auto-generated method stub
		return iEquipoDAO.findById(id).get();
	}

	@Override
	public Equipo actualizarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		return iEquipoDAO.save(equipo);
	}

	@Override
	public void eliminarEquipo(String id) {
		// TODO Auto-generated method stub
		iEquipoDAO.deleteById(id);
	}
}
