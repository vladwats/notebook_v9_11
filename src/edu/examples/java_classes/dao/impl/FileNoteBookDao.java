package edu.examples.java_classes.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao{

	@Override
	public void save(Note n) throws DaoException {
		BufferedWriter bufwriter = null;

		try {
			bufwriter = new BufferedWriter(new FileWriter("resources/my_notes.txt", true));

			bufwriter.write(n.toString());
			bufwriter.newLine();

		} catch (IOException e) {
			throw new DaoException("Notepad data not saved.", e);
			
		} finally {
			try {
				bufwriter.close();
			} catch (IOException e) {
				throw new DaoException("File close error!", e);
			}
		}
	}

	@Override
	public List<Note> allNotes() throws DaoException {
		List<Note> notes = new ArrayList<>();
		BufferedReader breader = null;
			
		try {
			breader = new BufferedReader(new FileReader("resources/my_notes.txt"));
			String line;
			
			while ((line = breader.readLine()) != null) {
				
				notes.add(formNote(line));					
			}	
		}
		catch (IOException e) {
			throw new RuntimeException("Somthing Wrong!");
		} finally {
			try {
				breader.close();
			} catch (IOException e) {
				throw new DaoException("File close error!", e);
			}
		}
		
		return notes;
	}
	
	private Note formNote(String line) {

		String[] params = line.split("\\s+", 5);

		String title = params[2].split("=")[1];
		String content = params[3].split("=")[1];			       

		Note note = new Note(title, content);
		return note;
	}
	
}



