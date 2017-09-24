package Products;

import java.awt.Image;
import java.util.Date;

import Enums.*;

public abstract class MotorProduct extends Product {
	protected TypeEngine typeEngine;
	protected int euroStandart;
	protected Transmission transmission;
	protected VehicleCategory categoryVehicle;// (kombi , sedan)
	protected int mileage; // ????
	protected String marka;
	protected int cubic;

	private MotorProduct(String title, Condition condition, double price, String color, String email, String phoneNum) {
		super(title, condition, price, color, email, phoneNum);
	}

	public MotorProduct(String title, Condition condition, double price, String color, String email, String phoneNum,
			TypeEngine typeEngine, int euroStandart, Transmission transmission, VehicleCategory categoryVehicle,
			int mileage, String marka, int cubic) {
		this(title, condition, price, color, email, phoneNum);
		this.typeEngine = typeEngine;
		if (euroStandart >= 0 && euroStandart <= 6) {
			this.euroStandart = euroStandart;
		}
		this.transmission = transmission;
		this.categoryVehicle = categoryVehicle;
		if (mileage >= 0) {
			this.mileage = mileage;
		}
		if (marka != null && !marka.isEmpty()) {
			this.marka = marka; // ??? why we need this
		}
		if (cubic > 0) {
			this.cubic = cubic;
		}
	}

	public MotorProduct(String title, String email, String phoneNum) {
		super(title, email, phoneNum);
	}

}
