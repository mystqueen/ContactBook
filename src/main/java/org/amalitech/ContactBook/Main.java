package org.amalitech.ContactBook;

public class Main {
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


        contactBook.backupContact("file.ser");

        contactBook.restoreBackup("file.ser");
        System.out.println(contactBook);
        contactBook.searchForContact("Nana Ama or nama@gmail.com");


    }
}