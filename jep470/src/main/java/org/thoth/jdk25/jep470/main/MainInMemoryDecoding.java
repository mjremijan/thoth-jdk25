
package org.thoth.jdk25.jep470.main;

import java.security.DEREncodable;
import java.security.KeyPair;
import java.security.PEMDecoder;

/**
 */
public class MainInMemoryDecoding {

    public static void main(String[] args) throws Exception {
        System.out.printf("Hello JEP-470! In memory decoding%n%n");
        
        String pem = """
-----BEGIN PRIVATE KEY-----
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
AgMBAAE=
-----END PRIVATE KEY-----""";
        
        System.out.printf("Create PEMDecoder%n");
        PEMDecoder pd = PEMDecoder.of();
        DEREncodable derEncodable = pd.decode(pem);
        switch (derEncodable) {
            case KeyPair keyPair -> System.out.printf("Successfully decoded KeyPair!%n%s%n", keyPair.toString());    
            default -> System.out.printf("What is \"%s\"%n", derEncodable.getClass().getName());
        } 
    }
}
