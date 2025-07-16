
package org.thoth.jdk25.jep470.main;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.DEREncodable;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PEMDecoder;
import java.security.PEMEncoder;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

/**
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.printf("Hello JEP-470!%n%n");
        
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
        
        System.out.printf("Encode KeyPair to the PEM format%n");
        String pem = pe.encodeToString(pair);
        System.out.printf("%s%n", pem);
        
        System.out.printf("Create PEMDecoder%n");
        PEMDecoder pd = PEMDecoder.of();
        
        System.out.printf("Read the OpenSSL test-public.pem file into a String%n");        
        {
            InputStream is = Main.class.getClassLoader().getResourceAsStream("test-public.pem");
            byte[] bytes = is.readAllBytes();
            String publicPem = new String(bytes, StandardCharsets.UTF_8);
            System.out.printf("%s%n", publicPem);
            
            DEREncodable derEncodable = pd.decode(publicPem);
            switch (derEncodable) {
                case PublicKey publicKey -> System.out.printf("Successfully decoded PublicKey!%n");    
                default -> System.out.printf("What is \"%s\"%n", derEncodable.getClass().getName());
            }            
        }
        
        System.out.printf("Read the OpenSSL test-private.pem file into a String%n");        
        {
            InputStream is = Main.class.getClassLoader().getResourceAsStream("test-private.pem");
            byte[] bytes = is.readAllBytes();
            String privatePem = new String(bytes, StandardCharsets.UTF_8);
            System.out.printf("%s%n", privatePem);
            
            DEREncodable derEncodable = pd.decode(privatePem);
            switch (derEncodable) {
                case PrivateKey privateKey -> System.out.printf("Successfully decoded PrivateKey!%n");    
                default -> System.out.printf("What is \"%s\"%n", derEncodable.getClass().getName());
            }            
        }
    }
}
