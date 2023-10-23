package edu.hw3;

final class Task5ContactList {
    private Task5ContactList() {
    }

    private static int parseInit(String sortOrder) throws Exception {
        if (sortOrder.equals("DESC")) {
            return -1;
        } else if (sortOrder.equals("ABS")) {
            return 1;
        } else {
            throw new Exception("The sorting type is incorrect");
        }
    }

    public static Person[] parseContacts(String[] names, String sortOrder) throws Exception {
        int orderType = parseInit(sortOrder);
        if (names == null) {
            return new Person[0];
        }
        Person[] sortArr = new Person[names.length];
        for (int i = 0; i < names.length; i++) {
            sortArr[i] = new Person(names[i]);
        }

        for (int i = 0; i < sortArr.length; i++) {
            int pos = i;
            Person prime = sortArr[i];
            //цикл выбора наименьшего элемента
            for (int j = i + 1; j < sortArr.length; j++) {
                if (sortArr[j].compareTo(prime) * orderType < 0) {
                    //pos - индекс наименьшего элемента
                    pos = j;
                    prime = sortArr[j];
                }
            }
            sortArr[pos] = sortArr[i];
            //меняем местами наименьший с sortArr[i]
            sortArr[i] = prime;
        }
        return sortArr;
    }

    public static final class Person {
        private final String firstName;
        private  String lastName = null;

        Person(String fullName) throws Exception {
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
}
