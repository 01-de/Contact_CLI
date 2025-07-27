package org.de;

import java.util.Objects;


public class Contact {
    private String name;
    private String phone;
    private String email;
    private String group;

    public Contact(String name, String phone, String email, String group) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact other = (Contact) obj;
        return (name != null ? name.equals(other.name) : other.name == null) &&
                (phone != null ? phone.equals(other.phone) : other.name == null) &&
                (email != null ? email.equals(other.email) : other.email == null) &&
                (group != null ? group.equals(other.group) : other.group == null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, email, group);
    }

    @Override
    public String toString() {
        return "Contact {name='" +name+ "', phone='" +phone+ "', email='" +email+ "', group='" +group+ "'}";
    }
}
