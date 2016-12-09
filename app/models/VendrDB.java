package models;

import play.db.*;
import java.sql.*;
import javax.sql.*;
import java.util.ArrayList;

public class VendrDB {

    public static ArrayList<String> getAllUserNames() throws SQLException {
        return getAllNames("users");
    }

    public static ArrayList<String> getAllNames(String table) throws SQLException {
        assert table.equals("users");
        Connection connection = null;
        ArrayList<String> names = new ArrayList<String>();
        try {
            connection = DB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement
                    .executeQuery("SELECT * FROM " + table);
            while (rs.next()) {
                String name = rs.getString(1);
                names.add(name);
            }
            rs.close();
            statement.close();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (Exception e) {
                }
            }
        }
        return names;
    }
}
