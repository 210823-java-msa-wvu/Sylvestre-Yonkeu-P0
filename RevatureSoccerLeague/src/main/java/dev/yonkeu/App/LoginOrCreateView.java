package dev.yonkeu.App;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import dev.yonkeu.Exceptions.NonexistentException;
import dev.yonkeu.models.Player;
import dev.yonkeu.models.User;
import dev.yonkeu.repositories.PlayerRepo;
import dev.yonkeu.services.UserServices;

public class LoginOrCreateView {
    private static Scanner scanner = new Scanner(System.in);
    private static UserServices userServices = new UserServices();
    static Boolean running = true;

    public static void display(){


        while (running) {

            System.out.println("Welcome to the  Revature Soccer League!\n Select an Option below");
            System.out.println(" 1.Login\n 2.Create an account\n 3.quit");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    //Login service
                    scanner.nextLine();
                    System.out.println("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter Password: ");
                    String password = scanner.nextLine();

                    try {
                        User signInResponse = userServices.login(username, password);
                        if (signInResponse != null) {
                            if (signInResponse.isAdministrator()) {

                                System.out.println("Welcome Admin");
                                //call admin view
                                AdminView.display();

                            } else {
                                System.out.println("Welcome player");
                                //call player view
                                PlayerView.display();
                            }
                        } else {
                            System.out.println("Failed to login");
                        }
                    }
                    catch (NonexistentException e){
                        System.out.println("Incorrect Username or Password");
                    }
                    break;
                }


                case 2:
                    //Create an account
                    scanner.nextLine();
                    System.out.println("Insert a new Username: ");
                    String username = scanner.nextLine();
                    System.out.println("Insert a new Password: ");
                    String password = scanner.nextLine();
                    userServices.createUser(username, password);
                    System.out.println("Insert your First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Insert your Last name: ");
                    String lastName = scanner.nextLine();
                    System.out.println("insert a team Id");
                    Integer team_id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("What is your preferred foot: ");
                    String preferedFoot = scanner.nextLine();
                    System.out.println("What position do you prefer to play");
                    String preferedPosition = scanner.nextLine();
                    System.out.println("What is you phone number: ");
                    Integer phoneNumber = scanner.nextInt();

                    userServices.createPlayer(firstName, lastName, team_id, preferedFoot, preferedPosition, phoneNumber);
                    System.out.println("New Player created");


                    break;

                case 3:
                    System.out.println("See you later");
                    running = false;
                    break;
            }
        } return;
        }
    }
