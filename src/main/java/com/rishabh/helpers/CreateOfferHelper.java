package com.rishabh.helpers;

import com.rishabh.constants.EndPoints;
import com.rishabh.model.CreateOfferModel;
import com.rishabh.utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CreateOfferHelper {

    private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
    private static final String BASE_PORT = ConfigManager.getInstance().getString("basePort");

    public CreateOfferHelper() {
        RestAssured.baseURI = BASE_URL;
//        RestAssured.port = Integer.parseInt(BASE_PORT);
        RestAssured.useRelaxedHTTPSValidation();

    }

    public Response createOffer(int restaurant_id, String offer_type, int offer_value, List<String> customer_segment) {
        CreateOfferModel createOfferModel = new CreateOfferModel();

        createOfferModel.setOfferValue(offer_value);
        createOfferModel.setOfferType(offer_type);
        createOfferModel.setRestaurantId(restaurant_id);
        createOfferModel.setCustomerSegment(customer_segment);

        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .port(9001)
                .when()
                .body(createOfferModel)
                .post(EndPoints.CREATE_OFFER)
                .andReturn();

        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        return response;
    }
}
