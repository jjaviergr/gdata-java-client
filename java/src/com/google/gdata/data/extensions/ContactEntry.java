/* Copyright (c) 2006 Google Inc.
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


package com.google.gdata.data.extensions;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.util.Namespaces;

import java.util.List;

/**
 * Extension class for manipulating entries of the Contact kind.
 *
 * 
 */
@Kind.Term(ContactEntry.CONTACT_KIND)
public class ContactEntry extends BaseEntry<ContactEntry> {

  /**
   * Kind term value for Contact category labels.
   */
  public static final String CONTACT_KIND = Namespaces.gPrefix + "contact";

  /**
   * Kind category used to label feeds or entries that have Contact
   * extension data.
   */
  public static final Category CONTACT_CATEGORY =
    new Category(Namespaces.gKind, CONTACT_KIND);


  /**
   * Constructs a new empty ContactEntry with the appropriate kind category
   * to indicate that it is a contact.
   */
  public ContactEntry() {
    super();
    getCategories().add(CONTACT_CATEGORY);
  }

  /**
   * Constructs a new ContactEntry by doing a shallow copy of data from an
   * existing BaseEntry intance.
   */
  public ContactEntry(BaseEntry sourceEntry) {
    super(sourceEntry);
    getCategories().add(CONTACT_CATEGORY);
  }

  /**
   * Initializes an ExtensionProfile based upon the extensions expected
   * by an ContactEntry.
   */
  public void declareExtensions(ExtensionProfile extProfile) {
    extProfile.declare(ContactEntry.class, Email.getDefaultDescription());
    extProfile.declare(ContactEntry.class, Im.getDefaultDescription());
    extProfile.declare(ContactEntry.class, PhoneNumber.getDefaultDescription());
    extProfile.declare(ContactEntry.class,
        PostalAddress.getDefaultDescription());
    extProfile.declare(ContactEntry.class, GeoPt.getDefaultDescription());
  }

  public List<Email> getEmailAddresses() {
    return getRepeatingExtension(Email.class);
  }

  public void addEmailAddress(Email email) {
    getEmailAddresses().add(email);
  }

  public List<Im> getImAddresses() {
    return getRepeatingExtension(Im.class);
  }

  public void addImAddress(Im im) {
    getImAddresses().add(im);
  }

  public List<PhoneNumber> getPhoneNumbers() {
    return getRepeatingExtension(PhoneNumber.class);
  }

  public void addPhoneNumber(PhoneNumber phoneNumber) {
    getPhoneNumbers().add(phoneNumber);
  }

  public List<PostalAddress> getPostalAddresses() {
    return getRepeatingExtension(PostalAddress.class);
  }

  public void addPostalAddress(PostalAddress postalAddress) {
    getPostalAddresses().add(postalAddress);
  }

  public List<GeoPt> getLocations() {
    return getRepeatingExtension(GeoPt.class);
  }

  public void addLocation(GeoPt geoPt) {
    getLocations().add(geoPt);
  }
}