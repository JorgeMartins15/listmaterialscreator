package application;

import model.entities.Components;
import model.entities.Machine;

public class Program {

	public static void main(String[] args) {

		Machine machine = new Machine("GS300", "Empacotadora");
		Components components = new Components(1, 5, "CLP", "000.001.0002", "Delta", "Rockwell", machine );
		
		System.out.println(components);

	}

}
