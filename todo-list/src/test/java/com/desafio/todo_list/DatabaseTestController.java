package com.desafio.todo_list;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/dbtest")
public class DatabaseTestController {
    private final DataSource dataSource;

    public DatabaseTestController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping
    public String testDatabase() {
        try (Connection conn = dataSource.getConnection()) {
            return "Database connected successfully: " + conn.getCatalog();
        } catch (SQLException e) {
            return "Database connection failed: " + e.getMessage();
        }
    }
}

