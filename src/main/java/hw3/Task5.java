package hw3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Task5 {
    public static class Contact {
        private String firstName;
        private String lastName;

        public Contact(String fullName) {
            String[] names = fullName.split(" ");
            if (names.length > 1) {
                this.firstName = names[0];
                this.lastName = names[1];
            } else {
                this.firstName = names[0];
                this.lastName = names[0];
            }
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static List<Contact> parseContacts(String[] names, String sortOrder) {
        List<Contact> contacts = new ArrayList<>();

        if (names == null || names.length == 0) {
            return contacts;
        }

        for (String name : names) {
            contacts.add(new Contact(name));
        }

        if (sortOrder.equals("ASC")) {
            contacts.sort(Comparator.comparing(Contact::getLastName).thenComparing(Contact::getFirstName));
        } else if (sortOrder.equals("DESC")) {
            contacts.sort(Comparator.comparing(Contact::getLastName).reversed().thenComparing(Contact::getFirstName).reversed());
        }

        return contacts;
    }

    public static void main(String[] args) {
        System.out.println();

    }
}
