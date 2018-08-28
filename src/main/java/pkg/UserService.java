package pkg;

import java.sql.SQLException;

public class UserService {

    private DBService dbService = new DBService();

    public String getSSN(String username) {
        try {
            return dbService.getUser(username).getSsn();
        } catch (SQLException e){
            return "";
        }
    }

}
