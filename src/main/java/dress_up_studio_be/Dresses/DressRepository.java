package dress_up_studio_be.Dresses;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DressRepository extends MongoRepository<DressDocument, String> {
    DressDocument findByName(String name);

    List<DressDocument> findAllByOrderByDateModifiedDesc();
}
