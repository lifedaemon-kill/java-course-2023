package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8BackwardIteratorTest {
    @Test
    @DisplayName("Is List.of backward-iterating correct")
    void test1() {
        // Arrange
        int[] result = new int[3];
        int[] expected = {3, 2, 1};

        // Act
        var iterator = new BackwardIterator<>(List.of(1, 2, 3));
        for (int i = 0; iterator.hasNext(); i++) {
            result[i] = iterator.next();
        }

        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Is Arrays.asList backward-iterating correct")
    void test2() {
        // Arrange
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> target = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 2, 1));

        // Act
        var iterator = new BackwardIterator<>(target);
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        // Assert
        assertThat(result).isEqualTo(expected);
    }
}
