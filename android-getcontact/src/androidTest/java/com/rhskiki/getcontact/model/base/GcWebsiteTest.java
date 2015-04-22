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

import com.rhskiki.getcontact.model.GcWebsite;

/**
 * // TODO comment
 */
public class GcWebsiteTest extends InstrumentationTestCase {

    private static final String DEFAULT_LABEL = "label";

    private static final int DEFAULT_TYPE = 1;

    private static final String DEFAULT_URL = "url";

    private GcWebsite gcWebsite;

    @Override
    protected void setUp() throws Exception {
        gcWebsite = new GcWebsite();
    }

    public void testGetSetLabel() {
        gcWebsite.setLabel(DEFAULT_LABEL);
        assertEquals("Label set error", gcWebsite.getLabel(), DEFAULT_LABEL);
    }

    public void testGetSetType() {
        gcWebsite.setType(DEFAULT_TYPE);
        assertEquals("Type set error", gcWebsite.getType(), DEFAULT_TYPE);
    }

    public void testGetSetUrl() {
        gcWebsite.setUrl(DEFAULT_URL);
        assertEquals("Url set error", gcWebsite.getUrl(), DEFAULT_URL);
    }
}
