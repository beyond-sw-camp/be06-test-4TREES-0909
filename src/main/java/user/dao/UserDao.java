//데이터베이스에 접속하게 해주는 파일

package user.dao;

import com.zaxxer.hikari.HikariDataSource;
import config.DataSourceConfig;
import user.dto.UserLoginDto;

import user.response.PostMemberLoginRes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  // 쿼리 실행하면 ResultSet타입으로 반환을 해주어 결과값을 저장
import java.sql.SQLException;

public class UserDao {
    HikariDataSource dataSourceConfig;

    public UserDao() {dataSourceConfig = DataSourceConfig.getInstance();
    }

    // 유저 로그인 DTO
    public boolean find(UserLoginDto dto) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = dataSourceConfig.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM USER WHERE user_email=? AND user_password=?");
            pstmt.setString(1, dto.getUserEmail());
            pstmt.setString(2, dto.getUserPassword());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
                //re = 셀렉 쿼리의 결과값들을 가지고 있는데(쿼리 결과값의 집합), next를 통해서 유저들을 조회
            }

            return false;
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

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }
        }
    }
}



