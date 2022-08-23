package com.testDataModels;

import lombok.*;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestDataModel {

	private Login_credentail login_credentail;
	private List<Item> items = null;
	private Billing_address billing_address;
	private Shipping_address shipping_address;
	private Payment payment;
}
