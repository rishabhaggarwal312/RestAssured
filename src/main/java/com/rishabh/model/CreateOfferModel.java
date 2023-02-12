package com.rishabh.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "restaurant_id",
        "offer_type",
        "offer_value",
        "customer_segment"
})
@Generated("jsonschema2pojo")
public class CreateOfferModel {

    @JsonProperty("restaurant_id")
    private Integer restaurantId;
    @JsonProperty("offer_type")
    private String offerType;
    @JsonProperty("offer_value")
    private Integer offerValue;
    @JsonProperty("customer_segment")
    private List<String> customerSegment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("restaurant_id")
    public Integer getRestaurantId() {
        return restaurantId;
    }

    @JsonProperty("restaurant_id")
    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    @JsonProperty("offer_type")
    public String getOfferType() {
        return offerType;
    }

    @JsonProperty("offer_type")
    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    @JsonProperty("offer_value")
    public Integer getOfferValue() {
        return offerValue;
    }

    @JsonProperty("offer_value")
    public void setOfferValue(Integer offerValue) {
        this.offerValue = offerValue;
    }

    @JsonProperty("customer_segment")
    public List<String> getCustomerSegment() {
        return customerSegment;
    }

    @JsonProperty("customer_segment")
    public void setCustomerSegment(List<String> customerSegment) {
        this.customerSegment = customerSegment;
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