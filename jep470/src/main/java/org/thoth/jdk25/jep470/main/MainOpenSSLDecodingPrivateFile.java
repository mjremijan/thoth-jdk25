package org.thoth.jdk25.jep470.main;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.DEREncodable;
import java.security.PEMDecoder;
import java.security.PrivateKey;

/**
 */
public class MainOpenSSLDecodingPrivateFile {
    public static void main(String[] args) throws Exception {
     System.out.printf("Hello JEP-470! OpenSSL decoding private PEM file%n%n");
     
     System.out.printf("Read the OpenSSL test-private.pem file into a String%n");
     InputStream is = MainOpenSSLDecodingPrivateFile.class.getClassLoader().getResourceAsStream("test-private.pem");
     byte[] bytes = is.readAllBytes();
     String privatePem = new String(bytes, StandardCharsets.UTF_8);
     System.out.printf("%s%n", privatePem);

     System.out.printf("Create PEMDecoder%n");
     PEMDecoder pd = PEMDecoder.of();
     
     System.out.printf("Decode the OpenSSL test-private.pem file%n");
     DEREncodable derEncodable = pd.decode(privatePem);
     switch (derEncodable) {
      case PrivateKey privateKey -> System.out.printf("Successfully decoded PrivateKey!%n");    
      default -> System.out.printf("What is \"%s\"%n", derEncodable.getClass().getName());
     }
  }
}
