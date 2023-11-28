package jay.RegistrationLoginLogoutWithSpringSecurity.Users.Service;

import jay.RegistrationLoginLogoutWithSpringSecurity.Users.Dto.UsersRegisterDto;
import jay.RegistrationLoginLogoutWithSpringSecurity.Users.Model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    Users saves(UsersRegisterDto usersRegisterDto);
}
