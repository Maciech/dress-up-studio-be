package dress_up_studio_be.Users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/users")
public class UsersController {

    @GetMapping(path = "/is-user-logged")
    String isUserLoggedIn() {
        return "Security";
    }
}