package db_connection;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Products.Bus;
import Products.Insertable;

public class Db_Connection {
	private Connection con;
	private Statement stat;
	private ResultSet set;

	public Db_Connection(String user, String pass, String database) {
		try {
			String url = "jdbc:mysql://localhost/" + database;
			// String user = "root";
			// String pass = "";
			con = DriverManager.getConnection(url, user, pass);
			stat = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean insert(Insertable bus) {
		

		List<Field> fieldList = new ArrayList<Field>();
		Class<?> tmpClass = bus.getClass();
		while (tmpClass != null) {
			fieldList.addAll(Arrays.asList(tmpClass.getDeclaredFields()));
			tmpClass = tmpClass.getSuperclass();
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;
		sb.append("INSERT INTO " + bus.getClass().getSimpleName().toLowerCase() + " (");
		for (Field field : fieldList) {
			i++;
			if (fieldList.size() == i) {
				sb.append(field.getName() + ") VALUES (" + bus.toStringForInsert() + " );");
			} else {
				sb.append(field.getName() + " , ");
			}
		}

		System.out.println(sb.toString());
		String s = sb.toString();
		try {
			stat.executeUpdate(s);
			System.out.println(set);
//			String sql = "SELECT last_insert_id() from bus";
		} catch (SQLException e) {
			System.out.println(e.getCause());
			System.out.println(e.getSQLState());
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			return false;
		}
		return true;
	}

}
