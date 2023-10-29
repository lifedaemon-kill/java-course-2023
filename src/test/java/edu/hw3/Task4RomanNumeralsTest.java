package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edu.hw3.Task4.RomanNumerals.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4RomanNumeralsTest {
    @Test
    @DisplayName("2")
    void test1() throws Exception {
        // Arrange
        int arabic = 2;
        // Act
        String roman = convertToRoman(arabic);
        // Assert
        assertThat(roman).isEqualTo("II");
    }
    @Test
    @DisplayName("12")
    void test2() throws Exception {
        int arabic = 12;
        String roman = convertToRoman(arabic);
        assertThat(roman).isEqualTo("XII");
    }
    @Test
    @DisplayName("16")
    void test3() throws Exception {
        int arabic = 16;
        String roman = convertToRoman(arabic);
        assertThat(roman).isEqualTo("XVI");
    }
    @Test
    @DisplayName("37_330")
    void test4() throws Exception {
        int arabic = 37_330;
        String roman = convertToRoman(arabic);
        assertThat(roman).isEqualTo("ↂↂↂↁↀↀCCCXXX");
    }
    @Test
    @DisplayName("99_999 (maxBase - 1)")
    void test5() throws Exception {
        int arabic = 99_999;
        String roman = convertToRoman(arabic);
        assertThat(roman).isEqualTo("ↂↈↀↂCↀXCIX");
    }
    @Test
    @DisplayName("399_999 (the true max)")
    void test6() throws Exception {
        int arabic = 399_999;
        String roman = convertToRoman(arabic);
        assertThat(roman).isEqualTo("ↈↈↈↂↈↀↂCↀXCIX");
    }
    @Test
    @DisplayName("1994")
    void test7() throws Exception {
        int arabic = 1994;
        String roman = convertToRoman(arabic);
        assertThat(roman).isEqualTo("ↀCↀXCIV");
    }
    @Test
    @DisplayName("73")
    void test8() throws Exception {
        int arabic = 73;
        String roman = convertToRoman(arabic);
        assertThat(roman).isEqualTo("LXXIII");
    }
    @Test
    @DisplayName("96")
    void test9() throws Exception {
        int arabic = 96;
        String roman = convertToRoman(arabic);
        assertThat(roman).isEqualTo("XCVI");
    }
    @Test
    @DisplayName("271_386")
    void test10() throws Exception {
        int arabic = 271_386;
        String roman = convertToRoman(arabic);
        assertThat(roman).isEqualTo("ↈↈↇↂↂↀCCCLXXXVI");
    }
    @Test
    @DisplayName("26_644")
    void test11() throws Exception {
        int arabic = 26644;
        String roman = convertToRoman(arabic);
        assertThat(roman).isEqualTo("ↂↂↁↀDCXLIV");
    }
    @Test
    @DisplayName("141_157")
    void test12() throws Exception {
        int arabic = 141157;
        String roman = convertToRoman(arabic);
        assertThat(roman).isEqualTo("ↈↂↇↀCLVII");
    }
}
