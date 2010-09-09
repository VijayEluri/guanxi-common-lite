//: "The contents of this file are subject to the Mozilla Public License
//: Version 1.1 (the "License"); you may not use this file except in
//: compliance with the License. You may obtain a copy of the License at
//: http://www.mozilla.org/MPL/
//:
//: Software distributed under the License is distributed on an "AS IS"
//: basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
//: License for the specific language governing rights and limitations
//: under the License.
//:
//: The Original Code is Guanxi (http://www.guanxi.uhi.ac.uk).
//:
//: The Initial Developer of the Original Code is Alistair Young alistair@codebrane.com
//: All Rights Reserved.
//:

package org.guanxi.common.definitions;

public class SAML {
  // SAML1 URNs
  public static final String URN_AUTH_METHOD_PASSWORD = "urn:oasis:names:tc:SAML:1.0:am:password";
  public static final String URN_CONFIRMATION_METHOD_BEARER = "urn:oasis:names:tc:SAML:1.0:cm:bearer";

  // SAML2 URNs
  public static final String URN_SAML2_CONFIRMATION_METHOD_BEARER = "urn:oasis:names:tc:SAML:2.0:cm:bearer";
  public static final String URN_SAML2_PASSWORD_PROTECTED_TRANSPORT = "urn:oasis:names:tc:SAML:2.0:ac:classes:PasswordProtectedTransport";
  public static final String URN_SAML2_NAMEID_FORMAT_ENTITY = "urn:oasis:names:tc:SAML:2.0:nameid-format:entity";

  // Namespaces
  public static final String NS_SAML_ASSERTION = "urn:oasis:names:tc:SAML:1.0:assertion";

  // Bindings
  public static final String BROWSER_POST_BINDING = "urn:oasis:names:tc:SAML:1.0:profiles:browser-post";

  // SAML2
  public static final String NS_SAML_20_PROTOCOL = "urn:oasis:names:tc:SAML:2.0:protocol";
  public static final String NS_SAML_20_ASSERTION = "urn:oasis:names:tc:SAML:2.0:assertion";
  public static final String NS_PREFIX_SAML_20_PROTOCOL = "samlp";
  public static final String NS_PREFIX_SAML_20_ASSERTION = "saml";
  public static final String SAML2_ATTRIBUTE_NAME_FORMAT_URI = "urn:oasis:names:tc:SAML:2.0:attrname-format:uri";
  public static final String SAML2_ATTRIBUTE_FORMAT_NAMEID_PERSISTENT = "urn:oasis:names:tc:SAML:2.0:nameid-format:persistent";
  public static final String SAML2_STATUS_SUCCESS = "urn:oasis:names:tc:SAML:2.0:status:Success";
  public static final String SAML2_BINDING_HTTP_POST = "urn:oasis:names:tc:SAML:2.0:bindings:HTTP-POST";
  public static final String SAML2_BINDING_HTTP_REDIRECT = "urn:oasis:names:tc:SAML:2.0:bindings:HTTP-Redirect";
}
