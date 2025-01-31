package dress_up_studio_be.Dresses.Models;

import dress_up_studio_be.Dresses.Enums.COLOR;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DressModel {

    private String productCode;
    private String name;
    private double price;
    private List<DressAvailabilityModel> dressAvailability;
    private COLOR color;
    private List<String> imageUrls;
}
