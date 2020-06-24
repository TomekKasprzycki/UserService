package pl.malopolska.umwm.services;

import org.springframework.stereotype.Service;
import pl.malopolska.umwm.entities.Role;
import pl.malopolska.umwm.repository.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    public Role getRole(Long id){
        return roleRepository.findRoleById(id);
    }

}
