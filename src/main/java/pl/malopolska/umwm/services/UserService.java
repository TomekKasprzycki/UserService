package pl.malopolska.umwm.services;

import org.springframework.stereotype.Service;
import pl.malopolska.umwm.entities.User;
import pl.malopolska.umwm.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User findUser(String email){ return userRepository.getUserByEmail(email);}

    public Long getUserRoleId(String email){
        return userRepository.findRoleId(email).getId();
    }

    public User save(User user){ return userRepository.save(user); }

}
