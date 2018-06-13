package by.epam.training.bean;

public class Furniture {

	private String name;
	private double maxSquare;
	private double minSquare;

	public Furniture(String name, double maxSquare) {
		this.name = name;
		this.maxSquare = maxSquare;
	}

	public Furniture(String name, double minSquare, double maxSquare) {
		this.name = name;
		this.maxSquare = maxSquare;
		this.minSquare = minSquare;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMaxSquare() {
		return maxSquare;
	}

	public void setMaxSquare(double maxSquare) {
		this.maxSquare = maxSquare;
	}

	public double getMinSquare() {
		return minSquare;
	}

	public void setMinSquare(double minSquare) {
		this.minSquare = minSquare;
	}

	@Override
	public String toString() {
		return "\t\t\t" + getName() + " " + "(Square " + getMaxSquare() + " m^2)";
	}
}
