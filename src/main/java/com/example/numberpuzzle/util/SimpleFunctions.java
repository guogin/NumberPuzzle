package com.example.numberpuzzle.util;

import java.util.Set;

public class SimpleFunctions {
    public static int sum(Set<Integer> set) {
        return set.stream().reduce(0, (a, b) -> a + b);
    }
}
