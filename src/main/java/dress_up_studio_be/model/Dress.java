package dress_up_studio_be.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "DRESSES")
@Builder
public class Dress {

    @Id
    private String id;
    private String name;
    private double price;
    private String size;
    private String color;
}
