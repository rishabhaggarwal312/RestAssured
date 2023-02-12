package com.rishabh.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cart_value",
        "user_id",
        "restaurant_id"
})
@Generated("jsonschema2pojo")
public class ApplyOfferModel {

    @JsonProperty("cart_value")
    private Integer cartValue;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("restaurant_id")
    private Integer restaurantId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("cart_value")
    public Integer getCartValue() {
        return cartValue;
    }

    @JsonProperty("cart_value")
    public void setCartValue(Integer cartValue) {
        this.cartValue = cartValue;
    }

    @JsonProperty("user_id")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("restaurant_id")
    public Integer getRestaurantId() {
        return restaurantId;
    }

    @JsonProperty("restaurant_id")
    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}