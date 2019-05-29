package ru.geekbrains.server.persistance;

import ru.geekbrains.server.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final Connection conn;

    public UserRepository(Connection conn) throws SQLException {
        this.conn = conn;
        try (Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                    + "	id int auto_increment primary key,\n"
                    + "	login varchar(25) NOT NULL UNIQUE,\n"
                    + "	password varchar(25)\n"
                    + ");";

            stmt.execute(sql);
        }
        if ( getAllUsers().size() == 0 ) {
            insert(new User(-1, "ivan", "123"));
            insert(new User(-1, "petr", "123"));
            insert(new User(-1, "julia", "789"));
        }
    }

    public void insert(User user) {
        String sql = "INSERT INTO users(login,password) VALUES(?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public User findByLogin(String login) throws SQLException {
        String sql = "SELECT id, login, password FROM users where login like ?";
        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,login);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User (rs.getInt("id"),
                                rs.getString("login"),
                                rs.getString("password")
                );
            }
        }
        return new User(-1, "", "");
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT id, login, password FROM users";
        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                userList.add(new User(rs.getInt("id"),
                                      rs.getString("login"),
                                      rs.getString("password")
                                     )
                );
            }
        return userList;
        }
    }
}
