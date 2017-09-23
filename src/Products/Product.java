package Products;

import java.awt.Image;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Product {

	protected long ID;
	protected String title;
	protected Condition conditions;
	protected Date manufacturing;
	protected double price;
	protected String color;
	protected Date dateUpload;
	protected String email;
	protected String phoneNum;
	protected String regionToSale;
	protected Date expiryDate;
	protected String typeProduct;
	protected Image[] images;

	Product(String title, Condition condition, double price, String color, String email,String phoneNum) {
		this.title = stringValidate(title);
		this.color = stringValidate(color);
		this.email = isValidEmailId(email);
		this.phoneNum = phoneNumValidator(phoneNum);
		if (price > 0) {
			this.price = price;
		}
		this.conditions = condition;
		this.typeProduct = this.getClass().getSimpleName();
		this.dateUpload = new Date(); // when we create a product we aded a date
	}
	// Product( ){
	// typeProduct = this.getClass().getSimpleName();
	// this.phoneNum= phoneNumValidator( phoneNum);
	// }

	private String stringValidate(String str) {

		if (str != null && !str.isEmpty()) {
			return str;
		} else {
			return "Default";
		}

	}

	// for now the return type is String later will be boolean
	private static String isValidEmailId(String email) {
		String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern p = Pattern.compile(emailPattern);
		Matcher m = p.matcher(email);
		if (m.matches()) {
			return email;
		} else {
			return "No email";
		}
	}

	private String phoneNumValidator(String number) {
		Pattern pattern = Pattern.compile("^[0-9 -/]+");
		Matcher matcher = pattern.matcher(number);
		if (matcher.matches()) {
			return number;
		} else {
			return "No phone";
		}
	}

}
