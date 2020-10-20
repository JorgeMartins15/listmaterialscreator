package application;

import java.util.List;

import model.dao.ComponentsDao;
import model.dao.DaoFactory;
import model.entities.Components;
import model.entities.Machine;

public class Program {

	public static void main(String[] args) {

		ComponentsDao componentsDao = DaoFactory.createComponentsDao();

		System.out.println("\n=== TEST 2: components findByMachine =====");
		Machine machine = new Machine(1, null, null);
		List<Components> list = componentsDao.findByMachine(machine);
		for (Components obj : list) {
			System.out.println(obj);
		}
	}

}
