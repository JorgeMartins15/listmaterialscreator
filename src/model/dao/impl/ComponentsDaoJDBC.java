package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.ComponentsDao;
import model.entities.Components;
import model.entities.Machine;

public class ComponentsDaoJDBC implements ComponentsDao {

	private Connection conn;

	public ComponentsDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Components obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Components obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Components findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT components.*,machine.Name as MacName,machine.Type as MacType " 
					+ "FROM components INNER JOIN machine "
					+ "ON components.MachineId = machine.Id " 
					+ "WHERE components.Id = ? ");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Machine mac = instantiateMachine(rs);
				Components obj = instantiateComponents(rs, mac);
				return obj;
			}

			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Components instantiateComponents(ResultSet rs, Machine mac) throws SQLException {
		Components obj = new Components();
		obj.setId(rs.getInt("Id"));
		obj.setQuantity(rs.getInt("Quantity"));
		obj.setDescription(rs.getString("Description"));
		obj.setProvider1(rs.getString("Provider1"));
		obj.setProvider2(rs.getString("Provider2"));
		obj.setMachine(mac);
		return obj;
	}

	private Machine instantiateMachine(ResultSet rs) throws SQLException {
		Machine mac = new Machine();
		mac.setMachineId(rs.getInt("Id"));
		mac.setName(rs.getString("MacName"));  //MacName � apelido para nome da coluna
		mac.setType(rs.getString("MacType"));  //MacType � apelido para nome da coluna

		return mac;
	}

	@Override
	public List<Components> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Components> findByMachine(Machine machine) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT components.*,machine.Name as MacName, machine.Type as MacType "
					+"FROM components INNER JOIN machine "
					+"ON components.MachineId = machine.Id "
					+"WHERE MachineId = ? "
					+"ORDER BY Name");
			
			st.setInt(1, machine.getMachineId());

			rs = st.executeQuery();

			List<Components> list = new ArrayList<>();
			Map<Integer, Machine> map = new HashMap<>();

			while (rs.next()) {

				Machine dep = map.get(rs.getInt("MachineId"));

				if (dep == null) {
					dep = instantiateMachine(rs);
					map.put(rs.getInt("MachineId"), dep);
				}

				Components obj = instantiateComponents(rs, dep);
				list.add(obj);
			}
			return list;
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}



}
