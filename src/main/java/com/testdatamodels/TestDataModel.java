package com.testdatamodels;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
public class TestDataModel {

	private LoginCredential loginCredential;
	private List<Item> items = null;
	private BillingAddress billingAddress;
	private ShippingAddress shippingAddress;
	private Payment payment;
}
