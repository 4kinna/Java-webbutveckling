package bean;

import database.SQLconnection;

//UserBean is a access modelclass,  holds and communicate data about users

public class UserBean {
	private String username, password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//check if we can connect to DB
	public boolean validate(UserBean bean) {

		//make us connect to database that has the name "user"
		if (SQLconnection.connectSQL("user")) {
			return SQLconnection.validateUserSQL(bean);
		}

		return false;
	}

	public void resetUserBean() {
		this.password = null;
		this.username = null;
	}

}
