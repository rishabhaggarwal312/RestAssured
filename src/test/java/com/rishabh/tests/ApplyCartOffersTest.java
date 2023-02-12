package com.rishabh.tests;

import com.rishabh.dataproviders.createOfferDataProvider;
import com.rishabh.helpers.ApplyOfferHelper;
import com.rishabh.helpers.CreateOfferHelper;
import com.rishabh.helpers.GetUserSegmentHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ApplyCartOffersTest {

    private CreateOfferHelper createOfferHelper;
    private ApplyOfferHelper applyOfferHelper;
    private GetUserSegmentHelper getUserSegmentHelper;

    @BeforeClass
    public void init() {
        createOfferHelper = new CreateOfferHelper();
        applyOfferHelper = new ApplyOfferHelper();
        getUserSegmentHelper = new GetUserSegmentHelper();
    }

    @Test(dataProviderClass = createOfferDataProvider.class, dataProvider = "applyFiftyPerOff")
    public void applyFiftyPerOff(int restaurant_id, String offer_type, int offer_value, List<String> customer_segment, int user_id) {
        Random rand = new Random();
        int cart_value = rand.nextInt(9999);
        int expected_cart_value;

        Response createOfferResponse = createOfferHelper.createOffer(restaurant_id, offer_type, offer_value, customer_segment);
        System.out.println("Create Offer Response Body \n" + createOfferResponse.getBody().asString());
        Assert.assertEquals(createOfferResponse.getStatusCode(), HttpStatus.SC_OK, "Offer creation Failed");
        Assert.assertEquals(createOfferResponse.jsonPath().getString("response_msg"), "success");

        int applyCartOfferResponse = applyOfferHelper.applyCartOffer(cart_value, user_id, restaurant_id);

        if (getUserSegmentHelper.getUserSegment(user_id).matches(customer_segment.get(0))) {
            if (offer_type.equals("FLATX")) {
                expected_cart_value = cart_value - offer_value;
            } else {
                expected_cart_value = (int) (cart_value - cart_value * offer_value * (0.01));
            }
            Assert.assertEquals(applyCartOfferResponse, expected_cart_value, "Cart Value is incorrect Test Failed");
        } else {
            Assert.assertEquals(applyCartOfferResponse, cart_value, "Cart Value is incorrect Test Failed");

        }


    }


    @Test(dataProviderClass = createOfferDataProvider.class, dataProvider = "applyTenPerOff")
    public void applyTenPerOff(int restaurant_id, String offer_type, int offer_value, List<String> customer_segment, int user_id) {
        Random rand = new Random();
        int cart_value = rand.nextInt(9999);
        int expected_cart_value;

        Response createOfferResponse = createOfferHelper.createOffer(restaurant_id, offer_type, offer_value, customer_segment);
        System.out.println("Create Offer Response Body \n" + createOfferResponse.getBody().asString());
        Assert.assertEquals(createOfferResponse.getStatusCode(), HttpStatus.SC_OK, "Offer creation Failed");
        Assert.assertEquals(createOfferResponse.jsonPath().getString("response_msg"), "success");

        int applyCartOfferResponse = applyOfferHelper.applyCartOffer(cart_value, user_id, restaurant_id);

        if (getUserSegmentHelper.getUserSegment(user_id).matches(customer_segment.get(0))) {
            if (offer_type.equals("FLATX")) {
                expected_cart_value = cart_value - offer_value;
            } else {
                expected_cart_value = (int) (cart_value - cart_value * offer_value * (0.01));
            }
            Assert.assertEquals(applyCartOfferResponse, expected_cart_value, "Cart Value is incorrect Test Failed");
        } else {
            Assert.assertEquals(applyCartOfferResponse, cart_value, "Cart Value is incorrect Test Failed");

        }
    }

    @Test(dataProviderClass = createOfferDataProvider.class, dataProvider = "applyNoSegmentOffer")
    public void applyNoSegmentOffer(int restaurant_id, String offer_type, int offer_value, List<String> customer_segment, int user_id) {
        Random rand = new Random();
        int cart_value = rand.nextInt(9999);
        int expected_cart_value;

        Response createOfferResponse = createOfferHelper.createOffer(restaurant_id, offer_type, offer_value, customer_segment);
        System.out.println("Create Offer Response Body \n" + createOfferResponse.getBody().asString());
        Assert.assertEquals(createOfferResponse.getStatusCode(), HttpStatus.SC_OK, "Offer creation Failed");
        Assert.assertEquals(createOfferResponse.jsonPath().getString("response_msg"), "success");

        int applyCartOfferResponse = applyOfferHelper.applyCartOffer(cart_value, user_id, restaurant_id);

        if (getUserSegmentHelper.getUserSegment(user_id).matches(customer_segment.get(0))) {
            if (offer_type.equals("FLATX")) {
                expected_cart_value = cart_value - offer_value;
            } else {
                expected_cart_value = (int) (cart_value - cart_value * offer_value * (0.01));
            }
            Assert.assertEquals(applyCartOfferResponse, expected_cart_value, "Cart Value is incorrect Test Failed");
        } else {
            Assert.assertEquals(applyCartOfferResponse, cart_value, "Cart Value is incorrect Test Failed");

        }


    }

    @Test(dataProviderClass = createOfferDataProvider.class, dataProvider = "applyFlat10Offer")
    public void applyFlat10Offer(int restaurant_id, String offer_type, int offer_value, List<String> customer_segment, int user_id) {
        Random rand = new Random();
        int cart_value = rand.nextInt(9999);
        int expected_cart_value;

        Response createOfferResponse = createOfferHelper.createOffer(restaurant_id, offer_type, offer_value, customer_segment);
        System.out.println("Create Offer Response Body \n" + createOfferResponse.getBody().asString());
        Assert.assertEquals(createOfferResponse.getStatusCode(), HttpStatus.SC_OK, "Offer creation Failed");
        Assert.assertEquals(createOfferResponse.jsonPath().getString("response_msg"), "success");

        int applyCartOfferResponse = applyOfferHelper.applyCartOffer(cart_value, user_id, restaurant_id);

        if (getUserSegmentHelper.getUserSegment(user_id).matches(customer_segment.get(0))) {
            if (offer_type.equals("FLATX")) {
                expected_cart_value = cart_value - offer_value;
            } else {
                expected_cart_value = (int) (cart_value - cart_value * offer_value * (0.01));
            }
            Assert.assertEquals(applyCartOfferResponse, expected_cart_value, "Cart Value is incorrect Test Failed");
        } else {
            Assert.assertEquals(applyCartOfferResponse, cart_value, "Cart Value is incorrect Test Failed");

        }
    }

    @Test(dataProviderClass = createOfferDataProvider.class, dataProvider = "applyFlatWithLessCartValue")
    public void applyFlatWithLessCartValue(int restaurant_id, String offer_type, int offer_value, List<String> customer_segment, int user_id) {
        int cart_value = 200;
        int expected_cart_value;

        Response createOfferResponse = createOfferHelper.createOffer(restaurant_id, offer_type, offer_value, customer_segment);
        System.out.println("Create Offer Response Body \n" + createOfferResponse.getBody().asString());
        Assert.assertEquals(createOfferResponse.getStatusCode(), HttpStatus.SC_OK, "Offer creation Failed");
        Assert.assertEquals(createOfferResponse.jsonPath().getString("response_msg"), "success");

        int applyCartOfferResponse = applyOfferHelper.applyCartOffer(cart_value, user_id, restaurant_id);

        if (getUserSegmentHelper.getUserSegment(user_id).matches(customer_segment.get(0))) {
            if (offer_type.equals("FLATX")) {
                expected_cart_value = cart_value - offer_value;
            } else {
                expected_cart_value = (int) (cart_value - cart_value * offer_value * (0.01));
            }
            Assert.assertEquals(applyCartOfferResponse, expected_cart_value, "Cart Value is incorrect Test Failed");
        } else {
            Assert.assertEquals(applyCartOfferResponse, cart_value, "Cart Value is incorrect Test Failed");

        }
    }

    @Test(dataProviderClass = createOfferDataProvider.class, dataProvider = "applyOfferNegativeCartValue")
    public void applyOfferNegativeCartValue(int restaurant_id, String offer_type, int offer_value, List<String> customer_segment, int user_id) {
        int cart_value = 200;
        int expected_cart_value;

        Response createOfferResponse = createOfferHelper.createOffer(restaurant_id, offer_type, offer_value, customer_segment);
        System.out.println("Create Offer Response Body \n" + createOfferResponse.getBody().asString());
        Assert.assertEquals(createOfferResponse.getStatusCode(), HttpStatus.SC_OK, "Offer creation Failed");
        Assert.assertEquals(createOfferResponse.jsonPath().getString("response_msg"), "success");

        int applyCartOfferResponse = applyOfferHelper.applyCartOffer(cart_value, user_id, restaurant_id);

        if (getUserSegmentHelper.getUserSegment(user_id).matches(customer_segment.get(0))) {
            if (offer_type.equals("FLATX")) {
                expected_cart_value = cart_value - offer_value;
            } else {
                expected_cart_value = (int) (cart_value - cart_value * offer_value * (0.01));
            }
            Assert.assertEquals(applyCartOfferResponse, expected_cart_value, "Cart Value is incorrect Test Failed");
        } else {
            Assert.assertEquals(applyCartOfferResponse, cart_value, "Cart Value is incorrect Test Failed");

        }
    }


}
