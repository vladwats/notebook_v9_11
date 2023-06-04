package edu.examples.java_classes.input;

import java.util.Scanner;

public class InputTerminal {

	private Scanner sc = new Scanner(System.in);

	public int input() {

		int variant = 0;

		System.out.println(" - Сделайте выбор. >");
		if (sc.hasNextInt()) {
			variant = sc.nextInt();
			return variant;
		} else {
			sc.nextLine();
			System.out.println(" - Неверный ввод.");
			return -1;
		}
	}

}
