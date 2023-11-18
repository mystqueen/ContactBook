package org.amalitech;

import java.util.ArrayList;

public class ContactBook {
 private String name;
 private String email;
 ArrayList<Contact> contacts;

 public ContactBook(String name, String email){
     this.email=email;
     this.name=name;

     contacts = new ArrayList<>();
 }

  public boolean addContact(Contact contact){
     contacts.add(contact);
     return true;
  }


//  public boolean searchForContact(String contactName, String contactMail ){
//     for(Contact contact: contacts)
//         if(contact.getName() == contactName || contact.getEmail() == contactMail)
//             contacts.indexOf(contact);
//
//  }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
