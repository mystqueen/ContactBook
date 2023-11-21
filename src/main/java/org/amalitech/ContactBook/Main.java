package org.amalitech.ContactBook;

import java.io.*;

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

        //Serialization
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(contactBook);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            System.out.println("Object serialized and saved in contactBook.txt");
            System.out.println("IOException is caught");
        }


        //Deserialization
        Contact contactBook2 = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            contactBook2 = (Contact).in.readObject();

            in.close();
            fileIn.close();
            System.out.println("Object has been deserialized ");
            System.out.println("a = " + contactBook2.getName());
            System.out.println("b = " + contactBook2.getEmail());
        } catch (IOException e) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException is caught");
        }

        System.out.println(contactBook);
        contactBook.searchForContact("Nana Ama or nama@gmail.com");


    }
}