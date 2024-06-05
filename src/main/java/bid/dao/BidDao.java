package bid.dao;

import bid.dto.BidDto;
import com.zaxxer.hikari.HikariDataSource;
import config.DataSourceConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BidDao {
    HikariDataSource dataSourceConfig;

    public BidDao() {
        dataSourceConfig = DataSourceConfig.getInstance();
    }

    public Boolean create(BidDto dto) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        Integer result = null;
        try {
            connection = dataSourceConfig.getConnection();
            pstmt = connection.prepareStatement("INSERT INTO test.BID (product_idx, gpby_idx, bid_price) VALUES (?, ?, ?)");
            pstmt.setInt(1, dto.getProductIdx());
            pstmt.setInt(2, dto.getGpbyIdx());
            pstmt.setInt(3, dto.getBidPrice());
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
