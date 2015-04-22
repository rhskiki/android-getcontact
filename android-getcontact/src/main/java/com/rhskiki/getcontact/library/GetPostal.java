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

package com.rhskiki.getcontact.library;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.rhskiki.getcontact.library.IBaseGetContact;
import com.rhskiki.getcontact.model.GcPostal;
import com.rhskiki.getcontact.utils.GetContactLog;
import com.rhskiki.getcontact.utils.GetContactUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for getting data from postal contacts.
 */
public class GetPostal implements IBaseGetContact {

    /**
     * Context of the application.
     */
    private Context mContext;

    /**
     * Construtor with parameters.
     *
     * @param context context of the application.
     */
    public GetPostal(Context context) {
        mContext = context;
    }

    /**
     * Get all postal contacts on the agenda.
     *
     * @param contactId ID of the contact.
     * @return List type {@link java.lang.String}, with all postal contacts.
     */
    @Override
    public List<String> getSimple(int contactId) {
        Uri uri = ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.StructuredPostal.CONTACT_ID,
                ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS};
        String selection;
        String[] selectionArgs;
        String sortOrder = ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS;

        if (contactId == GetContactUtils.NO_CONTACT_SELECTED) {
            selection = null;
            selectionArgs = null;
        } else {
            selection = ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID + " = ? ";
            selectionArgs = new String[]{String.valueOf(contactId)};
        }

        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null && cursor.moveToFirst()) {
            List<String> listPostals = new ArrayList<String>();

            int idxFormattedAddress = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS);

            do {
                String formattedAddress = cursor.getString(idxFormattedAddress);
                listPostals.add(formattedAddress);
            } while (cursor.moveToNext());

            cursor.close();
            return listPostals;
        } else {
            GetContactLog.i("No postals address for read.");
            return null;
        }
    }

    /**
     * Get all postal contacts detailed on the agenda.
     *
     * @param contactId ID of the contact.
     * @return List type {@link java.lang.String}, with all postal contacts.
     */
    @Override
    public List<GcPostal> getDetails(int contactId) {
        Uri uri = ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.StructuredPostal.CONTACT_ID,
                ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS};
        String selection;
        String[] selectionArgs;
        String sortOrder = ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS;

        if (contactId == GetContactUtils.NO_CONTACT_SELECTED) {
            selection = null;
            selectionArgs = null;
        } else {
            selection = ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID + " = ? ";
            selectionArgs = new String[]{String.valueOf(contactId)};
        }

        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null && cursor.moveToFirst()) {
            List<GcPostal> listGcPostals = new ArrayList<GcPostal>();

            int idxCity = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredPostal.CITY);
            int idxCountry = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY);
            int idxLabel = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredPostal.LABEL);
            int idxFormattedAddress = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS);
            int idxNeighborhood = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredPostal.NEIGHBORHOOD);
            int idxPobox = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredPostal.POBOX);
            int idxPostcode = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE);
            int idxRegion = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredPostal.REGION);
            int idxStreet = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredPostal.STREET);
            int idxType = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredPostal.TYPE);
            do {
                GcPostal gcPostal = new GcPostal();

                gcPostal.setCity(cursor.getString(idxCity));
                gcPostal.setCountry(cursor.getString(idxCountry));
                gcPostal.setFormattedAddress(cursor.getString(idxFormattedAddress));
                gcPostal.setLabel(cursor.getString(idxLabel));
                gcPostal.setNeighborhood(cursor.getString(idxNeighborhood));
                gcPostal.setPobox(cursor.getString(idxPobox));
                gcPostal.setPostcode(cursor.getString(idxPostcode));
                gcPostal.setRegion(cursor.getString(idxRegion));
                gcPostal.setStreet(cursor.getString(idxStreet));
                gcPostal.setType(cursor.getInt(idxType));

                listGcPostals.add(gcPostal);
            } while (cursor.moveToNext());

            cursor.close();
            return listGcPostals;
        } else {
            GetContactLog.i("No postals address for read.");
            return null;
        }
    }
}
