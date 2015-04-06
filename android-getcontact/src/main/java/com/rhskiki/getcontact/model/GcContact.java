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

package com.rhskiki.getcontact.model;

import android.net.Uri;

import com.rhskiki.getcontact.model.base.GcEmail;
import com.rhskiki.getcontact.model.base.GcName;
import com.rhskiki.getcontact.model.base.GcPhone;
import com.rhskiki.getcontact.model.base.GcWebsite;

import java.util.List;

/**
 * // TODO comment
 */
public class GcContact {

    private List<GcEmail> mGcEmails;

    /**
     *
     */
    private List<GcName> mGcNames;

    private List<GcPhone> mGcPhones;

    private List<GcWebsite> mGcWebsites;


    /**
     * List of address of the contact.
     */
    private List<String> mAddress;

    /**
     * Contact id.
     */
    private int mContactId;

    /**
     * List of emails of the contact.
     */
    private List<String> mEmail;

    /**
     * If exists phone numbers, set to true.
     */
    private int mHasNumber;

    /**
     * List of numbers of the contact.
     */
    private List<String> mNumber;

    /**
     * Contact photo.
     */
    private Uri mPhoto;

    /**
     * Construtor default.
     */
    public GcContact() {
        this.mAddress = null;
        this.mEmail = null;
        this.mHasNumber = 0;
        this.mPhoto = null;

    }

    public List<String> getAddress() {
        return mAddress;
    }

    public int getContactId() {
        return mContactId;
    }

    public List<String> getEmail() {
        return mEmail;
    }

    public int getHasNumber() {
        return mHasNumber;
    }

    public List<String> getNumber() {
        return mNumber;
    }

    public Uri getPhoto() {
        return mPhoto;
    }

    public void setAddress(List<String> address) {
        this.mAddress = address;
    }

    public void setContactId(int contactId) {
        this.mContactId = contactId;
    }

    public void setEmail(List<String> email) {
        this.mEmail = email;
    }

    public void setHasNumber(int hasNumber) {
        this.mHasNumber = hasNumber;
    }

    public void setNumber(List<String> number) {
        this.mNumber = number;
    }

    public void setPhoto(Uri photo) {
        this.mPhoto = photo;
    }
}
