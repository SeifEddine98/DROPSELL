package CONTROLLERS;

import org.springframework.web.bind.annotation.*;

import ENTITIES.User;
import SERVICE.UserService;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins ="http://localhost:8100")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/AddUser")
    public User addUser(@RequestBody User user) {
        System.out.println(user.toString());
        return userService.addUser(user) ;
    }
}
