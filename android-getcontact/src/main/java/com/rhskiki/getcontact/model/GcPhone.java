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

import android.os.Parcel;
import android.os.Parcelable;

import com.rhskiki.getcontact.utils.GetContactUtils.ParcelableId;

/**
 * This class is used for storage number phones.
 *
 * @see android.provider.ContactsContract.CommonDataKinds.Phone
 */
public class GcPhone implements Parcelable {

    /**
     * Label of number.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.Phone#LABEL
     */
    private String mLabel;

    /**
     * Phone number.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.Phone#NUMBER
     */
    private String mNumber;

    /**
     * Type of phone number.
     *
     * @see android.provider.ContactsContract.CommonDataKinds.Phone#TYPE
     */
    private int mType;

    /**
     * Get label of number phone.
     *
     * @return Label of number phone.
     */
    public String getLabel() {
        return mLabel;
    }

    /**
     * Get number phone.
     *
     * @return Number phone.
     */
    public String getNumber() {
        return mNumber;
    }

    /**
     * Get type of number phone.
     *
     * @return Type of number phone.
     */
    public int getType() {
        return mType;
    }

    /**
     * Set label of number phone.
     *
     * @param label Label of number phone.
     */
    public void setLabel(String label) {
        this.mLabel = label;
    }

    /**
     * Set number phone.
     *
     * @param number The number phone.
     */
    public void setNumber(String number) {
        this.mNumber = number;
    }

    /**
     * Set type of number phone.
     *
     * @param type Type of number phone.
     */
    public void setType(int type) {
        this.mType = type;
    }

    // Parcelable Implementation.
    private GcPhone(Parcel from) {
        mLabel = from.readString();
        mNumber = from.readString();
        mType = from.readInt();
    }

    public static final Parcelable.Creator<GcPhone> CREATOR = new Creator<GcPhone>() {

        @Override
        public GcPhone createFromParcel(Parcel source) {
            return new GcPhone(source);
        }

        @Override
        public GcPhone[] newArray(int size) {
            return new GcPhone[size];
        }
    };


    @Override
    public int describeContents() {
        return ParcelableId.GCPHONE;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mLabel);
        dest.writeString(mNumber);
        dest.writeInt(mType);
    }
}
