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

package org.guanxi.common.security;

import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.utils.URI;
import org.w3c.dom.Attr;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class OfflineResolver extends ResourceResolverSpi {
  static Map<String, String> _uriMap = null;
  static Map<String, String> _mimeMap = null;

  public XMLSignatureInput engineResolve(Attr uri, String BaseURI) throws ResourceResolverException {
    try {
      String URI = uri.getNodeValue();

      if (OfflineResolver._uriMap.containsKey(URI)) {
        String newURI = (String)OfflineResolver._uriMap.get(URI);

        InputStream is = new FileInputStream(newURI);

        XMLSignatureInput result = new XMLSignatureInput(is);
        result.setSourceURI(URI);
        result.setMIMEType((String) OfflineResolver._mimeMap.get(URI));

        return result;
      }
      else {
        Object exArgs[] = {"The URI " + URI + " is not configured for offline work"};
        throw new ResourceResolverException("generic.EmptyMessage", exArgs, uri, BaseURI);
      }
    }
    catch (IOException ex) {
      throw new ResourceResolverException("generic.EmptyMessage", ex, uri, BaseURI);
    }
  }

  public boolean engineCanResolve(Attr uri, String BaseURI) {
    String uriNodeValue = uri.getNodeValue();

    if (uriNodeValue.equals("") || uriNodeValue.startsWith("#")) {
      return false;
    }

    try {
      URI uriNew = new URI(new URI(BaseURI), uri.getNodeValue());
      if (uriNew.getScheme().equals("http")) {
        return true;
      }
    }
    catch (URI.MalformedURIException ex) {}

    return false;
  }

  private static void register(String URI, String filename, String MIME) {
    OfflineResolver._uriMap.put(URI, filename);
    OfflineResolver._mimeMap.put(URI, MIME);
  }

  static {
    org.apache.xml.security.Init.init();

    OfflineResolver._uriMap = new HashMap<String, String>();
    OfflineResolver._mimeMap = new HashMap<String, String>();

    OfflineResolver.register("http://www.w3.org/TR/xml-stylesheet",
                             "data/org/w3c/www/TR/xml-stylesheet.html",
                             "text/html");

    OfflineResolver.register("http://www.w3.org/TR/2000/REC-xml-20001006",
                             "data/org/w3c/www/TR/2000/REC-xml-20001006",
                             "text/xml");

    OfflineResolver.register("http://www.nue.et-inf.uni-siegen.de/index.html",
                             "data/org/apache/xml/security/temp/nuehomepage",
                             "text/html");

    OfflineResolver.register("http://www.nue.et-inf.uni-siegen.de/~geuer-pollmann/id2.xml",
                             "data/org/apache/xml/security/temp/id2.xml",
                             "text/xml");

    OfflineResolver.register("http://xmldsig.pothole.com/xml-stylesheet.txt",
                             "data/com/pothole/xmldsig/xml-stylesheet.txt",
                             "text/xml");
  }
}
