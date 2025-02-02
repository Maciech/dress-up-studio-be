package dress_up_studio_be.Dresses.Models;


import dress_up_studio_be.Dresses.Enums.COLOR;
import dress_up_studio_be.Dresses.Enums.SIZE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DressAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dressAvailabilityId;

    SIZE size;

    Boolean isAvailable;

    Double price;

    @ManyToOne
    @JoinColumn(name="dressId", nullable=false)
    DressMstEntity dressMstEntity;
}
