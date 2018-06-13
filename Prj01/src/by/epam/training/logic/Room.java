package by.epam.training.logic;

import java.util.ArrayList;

import by.epam.training.bean.Furniture;
import by.epam.training.bean.illumination.Lamp;
import by.epam.training.bean.illumination.Window;
import by.epam.training.exception.IlluminanceTooLittleException;
import by.epam.training.exception.IlluminanceTooMuchException;
import by.epam.training.exception.SpaceUsageTooMuchException;

public class Room {

	private static final int MIN_ILLUMINANCE = 300;
	private static final int MAX_ILLUMINANCE = 4000;
	private static final double MAX_OCCUPIED_AREA = 0.7;

	private String name;
	private int numberOfWindows;
	private int maxValueOfWindows;
	private double square;
	private double allowableSquare;
	private double usedSquare;
	private double illumination;

	private ArrayList<Lamp> lampsList = new ArrayList<>();
	private ArrayList<Furniture> furnitureList = new ArrayList<>();

	public Room(String name, double square, int numberOfWindows) {

		if (square <= 0) {
			System.out.println("The room area value is not entered correctly, enter a positive value");
		} else {
			maxValueOfWindows = MAX_ILLUMINANCE / Window.ILLUMINATION;
			if (numberOfWindows > maxValueOfWindows || numberOfWindows <= 0) {
				System.out.println(
						"The number of Windows must be greater than zero and not exceed the maximum number of Windows");
			} else {
				this.name = name;
				this.square = square;
				this.numberOfWindows = numberOfWindows;
				this.illumination = Window.ILLUMINATION * numberOfWindows;
			}
		}
	}

	public int getNumberOfWindows() {
		return numberOfWindows;
	}

	public void setNumberOfWindows(int numberOfWindows) {
		this.numberOfWindows = numberOfWindows;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(Lamp lamp) throws IlluminanceTooMuchException {
		if (isIlluminationAvailable(lamp.getIllumination())) {
			lampsList.add(lamp);
		}
	}

	public void add(Furniture furniture) throws SpaceUsageTooMuchException {
		if (isSpaceAvailable(furniture.getMaxSquare()))
			furnitureList.add(furniture);
	}

	private boolean isIlluminationAvailable(int lampIllumination) throws IlluminanceTooMuchException {
		if (lampIllumination < MAX_ILLUMINANCE - illumination) {
			illumination += lampIllumination;
			return true;
		}
		throw new IlluminanceTooMuchException();
	}

	private boolean isSpaceAvailable(double furnitureSquare) throws SpaceUsageTooMuchException {
		allowableSquare = square * MAX_OCCUPIED_AREA;
		if (furnitureSquare < allowableSquare) {
			usedSquare += furnitureSquare;
			return true;
		}
		throw new SpaceUsageTooMuchException();
	}

	public boolean validateMinIllumination() throws IlluminanceTooLittleException {
		if (illumination > MIN_ILLUMINANCE) {
			return true;
		}
		throw new IlluminanceTooLittleException();
	}

	public double getFreeSpace() {
		return square - usedSquare;
	}

	public int getPercentOfFreeSpace() {
		return (int) ((1 - usedSquare / square) * 100);
	}

	public String getLamp() {
		String infoAboutLamp = "";
		if (lampsList.isEmpty()) {
			return "No lamps";
		} else {
			for (Lamp lamp : lampsList) {
				infoAboutLamp += lamp.getIllumination() + " lux ";
			}
		}
		return infoAboutLamp.trim();
	}

	public void describeRoom() {

		System.out.println(getName());
		System.out.println("Illuminance = " + illumination + " (" + numberOfWindows + " windows on "
				+ Window.ILLUMINATION + " lux, lamps " + getLamp() + ")");
		System.out.println("Square = " + this.square + " m^2 (occupied " + this.usedSquare + " m^2, guaranteed free "
				+ getFreeSpace() + " or " + getPercentOfFreeSpace() + " %");
		System.out.println("Furniture : ");

		if (furnitureList.isEmpty()) {
			System.out.println("No furniture");
		} else {
			for (Furniture furniture : furnitureList) {
				System.out.println(furniture);
			}
		}
	}
}
