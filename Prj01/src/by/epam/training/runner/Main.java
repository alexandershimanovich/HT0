package by.epam.training.runner;

import by.epam.training.bean.Furniture;
import by.epam.training.bean.illumination.Lamp;
import by.epam.training.exception.IlluminanceTooMuchException;
import by.epam.training.exception.SpaceUsageTooMuchException;
import by.epam.training.logic.Building;

public class Main {

	public static void main(String[] args) {

		Building buildingOne = new Building("Building One");
		buildingOne.addRoom("Bedroom", 20, 3);
		try {
			buildingOne.getRoom("Bedroom").add(new Lamp(150));
			buildingOne.getRoom("Bedroom").add(new Lamp(300));
			buildingOne.getRoom("Bedroom").add(new Furniture("Chair", 1.0));
			buildingOne.getRoom("Bedroom").add(new Furniture("Bed", 2.0));

			buildingOne.addRoom("Kitchen", 3, 1);
			buildingOne.getRoom("Kitchen").add(new Furniture("Table", 0.5));
			buildingOne.getRoom("Kitchen").add(new Furniture("Chair", 0.2));
			buildingOne.getRoom("Kitchen").add(new Lamp(300));
		} catch (IlluminanceTooMuchException | SpaceUsageTooMuchException e) {
			e.printStackTrace();
		}
		buildingOne.describe();
	}
}