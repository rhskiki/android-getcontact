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

package com.rhskiki.getcontact.library.base;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.rhskiki.getcontact.library.IBaseGetContact;
import com.rhskiki.getcontact.model.base.GcEmail;
import com.rhskiki.getcontact.utils.GetContactLog;
import com.rhskiki.getcontact.utils.GetContactUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for getting data from email contacts.
 *
 * @author rhskiki
 * @since 2015
 */
public class GetEmail implements IBaseGetContact {

    /**
     * Context of the application.
     */
    private Context mContext;

    /**
     * Construtor with parameters.
     *
     * @param context Context of the application.
     */
    public GetEmail(Context context) {
        mContext = context;
    }

    /**
     * Get only address emails.
     *
     * @param contactId Id of contact, if case 0 get all emails.
     * @return List type {@link java.lang.String} with address emails.
     */
    @Override
    public List<String> getSimple(int contactId) {
        Uri uri = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Email.CONTACT_ID,
                ContactsContract.CommonDataKinds.Email.DATA};
        String selection;
        String[] selectionArgs;
        String sortOrder = ContactsContract.CommonDataKinds.Email.DATA;

        if (contactId == GetContactUtils.NO_CONTACT_SELECTED) {
            selection = null;
            selectionArgs = null;
        } else {
            selection = ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?";
            selectionArgs = new String[]{String.valueOf(contactId)};
        }

        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null && cursor.moveToFirst()) {
            List<String> listEmails = new ArrayList<String>();

            int idxAddress = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA);

            do {
                // Store all emails of contact.
                String address = cursor.getString(idxAddress);
                listEmails.add(address);
            } while (cursor.moveToNext());

            cursor.close();
            return listEmails;
        } else {
            GetContactLog.i("No emails for read.");
            return null;
        }
    }

    /**
     * Get all data address emails.
     * This data contais email adress, label and type.
     *
     * @param contactId Id of contact, if case 0 get all emails.
     * @return List type {@link com.rhskiki.getcontact.model.base.GcEmail} with datas.
     */
    @Override
    public List<GcEmail> getDetails(int contactId) {
        Uri uri = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Email.CONTACT_ID,
                ContactsContract.CommonDataKinds.Email.DATA,
                ContactsContract.CommonDataKinds.Email.LABEL,
                ContactsContract.CommonDataKinds.Email.TYPE};
        String selection;
        String[] selectionArgs;
        String sortOrder = ContactsContract.CommonDataKinds.Email.DATA;

        if (contactId != GetContactUtils.NO_CONTACT_SELECTED) {
            selection = null;
            selectionArgs = null;
        } else {
            selection = ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?";
            selectionArgs = new String[1];
            selectionArgs[0] = String.valueOf(contactId);
        }

        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null && cursor.moveToFirst()) {
            List<GcEmail> listGcEmail = new ArrayList<GcEmail>();

            int idxAddress = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA);
            int idxLabel = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.LABEL);
            int idxType = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.TYPE);

            do {
                // Store all emails of contact.
                String address = cursor.getString(idxAddress);
                String label = cursor.getString(idxLabel);
                int type = cursor.getInt(idxType);

                GcEmail gcEmail = new GcEmail();

                gcEmail.setAddress(address);
                gcEmail.setLabel(label);
                gcEmail.setType(type);

                listGcEmail.add(gcEmail);
            } while (cursor.moveToNext());

            cursor.close();
            return listGcEmail;
        } else {
            GetContactLog.i("No emails for read.");
            return null;
        }
    }
}
