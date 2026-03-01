package com.swaglabs.utils;

import org.testng.asserts.SoftAssert;


public class CustomSoftAssertion extends SoftAssert {

    public static CustomSoftAssertion softAssertion = new CustomSoftAssertion();

    public static void customAssertAll() {
        try {
        softAssertion.assertAll("Custom Soft Assert");
        } catch (Exception e) {
            System.out.println("Soft Assert Failed" );
        }
    }

}
