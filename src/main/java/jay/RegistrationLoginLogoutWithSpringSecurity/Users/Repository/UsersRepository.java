package jay.RegistrationLoginLogoutWithSpringSecurity.Users.Repository;

import jay.RegistrationLoginLogoutWithSpringSecurity.Users.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}
