package groupbuy.dao;

import com.zaxxer.hikari.HikariDataSource;
import config.DataSourceConfig;
import groupbuy.dto.GroupbuyDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupbuyDao {
    HikariDataSource dataSourceConfig;

    public GroupbuyDao() {
        dataSourceConfig = DataSourceConfig.getInstance();
    }

    public List<GroupbuyDto> listAll() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        List<GroupbuyDto> groupbuyDtos = null;
        try {
            connection = dataSourceConfig.getConnection();
            pstmt = connection.prepareStatement("SELECT gpby_idx, gpby_title, gpby_quantity from GROUP_BUY ");
            result = pstmt.executeQuery();
            groupbuyDtos = new ArrayList<>();
            while (result.next()) {
                groupbuyDtos.add(new GroupbuyDto(result.getInt("gpby_idx"), result.getString("gpby_title"), result.getInt("gpby_quantity")));
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
        return groupbuyDtos;
    }
}
