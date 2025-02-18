package dress_up_studio_be.Users.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    String email;
    String password;

    String firstName;
    String lastName;
    Long phoneNumber;
    String city;
    String streetAndNumber;
    String cityCode;
}
