package dress_up_studio_be.Dresses.Repository;

import dress_up_studio_be.Dresses.Models.DressMstEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DressRepository extends JpaRepository<DressMstEntity, Long> {
    DressMstEntity findByName(String name);

//    List<DressMstEntity> findAllByOrderByDateModifiedDesc();
}
