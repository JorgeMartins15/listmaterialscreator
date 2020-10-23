package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.MachineDao;
import model.entities.Components;
import model.entities.Machine;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		MachineDao machineDao = DaoFactory.createMachineDao();
		
		System.out.println("=== TEST 1: machine findById =====");
		Machine machine = machineDao.findById(3);
		System.out.println(machine);
		
		System.out.println("\n=== TEST 3: machine findAll =====");
		List <Machine> list = machineDao.findAll();
		for (Machine obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: machine insert =====");
		//Machine machineId = new Machine(6, null, null);
		//machine.setMachineId(5);
		Machine newMachine = new Machine(null, "Four", "Balance");
		machineDao.insert(newMachine);
		System.out.println("Inserted! New id = " + newMachine.getMachineId());
		
		System.out.println("\n=== TEST 5: machine update =====");
		machine = machineDao.findById(2);
		machine.setName("Xavasca");
		machine.setType("Xana");
		machineDao.update(machine);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: machine delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		machineDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();

	}

}
