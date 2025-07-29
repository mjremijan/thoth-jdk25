package org.thoth.jdk25.jep470.main;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PEMEncoder;
import java.security.SecureRandom;

/**
 */
public class MainInMemoryEncoding {

  public static void main(String[] args) throws Exception {
    System.out.printf("Hello JEP-470 In memory encoding!%n%n");
    
    System.out.printf("Create KeyPairGenerator for RSA%n");
    KeyPairGenerator generator 
      = KeyPairGenerator.getInstance("RSA");
    
    System.out.printf("Initialize KeyPairGenerator with a key size and SecureRandom%n");
    generator.initialize(2048, new SecureRandom());
    
    System.out.printf("Generate a KeyPair%n");
    KeyPair pair
      = generator.generateKeyPair();
    
    System.out.printf("Create PEMEncoder%n");
    PEMEncoder pe = PEMEncoder.of();
    
    System.out.printf("Encode private key to the PEM format%n");
    String privatePem = pe.encodeToString(pair.getPrivate());
    System.out.printf("%s%n", privatePem);
    
    System.out.printf("Encode public key to the PEM format%n");
    String publicPem = pe.encodeToString(pair.getPublic());
    System.out.printf("%s%n", publicPem);
  }
}
