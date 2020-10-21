package application;

import java.util.List;
import java.util.Scanner;

import model.dao.ComponentsDao;
import model.dao.DaoFactory;
import model.entities.Components;
import model.entities.Machine;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ComponentsDao componentsDao = DaoFactory.createComponentsDao();
		
		System.out.println("=== TEST 1: seller findById =====");
		Components components = componentsDao.findById(3);
		System.out.println(components);

		System.out.println("\n=== TEST 2: components findByMachine =====");
		Machine machine = new Machine(3, null, null);
		List<Components> list = componentsDao.findByMachineId(machine);
		for (Components obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: components findAll =====");
		list = componentsDao.findAll();
		for (Components obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println("\n=== TEST 4: components insert =====");
		//Machine machineId = new Machine(6, null, null);
		machine.setMachineId(5);
		Components newComponents = new Components(null, 5, "Relé","010.010.0011", "Schmersal", "Carlo Gavazzi", machine);
		componentsDao.insert(newComponents);
		System.out.println("Inserted! New id = " + newComponents.getId());
		
		
		System.out.println("\n=== TEST 5: components update =====");
		components = componentsDao.findById(2);
		components.setDescription("Xavasca");
		components.setCode("024.024.0244");
		componentsDao.update(components);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: components delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		componentsDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	
	}
}
