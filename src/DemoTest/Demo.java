package DemoTest;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.TreeMap;

import com.google.gson.Gson;
import com.mysql.jdbc.ResultSetMetaData;

import Enums.Transmission;
import Enums.TypeEngine;
import Enums.VehicleCategory;
import Products.Bus;
import Products.Condition;
import Products.Truck;
import db_connection.Db_Connection;

public class Demo {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException,
			IntrospectionException, InvocationTargetException, SQLException {

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

//		System.out.println(db.insert(bus) ? "Inserted" : "Not inserted");
		ResultSet set = db.selectQuery("Select * from bus ", bus);
		JSONArray js = convertResultSetToJson(set);
//		JSONArray j = new JSONArray();
		TreeMap<Integer, Bus> buses = new TreeMap<Integer, Bus>();
		// while (set.next()) {
		// buses.put(set.getInt("busID"),
		// new Bus(set.getString("title"), set.getString("email"),
		// set.getString("phoneNum")));
		// }
		Gson gson = new Gson();
//		j.add(gson.toJson(js, Bus.class));
		for (int i = 0; i < js.size(); i++) {
//			buses.put(i,gson.fromJson((String) j.get(i),Bus.class));
			System.out.println(js.get(i));
		}
		
		for (Entry<Integer, Bus> ent : buses.entrySet()) {
			System.out.println("ID " + ent.getKey());
			System.out.println(ent.getValue());
		}

		// final BeanInfo beanInfo = Introspector.getBeanInfo(bus.getClass());
		// for (final PropertyDescriptor descriptor :
		// beanInfo.getPropertyDescriptors()) {
		// final Object propertyValue = descriptor.getPropertyEditorClass();
		// System.out.println(propertyValue);
		// }
	}

	public static JSONArray convertResultSetToJson(ResultSet resultSet) throws SQLException {
		JSONArray json = new JSONArray();
		ResultSetMetaData metadata = (ResultSetMetaData) resultSet.getMetaData();
		int numColumns = metadata.getColumnCount();

		while (resultSet.next()) // iterate rows
		{
			JSONObject obj = new JSONObject(); // extends HashMap
			for (int i = 1; i <= numColumns; ++i) // iterate columns
			{
				String column_name = metadata.getColumnName(i);
				obj.put(column_name, resultSet.getObject(column_name));
			}
			json.add(obj);
		}
		return json;
	}
}
