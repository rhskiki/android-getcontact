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

import android.content.Context;

import com.rhskiki.getcontact.model.GcContact;
import com.rhskiki.getcontact.model.GcEmail;
import com.rhskiki.getcontact.model.GcName;
import com.rhskiki.getcontact.model.GcPhone;
import com.rhskiki.getcontact.model.GcPostal;
import com.rhskiki.getcontact.model.GcWebsite;
import com.rhskiki.getcontact.utils.GetContactLog;
import com.rhskiki.getcontact.utils.GetContactUtils;

import java.util.List;

/**
 * // TODO Comment.
 *
 * @author rhskiki
 * @since 2015
 */
public class GetContact {

    /**
     * Context of the application.
     */
    private Context mContext;

    /**
     * Construtor default.
     *
     * @param context Context of the application.
     */
    public GetContact(Context context) {
        this.mContext = context;
    }

    public List<String> getAllEmails() {
       GetEmail getEmail = new GetEmail(mContext);
       return getEmail.getSimple(GetContactUtils.NO_CONTACT_SELECTED);
    }

    public List<String> getAllNames() {
        GetName getName = new GetName(mContext);
        return getName.getSimple(GetContactUtils.NO_CONTACT_SELECTED);
    }

    public List<String> getAllPhone() {
        GetPhone getPhone = new GetPhone(mContext);
        return getPhone.getSimple(GetContactUtils.NO_CONTACT_SELECTED);
    }

    public List<String> getAllPostals() {
        GetPostal getPostal = new GetPostal(mContext);
        return getPostal.getSimple(GetContactUtils.NO_CONTACT_SELECTED);
    }

    public List<String> getAllWebsites() {
        GetWebsite getWebsite = new GetWebsite(mContext);
        return getWebsite.getSimple(GetContactUtils.NO_CONTACT_SELECTED);
    }

    public List<GcEmail> getAllEmailsDetails() {
        GetEmail getEmail = new GetEmail(mContext);
        return getEmail.getDetails(GetContactUtils.NO_CONTACT_SELECTED);
    }

    public List<GcName> getAllNamesDetails() {
        GetName getName = new GetName(mContext);
        return getName.getDetails(GetContactUtils.NO_CONTACT_SELECTED);
    }

    public List<GcPhone> getAllPhonesDetails() {
        GetPhone getPhone = new GetPhone(mContext);
        return getPhone.getDetails(GetContactUtils.NO_CONTACT_SELECTED);
    }

    public List<GcPostal> getAllPostalDetails() {
        GetPostal getPostal = new GetPostal(mContext);
        return getPostal.getDetails(GetContactUtils.NO_CONTACT_SELECTED);
    }

    public List<GcWebsite> getAllWebsite() {
        GetWebsite getWebsite = new GetWebsite(mContext);
        return getWebsite.getDetails(GetContactUtils.NO_CONTACT_SELECTED);
    }

    public List<String> getContactEmails(int contactId) {
        GetEmail getEmail = new GetEmail(mContext);
        return getEmail.getSimple(contactId);
    }

    public List<String> getContactNames(int contactId) {
        GetName getName = new GetName(mContext);
        return getName.getSimple(contactId);
    }

    public List<String> getContactPhones(int contactId) {
        GetPhone getPhone = new GetPhone(mContext);
        return getPhone.getSimple(contactId);
    }

    public List<String> getContactPostals(int contactId) {
        GetPostal getPostal = new GetPostal(mContext);
        return getPostal.getSimple(contactId);
    }

    public List<String> getContactWebsite(int contactId) {
        GetWebsite getWebsite = new GetWebsite(mContext);
        return getWebsite.getSimple(contactId);
    }

    public List<GcEmail> getContactEmailsDetails(int contactId) {
        GetEmail getEmail = new GetEmail(mContext);
        return getEmail.getDetails(contactId);
    }

    public List<GcName> getContactNamesDetails(int contactId) {
        GetName getName = new GetName(mContext);
        return getName.getDetails(contactId);
    }

    public List<GcPhone> getContactPhonesDetails(int contactId) {
        GetPhone getPhone = new GetPhone(mContext);
        return getPhone.getDetails(contactId);
    }

    public List<GcPostal> getContactPostalsDetails(int contactId) {
        GetPostal getPostal = new GetPostal(mContext);
        return getPostal.getDetails(contactId);
    }

    public List<GcWebsite> getContactWebsiteDetails(int contactId) {
        GetWebsite getWebsite = new GetWebsite(mContext);
        return getWebsite.getDetails(contactId);
    }

    private List<GcContact> getContacts(int contactId) {
        // TODO implement.
        GetContactLog.d("To do implement");
        return null;
    }

    private GcContact getContactDetails(int contactId) {
        // TODO implement.
        GetContactLog.d("To do implement");
        return null;
    }
}
