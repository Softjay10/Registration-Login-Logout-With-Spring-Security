package jay.RegistrationLoginLogoutWithSpringSecurity.Users.Controller;

import jay.RegistrationLoginLogoutWithSpringSecurity.Users.Dto.UsersRegisterDto;
import jay.RegistrationLoginLogoutWithSpringSecurity.Users.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @ModelAttribute("users")
    public UsersRegisterDto usersRegisterDto(){
        return new UsersRegisterDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "views/frontend/registration/index";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UsersRegisterDto registrationDto) {
        usersService.saves(registrationDto);
        return "redirect:/registration?success";
    }
}
