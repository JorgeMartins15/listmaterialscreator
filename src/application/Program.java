package application;

import model.dao.ComponentsDao;
import model.dao.DaoFactory;
import model.dao.MachineDao;
import model.entities.Components;
import model.entities.Machine;

public class Program {

	public static void main(String[] args) {

		ComponentsDao componentsDao = DaoFactory.createComponentsDao();
		
		Components components = componentsDao.findById(2);
		
		System.out.println(components);

	}

}
