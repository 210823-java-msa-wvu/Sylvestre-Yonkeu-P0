package dev.yonkeu.services;

import dev.yonkeu.Exceptions.NonexistentException;
import dev.yonkeu.models.Player;
import dev.yonkeu.models.Team;
import dev.yonkeu.models.User;
import dev.yonkeu.repositories.PlayerRepo;
import dev.yonkeu.repositories.TeamRepo;
import dev.yonkeu.repositories.UserRepo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServices {
    public static UserRepo userRepo = new UserRepo();
    public static PlayerRepo playerRepo = new PlayerRepo();
    public static TeamRepo teamRepo = new TeamRepo();

    public User login(String username, String password) throws NonexistentException {

        // in order to log in a user, we will need username and password
        User u = userRepo.getByUsername(username);

        // check to make sure User object is not null
        if (u == null) {
            throw new NonexistentException();
            // now check to make sure it matches
        }
        if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {

            return u;
        }

        return u;
    }


    public boolean createUser(String username, String password) {

        User u = userRepo.getByUsername(username);
        User add = new User(username, password);
        if (u == null) {
            userRepo.add(add);
            return true;
        } else {
            System.out.println("You already have an account");
            return false;
        }
    }

    public boolean createPlayer(String firstName, String lastName, Integer team_id, String preferedFoot, String preferedPosition, Integer phoneNumber) {

        Player add = new Player(firstName, lastName, team_id, preferedFoot, preferedPosition, phoneNumber);
        playerRepo.add(add);
        return true;
    }
    public boolean createTeam(String teamName, Integer gamesPlayed, Integer wins, Integer draws, Integer loses, Integer points){
        Team add = new Team(teamName, gamesPlayed, wins, draws, loses, points);
        teamRepo.add(add);
        return true;
    }
    public Player player(Integer p) {
        playerRepo.getByPhoneNumber(p);
        return null;
    }

    public static Player updatePP(String pp, Integer p) {
        Player up = new Player(pp, p);
        up = playerRepo.updatePP(pp, p);
        return up;
    }

    public static void getAll() {
        List<Player> player = playerRepo.getAll();
        for (Player playerRepo : player) {
            System.out.println(playerRepo);
        }
    }
    public static  void getAllTeam(){
        List<Team> team = teamRepo.getAllTeam();
        for (Team teamRepo : team) {
            System.out.println(teamRepo);
        }
    }

    public static void getLeaderboard() {
        List<Team> team = teamRepo.getleaderboard();
        for (Team teamRepo : team) {
            System.out.println(teamRepo);
        }
    }
    public Team setGamePlayed(int gp, String tm){
        Team games = new Team(gp,tm);
        teamRepo.updateGame(games);
        return games;
    }

    public Team setWins(int w, String tm) {
        Team wins = new Team(w, tm);
        teamRepo.updateWins(wins);
        return wins;
    }
    public Team setDraws(int d, String tm) {
        Team draws = new Team(d, tm);
        teamRepo.updateDraws(draws);
        return draws;
    }
    public Team setLoses(int l, String tm) {
        Team loses = new Team(l, tm);
        teamRepo.updateLoses(loses);
        return loses;
    }
    public Team setPoints(int po, String tm) {
        Team points = new Team(po, tm);
        teamRepo.updatePoints(points);
        return points;
    }

    public void setTeamName(String on, String nm) {
        teamRepo.updateTeamName(on, nm);
    }

    public void deleteTeam(String teamName){
        Team deleteTeam = new Team(teamName);
        teamRepo.delete(teamName);
    }




    }

