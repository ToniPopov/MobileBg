package DemoTest;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import Enums.Transmission;
import Enums.TypeEngine;
import Enums.VehicleCategory;
import Products.Bus;
import Products.Condition;
import Products.Truck;
import db_connection.Db_Connection;

public class Demo {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, IntrospectionException, InvocationTargetException {

		Truck truck = new Truck("Kamion me gazi", Condition.New, 100_000, "Blue", "tonitheonea@gmail.com",
				"0888-51-00-26", TypeEngine.Diesel, 2, Transmission.Manual, VehicleCategory.Hachback, 25, "Man", 80_000,
				4, 1000, 4);
		// System.out.println(truck);
		Bus bus = new Bus("Kamion me gazi", Condition.New, 100_000, "Blue", "tonitheonea@gmail.com", "0888-51-00-26",
				TypeEngine.Electric, 2, Transmission.Manual, VehicleCategory.Hachback, 25, "Man", 80_000, 4, 1000, 4);
		// System.out.println(bus);

		// Field[] fields = truck.getClass().getDeclaredFields();
		// System.out.println(fields.toString());
		// for(Field f : fields){
		// Class t = f.getType();
		// System.out.println(f.getType());
		// }

		Db_Connection db = new Db_Connection("root", "", "mobileproject");

		System.out.println(db.insert(bus) ? "Inserted" : "Not inserted");
		// final BeanInfo beanInfo = Introspector.getBeanInfo(bus.getClass());
		// for (final PropertyDescriptor descriptor :
		// beanInfo.getPropertyDescriptors()) {
		// final Object propertyValue = descriptor.getPropertyEditorClass();
		// System.out.println(propertyValue);
		// }
	}

}
