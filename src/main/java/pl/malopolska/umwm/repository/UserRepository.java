package pl.malopolska.umwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.malopolska.umwm.entities.Role;
import pl.malopolska.umwm.entities.User;

import javax.net.ssl.SSLSession;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByEmail(String email);

    @Query("select u.role from User u where u.email=:email")
    Role findRoleId(String email);
}
