package com.example.numberpuzzle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

import static com.example.numberpuzzle.util.SimpleFunctions.sum;

@SpringBootApplication
public class NumberPuzzleApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(NumberPuzzleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NumberPuzzleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final int m = 4;
        final int total = 24;

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 10; ++i) {
            set.add(i);
        }

        System.out.println("Set of numbers: \n" + set);
        System.out.println("List all combinations of " + m + " numbers which sum up to " + total);

        Set<Set<Integer>> all = Combination.getAllCombinations(set, m);
        for (Set<Integer> combination : all) {
            if (sum(combination) == total) {
                System.out.println(combination);
            }
        }
    }
}
