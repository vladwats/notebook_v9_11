package edu.examples.java_classes.logic;

public class LogicException extends Exception{
	private static final long serialVersionUID = -1309795400357459358L;

	public LogicException() {
	}

	public LogicException(String message) {
		super(message);
	}

	public LogicException(Exception e) {
		super(e);
	}

	public LogicException(String message, Exception e) {
		super(message, e);
	}
}
