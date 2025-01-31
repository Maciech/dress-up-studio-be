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
    private Long dressId;

    private String productCode;

    private String name;

    private double price;

    @OneToMany(cascade = CascadeType.ALL)
    List<DressAvailability> dressAvailability;

    @Enumerated(EnumType.STRING)
    private COLOR color;

    @Convert(converter = StringListConverter.class)
    private List<String> imageUrls;

}
