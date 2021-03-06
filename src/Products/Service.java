package Products;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {
	private String ID;
	private String title;
	private String email;
	private String phoneNumber;
	private String address;
	private String text;
	// TODO: private TypeService type; //*for which product*

	public Service(String ID, String title, String email, String phoneNumber, String address, String text) {
		this.ID = ID; // TODO: Verification for unique ID

		if (isValidString(title)) {
			this.title = title;
		}

		isValidEmailId(email); // TODO: maybe change it to boolean

		phoneNumValidator(phoneNumber);
		if (isValidString(address)) {
			this.address = address;
		}
		if (isValidString(text)) {
			this.text = text;
		}
	}

	// for now the return type is String later will be boolean
	protected static String isValidEmailId(String email) {
		String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern p = Pattern.compile(emailPattern);
		Matcher m = p.matcher(email);
		if (m.matches()) {
			return email;
		} else {
			return "No email";
		}
	}

	protected boolean isValidString(String str) {
		return str != null && !str.isEmpty();
	}
	
	private String phoneNumValidator(String number){
		Pattern pattern = Pattern.compile("^[0-9 -/]+");
		Matcher matcher = pattern.matcher(number); 
		 if (matcher.matches()) {
		     return number;
		 }else{
			 return "No phone";
		 }
	}
}

