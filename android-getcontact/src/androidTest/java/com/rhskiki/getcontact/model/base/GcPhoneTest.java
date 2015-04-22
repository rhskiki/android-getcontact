/*
 * Copyright 2015 Ricardo Henrique de Souza
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rhskiki.getcontact.model.base;

import android.test.InstrumentationTestCase;

import com.rhskiki.getcontact.model.GcPhone;

/**
 * // TODO comment
 */
public class GcPhoneTest extends InstrumentationTestCase {

    private static final String DEFAULT_LABEL = "label";

    private static final String DEFAULT_NUMBER = "12345";

    private static final int DEFAULT_TYPE = 1;

    private GcPhone gcPhone;

    @Override
    protected void setUp() throws Exception {
        gcPhone = new GcPhone();
    }

    public void testGetSetLabel() {
        gcPhone.setLabel(DEFAULT_LABEL);
        assertEquals("Label set error", gcPhone.getLabel(), DEFAULT_LABEL);
    }

    public void testGetSetNumber() {
        gcPhone.setNumber(DEFAULT_NUMBER);
        assertEquals("Number set error", gcPhone.getNumber(), DEFAULT_NUMBER);
    }

    public void testGetSetType() {
        gcPhone.setType(DEFAULT_TYPE);
        assertEquals("Type set error", gcPhone.getType(), DEFAULT_TYPE);
    }
}
