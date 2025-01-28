package dress_up_studio_be.Utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultDatabaseFields {
    Boolean isActive;
    String addedBy;
    String modifiedBy;
    Date dateAdded;
    Date dateModified;
}
