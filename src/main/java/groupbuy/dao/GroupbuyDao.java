package groupbuy.dao;

import com.zaxxer.hikari.HikariDataSource;
import config.DataSourceConfig;
import groupbuy.dto.GroupbuyDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupbuyDao {
    HikariDataSource dataSourceConfig;

    public GroupbuyDao() {
        dataSourceConfig = DataSourceConfig.getInstance();
    }

    public Integer regist(GroupbuyDto dto) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        Integer result = null;
        try {
            connection = dataSourceConfig.getConnection();
            pstmt = connection.prepareStatement(
                    "INSERT INTO GROUP_BUY " +
                            "(category_idx, user_idx, gpby_title, gpby_content,gpby_quantity, gpby_bid_enddate) " +
                            "VALUES (?, ?, ?,?,?,DATE_ADD(CURRENT_TIMESTAMP, INTERVAL ? DAY))", PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, dto.getCategoryIdx());
            pstmt.setInt(2, dto.getUserIdx());
            pstmt.setString(3, dto.getGpbyTitle());
            pstmt.setString(4, dto.getGpbyContent());
            pstmt.setInt(5, dto.getGpbyQuantity());
            pstmt.setInt(6, dto.getGpbyEnddate());
            result = pstmt.executeUpdate();

            if (result > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlEx) {
                } // ignore
                pstmt = null;
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqlEx) {
                } // ignore
                connection = null;
            }
        }
        return -1;
    }
}
