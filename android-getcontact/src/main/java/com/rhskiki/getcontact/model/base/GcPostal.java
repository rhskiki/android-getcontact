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
 * This model for data postal address.
 */
public class GcPostal implements Parcelable {

    /**
     * City of contact.
     */
    private String mCity;

    /**
     * Country of contact.
     */
    private String mCountry;

    /**
     * Label address of contact.
     */
    private String mLabel;

    /**
     * Address of contact.
     */
    private String mFormattedAddress;

    /**
     * Neighborhood of contact.
     */
    private String mNeighborhood;

    /**
     * Pobox of contact.
     */
    private String mPobox;

    /**
     * Postcode of contact.
     */
    private String mPostcode;

    /**
     * Region of contact.
     */
    private String mRegion;

    /**
     * Street of contact.
     */
    private String mStreet;

    /**
     * Type address of contact.
     */
    private int mType;

    /**
     * The default constructor.
     */
    public GcPostal() {
        mCity = null;
        mCountry = null;
        mFormattedAddress = null;
        mLabel = null;
        mNeighborhood = null;
        mPobox = null;
        mPostcode = null;
        mRegion = null;
        mStreet = null;
        mType = 0;
    }

    /**
     * Get postal city.
     *
     * @return postal city.
     */
    public String getCity() {
        return mCity;
    }

    /**
     * Get postal country.
     *
     * @return postal country.
     */
    public String getCountry() {
        return mCountry;
    }

    /**
     * Get postal address.
     *
     * @return postal address.
     */
    public String getFormattedAddress() {
        return mFormattedAddress;
    }

    /**
     * Get postal label.
     *
     * @return postal label.
     */
    public String getLabel() {
        return mLabel;
    }

    /**
     * Get postal neightborhood.
     *
     * @return postal neightborhood
     */
    public String getNeighborhood() {
        return mNeighborhood;
    }

    /**
     * Get postal pobox.
     *
     * @return postal pobox.
     */
    public String getPobox() {
        return mPobox;
    }

    /**
     * Get postal postcode.
     *
     * @return postal postcode.
     */
    public String getPostcode() {
        return mPostcode;
    }

    /**
     * Get postal region.
     *
     * @return postal region.
     */
    public String getRegion() {
        return mRegion;
    }

    /**
     * Get postal street.
     *
     * @return postal street.
     */
    public String getStreet() {
        return mStreet;
    }

    /**
     * Get postal type.
     *
     * @return postal type.
     */
    public int getType() {
        return mType;
    }

    /**
     * Set postal city.
     *
     * @param city postal city.
     */
    public void setCity(String city) {
        this.mCity = city;
    }

    /**
     * Set postal country.
     *
     * @param country postal country.
     */
    public void setCountry(String country) {
        this.mCountry = country;
    }

    /**
     * Set postal address.
     *
     * @param formattedAddress postal address.
     */
    public void setFormattedAddress(String formattedAddress) {
        this.mFormattedAddress = formattedAddress;
    }

    /**
     * Set postal label.
     *
     * @param label postal label.
     */
    public void setLabel(String label) {
        this.mLabel = label;
    }

    /**
     * Set postal neighborhood.
     *
     * @param neighborhood postal neighborhood.
     */
    public void setNeighborhood(String neighborhood) {
        this.mNeighborhood = neighborhood;
    }

    /**
     * Set postal pobox.
     *
     * @param pobox postal pobox.
     */
    public void setPobox(String pobox) {
        this.mPobox = pobox;
    }

    /**
     * Set postal postcode.
     *
     * @param postcode postal postcode.
     */
    public void setPostcode(String postcode) {
        this.mPostcode = postcode;
    }

    /**
     * Set postal region.
     *
     * @param region postal region.
     */
    public void setRegion(String region) {
        this.mRegion = region;
    }

    /**
     * Set postal street.
     *
     * @param street postal street.
     */
    public void setStreet(String street) {
        this.mStreet = street;
    }

    /**
     * Set postal type.
     *
     * @param type postal type.
     */
    public void setType(int type) {
        this.mType = type;
    }

    // Parcelable Implementation.
    private GcPostal(Parcel from) {
        mCity = from.readString();
        mCountry = from.readString();
        mFormattedAddress = from.readString();
        mLabel = from.readString();
        mNeighborhood = from.readString();
        mPobox = from.readString();
        mPostcode = from.readString();
        mRegion = from.readString();
        mStreet = from.readString();
        mType = from.readInt();
    }

    public static Parcelable.Creator<GcPostal> CREATOR = new Creator<GcPostal>() {

        @Override
        public GcPostal createFromParcel(Parcel source) {
            return new GcPostal(source);
        }

        @Override
        public GcPostal[] newArray(int size) {
            return new GcPostal[size];
        }
    };

    @Override
    public int describeContents() {
        return ParcelableId.GCPOSTAL;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mCity);
        dest.writeString(mCountry);
        dest.writeString(mFormattedAddress);
        dest.writeString(mLabel);
        dest.writeString(mNeighborhood);
        dest.writeString(mPobox);
        dest.writeString(mPostcode);
        dest.writeString(mStreet);
        dest.writeInt(mType);
    }
}
