package Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Controller;

import Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Models.User;
import Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<User> getUserById(@PathVariable Long Id){
        return userService.getUserById(Id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createdUser(@RequestBody User user){
        return userService.createdUser(user);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<User> updatdUser(@PathVariable Long Id, @RequestBody User userDetails){
        return userService.updatedUser(Id, userDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deletedUser(@PathVariable Long Id){
        boolean deletedUser = userService.deletedUser(Id);
        return deletedUser ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
