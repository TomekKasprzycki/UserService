package pl.malopolska.umwm.entities;

import lombok.Data;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Date created;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    public void setPassword(String unHashedPassword) {
        this.password = BCrypt.hashpw(unHashedPassword, BCrypt.gensalt());
    }

    public boolean checkPassword(String unHashedPassword) {

        return BCrypt.checkpw(unHashedPassword, this.password);
    }

}
