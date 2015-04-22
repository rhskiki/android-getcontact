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
import com.rhskiki.getcontact.model.GcPhone;
import com.rhskiki.getcontact.utils.GetContactLog;
import com.rhskiki.getcontact.utils.GetContactUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for getting data from phone contacts.
 */
public class GetPhone implements IBaseGetContact {

    /**
     * Context of the application.
     */
    private Context mContext;

    /**
     * Construtor with parameters.
     *
     * @param context Context of the application.
     */
    public GetPhone(Context context) {
        mContext = context;
    }

    /**
     * Get all contacts numbers.
     *
     * @param contactId ID of the contact.
     * @return List type {@link java.lang.String}, witl all contacts numbers.
     */
    @Override
    public List<String> getSimple(int contactId) {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
        String selection;
        String[] selectionArgs;
        String sortOrder = ContactsContract.CommonDataKinds.Phone.NUMBER;

        if (contactId == GetContactUtils.NO_CONTACT_SELECTED) {
            selection = null;
            selectionArgs = null;
        } else {
            selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? ";
            selectionArgs = new String[]{String.valueOf(contactId)};
        }

        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null && cursor.moveToFirst()) {
            List<String> listPhones = new ArrayList<String>();

            int idxNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

            do {
                String number = cursor.getString(idxNumber);
                listPhones.add(number);
            } while (cursor.moveToNext());

            cursor.close();
            return listPhones;
        } else {
            GetContactLog.i("No contacts for read.");
            return null;
        }
    }

    /**
     * Get contact phones numbers.
     *
     * @param contactId ID of the contact.
     * @return List type {@link java.lang.String} with all phones number of the contact.
     */
    @Override
    public List<GcPhone> getDetails(int contactId) {
        Uri uri = ContactsContract.Data.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER};
        String selection;
        String[] selectionArgs;
        String sortOrder = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;

        if (contactId == GetContactUtils.NO_CONTACT_SELECTED) {
            selection = null;
            selectionArgs = null;
        } else {
            selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? ";
            selectionArgs = new String[]{String.valueOf(contactId)};
        }

        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        List<GcPhone> listGcPhones = new ArrayList<GcPhone>();

        if (cursor != null && cursor.moveToFirst()) {
            int idxHasNumber = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER);
            int hasNumber = cursor.getInt(idxHasNumber);

            // Check if exists number.
            if (hasNumber > 0) {
                Uri uriNumber = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                String[] projectionNumber = {ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                        ContactsContract.CommonDataKinds.Phone.NUMBER,
                        ContactsContract.CommonDataKinds.Phone.TYPE,
                        ContactsContract.CommonDataKinds.Phone.LABEL};
                String selectionNumber;
                String[] selectionArgsNumber;
                String sortOrderNumber = ContactsContract.CommonDataKinds.Phone.NUMBER;

                if (contactId == GetContactUtils.NO_CONTACT_SELECTED) {
                    selectionNumber = null;
                    selectionArgsNumber = null;
                } else {
                    selectionNumber = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?";
                    selectionArgsNumber = new String[1];
                    selectionArgsNumber[0] = String.valueOf(contactId);
                }

                Cursor cursorNumbers = contentResolver.query(uriNumber, projectionNumber,
                        selectionNumber, selectionArgsNumber, sortOrderNumber);

                int idxNumber = cursorNumbers.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.NUMBER);
                int idxType = cursorNumbers.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.TYPE);
                int idxLabel = cursorNumbers.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.LABEL);

                if (cursorNumbers.moveToFirst()) {
                    // Store all numbers of contact.
                    int type;
                    String number;
                    String label;
                    do {
                        type = cursorNumbers.getInt(idxType);
                        number = cursorNumbers.getString(idxNumber);
                        label = cursorNumbers.getString(idxLabel);

                        GcPhone gcPhone = new GcPhone();
                        gcPhone.setType(type);
                        gcPhone.setNumber(number);
                        gcPhone.setLabel(label);

                        listGcPhones.add(gcPhone);
                    } while (cursorNumbers.moveToNext());
                }
            } else {
                GetContactLog.i("No contact phone number.");
            }

            cursor.close();
            return listGcPhones;
        } else {
            GetContactLog.i("No contacts for read.");
            return null;
        }
    }
}
