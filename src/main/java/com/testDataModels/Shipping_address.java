package com.testDataModels;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
