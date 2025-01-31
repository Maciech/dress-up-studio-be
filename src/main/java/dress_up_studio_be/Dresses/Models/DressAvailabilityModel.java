package dress_up_studio_be.Dresses.Models;

import dress_up_studio_be.Dresses.Enums.SIZE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DressAvailabilityModel {

    SIZE size;

    int dressesAvailable;

    int total;
}
