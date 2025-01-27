package dress_up_studio_be.Users.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "USERS")
public class UserDocument {

    @Id
    private String id;

    private String username;
    private String password;
    private Role role;
}
