package com.testDataModels;

public class Payment {

	private String pmtType;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Payment() {
	}

	/**
	 *
	 * @param pmtType
	 */
	public Payment(String pmtType) {
		super();
		this.pmtType = pmtType;
	}

	public String getPmtType() {
		return pmtType;
	}

	public void setPmtType(String pmtType) {
		this.pmtType = pmtType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("pmtType");
		sb.append('=');
		sb.append(((this.pmtType == null) ? "<null>" : this.pmtType));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
