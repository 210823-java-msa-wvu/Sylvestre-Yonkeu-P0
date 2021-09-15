package dev.yonkeu.repositories;

import dev.yonkeu.models.Player;
import dev.yonkeu.models.Team;
import dev.yonkeu.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamRepo implements CrudRepo<Team> {
    //Insert Logger declaration here
    private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    //Read
    @Override
    public Team getById(Integer id) {

        try (Connection conn = cu.getConnection()) {
            String sql = "select * from team where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Team a = new Team();
                a.setId(rs.getInt("id"));
                a.setTeamName(rs.getString("team_name"));

                return a;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Team getByPhoneNumber(Integer phoneNumber) {
        return null;
    }

    @Override
    public List<Team> getAll() {
        return null;
    }

    public List<Team> getAllTeam() {

        List<Team> team = new ArrayList<>();
        try (Connection conn = cu.getConnection()) {

            String sql = "select * from team";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Team a = new Team(
                        rs.getInt("id"),
                        rs.getString("team_name"),
                        rs.getInt("games_played"),
                        rs.getInt("wins"),
                        rs.getInt("draws"),
                        rs.getInt("loses"),
                        rs.getInt("points"));
                team.add(a);
            }
            return team;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Player update(Team team) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    public List<Team> getleaderboard() {

        List<Team> team = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {
            String sql = "select * from team order by points desc;\n";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Team a = new Team(
                        rs.getInt("id"),
                        rs.getString("team_name"),
                        rs.getInt("games_played"),
                        rs.getInt("wins"),
                        rs.getInt("draws"),
                        rs.getInt("loses"),
                        rs.getInt("points")
                );
                team.add(a);
            }
            return team;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //create
    public Team add(Team team) {
        try (Connection conn = cu.getConnection()) {

            String sql = "insert into team values (default, ?,?,?,?,?,?) returning *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, team.getTeamName());
            ps.setInt(2, team.getGamesPlayed());
            ps.setInt(3, team.getWins());
            ps.setInt(4, team.getDraws());
            ps.setInt(5, team.getLoses());
            ps.setInt(6, team.getPoints());


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                team.setId(rs.getInt("id"));
                return team;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //Update

    public Team updateGame(Team a) {
        try (Connection conn = cu.getConnection()) {

            String sql = "update team set games_played = ? where team_name = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, a.getGamesPlayed());
            ps.setString(2, a.getTeamName());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                a.setGamesPlayed(rs.getInt("games_played"));
                a.setTeamName(rs.getString("team_name"));
                return a;
            }

        } catch (SQLException e) {
            System.out.println("Done");
        }
        return null;
    }

    public Team updateWins(Team b) {
        try (Connection conn = cu.getConnection()) {

            String sql = "update team set wins = ? where team_name = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, b.getWins());
            ps.setString(2, b.getTeamName());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                b.setWins(rs.getInt("wins"));
                b.setTeamName(rs.getString("team_name"));
                return b;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Team updateDraws(Team b) {
        try (Connection conn = cu.getConnection()) {

            String sql = "update team set draws = ? where team_name = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, b.getDraws());
            ps.setString(2, b.getTeamName());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                b.setWins(rs.getInt("draws"));
                b.setTeamName(rs.getString("team_name"));
                return b;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Team updateLoses(Team b) {
        try (Connection conn = cu.getConnection()) {

            String sql = "update team set loses = ? where team_name = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, b.getLoses());
            ps.setString(2, b.getTeamName());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                b.setWins(rs.getInt("loses"));
                b.setTeamName(rs.getString("team_name"));
                return b;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Team updatePoints(Team b) {
        try (Connection conn = cu.getConnection()) {

            String sql = "update team set points = ? where team_name = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, b.getPoints());
            ps.setString(2, b.getTeamName());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                b.setWins(rs.getInt("points"));
                b.setTeamName(rs.getString("team_name"));
                return b;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateTeamName(String oldName, String newName) {
        try (Connection conn = cu.getConnection()) {

            String sql = "update team set team_name = ? where team_name = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newName);
            ps.setString(2, oldName);

            ps.executeUpdate();
            System.out.println("Update Completed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Delete

    public void delete(String teamName) {
        try (Connection conn = cu.getConnection()) {

            String sql = "delete from team where team_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, teamName);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

