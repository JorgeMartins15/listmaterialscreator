package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.MachineDao;
import model.entities.Machine;

public class MachineDaoJDBC implements MachineDao{
	
private Connection conn;
	
	public MachineDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Machine obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Machine obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Machine findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Machine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
