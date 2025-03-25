package oop;

public class Car extends Vehicle {
	String color;
	int numPassengers = 0;
	//constructor
	public Car(String color,int numPassengers) {
		this.color = color;
		this.numPassengers = numPassengers;
	}
}
