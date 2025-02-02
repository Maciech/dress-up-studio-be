package dress_up_studio_be.Users.Repository;

import dress_up_studio_be.Users.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String username);
}
