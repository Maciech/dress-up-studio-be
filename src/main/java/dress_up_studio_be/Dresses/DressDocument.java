package dress_up_studio_be.Dresses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "DRESSES")
public class DressDocument extends DefaultDatabaseFields {

    @Id
    private String id;
    private String name;
    private double price;
    private String size;
    private String color;
}
