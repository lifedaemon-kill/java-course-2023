package edu.hw3.Task5;

public final class ParseContactList {
    private ParseContactList() {
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
}
