// Batch - 004: Create the first Java class in the PetClinic package.
package org.springframework.samples.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Batch - 009: Turn the application class into the Spring Boot entry point.
@SpringBootApplication
public class PetClinicApplication {

    // Batch - 005: Add the Java application entry point.
    public static void main(String[] args) {

        // Batch - 009: Start the Spring Boot application.
        SpringApplication.run(PetClinicApplication.class, args);

    }

}
