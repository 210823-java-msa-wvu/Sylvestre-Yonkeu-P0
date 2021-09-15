package dev.yonkeu.repositories;

import dev.yonkeu.models.Player;
import dev.yonkeu.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepo implements CrudRepo<Player> {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Player add(Player player) {

        String sql = "insert into player values (default,?,?,?,?,?,?);";

        try (Connection conn = cu.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, player.getFirstName());
            ps.setString(2, player.getLastName());
            ps.setInt(3, player.getTeam_id());
            ps.setString(4, player.getPreferedFoot());
            ps.setString(5, player.getPreferedPosition());
            ps.setInt(6, player.getPhoneNumber());


            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Player p = new Player(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("team_id"),
                        rs.getString("prefered_foot"),
                        rs.getString("prefered_position"),
                        rs.getInt("phone_number"));
            }
        } catch (SQLException e) {
            System.out.println("Welcome New Player!\n Enter the following\n");
        }

        return null;
    }

    @Override
    public Player getById(Integer phoneNumber) {

        return null;
    }

    @Override
    public Player getByPhoneNumber(Integer phoneNumber) {
        try (Connection conn = cu.getConnection()){

            String sql = "select * from player where phone_number = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, phoneNumber);

            if (rs.next()) {
                Player p = new Player(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("prefered_foot"),
                        rs.getString("prefered_position"),
                        rs.getInt("phone_number"),
                        rs.getInt("team_id"));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Player> getAll() {

        List<Player> player = new ArrayList<>();
        try (Connection conn = cu.getConnection()) {
            String sql = "select * from player";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Player p = new Player(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("prefered_foot"),
                    rs.getString("prefered_position"),
                    rs.getInt("phone_number"),
                    rs.getInt("team_id"));
            player.add(p);
        }
        return player;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Player update(Player player) {
        return null;
    }


    public Player updatePP(String player, Integer phone) {
        String sql = "update player set prefered_position =? where phone_number = ?";
        try (Connection conn = cu.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, player);
            ps.setInt(2, phone);
            boolean rs = ps.execute();
//            if (rs.next()) {
//                Player p = new Player(
//                        rs.getString("prefered_position"),
//                        rs.getInt("phone_number")
//                      );
//
//            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        }


    @Override
    public void delete(Integer id) {
    }


}
