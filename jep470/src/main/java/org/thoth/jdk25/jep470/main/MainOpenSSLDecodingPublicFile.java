
package org.thoth.jdk25.jep470.main;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.DEREncodable;
import java.security.PEMDecoder;
import java.security.PublicKey;

/**
 */
public class MainOpenSSLDecodingPublicFile {

  public static void main(String[] args) throws Exception {
    System.out.printf("Hello JEP-470! OpenSSL decoding public PEM file%n%n");
    
    System.out.printf("Read the OpenSSL test-public.pem file into a String%n");    
    InputStream is = MainOpenSSLDecodingPublicFile.class.getClassLoader().getResourceAsStream("test-public.pem");
    byte[] bytes = is.readAllBytes();
    String publicPem = new String(bytes, StandardCharsets.UTF_8);
    System.out.printf("%s%n", publicPem);
    
    System.out.printf("Create PEMDecoder%n");
    PEMDecoder pd = PEMDecoder.of();

    System.out.printf("Decode the OpenSSL test-public.pem file%n");
    DEREncodable derEncodable = pd.decode(publicPem);
    switch (derEncodable) {
      case PublicKey publicKey -> System.out.printf("Successfully decoded PublicKey!%n");  
      default -> System.out.printf("What is \"%s\"%n", derEncodable.getClass().getName());
    }      
  }
}