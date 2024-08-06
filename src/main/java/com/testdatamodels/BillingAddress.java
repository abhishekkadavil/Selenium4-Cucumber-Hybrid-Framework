package com.testdatamodels;

import lombok.*;

/**
 * @author Abhishek Kadavil
 */
@Data
@NoArgsConstructor
public class BillingAddress {

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
