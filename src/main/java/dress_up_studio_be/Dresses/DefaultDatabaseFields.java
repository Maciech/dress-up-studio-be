package dress_up_studio_be.Dresses;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class DefaultDatabaseFields {
    String addedBy;
    String modifiedBy;
    Date dateAdded;
    Date dateModified;
}
