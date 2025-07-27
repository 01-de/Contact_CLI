package org.de;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        while (true) {
            System.out.println("""
                    Select an action:
                    1 — Add contact
                    2 — Delete contact
                    3 — View all contacts
                    4 — Find contact by name
                    5 — View contacts by group
                    0 — Exit""");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" :
                    System.out.println();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter group: ");
                    String group = scanner.nextLine();

                    if (manager.addContact(new Contact(name, phone, email, group))) {
                        System.out.println("Contact added.");
                    } else {
                        System.out.println("Such contact already exist");
                    }
                    System.out.println();
                    break;

                case "2":
                    System.out.print("Enter the contact name to delete: ");
                    String nameToDelete = scanner.nextLine();
                    if (manager.removeContact(nameToDelete)) {
                        System.out.println("Contact founded");
                    } else {
                        System.out.println("Contact not founded");
                    }
                    System.out.println();
                    break;

                case "3":
                    manager.listContact();
                    System.out.println();
                    break;

                case "4":
                    System.out.println("Enter name to find: ");
                    String nameToFind = scanner.nextLine();
                    manager.searchContacts(nameToFind);
                    System.out.println();
                    break;

                case "5":
                    System.out.println("Enter group name to see: ");
                    String groupName = scanner.nextLine();
                    manager.listByGroup(groupName);
                    System.out.println();
                    break;

                case "0":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }

    }
}