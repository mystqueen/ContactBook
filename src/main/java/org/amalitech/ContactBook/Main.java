package org.amalitech.ContactBook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) throws Exception {
        ContactBook contactBook = new ContactBook();
        String filename = "file.ser";

        try {
            contactBook.addContact(new Contact("Nana Ama", "nama@gmail.com"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            contactBook.addContact(new Contact("Ben Mensah", "bmsh@gmail.com"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            contactBook.addContact(new Contact("Nana Ama", "nama@gmail.com"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(contactBook);
            out.close();
            fileOut.close();
            System.out.println("Object serialized and saved in contactBook.txt");
        } catch (IOException i) {
            System.out.println("IOException is caught");
        }

        System.out.println(contactBook);
        contactBook.searchForContact("Nana Ama or nama@gmail.com");
    }
}