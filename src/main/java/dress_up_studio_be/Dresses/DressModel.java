package dress_up_studio_be.Dresses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DressModel {

    private String name;
    private double price;
    private String size;
    private String color;
}
