package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    MariaDbDataSource dataSource;

    public PeopleDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        String result = "";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("select ip_address from people where first_name=? and last_name=?")
                ) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);

            return getResult(result, ps);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect");
        }
    }

    private String getResult(String result, PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                result = rs.getString("ip_address");
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot query");
        }
    }
}
