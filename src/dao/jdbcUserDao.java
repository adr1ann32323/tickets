package dao;

import config.DbConfig;
import domain.User;

import java.sql.*;
import java.util.ArrayList;

public class jdbcUserDao implements userDao {
    @Override
    public User create(User user) throws SQLException {
        String sql = "INSERT INTO user (name, email, rol) VALUES (?, ?, ?)";
        try (Connection c = DbConfig.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getRol());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                    return user;
                }
            }
        }
        throw new SQLException("No se pudo crear usuario");
    }
    @Override
    public User findById(int id)  throws SQLException {
        String sql = "SELECT id,name,email,rol FROM user WHERE id = ?";
        try (Connection c = DbConfig.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) return new User(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("rol"));
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> listAll()  throws SQLException {
        ArrayList<User> listUsers = new ArrayList<>();
        String sql = "SELECT id,name,email,rol FROM user";
        try (Connection c = DbConfig.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                listUsers.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("rol")));
            }
        }
        return listUsers;
    }
}
