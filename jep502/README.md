
# thoth-jdk25-jep502

**PEM Stable Values (Preview)**

 (https://openjdk.org/jeps/502)
        
Introduce an API for stable values, which are objects that hold immutable data. 
Stable values are treated as constants by the JVM, enabling the same performance 
optimizations that are enabled by declaring a field final. Compared to final 
fields, however, stable values offer greater flexibility as to the timing of 
their initialization, allowing for deferred immutability
