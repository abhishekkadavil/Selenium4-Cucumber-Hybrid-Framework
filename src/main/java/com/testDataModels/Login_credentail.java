package com.testDataModels;

public class Login_credentail {

	private String username;
	private String password;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Login_credentail() {
	}

	/**
	 *
	 * @param password
	 * @param username
	 */
	public Login_credentail(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("username");
		sb.append('=');
		sb.append(((this.username == null) ? "<null>" : this.username));
		sb.append(',');
		sb.append("password");
		sb.append('=');
		sb.append(((this.password == null) ? "<null>" : this.password));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
