package database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {

    @Test
    void getConnection() {
        Connection first = Connection.getConnection();
        Connection second = Connection.getConnection();
        assert first == second;
    }
}