package dress_up_studio_be.Utils;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultDatabaseFields {

    @Column(name = "IS_ACTIVE")
    Boolean isActive;
    @Column(name = "CREATED_BY")
    String addedBy;
    @Column(name = "CREATION_DATE")
    String modifiedBy;
    @Column(name = "LAST_UPDATED_BY")
    Date dateAdded;
    @Column(name = "LAST_UPDATED_DATE")
    Date dateModified;
}
