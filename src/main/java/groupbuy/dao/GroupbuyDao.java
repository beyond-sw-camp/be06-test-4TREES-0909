package groupbuy.dao;

import com.zaxxer.hikari.HikariDataSource;
import config.DataSourceConfig;
import groupbuy.dto.GroupbuyIdxDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GroupbuyDao {
    HikariDataSource dataSourceConfig;

    public GroupbuyDao() {
        dataSourceConfig = DataSourceConfig.getInstance();
    }

    public Boolean start(GroupbuyIdxDto dto){
        Connection connection = null;
        PreparedStatement pstmt = null;
        Integer result = null;
        try {
            connection = dataSourceConfig.getConnection();
            pstmt = connection.prepareStatement("UPDATE GROUP_BUY SET gpby_status=\"진행\", gpby_startdate=current_timestamp() where gpby_idx=?");
            pstmt.setInt(1, dto.getGpbyIdx());
            result = pstmt.executeUpdate();

            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlEx) { } // ignore
                pstmt = null;
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqlEx) { } // ignore
                connection = null;
            }
        }
        return false;
    }
}
