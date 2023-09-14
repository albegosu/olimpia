package olimpia.BackEnd.controllers;

import olimpia.BackEnd.models.userModel;
import olimpia.BackEnd.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class userController {
    @Autowired
    userService myService;

    @GetMapping
    public userModel getUser(@RequestBody String userName){
        return myService.getByUserName(userName);
    }

}
