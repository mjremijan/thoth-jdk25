package org.thoth.jdk25.jep502.main.traditional;

public class Main {
    public static void main(String[] args) {
        new TraditionalLoggerWithEagerInitialization().service();
        new TraditionalLoggerWithLazyInitialization().service();
    }
   
}
