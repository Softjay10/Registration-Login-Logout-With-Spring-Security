package jay.RegistrationLoginLogoutWithSpringSecurity.Users.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/login")
    public String login(){
        return "views/frontend/login/index";
    }

    @GetMapping(value = "/")
    public String home(){
        return "views/frontend/index";
    }

}
