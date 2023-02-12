package com.rishabh.dataproviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class createOfferDataProvider {

    /**
     * Data Provider for below case
     * Valid Restaurant ID -> 42400
     * FLAT X% -> offer_type
     * offer_value -> 50
     * Segment -> p1
     * user_id -> 333
     *
     * @return
     * @throws Exception
     */
    @DataProvider(name = "applyFiftyPerOff")
    public Object[][] applyFiftyPerOff() throws Exception {
        List<String> customer_segment = new ArrayList<String>();
        customer_segment.add("p1");
        return new Object[][]{{42400,              //restaurant_id (int)
                "offer_type",       //offer_type (String)
                50,                 //offer_value (int)
                customer_segment,   //customer_segment (String)
                333                 //user_id (int)
        }};
    }


    /**
     * Data Provider for below case
     *
     * @return
     * @throws Exception
     */
    @DataProvider(name = "applyTenPerOff")
    public Object[][] applyTenPerOff() throws Exception {
        List<String> customer_segment = new ArrayList<String>();
        customer_segment.add("p2");
        return new Object[][]{{42401,              //restaurant_id (int)
                "offer_type",       //offer_type (String)
                50,                 //offer_value (int)
                customer_segment,   //customer_segment (String)
                22                 //user_id (int)
        }};
    }

    /**
     * Data Provider for below case
     *
     * @return
     * @throws Exception
     */
    @DataProvider(name = "applyNoSegmentOffer")
    public Object[][] applyNoSegmentOffer() throws Exception {
        List<String> customer_segment = new ArrayList<String>();
        customer_segment.add("");
        return new Object[][]{{42401,              //restaurant_id (int)
                "offer_type",       //offer_type (String)
                50,                 //offer_value (int)
                customer_segment,   //customer_segment (String)
                22                 //user_id (int)
        }};
    }

    /**
     * Data Provider for below case
     *
     * @return
     * @throws Exception
     */
    @DataProvider(name = "applyFlat10Offer")
    public Object[][] applyFlat10Offer() throws Exception {
        List<String> customer_segment = new ArrayList<String>();
        customer_segment.add("p3");
        return new Object[][]{{42401,              //restaurant_id (int)
                "FLATX",       //offer_type (String)
                100,                 //offer_value (int)
                customer_segment,   //customer_segment (String)
                3333                 //user_id (int)
        }};
    }


    /**
     * Data Provider for below case
     *
     * @return
     * @throws Exception
     */
    @DataProvider(name = "applyFlatWithLessCartValue")
    public Object[][] applyFlatWithLessCartValue() throws Exception {
        List<String> customer_segment = new ArrayList<String>();
        customer_segment.add("p3");
        return new Object[][]{{42401,              //restaurant_id (int)
                "FLATX",       //offer_type (String)
                1000,                 //offer_value (int)
                customer_segment,   //customer_segment (String)
                3333                 //user_id (int)
        }};
    }

    /**
     * Data Provider for below case
     *
     * @return
     * @throws Exception
     */
    @DataProvider(name = "applyOfferNegativeCartValue")
    public Object[][] applyOfferNegativeCartValue() throws Exception {
        List<String> customer_segment = new ArrayList<String>();
        customer_segment.add("p3");
        return new Object[][]{{42401,              //restaurant_id (int)
                "FLATX",       //offer_type (String)
                1000,                 //offer_value (int)
                customer_segment,   //customer_segment (String)
                3333                 //user_id (int)
        }};
    }


    /**
     * Data Provider for below case
     *
     * @return
     * @throws Exception
     */
    @DataProvider(name = "applyOfferNullRxID")
    public Object[][] applyOfferNullRxID() throws Exception {
        List<String> customer_segment = new ArrayList<String>();
        customer_segment.add("p3");
        return new Object[][]{{null,              //restaurant_id (int)
                "FLATX",       //offer_type (String)
                1000,                 //offer_value (int)
                customer_segment,   //customer_segment (String)
                3333                 //user_id (int)
        }};
    }

    /**
     * Data Provider for below case
     *
     * @return
     * @throws Exception
     */
    @DataProvider(name = "applyOfferNullUser")
    public Object[][] applyOfferNullUser() throws Exception {
        List<String> customer_segment = new ArrayList<String>();
        customer_segment.add("p3");
        return new Object[][]{{42678,              //restaurant_id (int)
                "FLATX",       //offer_type (String)
                1000,                 //offer_value (int)
                customer_segment,   //customer_segment (String)
                null                 //user_id (int)
        }};
    }


}

