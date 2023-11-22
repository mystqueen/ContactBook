package org.amalitech.ContactBook;

public class Main {
    public static void main(String[] args) throws Exception {
        ContactBook contactBook = new ContactBook();
        String contactBackup = "file.ser";

        try {
            contactBook.addContact(new Contact("Nana Ama", "nama@gmail.com"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Contact contact1 = new Contact("Ben Mensah", "bmsh@gmail.com");
        try {
            contactBook.addContact(contact1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            contactBook.addContact(new Contact("Agness Blankson", "agnessb@gmail.com"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try {
            contactBook.addContact(new Contact("Nana Ama", "nama@gmail.com"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        contactBook.searchForContact("Nana Ama");

        contactBook.backupContact();

        contactBook.restoreBackup();
//        System.out.println(contactBook);



    }
}