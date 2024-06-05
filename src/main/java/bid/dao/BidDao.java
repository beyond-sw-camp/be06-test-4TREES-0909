package bid.dao;

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

    public Boolean delete(int bidIdx) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        Integer result = null;
        try {
            connection = dataSourceConfig.getConnection();
            pstmt = connection.prepareStatement("UPDATE test.BID SET bid_status='취소', bid_deldate=now() WHERE bid_idx=(?) AND bid_status='등록'");
            pstmt.setInt(1, bidIdx);
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
