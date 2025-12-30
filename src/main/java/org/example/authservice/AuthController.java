package org.example.authservice;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;



    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginDTO dto) {
        System.out.println("========================================");
        System.out.println("📥 Requête reçue - Username: " + dto.username);
        System.out.println("📥 Requête reçue - Password: " + dto.password);
        System.out.println("========================================");
        User user = userService.authenticate(dto.username, dto.password);
        String token = jwtService.generateToken(user);
        return new TokenResponse(token);
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validate(@RequestParam String token) {
        if (jwtService.validate(token)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(401).build();
    }
}
