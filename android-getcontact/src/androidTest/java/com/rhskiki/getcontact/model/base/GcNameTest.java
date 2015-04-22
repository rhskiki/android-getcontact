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

import com.rhskiki.getcontact.model.GcName;

/**
 * // TODO comment
 */
public class GcNameTest extends InstrumentationTestCase {

    private static final String DEFAULT_DISPLAY_NAME = "display name";

    private static final String DEFAULT_FAMILY_NAME = "family name";

    private static final String DEFAULT_GIVEN_NAME = "given name";

    private static final String DEFAULT_MIDDLE_NAME = "middle name";

    private static final String DEFAULT_PHONETIC_FAMILY_NAME = "phonetic family name";

    private static final String DEFAULT_PHONETIC_GIVEN_NAME = "phonetic given name";

    private static final String DEFAULT_PHONETIC_MIDDLE_NAME = "phonetic middle name";

    private static final String DEFAULT_PREFIX = "prefix";

    private static final String DEFAULT_SUFFIX = "suffix";

    private GcName gcName;

    @Override
    protected void setUp() throws Exception {
        gcName = new GcName();
    }

    public void testGetSetDisplayName() {
        gcName.setDisplayName(DEFAULT_DISPLAY_NAME);
        assertEquals("Display Name set error", gcName.getDisplayName(), DEFAULT_DISPLAY_NAME);
    }

    public void testGetSetFamilyName() {
        gcName.setFamilyName(DEFAULT_FAMILY_NAME);
        assertEquals("Family Name set error", gcName.getFamilyName(), DEFAULT_FAMILY_NAME);
    }

    public void testGetSetGivenName() {
        gcName.setGivenName(DEFAULT_GIVEN_NAME);
        assertEquals("Given Name set error", gcName.getGivenName(), DEFAULT_GIVEN_NAME);
    }

    public void testGetSetMiddleName() {
        gcName.setMiddleName(DEFAULT_MIDDLE_NAME);
        assertEquals("Middle Name set error", gcName.getMiddleName(), DEFAULT_MIDDLE_NAME);
    }

    public void testGetSEtPhoneticFamilyName() {
        gcName.setPhoneticFamilyName(DEFAULT_PHONETIC_FAMILY_NAME);
        assertEquals("Phonetic Family Name set error", gcName.getPhoneticFamilyName(),
                DEFAULT_PHONETIC_FAMILY_NAME);
    }

    public void testGetSetPhoneticGivenName() {
        gcName.setPhoneticGivenName(DEFAULT_PHONETIC_GIVEN_NAME);
        assertEquals("Phonetic Given Name set error", gcName.getPhoneticGivenName(),
                DEFAULT_PHONETIC_GIVEN_NAME);
    }

    public void testGetSetPhoneticFamilyName() {
        gcName.setPhoneticMiddleName(DEFAULT_PHONETIC_MIDDLE_NAME);
        assertEquals("Phonetic Middle Name set error", gcName.getPhoneticMiddleName(),
                DEFAULT_PHONETIC_MIDDLE_NAME);
    }

    public void testGetSetPrefix() {
        gcName.setPrefix(DEFAULT_PREFIX);
        assertEquals("Prefix set error", gcName.getPrefix(), DEFAULT_PREFIX);
    }

    public void testGetSetSuffix() {
        gcName.setSuffix(DEFAULT_SUFFIX);
        assertEquals("Suffix set error", gcName.getSuffix(), DEFAULT_SUFFIX);
    }
}
