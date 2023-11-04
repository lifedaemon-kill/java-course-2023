package edu.hw3;

import edu.hw3.Task5.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task5.ParseContactList.parseContacts;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task5ContactListTest {
    @Test
    @DisplayName("Корректные имена, сортировка по возрастанию")
    void test1() throws Exception {
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        Person[] expected = {
            new Person("Thomas Aquinas"),
            new Person("Rene Descartes"),
            new Person("David Hume"),
            new Person("John Locke")};

        Person[] sorted = parseContacts(names, "ABS");
        assertArrayEquals(expected, sorted);
    }

    @Test
    @DisplayName("Корректные имена, сортировка по убыванию")
    void test2() throws Exception {
        String[] arrayNames = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        Person[] expectedNames = {
            new Person("John Locke"),
            new Person("David Hume"),
            new Person("Rene Descartes"),
            new Person("Thomas Aquinas")

        };

        Person[] sorted = parseContacts(arrayNames, "DESC");
        assertThat(sorted).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("Корректные имена, второй пример, сортировка по убыванию")
    void test3() throws Exception {
        String[] arrayNames = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        Person[] expectedNames = {
            new Person("Carl Gauss"),
            new Person("Leonhard Euler"),
            new Person("Paul Erdos"),
        };

        Person[] sorted = parseContacts(arrayNames, "DESC");
        assertThat(sorted).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("Пустой список")
    void test4() throws Exception {
        String[] arrayNames = {};
        Person[] expectedNames = {};

        Person[] sorted = parseContacts(arrayNames, "DESC");
        assertThat(sorted).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("Вместо списка имен null")
    void test5() throws Exception {
        Person[] expectedNames = {};

        Person[] sorted = parseContacts(null, "DESC");
        assertThat(sorted).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("У части людей нет фамилий")
    void test6() throws Exception {
        String[] arrayNames = {"John", "Janette", "Linus Jackovich", "Wolf Jsonov"};
        Person[] expectedNames = {
            new Person("Linus Jackovich"),
            new Person("Janette"),
            new Person("John"),
            new Person("Wolf Jsonov"),
        };

        Person[] sorted = parseContacts(arrayNames, "ABS");
        assertThat(sorted).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("Есть пустые строки")
    void test7() throws Exception {
        String[] arrayNames = {"", "Janette", "", "Wolf Jsonov"};
        Person[] expectedNames = {
            new Person(""),
            new Person(""),
            new Person("Janette"),
            new Person("Wolf Jsonov"),
        };

        Person[] sorted = parseContacts(arrayNames, "ABS");
        assertThat(sorted).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("isEquals возвращает true если элементы равны")
    void testEqualsTrue() throws Exception {
        Person person1 = new Person("Java Dusk");
        Person person2 = new Person("Java Dusk");

        boolean equals = person1.equals(person2);

        assertThat(equals).isTrue();
    }

    @Test
    @DisplayName("isEquals возвращает false если элементы не равны")
    void testEqualsFalse() throws Exception {
        Person person1 = new Person("Java Dusk");
        Person person2 = new Person("Dusk Java");

        boolean equals = person1.equals(person2);

        assertThat(equals).isFalse();
    }

    @Test
    @DisplayName("compareTo возвращает 0 если экземпляры равны")
    void testCompareToZero() throws Exception {
        Person person1 = new Person("Java Dusk");
        Person person2 = new Person("Java Dusk");

        int compare = person1.compareTo(person2);

        assertThat(compare).isZero();
    }

    @Test
    @DisplayName("compareTo return negative if first less then second")
    void testCompareToNegative() throws Exception {
        Person person1 = new Person("a b");
        Person person2 = new Person("a c");

        int compare = person1.compareTo(person2);

        assertThat(compare).isNegative();
    }

    @Test
    @DisplayName("compareTo return positive if first greater then second")
    void testCompareToPositive() throws Exception {
        Person person1 = new Person("a d");
        Person person2 = new Person("c a");

        int compare = person1.compareTo(person2);

        assertThat(compare).isPositive();
    }

    @Test
    @DisplayName("compareTo return positive if first greater then second but first have only 1 word")
    void testCompareToPositiveHalfWord() throws Exception {
        Person person1 = new Person("b ");
        Person person2 = new Person("c a");

        int compare = person1.compareTo(person2);

        assertThat(compare).isPositive();
    }

}

