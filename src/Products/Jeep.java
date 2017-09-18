package Products;

import Enums.Transmission;
import Enums.TypeEngine;
import Enums.VehicleCategory;

public class Jeep extends MotorProduct{

	public Jeep(String title, Condition condition, double price, String color, String email, String phoneNum,
			TypeEngine typeEngine, int euroStandart, Transmission transmission, VehicleCategory categoryVehicle,
			int mileage, String marka, int cubic) {
		super(title, condition, price, color, email, phoneNum, typeEngine, euroStandart, transmission, categoryVehicle, mileage,
				marka, cubic);
	}

}
