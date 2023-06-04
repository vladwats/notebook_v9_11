package edu.examples.java_classes.output;

import java.util.List;

import edu.examples.java_classes.entity.Note;

public class NotebookOutput {
	
	public void print(String title, List<Note> notes) {
		
		System.out.println(title.toUpperCase());
		System.out.println();
		
		if(notes == null || notes.size() <= 0) {
			System.out.println("Нет записей для вывода.");
			return;
		}
		
		for(Note n : notes) {
			System.out.println(n.getId() + " - " + n.getTitle());
		}
		
	}

	public static String print(List<Note> notes) {
		
		if(notes == null || notes.size() <= 0) {
			System.out.println("Нет записей для вывода.");			
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for (Note n : notes) {
			stringBuilder.append(n.toString());
			stringBuilder.append("\n");
		}

		return stringBuilder.toString();
	}

}
