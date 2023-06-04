package edu.examples.java_classes.input.command.impl;

import java.util.Scanner;

import edu.examples.java_classes.controller.Controller;
import edu.examples.java_classes.input.command.Command;

public class ConsoleFindItemByDate implements Command{
	
	private Controller controller = Controller.getInstance();

	@Override
	public void execute() {
		System.out.println("find item by date");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the date in next format: dd.mm.yyyy > ");
		String date = scanner.nextLine();
		
		
		String request = "FIND_BY_DATE date=" + date;

		String response;

		response = controller.doAction(request);

		System.out.println(response);
		
	}

}
