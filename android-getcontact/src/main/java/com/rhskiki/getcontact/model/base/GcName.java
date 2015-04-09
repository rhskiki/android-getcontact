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

import android.os.Parcel;
import android.os.Parcelable;

import com.rhskiki.getcontact.utils.GetContactUtils.ParcelableId;

/**
 * This model for data names.
 */
public class GcName implements Parcelable {

    /**
     * Display contact name.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.StructuredName#DISPLAY_NAME
     */
    private String mDisplayName;

    /**
     * Family name of contact.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.StructuredName#FAMILY_NAME
     */
    private String mFamilyName;

    /**
     * Given name of contact.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.StructuredName#GIVEN_NAME
     */
    private String mGivenName;

    /**
     * Middle name of contact.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.StructuredName#MIDDLE_NAME
     */
    private String mMiddleName;

    /**
     * Phonetic family name of contact.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.StructuredName#PHONETIC_FAMILY_NAME
     */
    private String mPhoneticFamilyName;

    /**
     * Phonetic given name of contact.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.StructuredName#PHONETIC_GIVEN_NAME
     */
    private String mPhoneticGivenName;

    /**
     * Phonetic middle name of contact.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.StructuredName#PHONETIC_MIDDLE_NAME
     */
    private String mPhoneticMiddleName;

    /**
     * Prefix of contact.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.StructuredName#PREFIX
     */
    private String mPrefix;

    /**
     * Suffix of contact.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.StructuredName#SUFFIX
     */
    private String mSuffix;

    public GcName() {
        mDisplayName = null;
        mFamilyName = null;
        mGivenName = null;
        mMiddleName = null;
        mPhoneticFamilyName = null;
        mPhoneticGivenName = null;
        mPhoneticMiddleName = null;
        mPrefix = null;
        mSuffix = null;
    }

    /**
     * Get display name of contact.
     *
     * @return display name of contact.
     */
    public String getDisplayName() {
        return mDisplayName;
    }

    /**
     * Get family name of contact.
     *
     * @return family name of contact.
     */
    public String getFamilyName() {
        return mFamilyName;
    }

    /**
     * Get given name of contact.
     *
     * @return given name of contact.
     */
    public String getGivenName() {
        return mGivenName;
    }

    /**
     * Get middle name of contact.
     *
     * @return middle name of contact.
     */
    public String getMiddleName() {
        return mMiddleName;
    }

    /**
     * Get phonetic family name of contact.
     *
     * @return phonetic family name of contact.
     */
    public String getPhoneticFamilyName() {
        return mPhoneticFamilyName;
    }

    /**
     * Get phonetic given name of contact.
     *
     * @return phonetic given name of contact.
     */
    public String getPhoneticGivenName() {
        return mPhoneticGivenName;
    }

    /**
     * Get phonetic middle name of contact.
     *
     * @return phonetic middle name of contact.
     */
    public String getPhoneticMiddleName() {
        return mPhoneticMiddleName;
    }

    /**
     * Get prefix of contact.
     *
     * @return prefix of contact.
     */
    public String getPrefix() {
        return mPrefix;
    }

    /**
     * Get suffix of contact.
     *
     * @return suffix of contact.
     */
    public String getSuffix() {
        return mSuffix;
    }

    /**
     * Set display name of contact.
     *
     * @param displayName display name of contact.
     */
    public void setDisplayName(String displayName) {
        this.mDisplayName = displayName;
    }

    /**
     * Set display name of contact.
     *
     * @param familyName display name of contact.
     */
    public void setFamilyName(String familyName) {
        this.mFamilyName = familyName;
    }

    /**
     * Set given name of contact.
     *
     * @param givenName given name of contact.
     */
    public void setGivenName(String givenName) {
        this.mGivenName = givenName;
    }

    /**
     * Set middle name of contact.
     *
     * @param middleName middle name of contact.
     */
    public void setMiddleName(String middleName) {
        this.mMiddleName = middleName;
    }

    /**
     * Set prefix of contact.
     *
     * @param prefix prefix of contact.
     */
    public void setPrefix(String prefix) {
        this.mPrefix = prefix;
    }

    /**
     * Set phonetic family name of contact.
     *
     * @param phoneticFamilyName phonetic family name of contact.
     */
    public void setPhoneticFamilyName(String phoneticFamilyName) {
        this.mPhoneticFamilyName = phoneticFamilyName;
    }

    /**
     * Set phonetic given name of contact.
     *
     * @param phoneticGivenName phonetic given name of contact.
     */
    public void setPhoneticGivenName(String phoneticGivenName) {
        this.mPhoneticGivenName = phoneticGivenName;
    }

    /**
     * Set phonetic middle name of contact.
     *
     * @param phoneticMiddleName phonetic middle name of contact.
     */
    public void setPhoneticMiddleName(String phoneticMiddleName) {
        this.mPhoneticMiddleName = phoneticMiddleName;
    }

    /**
     * Set suffix of contact.
     *
     * @param suffix suffix of contact.
     */
    public void setSuffix(String suffix) {
        this.mSuffix = suffix;
    }

    // Parcelable Implementation.
    private GcName(Parcel from) {
        mDisplayName = from.readString();
        mFamilyName = from.readString();
        mGivenName = from.readString();
        mMiddleName = from.readString();
        mPhoneticFamilyName = from.readString();
        mPhoneticGivenName = from.readString();
        mPhoneticMiddleName = from.readString();
        mPrefix = from.readString();
        mSuffix = from.readString();
    }

    public static final Parcelable.Creator<GcName> CREATOR = new Creator<GcName>() {

        @Override
        public GcName createFromParcel(Parcel source) {
            return new GcName(source);
        }

        @Override
        public GcName[] newArray(int size) {
            return new GcName[size];
        }
    };

    @Override
    public int describeContents() {
        return ParcelableId.GCNAME;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mDisplayName);
        dest.writeString(mFamilyName);
        dest.writeString(mGivenName);
        dest.writeString(mMiddleName);
        dest.writeString(mPhoneticFamilyName);
        dest.writeString(mPhoneticGivenName);
        dest.writeString(mPhoneticMiddleName);
        dest.writeString(mPrefix);
        dest.writeString(mSuffix);
    }
}
