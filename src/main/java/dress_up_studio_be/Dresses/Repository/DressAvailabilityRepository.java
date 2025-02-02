package dress_up_studio_be.Dresses.Repository;

import dress_up_studio_be.Dresses.Models.DressAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DressAvailabilityRepository extends JpaRepository<DressAvailability, Long> {
}
