package by.epam.training.logic;

import java.util.HashMap;

public class Building {

	private String name;

	private Room room;
	private HashMap<String, Room> roomMap = new HashMap<>();

	public Building(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addRoom(String name, double square, int numberOfWindows) {
		room = new Room(name, square, numberOfWindows);
		roomMap.put(room.getName(), room);
	}

	public Room getRoom(String name) {
		return roomMap.get(name);
	}

	public void describe() {
		System.out.println(getName());
		for (HashMap.Entry<String, Room> pair : roomMap.entrySet()) {
			pair.getValue().describeRoom();
		}

	}

}
