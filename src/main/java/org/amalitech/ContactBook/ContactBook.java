package org.amalitech.ContactBook;

import java.io.Serializable;
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
