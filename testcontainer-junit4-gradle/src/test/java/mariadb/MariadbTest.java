package mariadb;

import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.MariaDBContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariadbTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Rule
    public MariaDBContainer mariaDB = new MariaDBContainer();

    @Test
    public void connect() {
        logger.info("host: {}", mariaDB.getHost());
        logger.info("port: {}", mariaDB.getMappedPort(3306));
        logger.info("username: {}", mariaDB.getUsername());
        logger.info("password: {}", mariaDB.getPassword());
        logger.info("jdbc url: {}", mariaDB.getJdbcUrl());
        try (Connection conn = DriverManager.getConnection(mariaDB.getJdbcUrl(), mariaDB.getUsername(), mariaDB.getPassword())) {
            logger.info("got connection");
            Thread.sleep(30 * 1000);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
        }
    }

}
