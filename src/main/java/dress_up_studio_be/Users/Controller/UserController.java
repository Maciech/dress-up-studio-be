package dress_up_studio_be.Users.Controller;

import dress_up_studio_be.Users.Models.UserRequest;
import dress_up_studio_be.Users.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest loginRequest) {
        String token = userService.verifyUser(loginRequest);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody UserRequest request) {
        userService.saveUserDocument(request);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/users/panel")
    public ResponseEntity<Map<String, String>> getUserData() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "This is a secured user data response");
        return ResponseEntity.ok(response);
    }
}
