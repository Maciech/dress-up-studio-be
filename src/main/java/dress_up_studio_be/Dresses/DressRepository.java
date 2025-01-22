package dress_up_studio_be.Dresses;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DressRepository extends MongoRepository<DressDocument, String> {
    DressDocument findByName(String name);
}
