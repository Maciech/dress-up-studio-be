package dress_up_studio_be.Users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "USERS")
public class UserDocument {

    @Id
    private Long id;

    private String username;
    private String password;
    private Boolean isAdmin;


}
