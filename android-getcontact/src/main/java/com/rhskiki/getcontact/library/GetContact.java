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

import com.rhskiki.getcontact.library.base.GetEmail;
import com.rhskiki.getcontact.library.base.GetName;
import com.rhskiki.getcontact.library.base.GetPhone;
import com.rhskiki.getcontact.library.base.GetPostal;
import com.rhskiki.getcontact.library.base.GetWebsite;
import com.rhskiki.getcontact.model.GcContact;
import com.rhskiki.getcontact.model.base.GcEmail;
import com.rhskiki.getcontact.model.base.GcName;
import com.rhskiki.getcontact.model.base.GcPhone;
import com.rhskiki.getcontact.model.base.GcPostal;
import com.rhskiki.getcontact.model.base.GcWebsite;
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

    // ------------------------- GET ALL -----------------------

    // Todo-test, status: (OK)
    public List<String> getAllEmails() {
       GetEmail getEmail = new GetEmail(mContext);
        return getEmail.getSimple(GetContactUtils.NO_CONTACT_SELECTED);
    }

    // TODO-test, status: (OK)
    // TODO-describe
    public List<String> getAllNames() {
        GetName getName = new GetName(mContext);
        return getName.getSimple(GetContactUtils.NO_CONTACT_SELECTED);
    }

    // TODO-test
    public List<String> getAllPhone() {
        GetPhone getPhone = new GetPhone(mContext);
        return getPhone.getSimple(GetContactUtils.NO_CONTACT_SELECTED);
    }

    // TODO-implement
    public List<String> getAllPostals() {
        GetPostal getPostal = new GetPostal(mContext);
        return getPostal.getSimple(GetContactUtils.NO_CONTACT_SELECTED);
    }

    // TODO-implement
    public List<String> getAllWebsites() {
        GetWebsite getWebsite = new GetWebsite(mContext);
        return getWebsite.getSimple(GetContactUtils.NO_CONTACT_SELECTED);
    }

    // -------------------- GET ALL DETAILS --------------------

    // TODO-test
    public List<GcEmail> getAllEmailsDetails() {
        IBaseGetContact<GcEmail> getEmail = new GetEmail(mContext);
        return getEmail.getDetails(GetContactUtils.NO_CONTACT_SELECTED);
    }

    // TODO-test, status: (OK)
    // TODO-describe
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


    // -------------------- GET CONTACT --------------------


    // TODO-test
    public List<String> getContactEmails(int contactId) {
        GetEmail getEmail = new GetEmail(mContext);
        return getEmail.getSimple(contactId);
    }

    // TODO-test
    // TODO-describe
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

    // ---------------- GET CONTACT DETAILS ----------------


    // TODO-test
    public List<GcEmail> getContactEmailsDetails(int contactId) {
        GetEmail getEmail = new GetEmail(mContext);
        return getEmail.getDetails(contactId);
    }

    // TODO-test
    // TODO-describe
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



    // ----------------------- THIS CLASSE ---------------------

    // TODO for last.
    private List<GcContact> getContacts(int contactId) {
        // TODO implement.
        GetContactLog.d("To do implement");
        return null;
    }

    // TODO for last.
    private GcContact getContactDetails(int contactId) {
        // TODO implement.
        GetContactLog.d("To do implement");
        return null;
    }
}
