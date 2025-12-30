package org.example.authservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) {
        if (repo.count() == 0) {
            repo.save(new User(null, "caissier", encoder.encode("1234"), Role.Caissier));
            repo.save(new User(null, "cuisinier", encoder.encode("6789"), Role.Cuisinier));
        }
    }
}
