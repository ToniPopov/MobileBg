package DemoTest;

import Enums.Transmission;
import Enums.TypeEngine;
import Enums.VehicleCategory;
import Products.Condition;
import Products.Truck;

public class Demo {

	public static void main(String[] args) {

		Truck truck = new Truck("Kamion me gazi", Condition.New, 100_000, "Blue", "tonitheonea@gmail.com",
				"0888-51-00-26", TypeEngine.Diesel, 2, Transmission.Manual, VehicleCategory.Hachback, 25, "Man", 80_000,
				4, 1000, 4);
		System.out.println(truck);

	}

}
