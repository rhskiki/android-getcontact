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
import com.rhskiki.getcontact.model.base.GcWebsite;
import com.rhskiki.getcontact.utils.GetContactLog;
import com.rhskiki.getcontact.utils.GetContactUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for getting data from webiste of contacts.
 */
public class GetWebsite implements IBaseGetContact {

    /**
     * Context of application.
     */
    private Context mContext;

    /**
     * Constructor with parameters.
     *
     * @param context Context of the application.
     */
    public GetWebsite(Context context) {
        mContext = context;
    }

    /**
     * Get only url of the contacts.
     *
     * @param contactId Id of contact, if case 0 get all url of the contacts.
     * @return List type {@link java.lang.String} with urls.
     */
    @Override
    public List<String> getSimple(int contactId) {
        Uri uri = ContactsContract.Data.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Website.CONTACT_ID,
                ContactsContract.CommonDataKinds.Website.URL};
        String selection;
        String[] selectionArgs;
        String sortOrder = ContactsContract.CommonDataKinds.Website.URL;

        if (contactId == GetContactUtils.NO_CONTACT_SELECTED) {
            selection = ContactsContract.Data.MIMETYPE + " = ? ";
            selectionArgs = new String[]{
                    String.valueOf(ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE)};
        } else {
            selection = ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID + " = ? AND "
                    + ContactsContract.Data.MIMETYPE + " = ? ";
            selectionArgs = new String[]{
                    String.valueOf(contactId),
                    String.valueOf(ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE)};
        }

        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null && cursor.moveToFirst()) {
            List<String> listWebsite = new ArrayList<String>();

            int idxUrl = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Website.URL);

            do {
                String url = cursor.getString(idxUrl);
                if (!GetContactUtils.verifyStringNull(url)) {
                    listWebsite.add(url);
                }
            } while (cursor.moveToNext());

            cursor.close();
            return listWebsite;
        } else {
            GetContactLog.v("No websites for read.");
            return null;
        }
    }

    /**
     * Get all data web.
     * This data contains label, type and url of the website.
     *
     * @param contactId Id of contact, if case 0 get all emails.
     * @return List type {@link com.rhskiki.getcontact.model.base.GcWebsite} with datas.
     * @see android.provider.ContactsContract.CommonDataKinds.Website
     */
    @Override
    public List<GcWebsite> getDetails(int contactId) {
        Uri uri = ContactsContract.Data.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Website.CONTACT_ID,
                ContactsContract.CommonDataKinds.Website.LABEL,
                ContactsContract.CommonDataKinds.Website.TYPE,
                ContactsContract.CommonDataKinds.Website.URL};
        String selection;
        String[] selectionArgs;
        String sortOrder = ContactsContract.CommonDataKinds.Website.URL;

        if (contactId == GetContactUtils.NO_CONTACT_SELECTED) {
            selection = ContactsContract.Data.MIMETYPE + " = ? ";
            selectionArgs = new String[]{
                    String.valueOf(ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE)};
        } else {
            selection = ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID + " = ? AND "
                    + ContactsContract.Data.MIMETYPE + " = ? ";
            selectionArgs = new String[]{
                    String.valueOf(contactId),
                    String.valueOf(ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE)};
        }

        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null && cursor.moveToFirst()) {
            List<GcWebsite> listWebsite = new ArrayList<GcWebsite>();

            int idxLabel = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Website.LABEL);
            int idxUrl = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Website.URL);
            int idxType = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Website.TYPE);

            do {
                GcWebsite gcWebsite = new GcWebsite();

                gcWebsite.setLabel(cursor.getString(idxLabel));
                gcWebsite.setUrl(cursor.getString(idxUrl));
                gcWebsite.setType(cursor.getInt(idxType));

                listWebsite.add(gcWebsite);
            } while (cursor.moveToNext());

            cursor.close();
            return listWebsite;
        } else {
            GetContactLog.v("No websites for read.");
            return null;
        }
    }
}
