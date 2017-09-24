package Products;

import Enums.Transmission;
import Enums.TypeEngine;
import Enums.VehicleCategory;

public abstract class LoadingVehicle extends MotorProduct {

	protected int numOfSeats;
	protected int loadCapacity;
	protected int numOfAxles;

	public LoadingVehicle(String title, Condition condition, double price, String color, String email, String phoneNum,
			TypeEngine typeEngine, int euroStandart, Transmission transmission, VehicleCategory categoryVehicle,
			int mileage, String marka, int cubic, int numOfSeats, int loadCapacity, int numOfAxles) {
		super(title, condition, price, color, email, phoneNum, typeEngine, euroStandart, transmission, categoryVehicle,
				mileage, marka, cubic);
		this.numOfSeats = checkInt(numOfSeats);
		this.loadCapacity = checkInt(loadCapacity);
		this.numOfAxles = checkInt(numOfAxles);
	}

	public LoadingVehicle(String title, String email, String phoneNum) {
		super(title,  email,  phoneNum);
	}

	private int checkInt(int i) {
		if (i > 0) {
			return i;
		} else {
			return 0;
		}
	}

}
