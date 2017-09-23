package Products;

import java.util.Arrays;

import Enums.Transmission;
import Enums.TypeEngine;
import Enums.VehicleCategory;

public class Truck extends LoadingVehicle {

	public Truck(String title, Condition condition, double price, String color, String email, String phoneNum,
			TypeEngine typeEngine, int euroStandart, Transmission transmission, VehicleCategory categoryVehicle,
			int mileage, String marka, int cubic, int numOfSeats, int loadCapacity, int numOfAxles) {
		super(title, condition, price, color, email, phoneNum, typeEngine, euroStandart, transmission, categoryVehicle,
				mileage, marka, cubic, numOfSeats, loadCapacity, numOfAxles);
	}

	@Override
	public String toString() {
		return "=======Truck====== \nnumOfSeats: " + numOfSeats + "\nloadCapacity: " + loadCapacity + "\nnumOfAxles: "
				+ numOfAxles + "\ntypeEngine: " + typeEngine + "\neuroStandart: " + euroStandart + "\ntransmission: "
				+ transmission + "\ncategoryVehicle: " + categoryVehicle + "\nmileage: " + mileage + "\nmarka: " + marka
				+ "\ncubic: " + cubic + "\nID: " + ID + "\ntitle: " + title + "\ncondition: " + conditions
				+ "\nmanufacturing: " + manufacturing + "\nprice: " + price + "\ncolor: " + color + "\ndateUpload: "
				+ dateUpload + "\nemail: " + email + "\nphoneNum: " + phoneNum + "\nregionToSale: " + regionToSale
				+ "\nexpiryDate: " + expiryDate + "\ntypeProduct: " + typeProduct + "\nimages: "
				+ Arrays.toString(images) + "\n";
	}
	public String toStringForInsert() {
		return  " '"+numOfSeats + "' , '" + loadCapacity +"' , '"
				+ numOfAxles + "' , '" + typeEngine + "' , '"+ euroStandart +"' , '"
				+ transmission + "' , '" + categoryVehicle + "' , '"+ mileage + "' , '" + marka
				+"' , '"+ cubic +"' , '" + ID + "' , '" + title +"' , '" + conditions
				+ "' , '" + manufacturing +"' , '" + price + "' , '"+ color + "' , '"
				+ dateUpload + "' , '" + email + "' , '" + phoneNum + "' , '" + regionToSale
				+ "' , '"+ expiryDate + "' , '" + typeProduct + "' , '"
				+ Arrays.toString(images) +"'";
	}
}
