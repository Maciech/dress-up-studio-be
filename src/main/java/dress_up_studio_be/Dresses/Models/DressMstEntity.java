package dress_up_studio_be.Dresses.Models;

import dress_up_studio_be.Dresses.Enums.COLOR;
import dress_up_studio_be.Utils.DefaultDatabaseFields;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DRESS_MST")
public class DressMstEntity extends DefaultDatabaseFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DRESS_ID")
    private String dressId;

    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "DRESS_NAME")
    private String name;

    @Column(name = "PRICE")
    private double price;

    @Lob
    @Column(name = "DRESS_AVAILABILITY", columnDefinition = "TEXT")
    @Convert(converter = DressAvailabilityConverter.class)
    private List<DressAvailability> dressAvailability;

    @Column(name = "COLOR")
    @Enumerated(EnumType.STRING)
    private COLOR color;

    @Column(name = "IMAGE_URLS")
    @Convert(converter = StringListConverter.class)
    private List<String> imageUrls;

}
