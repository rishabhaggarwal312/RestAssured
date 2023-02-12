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

public class GetUserSegmentHelper {

    private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
    private static final String MOCK_PORT = ConfigManager.getInstance().getString("mockPort");

    public GetUserSegmentHelper() {
        RestAssured.baseURI = BASE_URL;
//        RestAssured.port = Integer.parseInt(MOCK_PORT);
        RestAssured.useRelaxedHTTPSValidation();

    }


    public String getUserSegment(int user_id) {

        Response response = RestAssured
                .given().log().all()
                .queryParam("user_id", user_id)
                .contentType(ContentType.JSON)
                .port(1080)
                .when()
                .get(EndPoints.GET_USER_SEGMENT)
                .andReturn();

        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        return response.jsonPath().getString("segment");
    }

}
