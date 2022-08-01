package com.testDataModels;

public class Shipping_address {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String homePh;
	private String mobilePh;
	private String addressTitle;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Shipping_address() {
	}

	/**
	 *
	 * @param zip
	 * @param homePh
	 * @param firstName
	 * @param lastName
	 * @param country
	 * @param mobilePh
	 * @param address
	 * @param addressTitle
	 * @param city
	 * @param state
	 */
	public Shipping_address(String firstName, String lastName, String address, String city, String state, String zip,
			String country, String homePh, String mobilePh, String addressTitle) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.homePh = homePh;
		this.mobilePh = mobilePh;
		this.addressTitle = addressTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHomePh() {
		return homePh;
	}

	public void setHomePh(String homePh) {
		this.homePh = homePh;
	}

	public String getMobilePh() {
		return mobilePh;
	}

	public void setMobilePh(String mobilePh) {
		this.mobilePh = mobilePh;
	}

	public String getAddressTitle() {
		return addressTitle;
	}

	public void setAddressTitle(String addressTitle) {
		this.addressTitle = addressTitle;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("firstName");
		sb.append('=');
		sb.append(((this.firstName == null) ? "<null>" : this.firstName));
		sb.append(',');
		sb.append("lastName");
		sb.append('=');
		sb.append(((this.lastName == null) ? "<null>" : this.lastName));
		sb.append(',');
		sb.append("address");
		sb.append('=');
		sb.append(((this.address == null) ? "<null>" : this.address));
		sb.append(',');
		sb.append("city");
		sb.append('=');
		sb.append(((this.city == null) ? "<null>" : this.city));
		sb.append(',');
		sb.append("state");
		sb.append('=');
		sb.append(((this.state == null) ? "<null>" : this.state));
		sb.append(',');
		sb.append("zip");
		sb.append('=');
		sb.append(((this.zip == null) ? "<null>" : this.zip));
		sb.append(',');
		sb.append("country");
		sb.append('=');
		sb.append(((this.country == null) ? "<null>" : this.country));
		sb.append(',');
		sb.append("homePh");
		sb.append('=');
		sb.append(((this.homePh == null) ? "<null>" : this.homePh));
		sb.append(',');
		sb.append("mobilePh");
		sb.append('=');
		sb.append(((this.mobilePh == null) ? "<null>" : this.mobilePh));
		sb.append(',');
		sb.append("addressTitle");
		sb.append('=');
		sb.append(((this.addressTitle == null) ? "<null>" : this.addressTitle));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
