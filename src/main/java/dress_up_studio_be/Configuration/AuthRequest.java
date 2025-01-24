package dress_up_studio_be.Configuration;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
