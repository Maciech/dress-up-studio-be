package dress_up_studio_be.Dresses;

import java.sql.Date;

public class DressUtils {

    public static Date getCurrentSqlTime() {
        return new Date(System.currentTimeMillis());
    }

    public static String getUserName() {
        return "XXXXX";
    }
}
