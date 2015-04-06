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
 * This model for data emails.
 *
 * @see android.provider.ContactsContract.CommonDataKinds.Email
 */
public class GcEmail {

    /**
     * Email address of contact.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.Email#DATA
     */
    private String mAddress;

    /**
     * Label (office, home..) email of contact.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.Email#LABEL
     */
    private String mLabel;

    /**
     * Type email of contact.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.Email#TYPE
     */
    private int mType;

    /**
     * The default constructor.
     */
    public GcEmail() {
        mAddress = null;
        mLabel = null;
        mType = 0;
    }

    /**
     * Get email address.
     *
     * @return email address.
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     * Get email label.
     *
     * @return Email label.
     */
    public String getLabel() {
        return mLabel;
    }

    /**
     * Get type of email.
     *
     * @return Type of email.
     */
    public int getType() {
        return mType;
    }

    /**
     * Set email address.
     *
     * @param mAddress email address.
     */
    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    /**
     * Set label of email.
     *
     * @param mLabel label of email.
     */
    public void setLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    /**
     * Set type of email.
     *
     * @param mType type of email.
     */
    public void setType(int mType) {
        this.mType = mType;
    }
}
