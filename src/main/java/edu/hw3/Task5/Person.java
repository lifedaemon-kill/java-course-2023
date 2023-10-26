package edu.hw3.Task5;

public final class Person {
    private final String firstName;
    private String lastName = null;

    public Person(String fullName) throws Exception {
        String[] splitName = fullName.split(" ");
        if (splitName.length != 1 && splitName.length != 2) {
            throw new Exception("Name \"" + fullName + "\" is wrong");
        }
        this.firstName = splitName[0];
        if (splitName.length == 2) {
            this.lastName = splitName[1];
        }
    }

    @Override
    public String toString() {
        if (lastName != null) {
            return firstName + " " + lastName;
        } else {
            return firstName;
        }
    }

    private String toReverseString() {
        if (lastName != null) {
            return lastName + firstName;
        } else {
            return firstName;
        }
    }

    public int compareTo(Person anotherPerson) {
        return this.toReverseString().compareTo(anotherPerson.toReverseString());
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) {
            return true;
        }
        if (another == null) {
            return false;
        }
        if (!(another instanceof Person obj)) {
            return false;
        }
        return this.toString().equals(obj.toString());
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
