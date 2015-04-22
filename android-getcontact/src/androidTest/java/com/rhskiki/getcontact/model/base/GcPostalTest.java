/*
 *
 *  * Copyright 2015 Ricardo Henrique de Souza
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.rhskiki.getcontact.model.base;

import android.test.InstrumentationTestCase;

import com.rhskiki.getcontact.model.GcPostal;

/**
 * // TODO comment
 */
public class GcPostalTest extends InstrumentationTestCase {

    private static final String DEFAULT_CITY = "city";

    private static final String DEFAULT_COUNTRY = "country";

    private static final String DEFAULT_LABEL = "label";

    private static final String DEFAULT_FORMATTED_ADDRESS = "formatted address";

    private static final String DEFAULT_NEIGHBORHOOD = "neighborhood";

    private static final String DEFAULT_POBOX = "pobox";

    private static final String DEFAULT_POSTCODE = "postcode";

    private static final String DEFAULT_REGION = "region";

    private static final String DEFAULT_STREET = "street";

    private static final int DEFAULT_TYPE = 1;

    private GcPostal gcPostal;

    @Override
    protected void setUp() throws Exception {
        gcPostal = new GcPostal();
    }

    public void testGetSetCity() {
        gcPostal.setCity(DEFAULT_CITY);
        assertEquals("City set error", gcPostal.getCity(), DEFAULT_CITY);
    }

    public void testGetSetCountry() {
        gcPostal.setCountry(DEFAULT_COUNTRY);
        assertEquals("Country set error", gcPostal.getCountry(), DEFAULT_COUNTRY);
    }

    public void testGetSetLabel() {
        gcPostal.setLabel(DEFAULT_LABEL);
        assertEquals("Label set error", gcPostal.getLabel(), DEFAULT_LABEL);
    }

    public void testGetSetFormattedAddress() {
        gcPostal.setFormattedAddress(DEFAULT_FORMATTED_ADDRESS);
        assertEquals("Formatted Address set error", gcPostal.getFormattedAddress(),
                DEFAULT_FORMATTED_ADDRESS);
    }

    public void testGetSetNeighborhood() {
        gcPostal.setNeighborhood(DEFAULT_NEIGHBORHOOD);
        assertEquals("Neighborhood set error", gcPostal.getNeighborhood(), DEFAULT_NEIGHBORHOOD);
    }

    public void testGetSetPobox() {
        gcPostal.setPobox(DEFAULT_POBOX);
        assertEquals("Pobox set error", gcPostal.getPobox(), DEFAULT_POBOX);
    }

    public void testGetSetPostcode() {
        gcPostal.setPostcode(DEFAULT_POSTCODE);
        assertEquals("Postcode set error", gcPostal.getPostcode(), DEFAULT_POSTCODE);
    }

    public void testGetSetRegion() {
        gcPostal.setRegion(DEFAULT_REGION);
        assertEquals("Region set error", gcPostal.getRegion(), DEFAULT_REGION);
    }

    public void testGetSetStreet() {
        gcPostal.setStreet(DEFAULT_STREET);
        assertEquals("Street set error", gcPostal.getStreet(), DEFAULT_STREET);
    }

    public void testGetSetType() {
        gcPostal.setType(DEFAULT_TYPE);
        assertEquals("Type set error", gcPostal.getType(), DEFAULT_TYPE);
    }
}
