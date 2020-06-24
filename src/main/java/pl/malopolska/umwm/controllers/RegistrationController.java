package pl.malopolska.umwm.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.malopolska.umwm.Dto.DtoConverter;
import pl.malopolska.umwm.Dto.UserDto;
import pl.malopolska.umwm.entities.User;
import pl.malopolska.umwm.services.RoleService;
import pl.malopolska.umwm.services.UserService;
import pl.malopolska.umwm.validators.Validator;

import java.util.Date;

@RestController
public class RegistrationController {

    private final Validator validator;
    private final UserService userService;
    private final DtoConverter dtoConverter;
    private final RoleService roleService;

    public RegistrationController(Validator validator, UserService userService, DtoConverter dtoConverter, RoleService roleService){
        this.validator=validator;
        this.userService=userService;
        this.dtoConverter=dtoConverter;
        this.roleService=roleService;
    }

    @PostMapping("/registration")
    public boolean registration(@RequestBody UserDto userDto){

        boolean result = false;

        boolean condition1 = validator.isEmailValid(userDto.getEmail());
        boolean condition2 = validator.isPasswordValid(userDto);

        if(condition1 && condition2){
            User user = dtoConverter.convertFromDto(userDto);
            user.setCreated(new Date(System.currentTimeMillis()));
            if (userDto.getRoleId() == null) {
                user.setRole(roleService.getRole(3L));
            } else {
                user.setRole(roleService.getRole(userDto.getRoleId()));
            }
            user = userService.save(user);
        }

        return result;
    }

}
