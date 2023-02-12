package com.rishabh.helpers;

import com.rishabh.constants.EndPoints;
import com.rishabh.model.ApplyOfferModel;
import com.rishabh.model.CreateOfferModel;
import com.rishabh.utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ApplyOfferHelper {

    private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
    private static final String BASE_PORT = ConfigManager.getInstance().getString("basePort");

    public ApplyOfferHelper() {
        RestAssured.baseURI = BASE_URL;
//        RestAssured.port = Integer.parseInt(BASE_PORT);
        RestAssured.useRelaxedHTTPSValidation();

    }

    public int applyCartOffer(int cart_value, int user_id,int restaurant_id) {
        ApplyOfferModel applyOfferModel = new ApplyOfferModel();

        applyOfferModel.setCartValue(cart_value);
        applyOfferModel.setUserId(user_id);
        applyOfferModel.setRestaurantId(restaurant_id);

        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .port(9001)
                .when()
                .body(applyOfferModel)
                .post(EndPoints.APPLY_CART_OFFER)
                .andReturn();

        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        return response.jsonPath().getInt("cart_value");
    }


}
