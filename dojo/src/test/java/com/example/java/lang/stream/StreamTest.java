package com.example.java.lang.stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class StreamTest {

    @Test
    void minNum() {
        List<Integer> array = List.of(3, 1, 4, 1, 5, 9, 2, 6);
        Optional<Integer> minN = array.stream().min(Integer::compareTo);
        Assertions.assertThat(minN).isPresent();
        Assertions.assertThat(minN.get()).isEqualTo(1);
    }

}
