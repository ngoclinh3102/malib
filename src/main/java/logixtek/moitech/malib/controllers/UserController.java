package logixtek.moitech.malib.controllers;

import jakarta.validation.constraints.NotEmpty;
import logixtek.moitech.malib.configurations.versioning.ApiVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiVersion({1})
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserV1(@PathVariable @NotEmpty String userId) {
        return ResponseEntity.ok("User V1: " + userId);
    }

    @ApiVersion({2})
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserV2(@PathVariable @NotEmpty String userId) {
        return ResponseEntity.ok("User V1: " + userId);
    }
}
