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

import com.rhskiki.getcontact.model.GcName;
import com.rhskiki.getcontact.utils.GetContactLog;
import com.rhskiki.getcontact.utils.GetContactUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for getting data from names contacts.
 */
public class GetName implements IBaseGetContact {

    /**
     * Context of the application.
     */
    private Context mContext;

    /**
     * Construtor with parameters.
     *
     * @param context Context of the application.
     */
    public GetName(Context context) {
        mContext = context;
    }

    /**
     * Get only address emails.
     *
     * @param contactId Id of contact, if case 0 get all display names.
     * @return List type {@link java.lang.String} with display names.
     */
    @Override
    public List<String> getSimple(int contactId) {
        Uri uri = ContactsContract.Data.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID,
                ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME};
        String selection;
        String[] selectionArgs;
        String sortOrder = ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME;

        if (contactId == GetContactUtils.NO_CONTACT_SELECTED) {
            selection = ContactsContract.Data.MIMETYPE + " = ? ";
            selectionArgs = new String[]{
                    String.valueOf(ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)};
        } else {
            selection = ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID + " = ? AND "
                    + ContactsContract.Data.MIMETYPE + " = ? ";
            selectionArgs = new String[]{
                    String.valueOf(contactId),
                    String.valueOf(ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)};
        }

        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null && cursor.moveToFirst()) {
            List<String> listNames = new ArrayList<String>();

            int idxName = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME);

            do {
                String name = cursor.getString(idxName);
                if (!GetContactUtils.verifyStringNull(name)) {
                    listNames.add(name);
                }
            } while (cursor.moveToNext());

            cursor.close();
            return listNames;
        } else {
            GetContactLog.v("No names for read.");
            return null;
        }
    }

    /**
     * Get all data names.
     * This data contains display name, family name, given name, middle name, prefix,
     * phonetic family name, phonetic given name, phonetic middle name and suffix.
     *
     * @param contactId Id of contact, if case 0 get all emails.
     * @return List type {@link com.rhskiki.getcontact.model.GcName} with datas.
     * @see android.provider.ContactsContract.CommonDataKinds.StructuredName
     */
    @Override
    public List<GcName> getDetails(int contactId) {
        Uri uri = ContactsContract.Data.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID,
                ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME,
                ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME,
                ContactsContract.CommonDataKinds.StructuredName.MIDDLE_NAME,
                ContactsContract.CommonDataKinds.StructuredName.PREFIX,
                ContactsContract.CommonDataKinds.StructuredName.PHONETIC_FAMILY_NAME,
                ContactsContract.CommonDataKinds.StructuredName.PHONETIC_GIVEN_NAME,
                ContactsContract.CommonDataKinds.StructuredName.PHONETIC_MIDDLE_NAME,
                ContactsContract.CommonDataKinds.StructuredName.SUFFIX
        };
        String selection;
        String[] selectionArgs;
        String sortOrder = ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME;

        if (contactId == GetContactUtils.NO_CONTACT_SELECTED) {
            selection = ContactsContract.Data.MIMETYPE + " = ? ";
            selectionArgs = new String[]{
                    String.valueOf(ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)};
        } else {
            selection = ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID + " = ?"
                    + ContactsContract.Data.MIMETYPE + " = ? ";
            selectionArgs = new String[]{
                    String.valueOf(contactId),
                    String.valueOf(ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)};
        }

        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null && cursor.moveToFirst()) {
            List<GcName> listGcNames = new ArrayList<GcName>();

            int idxDisplayName = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME);
            int idxFamilyName = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME);
            int idxGivenName = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME);
            int idxMidleName = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredName.MIDDLE_NAME);
            int idxPrefix = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredName.PREFIX);
            int idxPhoneticFamilyName = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredName.PHONETIC_FAMILY_NAME);
            int idxPhoneticGivenName = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredName.PHONETIC_GIVEN_NAME);
            int idxPhoneticMiddleName = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredName.PHONETIC_MIDDLE_NAME);
            int idxSuffix = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.StructuredName.SUFFIX);

            do {
                GcName names = new GcName();

                String displayName = cursor.getString(idxDisplayName);
                String familyName = cursor.getString(idxFamilyName);
                String givenName = cursor.getString(idxGivenName);
                String middleName = cursor.getString(idxMidleName);
                String prefix = cursor.getString(idxPrefix);
                String phoneticFamilyName = cursor.getString(idxPhoneticFamilyName);
                String phoneticGivenName = cursor.getString(idxPhoneticGivenName);
                String phoneticMiddleName = cursor.getString(idxPhoneticMiddleName);
                String suffix = cursor.getString(idxSuffix);

                if (!GetContactUtils.verifyStringNull(displayName, familyName, givenName,
                        middleName, prefix, phoneticFamilyName, phoneticGivenName,
                        phoneticMiddleName, suffix)) {
                    names.setDisplayName(displayName);
                    names.setFamilyName(familyName);
                    names.setGivenName(givenName);
                    names.setMiddleName(middleName);
                    names.setPrefix(prefix);
                    names.setPhoneticFamilyName(phoneticFamilyName);
                    names.setPhoneticGivenName(phoneticGivenName);
                    names.setPhoneticMiddleName(phoneticMiddleName);
                    names.setSuffix(suffix);

                    listGcNames.add(names);
                }
            } while (cursor.moveToNext());

            cursor.close();
            return listGcNames;
        } else {
            GetContactLog.v("No names for read.");
            return null;
        }
    }
}
