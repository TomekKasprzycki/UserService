package pl.malopolska.umwm.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.malopolska.umwm.Dto.UserDto;
import pl.malopolska.umwm.entities.User;
import pl.malopolska.umwm.services.UserService;

import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto) {

        String result = "Denied";
        long milliseconds = System.currentTimeMillis();
        long expirationTime = 20L * 60 * 1000; //20 minutes

        try {

            User user = userService.findUser(userDto.getEmail());
            user.checkPassword(userDto.getPassword());

            result = Jwts.builder().setSubject(user.getEmail())
                    .claim("name", user.getName())
                    .claim("email", user.getEmail())
                    .claim("role", user.getRole().getId())
                    .setIssuedAt(new Date(milliseconds))
                    .setExpiration(new Date(expirationTime))
                    .signWith(SignatureAlgorithm.HS256, user.getPassword())
                    .compact();

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }


        return result;
    }


}
