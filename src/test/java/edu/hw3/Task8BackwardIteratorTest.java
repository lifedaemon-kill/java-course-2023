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
    @DisplayName("List.of")
    void test1() {
        int[] result = new int[3];

        var iterator = new BackwardIterator<>(List.of(1, 2, 3));

        for (int i = 0; iterator.hasNext(); i++) {
            result[i] = iterator.next();
        }

        int[] expected = {3, 2, 1};

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Arrays.asList")
    void test2() {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> target = new ArrayList<>(Arrays.asList(1, 2, 3));

        var iterator = new BackwardIterator<>(target);

        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 2, 1));

        assertThat(result).isEqualTo(expected);
    }
}
