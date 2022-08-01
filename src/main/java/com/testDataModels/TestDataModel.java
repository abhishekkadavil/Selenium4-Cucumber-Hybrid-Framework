package com.testDataModels;

import java.util.List;

public class TestDataModel {

	private Login_credentail login_credentail;
	private List<Item> items = null;
	private Billing_address billing_address;
	private Shipping_address shipping_address;
	private Payment payment;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public TestDataModel() {
	}

	/**
	 *
	 * @param login_credentail
	 * @param billing_address
	 * @param payment
	 * @param shipping_address
	 * @param items
	 */
	public TestDataModel(Login_credentail login_credentail, List<Item> items, Billing_address billing_address,
			Shipping_address shipping_address, Payment payment) {
		super();
		this.login_credentail = login_credentail;
		this.items = items;
		this.billing_address = billing_address;
		this.shipping_address = shipping_address;
		this.payment = payment;
	}

	public Login_credentail getLogin_credentail() {
		return login_credentail;
	}

	public void setLogin_credentail(Login_credentail login_credentail) {
		this.login_credentail = login_credentail;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Billing_address getBilling_address() {
		return billing_address;
	}

	public void setBilling_address(Billing_address billing_address) {
		this.billing_address = billing_address;
	}

	public Shipping_address getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(Shipping_address shipping_address) {
		this.shipping_address = shipping_address;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("login_credentail");
		sb.append('=');
		sb.append(((this.login_credentail == null) ? "<null>" : this.login_credentail));
		sb.append(',');
		sb.append("items");
		sb.append('=');
		sb.append(((this.items == null) ? "<null>" : this.items));
		sb.append(',');
		sb.append("billing_address");
		sb.append('=');
		sb.append(((this.billing_address == null) ? "<null>" : this.billing_address));
		sb.append(',');
		sb.append("shipping_address");
		sb.append('=');
		sb.append(((this.shipping_address == null) ? "<null>" : this.shipping_address));
		sb.append(',');
		sb.append("payment");
		sb.append('=');
		sb.append(((this.payment == null) ? "<null>" : this.payment));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
