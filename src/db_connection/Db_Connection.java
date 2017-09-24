package db_connection;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.jdbc.ResultSetMetaData;

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

	public ResultSet selectQuery(String sql , Insertable bus) throws SQLException{
		List<Field> fieldList = new ArrayList<Field>();
		Class<?> tmpClass = bus.getClass();
		while (tmpClass != null) {
			fieldList.addAll(Arrays.asList(tmpClass.getDeclaredFields()));
			tmpClass = tmpClass.getSuperclass();
		}
		
		
		ResultSet s = stat.executeQuery(sql);
		System.out.println(convertResultSetToJson(s));
//		while(s.next()){
//			System.out.println(s.getCursorName());
//		}
		return stat.executeQuery(sql);
	}
	public static String convertResultSetToJson(ResultSet resultSet) throws SQLException
	{
	    JSONArray json = new JSONArray();
	    ResultSetMetaData metadata = (ResultSetMetaData) resultSet.getMetaData();
	    int numColumns = metadata.getColumnCount();

	    while(resultSet.next())             //iterate rows
	    {
	        JSONObject obj = new JSONObject();      //extends HashMap
	        for (int i = 1; i <= numColumns; ++i)           //iterate columns
	        {
	            String column_name = metadata.getColumnName(i);
	            obj.put(column_name, resultSet.getObject(column_name));
	        }
	        json.add(obj);
	    }
	    return json.toJSONString();
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
