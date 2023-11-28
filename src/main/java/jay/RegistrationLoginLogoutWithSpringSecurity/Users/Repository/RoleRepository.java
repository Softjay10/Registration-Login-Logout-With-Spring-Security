package jay.RegistrationLoginLogoutWithSpringSecurity.Users.Repository;

import jay.RegistrationLoginLogoutWithSpringSecurity.Users.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
