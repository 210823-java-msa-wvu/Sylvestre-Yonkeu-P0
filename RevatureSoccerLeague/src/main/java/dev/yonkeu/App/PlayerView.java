package dev.yonkeu.App;

import dev.yonkeu.models.Player;
import dev.yonkeu.models.Team;
import dev.yonkeu.models.User;
import dev.yonkeu.services.UserServices;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class PlayerView {
    private static Scanner scanner = new Scanner(System.in);
    private static UserServices userServices = new UserServices();
    static Boolean running = true;

    public static void display() {

        while (running) {
            System.out.println("1- View Teams");
            System.out.println("2- Edit your position");
            System.out.println("3- View League Standings");
            System.out.println("4- exit");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    //View teams
                    userServices.getAllTeam();
                    break;
                    }
                    case 2: {
                        scanner.nextLine();
                        System.out.println("Please enter your Prefered Position: ");
                        String pp = scanner.nextLine();
                        System.out.println("insert your Phone Number to confirm change");
                        String pn = scanner.nextLine();

                        userServices.updatePP(pp, Integer.parseInt(pn));
                        System.out.println("Update completed");

                        break;
                    }
                case 3: {
                    //view league standing
                    userServices.getLeaderboard();
                    break;
                }
                    case 4: {
                        running = false;
                    }
                    return;
                }
            }
        }

    }