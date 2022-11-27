package ru.dorjik.rest_js.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dorjik.rest_js.dto.UserDTO;
import ru.dorjik.rest_js.models.User;
import ru.dorjik.rest_js.services.UserService;
import ru.dorjik.rest_js.services.security.AccountDetails;
import ru.dorjik.rest_js.utils.UserErrorResponse;
import ru.dorjik.rest_js.utils.UserNotFoundException;


import java.util.List;

@RestController
@RequestMapping("/api")
public class RestAccessController {
    private final UserService userService;

    public RestAccessController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> userList() {

        return userService.listUsers();
    }


    @GetMapping("/users/{id}")
    public User showUser(@PathVariable("id") Long id) {

        return userService.getUser(id);
    }


    @GetMapping("/user")
    public User currentUser(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
        return accountDetails.getUser();
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> userException(UserNotFoundException exception) {

        UserErrorResponse response = new UserErrorResponse(
                "User not found", System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserDTO user) {

        System.out.println(user);
        userService.addUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<HttpStatus> editUser(@RequestBody UserDTO user, @PathVariable("id") Long id) {

        userService.editUser(id, user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {

        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}




