package dev.yonkeu.App;

import dev.yonkeu.models.Player;
import dev.yonkeu.models.Team;
import dev.yonkeu.services.UserServices;

import java.util.Scanner;

public class UpdateLeaderboardView {
    private static Scanner scanner = new Scanner(System.in);
    private static UserServices userServices = new UserServices();
    static Boolean running = true;

    public static void display() {

        while (running) {
            System.out.println("1- Edit games played");
            System.out.println("2- Edit wins");
            System.out.println("3- Edit draws");
            System.out.println("4- Edit loses");
            System.out.println("5- Edit points");
            System.out.println("6- exit");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    //Edit team games played
                    scanner.nextLine();
                    System.out.println("Enter amount of games played ");
                    String gp = scanner.nextLine();
                    System.out.println("Enter Team name");
                    String tn = scanner.nextLine();
                    Team gamesPlayed = userServices.setGamePlayed(Integer.parseInt(gp), tn);
                    System.out.println("update Complete");
                    System.out.println(gamesPlayed);

                    break;
                }
                case 2: {
                    //Edit wins
                    scanner.nextLine();
                    System.out.println("Enter amount of wins ");
                    String w = scanner.nextLine();
                    System.out.println("Enter Team name");
                    String tn = scanner.nextLine();

                    Team wins = userServices.setWins(Integer.parseInt(w), tn);
                    System.out.println(wins);
                    System.out.println("update Complete");
                    break;
                }
                    case 3: {
                        //Edit draws
                        scanner.nextLine();
                        System.out.println("Enter amount of draws ");
                        String d = scanner.nextLine();
                        System.out.println("Enter Team name");
                        String ta = scanner.nextLine();

                        Team draws = userServices.setDraws(Integer.parseInt(d), ta);
                        System.out.println(draws);
                        break;
                    }
                    case 4: {
                        //Edit Loses
                        scanner.nextLine();
                        System.out.println("Enter amount of Loses ");
                        String l = scanner.nextLine();
                        System.out.println("Enter Team name");
                        String tl = scanner.nextLine();

                        Team draws = userServices.setLoses(Integer.parseInt(l), tl);
                        System.out.println(draws);
                        break;
                    }
                case 5: {
                    //Edit Points
                    scanner.nextLine();
                    System.out.println("Enter amount of Points ");
                    String po = scanner.nextLine();
                    System.out.println("Enter Team name");
                    String tp = scanner.nextLine();

                    Team points = userServices.setPoints(Integer.parseInt(po), tp);
                    System.out.println(points);
                    break;
                }
                case 6: {

                    running = false;
                }
                }

            }
        }
    }