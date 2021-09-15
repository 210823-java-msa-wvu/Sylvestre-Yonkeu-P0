package dev.yonkeu.App;

import dev.yonkeu.models.Player;
import dev.yonkeu.models.Team;
import dev.yonkeu.services.UserServices;

import java.util.Scanner;

public class AdminView {
    private static Scanner scanner = new Scanner(System.in);
    private static UserServices userServices = new UserServices();
    static Boolean running = true;

    public static void display() {

        while (running) {
            System.out.println("1- View player info");
            System.out.println("2- view teams");
            System.out.println("3- Edit teams");
            System.out.println("4- View League Standings");
            System.out.println("5- exit");

            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    //select all from players
                    System.out.println("list of all players");
                    userServices.getAll();
                    break;
                }
                case 2: {
                    //View teams
                    userServices.getAllTeam();
                    break;
                }

                case 3: {
                    //edit teams
                    UpdateTeamView.display();
                    break;
                }
                case 4: {
                    //view league standing
                    userServices.getLeaderboard();
                    break;
                }
                case 5:{
                    running = false;
                    break;
                }
            }
        }
    }

}
