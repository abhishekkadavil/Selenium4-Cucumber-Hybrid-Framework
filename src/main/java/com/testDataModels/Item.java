package com.testDataModels;

public class Item {

	private String url;
	private String size;
	private String quantity;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Item() {
	}

	/**
	 *
	 * @param quantity
	 * @param size
	 * @param url
	 */
	public Item(String url, String size, String quantity) {
		super();
		this.url = url;
		this.size = size;
		this.quantity = quantity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("url");
		sb.append('=');
		sb.append(((this.url == null) ? "<null>" : this.url));
		sb.append(',');
		sb.append("size");
		sb.append('=');
		sb.append(((this.size == null) ? "<null>" : this.size));
		sb.append(',');
		sb.append("quantity");
		sb.append('=');
		sb.append(((this.quantity == null) ? "<null>" : this.quantity));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
