package pl.malopolska.umwm.Dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String password2;
    private Long roleId;
    private String token;

}
