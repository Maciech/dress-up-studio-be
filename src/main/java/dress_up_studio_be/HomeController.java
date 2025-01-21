package dress_up_studio_be;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping
    String getHelloMessage() {
        return "Hello";
    }
}
