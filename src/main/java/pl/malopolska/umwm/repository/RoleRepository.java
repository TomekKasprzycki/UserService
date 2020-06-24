package pl.malopolska.umwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.malopolska.umwm.entities.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select r from Role r where r.id=:id")
    Role findRoleById(@Param("id")Long id);

}
