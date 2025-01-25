package dress_up_studio_be.Users;

import dress_up_studio_be.Users.Models.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {

    UserDocument findByUsername(String username);
}
