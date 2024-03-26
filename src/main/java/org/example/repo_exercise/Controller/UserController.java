package org.example.repo_exercise.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.repo_exercise.API.ApiResponse;
import org.example.repo_exercise.Model.User;
import org.example.repo_exercise.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }
    @PostMapping("/add")
    public ResponseEntity addUSer(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("user Updated "));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("user deleted"));
    }
    @GetMapping("/search-role/{role}")
    public ResponseEntity searchAge(@PathVariable String role){
        List<User> list_role=userService.searchRole(role);
        return ResponseEntity.status(200).body(list_role);
    }

    @GetMapping("/search-age/{age1}")
    public ResponseEntity searchAge(@PathVariable Integer age1){
        List<User> list_age=userService.searchAge(age1);
        return ResponseEntity.status(200).body(list_age);
    }
@GetMapping("/search-email/{email}")
    public ResponseEntity searchByEmial(@PathVariable String email){
        User u=userService.searchByEmail(email);
        return ResponseEntity.status(200).body(u);
    }
    @GetMapping("/check/{user_name}/{pass}")
    public ResponseEntity checkUserNamePass(@PathVariable String user_name,@PathVariable String pass){
        User u=userService.checkPasswordUsername(user_name,pass);
        return ResponseEntity.status(200).body(u);
    }
}
