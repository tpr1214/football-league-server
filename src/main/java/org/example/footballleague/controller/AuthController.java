package org.example.footballleague.controller;

import org.example.footballleague.Service.UserService;
import org.example.footballleague.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {// אימות
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        boolean isSuccess = userService.register(user);

        if (!isSuccess) {
            return ResponseEntity.badRequest().body("כתובת האימייל הזו כבר רשומה במערכת!");
        }

        return ResponseEntity.ok("המשתמש נרשם בהצלחה!");
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {

        return ResponseEntity.ok("התחברת בהצלחה!");
    }
}
