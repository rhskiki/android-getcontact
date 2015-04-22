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

import com.rhskiki.getcontact.model.GcEmail;

/**
 * // TODO comment
 */
public class GcEmailTest extends InstrumentationTestCase {

    private static final String DEFAULT_ADDRESS = "address@address.com";

    private static final String DEFAULT_LABEL = "label";

    private static final int DEFAULT_TYPE = 1;

    GcEmail gcEmail;

    @Override
    protected void setUp() throws Exception {
        gcEmail = new GcEmail();
    }

    public void testGetSetAddress() {
        gcEmail.setAddress(DEFAULT_ADDRESS);
        assertEquals("Address set error", gcEmail.getAddress(), DEFAULT_ADDRESS);
    }

    public void testGetSetLabel() {
        gcEmail.setLabel(DEFAULT_LABEL);
        assertEquals("Label set error", gcEmail.getLabel(), DEFAULT_LABEL);
    }

    public void testGetSetType() {
        gcEmail.setType(DEFAULT_TYPE);
        assertEquals("Type set error", gcEmail.getType(), DEFAULT_TYPE);
    }
}
