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

import android.util.Log;

/**
 * Log class for GetContact library. By default all logs are enabled.
 * Set {@link GetContactLog#DEBUG} to false for disable logs.
 */
public class GetContactLog {

    /**
     * Log tag.
     */
    public static String LOG_TAG = "GetContact";

    /**
     * Set how true for enabled logs.
     */
    private static boolean DEBUG = true;

    /**
     * Class not instantiable.
     */
    private GetContactLog() {
    }

    /**
     * Calls {@link android.util.Log#d(String, String)} if logs are enabled.
     *
     * @param message Message of the log.
     */
    public static void d(String message) {
        if (DEBUG) {
            Log.d(LOG_TAG, message);
        }
    }

    /**
     * Calls {@link android.util.Log#i(String, String)} if logs are enabled.
     *
     * @param message Message of the log.
     */
    public static void i(String message) {
        if (DEBUG) {
            Log.i(LOG_TAG, message);
        }
    }

    /**
     * Calls {@link android.util.Log#e(String, String)} if logs are enabled.
     *
     * @param message Message of the log.
     */
    public static void e(String message) {
        if (DEBUG) {
            Log.e(LOG_TAG, message);
        }
    }

    /**
     * Calls {@link android.util.Log#v(String, String)} if logs are enabled.
     *
     * @param message Message of the log.
     */
    public static void v(String message) {
        if (DEBUG) {
            Log.v(LOG_TAG, message);
        }
    }


    /**
     * Calls {@link android.util.Log#w(String, String)} if logs are enabled.
     *
     * @param message Message of the log.
     */
    public static void w(String message) {
        if (DEBUG) {
            Log.w(LOG_TAG, message);
        }
    }

    /**
     * Set mode debug.
     *
     * @param debug Set debug to true for enabled logs.
     */
    public static void setDebug(boolean debug) {
        DEBUG = debug;
    }
}
