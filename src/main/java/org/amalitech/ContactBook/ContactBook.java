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
                throw new Exception("Contact: " + contact.getName() + " " + contact.getEmail() + " already exists");
        }

        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }


    public String searchForContact(String nameOrMail) {
        for (Contact contact : contacts)
            if (Objects.equals(contact.getName(), nameOrMail) || Objects.equals(contact.getEmail(), nameOrMail)) {
                System.out.println(contact);
            }
        System.out.println(-1);
        return null;
    }

    public void backupContact(String fileName) {
        //Serialization
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(out);
            out.close();
            fileOut.close();
        } catch (
                IOException i) {
            System.out.println("Object serialized and saved in contactBook.txt");
            System.out.println("IOException is caught");
        }
    }


    Contact contactBook2 = null;

    public void restoreBackup(String fileName) throws IOException, ClassNotFoundException {
        //Deserialization
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(fileIn);

        contactBook2 = (Contact) in.readObject();

        in.close();
        fileIn.close();
        System.out.println("Object has been deserialized ");
        System.out.println("a = " + contactBook2.getName());
        System.out.println("b = " + contactBook2.getEmail());
//        System.out.println("IOException is caught");
//        System.out.println("ClassNotFoundException is caught");

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
