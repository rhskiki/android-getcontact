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

package com.rhskiki.getcontact.utils;

/**
 * // TODO comment
 */
public class GetContactUtils {

    /**
     * Constant for no contact selected.
     */
    public static final int NO_CONTACT_SELECTED = 0;

    /**
     * Check if strings is not null, not equals "" and not empty.
     *
     * @param names strings for check.
     * @return True if string contains values null, equals "" or empty.
     */
    public static boolean verifyStringNull(String... names) {
        for (String s : names) {
            if (s != null && !s.equals("") && !s.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
