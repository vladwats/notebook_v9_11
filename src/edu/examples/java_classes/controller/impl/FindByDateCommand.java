package edu.examples.java_classes.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NoteBookLogic;
import edu.examples.java_classes.output.NotebookOutput;

public class FindByDateCommand implements Command {

	private final NoteBookLogic logic = LogicProvider.getInstance().getNoteBookLogic();

	@Override
	public String execute(String request) {
		String[] params = request.split("\\s+", 2);

		String data = params[1].split("=")[1];

		String response = "";

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd.MM.yyyy");

		try {
			Date d = format.parse(data);
			response = NotebookOutput.print(logic.find(d));
			
		} catch (ParseException e) {
			response = "Invalid date format. Enter the date in the required format";
			
		} catch (LogicException e) {
			response = "Error!!!";
		}

		return response;
	}

}
