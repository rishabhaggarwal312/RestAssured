package com.rishabh.tests;


import com.rishabh.dataproviders.createOfferDataProvider;
import com.rishabh.helpers.CreateOfferHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CreateOffersTest {

    private CreateOfferHelper createOfferHelper;

    @BeforeClass
    public void init() {
        createOfferHelper = new CreateOfferHelper();
    }

    @Test(dataProviderClass = createOfferDataProvider.class, dataProvider = "applyFiftyPerOff", description = "Validate the response from create offer API for new offer with valid restaurant having % discount")
    public void testCreateOffer(int restaurant_id, String offer_type, int offer_value, List<String> customer_segment) {

        Response createOfferResponse = createOfferHelper.createOffer(restaurant_id, offer_type, offer_value, customer_segment);
        System.out.println("Response Body \n" + createOfferResponse.getBody().asString());
        Assert.assertEquals(createOfferResponse.getStatusCode(), HttpStatus.SC_OK, "Offer creation Failed");
        Assert.assertEquals(createOfferResponse.jsonPath().getString("response_msg"), "success");

    }
}
