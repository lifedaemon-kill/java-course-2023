package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task5ContactList.Person;
import static edu.hw3.Task5ContactList.parseContacts;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task5ContactListTest {
    @Test
    @DisplayName("1 Тест с курсa")
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
    @DisplayName("1 Тест с курсa, обратный ход")
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
    @DisplayName("2 Тест с курсa")
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
    @DisplayName("3 Тест с курсa")
    void test4() throws Exception {
        String[] arrayNames = {};
        Person[] expectedNames = {};

        Person[] sorted = parseContacts(arrayNames, "DESC");
        assertThat(sorted).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("4 Тест с курсa")
    void test5() throws Exception {
        Person[] expectedNames = {};

        Person[] sorted = parseContacts(null, "DESC");
        assertThat(sorted).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("У части нет фамилий")
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
    @DisplayName("Функции")
    void test8() throws Exception {
        Person person1 = new Person("Java Dusk");
        Person person2 = new Person("Java Dusk");

        boolean equals = person1.equals(person2);
        assertThat(equals).isTrue();

        int compare = person1.compareTo(person2);
        assertThat(compare).isZero();

        person1 = new Person("a b");
        person2 = new Person("a c");
        compare = person1.compareTo(person2);
        assertThat(compare).isNegative();

        person1 = new Person("a d");
        person2 = new Person("c a");
        compare = person1.compareTo(person2);
        assertThat(compare).isPositive();

        person1 = new Person("b ");
        person2 = new Person("c a");
        compare = person1.compareTo(person2);
        assertThat(compare).isPositive();
    }
}
