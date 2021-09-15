package dev.yonkeu.App;

import dev.yonkeu.models.Team;
import dev.yonkeu.services.UserServices;

import java.util.Scanner;

public class UpdateTeamView {
    private static Scanner scanner = new Scanner(System.in);
    private static UserServices userServices = new UserServices();
    static Boolean running = true;

    public static void display() {

        while (running) {
            System.out.println("1- Edit Team Name");
            System.out.println("2- Create a Team");
            System.out.println("3- Delete a Team");
            System.out.println("4- exit");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    //Edit team name
                    scanner.nextLine();
                    System.out.println("Enter old Team name ");
                    String ot = scanner.nextLine();
                    System.out.println("Enter new Team name");
                    String nt = scanner.nextLine();

                    userServices.setTeamName(ot,nt);
                    break;
                }
                case 2: {
                    //Create a team
                    scanner.nextLine();
                    System.out.println("Enter Team name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter games played: ");
                    Integer gamesPlayed = scanner.nextInt();
                    System.out.println("Enter number of wins: ");
                    Integer wins = scanner.nextInt();
                    System.out.println("Enter number of draws: ");
                    Integer draws = scanner.nextInt();
                    System.out.println("Enter number of loses: ");
                    Integer loses = scanner.nextInt();
                    System.out.println("Enter number of points");
                    Integer points = scanner.nextInt();
                    boolean createTeam = userServices.createTeam(name, gamesPlayed, wins, draws, loses, points);
                    System.out.println("New team created");
                    System.out.println(createTeam);
                    break;
                }
                case 3: {
                //Delete a team
                    scanner.nextLine();
                    System.out.println("Enter Team you wish to delete: ");
                    String del = scanner.nextLine();

                    userServices.deleteTeam(del);
                    System.out.println("Team successfully Deleted");
                    break;
                }
                case 4: {
                    //exit
                    running = false;
                }
            }
        }
    }
}