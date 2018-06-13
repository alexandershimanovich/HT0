package by.epam.training.exception;

public class SpaceUsageTooMuchException extends Exception {

	public SpaceUsageTooMuchException() {
		super("There is not enough free space in the room");
	}
}
