package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3InsertedArrayTest {
    @Test
    @DisplayName("Два пустых массива")
    void test1() {
        // given
        int[] arr1 = {};
        int[] arr2 = {};
        // when
        boolean answer = Task3InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isFalse();
    }
    @Test
    @DisplayName("Первый пустой массив")
    void test2() {
        // given
        int[] arr1 = {};
        int[] arr2 = {2, 3, 4};
        // when
        boolean answer = Task3InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isFalse();
    }
    @Test
    @DisplayName("Массив является вложенным")
    void test3() {
        // given
        int[] arr1 = {3, 4};
        int[] arr2 = {2, 5, 7};
        // when
        boolean answer = Task3InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isTrue();
    }
    @Test
    @DisplayName("Min совпадает")
    void test4() {
        // given
        int[] arr1 = {2, 4};
        int[] arr2 = {2, 5, 7};
        // when
        boolean answer = Task3InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isFalse();
    }
    @Test
    @DisplayName("Max совпадает")
    void test5() {
        // given
        int[] arr1 = {3, 7};
        int[] arr2 = {2, 5, 7};
        // when
        boolean answer = Task3InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isFalse();
    }
    @Test
    @DisplayName("Не является вложенным")
    void test6() {
        // given
        int[] arr1 = {1, 8};
        int[] arr2 = {2, 5, 7};
        // when
        boolean answer = Task3InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isFalse();
    }
}
