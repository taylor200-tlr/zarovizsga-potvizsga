package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        String result;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?");
        ) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            result = getIpAddress(stmt);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
        return result;
    }

    private String getIpAddress(PreparedStatement stmt) {
        String result = "";
        try (ResultSet resultSet = stmt.executeQuery()) {
            if (resultSet.next()) {
                result = resultSet.getString("ip_address");
            }
        } catch (SQLException sqe) {
            throw new IllegalStateException("Can not found any IP", sqe);
        }
        return result;
    }
}
