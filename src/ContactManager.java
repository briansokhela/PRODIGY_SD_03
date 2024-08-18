import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private static final String FILE_NAME = "contacts.txt";
    private List<Contact> contacts;

    public ContactManager() {
        contacts = loadContacts();
    }

    public void addContact(String name, String phoneNumber, String email) {
        contacts.add(new Contact(name, phoneNumber, email));
        saveContacts();
        System.out.println("Contact added successfully!");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    public void editContact(int index, String newName, String newPhoneNumber, String newEmail) {
        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index);
            contact.setName(newName);
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmail(newEmail);
            saveContacts();
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Invalid contact index.");
        }
    }

    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            saveContacts();
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Invalid contact index.");
        }
    }

    private void saveContacts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : contacts) {
                writer.write(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    private List<Contact> loadContacts() {
        List<Contact> loadedContacts = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return loadedContacts;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] contactData = line.split(",");
                if (contactData.length == 3) {
                    loadedContacts.add(new Contact(contactData[0], contactData[1], contactData[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }

        return loadedContacts;
    }
}
