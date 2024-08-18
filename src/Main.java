import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add a new contact
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    contactManager.addContact(name, phoneNumber, email);
                    break;

                case 2:
                    contactManager.viewContacts();
                    break;

                case 3:
                    contactManager.viewContacts();
                    System.out.print("Enter the contact number to edit: ");
                    int editIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); 
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    contactManager.editContact(editIndex, newName, newPhoneNumber, newEmail);
                    break;

                case 4:
                    contactManager.viewContacts();
                    System.out.print("Enter the contact number to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    contactManager.deleteContact(deleteIndex);
                    break;

                case 5:
                    System.out.println("Exiting Contact Management System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
//            System.out.flush();
        } while (choice != 5);

        scanner.close();
    }
}
