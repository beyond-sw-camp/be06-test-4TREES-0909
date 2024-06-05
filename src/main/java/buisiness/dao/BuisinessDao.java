package buisiness.dao;

import buisiness.dto.ComInfoRegiDto;
import com.zaxxer.hikari.HikariDataSource;
import config.DataSourceConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuisinessDao {
    HikariDataSource hikariDataSource;

    public BuisinessDao() {
        hikariDataSource = DataSourceConfig.getInstance();
    }

    public Boolean createAccount(ComInfoRegiDto dto){

        Connection connection = null;
        PreparedStatement pstmt;
        Integer res;
        try {
            connection = hikariDataSource.getConnection();
            pstmt = connection.prepareStatement("INSERT INTO COMPANY_INFO " +
                    "(com_info_name, com_info_address, com_info_type, com_info_intro, company_idx) values(?,?,?,?,?)");
            pstmt.setString(1, dto.getComInfoName());
            pstmt.setString(2, dto.getComInfoAddress());
            pstmt.setString(3, dto.getComInfoType());
            pstmt.setString(4, dto.getComInfoIntro());
            pstmt.setInt(5, dto.getCompanyIdx());
            res = pstmt.executeUpdate();
            System.out.println("res = " + res);
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (res == 1){
            return true;
        }else {
            return false;
        }
    }
}
