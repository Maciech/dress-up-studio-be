package dress_up_studio_be.Dresses.Models;

import dress_up_studio_be.Dresses.Enums.COLOR;
import dress_up_studio_be.Dresses.Enums.SIZE;
import dress_up_studio_be.Utils.DefaultDatabaseFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "DRESSES")
public class DressDocument extends DefaultDatabaseFields {

    @Id
    private String id;
    private String name;
    private double price;
    private List<SIZE> size;
    private List<COLOR> color;
    private String imageUrl;
}
