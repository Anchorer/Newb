package org.anchorer.newb.model;

import java.util.ArrayList;

/**
 * Model: Contact
 * Created by Anchorer on 16/4/27.
 */
public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String name, boolean online) {
        this.mName = name;
        this.mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> getContactsList(int num) {
        ArrayList<Contact> contactList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            contactList.add(new Contact("Contact: " + ++lastContactId, i <= lastContactId / 2));
        }
        return contactList;
    }

}
