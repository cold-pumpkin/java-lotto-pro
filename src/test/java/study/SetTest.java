package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set 사이즈 조회")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set에 값이 있으면 True")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsOnlyTrue(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set에 값이 있으면 True, 없으면 False")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTrueAndFalse(int input, boolean expected) {
        assertThat(numbers.contains(input))
                .isEqualTo(expected);
    }
}