package org.de;

import java.util.*;

public class Manager {
    List<Contact> arrayList = new ArrayList<>();
    Set<Contact> hashSet = new HashSet<>();
    Map<String, List<Contact>> hashMap = new HashMap<>();

    public boolean addContact(Contact contact) {
        if (hashSet.contains(contact)) {
            return false;
        }
        arrayList.add(contact);
        hashSet.add(contact);
        String group = contact.getGroup();
        if (!hashMap.containsKey(group)) {
            hashMap.put(group, new ArrayList<Contact>());
        }
        hashMap.get(group).add(contact);
        return true;
    }

    public boolean removeContact(String name) {
        Iterator<Contact> iterator = arrayList.iterator();

        boolean removed = false;

        while (iterator.hasNext()) {
            Contact c = iterator.next();
            if (c.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                hashSet.remove(c);
                hashMap.get(c.getGroup()).remove(c);
                removed = true;
            }
        }
        return removed;
    }

    public void listContact() {
        Iterator<Contact> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void searchContacts(String name) {
        boolean found = false;

        for (Contact c : arrayList) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not founded.");
        }
    }

    public void listByGroup(String group) {
        List<Contact> contacts = hashMap.get(group);
        if (contacts == null || contacts.isEmpty()) {
            System.out.println("Group is empty or not exist");
            return;
        }
        System.out.println("List of " + group + " :");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}
