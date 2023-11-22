package org.amalitech.ContactBook;

import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
public class ContactBook implements Serializable {
    Set<Contact> contacts;

    public ContactBook() {
        contacts = new HashSet<>();
    }

    public void addContact(Contact contact) throws Exception {
        System.out.println(contacts);
        System.out.println(contact);

        for (Contact exitingContact : contacts) {
            if (exitingContact.getName().equals(contact.getName()) && exitingContact.getEmail().equals(contact.getEmail()))
                throw new Exception("Contact: " + contact.getName() + " | " + contact.getEmail() + ", already exists");
        }

        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }


    public void searchForContact(String eitherNameOrMail) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(eitherNameOrMail) || contact.getEmail().equals(eitherNameOrMail))
                System.out.println("Name: " + contact.getName() + " Email: " + contact.getEmail());
        }
        System.out.println("No results");
    }

    public void backupContact() {
        //Serialization
        try (FileOutputStream fileOut = new FileOutputStream("file.ser")){
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(this);
            System.out.println("Contacts backup successful ");
        } catch (IOException i) {
            System.out.println(i.getMessage());
            // System.out.println("IOException is caught");
        }
    }




    public void restoreBackup() {
        //Deserialization
        try (FileInputStream fileIn = new FileInputStream("file.ser");){
            ObjectInputStream in = new ObjectInputStream(fileIn);

            ContactBook restoredContactBook = (ContactBook) in.readObject();
            System.out.println("Restored contact book\n " + restoredContactBook.toString());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "ContactBook{" + "contacts=" + contacts + '}';
    }
}
