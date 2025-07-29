
# thoth-jdk25-jep470

## PEM Encodings of Cryptographic Objects (Preview)**

**Notes**

 <https://openjdk.org/jeps/470>
        
The Privacy-Enhanced Mail (PEM) format <https://en.wikipedia.org/wiki/Privacy-Enhanced_Mail>
defined by RFC 7468 <https://www.rfc-editor.org/rfc/rfc7468> is a representation 
of cryptographic objects.

Here is an example of a PEM-encoded cryptographic object, in this case an elliptic curve public key:

```
-----BEGIN PUBLIC KEY-----
MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEi/kRGOL7wCPTN4KJ2ppeSt5UYB6u
cPjjuKDtFTXbguOIFDdZ65O/8HTUqS/sVzRF+dg7H3/tkQ/36KdtuADbwQ==
-----END PUBLIC KEY-----
```

This is a preview API, disabled by default
To use this API in JDK 25, you must enable preview APIs:

* Compile the program with `javac --release 25 --enable-preview Main.java`
* Run the program with `java --enable-preview Main`

Generate 2048-bit RSA private keys in PEM format:

```
openssl genrsa -out test-private.pem 2048
```  

Extract the public key file from the private key in PEM format:

```
 openssl rsa -in test-private.pem -out test-public.pem -pubout -outform PEM
```