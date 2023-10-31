import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone: " + phone + "\nEmail: " + email + "\n";
    }
}

public class ContactManagement{
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cmg2 app = new Cmg2();
        app.run();
    }

    public void run() {
        while (true) {
            System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
            System.out.println(" Welcome to Contact Management System");
            System.out.println("1. Add a new contact");
            System.out.println("2. View contacts");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addContact() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);

        System.out.println("Contact added successfully!");
    }

    private void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println("Contact " + (i + 1) + ":\n" + contacts.get(i));
            }
        }
    }

    private void editContact() {
        viewContacts();

        System.out.print("Enter the index of the contact you want to edit (1-" + contacts.size() + "): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid index. Please try again.");
            return;
        }

        System.out.print("Enter the new name (leave empty to keep the current name): ");
        String name = scanner.nextLine();
        System.out.print("Enter the new phone number (leave empty to keep the current phone number): ");
        String phone = scanner.nextLine();
        System.out.print("Enter the new email address (leave empty to keep the current email address): ");
        String email = scanner.nextLine();

        Contact contact = contacts.get(index - 1);

        if (!name.isEmpty()) {
            contact.setName(name);
        }
        if (!phone.isEmpty()) {
            contact.setPhone(phone);
        }
        if (!email.isEmpty()) {
            contact.setEmail(email);
        }

        System.out.println("Contact updated successfully!");
    }

    private void deleteContact() {
        viewContacts();

        System.out.print("Enter the index of the contact you want to delete (1-" + contacts.size() + "): ");
        int index = scanner.nextInt();

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid index. Please try again.");
            return;
        }

        Contact deletedContact = contacts.remove(index - 1);
        System.out.println(deletedContact.getName() + " has been deleted.");
    }
}
