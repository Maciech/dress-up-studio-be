package dress_up_studio_be.repository;

import dress_up_studio_be.model.Dress;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DressRepository extends MongoRepository<Dress, String> {
    Dress findByName(String name);
}
