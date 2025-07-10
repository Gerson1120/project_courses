package utez.edu.mx.melimas.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.melimas.user.model.UserEntity;

@RestController
@RequestMapping("/cursos/auth")
@CrossOrigin(origins = "http://localhost:3000")

public class AuthController {
// este es el controlador de autenticación
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto) {
        return authService.login(dto);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity nuevo) {
        return authService.register(nuevo);
    }
}