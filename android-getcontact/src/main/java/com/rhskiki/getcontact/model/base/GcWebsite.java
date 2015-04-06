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

/**
 * This model for website of the contacts.
 */
public class GcWebsite {

    /**
     * Label of website.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.Website#LABEL
     */
    private String mLabel;

    /**
     * Type of website.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.Website#TYPE
     */
    private int mType;

    /**
     * Url of website.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.Website#URL
     */
    private String mUrl;

    /**
     * The default constructor.
     */
    public GcWebsite() {
        mLabel = null;
        mType = 0;
        mUrl = null;
    }

    /**
     * Get label of website.
     *
     * @return label of website.
     */
    public String getLabel() {
        return mLabel;
    }

    /**
     * Get type of website.
     *
     * @return type of website.
     */
    public int getType() {
        return mType;
    }

    /**
     * Get url of website.
     *
     * @return url of webiste.
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Set label of website.
     *
     * @param label label of website.
     */
    public void setLabel(String label) {
        this.mLabel = label;
    }

    /**
     * Set type of website.
     *
     * @param type type of website.
     */
    public void setType(int type) {
        this.mType = type;
    }

    /**
     * Set url of website.
     *
     * @param url url of website.
     */
    public void setUrl(String url) {
        this.mUrl = url;
    }
}
