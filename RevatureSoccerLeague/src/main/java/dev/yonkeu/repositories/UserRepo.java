package dev.yonkeu.repositories;

import dev.yonkeu.models.Player;
import dev.yonkeu.models.User;
import dev.yonkeu.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepo implements CrudRepo<User> {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();


    @Override
    public User add(User user) {
        String sql = "insert into users values (default, ?,?);";

        try (Connection conn = cu.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User(
                        rs.getString("username"),
                        rs.getString("password")
                );

                return u;
            }
        } catch (SQLException e) {
            System.out.println("Welcome New Player!\n Enter the following\n");
        }

        return user;
    }

    @Override
    public User getByPhoneNumber(Integer phoneNumber) {
        return null;
    }

    @Override
    public User getById(Integer users_id) {return null;}

    public User getByUsername(String username) {

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from users u left join player p on p.id = u.users_id where username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User(
                        rs.getInt("users_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("administrator")
                );

                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Player update(User user) {
        return null;
    }


    @Override
    public void delete(Integer id) {

    }

}
