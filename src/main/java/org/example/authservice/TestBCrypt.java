package org.example.authservice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCrypt {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = "$2a$10$8jI.5hLPSeGPduGXRvQdf.OE8vzEPNBlACNqOESRZuRQZs2oUxGMS "; // hash du mot de passe
        String password = "1234";

        System.out.println(encoder.matches(password, hash)); // true si ça correspond
    }
}
