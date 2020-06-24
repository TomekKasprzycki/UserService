package pl.malopolska.umwm.Dto;

import org.springframework.stereotype.Service;
import pl.malopolska.umwm.entities.User;
import pl.malopolska.umwm.services.RoleService;
import pl.malopolska.umwm.services.UserService;

@Service
public class DtoConverter {

    private final UserService userService;
    private final RoleService roleService;

    public DtoConverter(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public UserDto convertToDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setRoleId(user.getRole().getId());

        return userDto;
    }

    public User convertFromDto(UserDto userDto) {

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setRole(roleService.getRole(userDto.getRoleId()));

        return user;
    }


}
