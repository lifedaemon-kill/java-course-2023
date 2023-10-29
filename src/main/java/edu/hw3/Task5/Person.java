package edu.hw3.Task5;

public final class Person {
    private final String firstName;
    private String lastName;

    public Person(String fullName) throws Exception {
        String[] splitName = fullName.split(" ");

        switch (splitName.length) {
            case 2:
                this.lastName = splitName[1];
            case 1:
                this.firstName = splitName[0];
                break;
            default:
                throw new Exception("Name \"" + fullName + "\" is wrong");
        }
    }

    @Override
    public String toString() {
        return toString(false);
    }

    public String toReverseString() {
        return toString(true);
    }

    private String toString(boolean reverse) {
        return (lastName == null) ? firstName : (reverse) ? lastName + " " + firstName : firstName + " " + lastName;
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
