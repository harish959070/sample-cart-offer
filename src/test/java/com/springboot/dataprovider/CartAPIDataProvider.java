package com.springboot.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.List;

public class CartAPIDataProvider {

    @DataProvider(name = "getCreateOfferData")
    public static Object[][] getCreateOfferData() {
        return new Object[][] {
                {
                    1, "FLATX", 150, List.of("p1")
                },
                {
                        2, "FLATX", 200, List.of("p2")
                },
                {
                        3, "PERCENT", 10, List.of("p3")
                }
        };
    }

    @DataProvider(name = "getApplyOfferData")
    public static Object[][] getApplyOfferData() {
        return new Object[][] {
                {
                        300, 1, 1, 150
                },
                {
                        300, 2, 2, 100
                },
                {
                        300, 3, 3, 270
                }
        };
    }

}
