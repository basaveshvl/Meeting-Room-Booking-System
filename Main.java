package Assignment1;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RoomManager roomManager = new RoomManager();
        BookingManager bookingManager = new BookingManager();
        ConflictResolver conflictResolver = new ConflictResolver(bookingManager);
        UserInterface userInterface = new UserInterface(roomManager, bookingManager, conflictResolver);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as User");
            System.out.println("3. Register");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    if (userInterface.isAdmin()) {
                        System.out.println("You are already logged in as Admin.");
                    } else {
                        userInterface.loginAsAdmin();
                        if (userInterface.isAdmin()) {
                            adminMenu(userInterface, scanner);
                        }
                    }
                    break;
                case 2:
                    if (userInterface.isUserLoggedIn()) {
                        userMenu(userInterface, scanner);
                    } else {
                        userInterface.loginAsUser();
                        if (userInterface.isUserLoggedIn()) {
                            userMenu(userInterface, scanner);
                        }
                    }
                    break;
                case 3:
                    userInterface.register();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    private static void adminMenu(UserInterface userInterface, Scanner scanner) {
        boolean adminLoggedIn = true;
        while (adminLoggedIn) {
            System.out.println("\n1. Add Rooms");
            System.out.println("2. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    userInterface.addRooms();
                    break;
                case 2:
                    System.out.println("Logging out...");
                    userInterface.logout();
                    adminLoggedIn = false;
                    break;
                
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    private static void userMenu(UserInterface userInterface, Scanner scanner) {
        boolean userLoggedIn = true;
        while (userLoggedIn) {
            System.out.println("\n1. Display Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Logout");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    userInterface.displayAvailableRooms(new Date(), new Date());
                    break;
                case 2:
                    userInterface.iterativeBooking();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    userInterface.logout();
                    userLoggedIn = false;
                    break;
              
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
}
