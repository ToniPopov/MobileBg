package User;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
<<<<<<< HEAD
    private String ID;
    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPass;
    //TODO: private Set<Note> note;
    //TODO: private Set<Ad> ads;

    // For normal user
    public User(String ID, String email, String userName, String firstName, String lastName, String password, String confirmPass) {
        this.ID = ID; //TODO: Verification for unique ID

        isValidEmailId(email); //TODO: maybe change it to boolean

        if (isValidString(userName)) {
            this.userName = userName;
        }
        if (isValidString(firstName)) {
            this.firstName = firstName;
        }
        if (isValidString(lastName)) {
            this.lastName = lastName;
        }
        if (isValidString(password)) {
            this.password = password;
        }
        if (isValidString(confirmPass)) {
            this.confirmPass = confirmPass;
        }

    }

    // For dealer
    public User(String ID, String email, String userName, String firstName, String password, String confirmPass) {
        this.ID = ID; //TODO: Verification for unique ID

        isValidEmailId(email); //TODO: maybe change it to boolean

        if (isValidString(userName)) {
            this.userName = userName;
        }
        if (isValidString(firstName)) {
            this.firstName = firstName;
        }
        if (isValidString(password)) {
            this.password = password;
        }
        if (isValidString(confirmPass)) {
            this.confirmPass = confirmPass;
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
=======
	private long id;
	private String email;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String confirmPass;
	//TODO: private Set<Note> note;
	//TODO: private Set<Ad> ads;

	// For normal user
	public User(long id, String email, String userName, String firstName, String lastName, String password, String confirmPass) {
		this.ID = ID; //TODO: Verification for unique ID
		
		isValidEmailId(email); //TODO: maybe change it to boolean
		
		if (isValidString(userName)) {
			this.userName = userName;
		}
		if (isValidString(firstName)) {
			this.firstName = firstName;
		}
		if (isValidString(lastName)) {
			this.lastName = lastName;
		}
		if (isValidString(password)) {
			this.password = password;
		}
		if (isValidString(confirmPass)) {
			this.confirmPass = confirmPass;
		}
		
	}

	// For dealer
	public User(long id, String email, String userName, String firstName, String password, String confirmPass) {
		this.ID = ID; //TODO: Verification for unique ID
		
		isValidEmailId(email); //TODO: maybe change it to boolean
		
		if (isValidString(userName)) {
			this.userName = userName;
		}
		if (isValidString(firstName)) {
			this.firstName = firstName;
		}
		if (isValidString(password)) {
			this.password = password;
		}
		if (isValidString(confirmPass)) {
			this.confirmPass = confirmPass;
		}
	}
	
	// for now the return type is String later will be boolean 
		protected static String isValidEmailId(String email) {
	        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	        Pattern p = Pattern.compile(emailPattern);
	        Matcher m = p.matcher(email);
	        if(m.matches()){
	        	return email;
	        }else{
	        	return "No email";
	        }
	    }
		
	protected boolean isValidString(String str) {
		return str != null && !str.isEmpty();
	}
>>>>>>> 961142253a322725512e24e8e77c56228a73a531

}

