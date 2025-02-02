package dress_up_studio_be.Users.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "USERS")
public class UserEntity {

    @Id
    private Long userId;

    private String email;
    private String password;
    private Role role;
}
