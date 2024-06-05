package config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceConfig {
    private static HikariDataSource dataSource;

    private DataSourceConfig() {

    }

    public static HikariDataSource getInstance() {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mariadb://192.168.25.119:3306/groupbuying");
            config.setUsername("kwh");
            config.setPassword("qwer1234");
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(5);
            dataSource = new HikariDataSource(config);
        }
        return dataSource;
    }
}