package jay.RegistrationLoginLogoutWithSpringSecurity.Users.Service;

import jay.RegistrationLoginLogoutWithSpringSecurity.Users.Dto.UsersRegisterDto;
import jay.RegistrationLoginLogoutWithSpringSecurity.Users.Model.Role;
import jay.RegistrationLoginLogoutWithSpringSecurity.Users.Model.Users;
import jay.RegistrationLoginLogoutWithSpringSecurity.Users.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users saves(UsersRegisterDto usersRegisterDto) {
        Users users = new Users();
        users.setFirstName(usersRegisterDto.getFirstName());
        users.setLastName(usersRegisterDto.getLastName());
        users.setEmail(usersRegisterDto.getEmail());
        users.setPassword(passwordEncoder.encode(usersRegisterDto.getPassword()));

        List<Role> roles = new ArrayList<Role>();
        Role role = new Role();
        role.setName("ROLE_USER");
        roles.add(role);
        users.setRoles(roles);

        return usersRepository.save(users);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByEmail(username);
        if (users == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(), mapRolesToAuthorities(users.getRoles()));
    }
}

