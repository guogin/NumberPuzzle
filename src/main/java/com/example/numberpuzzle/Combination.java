package com.example.numberpuzzle;

import java.util.*;

public class Combination {
    private static <E extends Comparable<? super E>>
    E getAtIndex(Set<E> set, int index) {
        ArrayList<E> list = new ArrayList<>(set);
        return list.get(index);
    }

    private static <E extends Comparable<? super E>>
    Set<E> add(Set<E> set, E element) {
        Set<E> superset = new HashSet<>(set);
        superset.add(element);
        return sort(superset);
    }

    private static <E extends Comparable<? super E>>
    Set<E> remove(Set<E> set, E element) {
        Set<E> subset = new HashSet<>(set);
        subset.remove(element);
        return sort(subset);
    }

    private static <E extends Comparable<? super E>>
    LinkedHashSet<E> sort(Set<E> set) {
        ArrayList<E> list = new ArrayList<>(set);
        Collections.sort(list);
        return new LinkedHashSet<>(list);
    }

    public static <E extends Comparable<? super E>>
    Set<Set<E>> getAllCombinations(Set<E> setOfObjects, int m) {
        Set<Set<E>> result = new LinkedHashSet<>();

        final Set<E> set = sort(setOfObjects);

        if (m == 1) {
            for (E element : set) {
                LinkedHashSet<E> subset = new LinkedHashSet<>(Set.of(element));
                result.add(subset);
            }
        } else {
            for (int i = 0; i < set.size(); ++i) {
                E element = getAtIndex(set, i);
                Set<E> subset = remove(set, element);

                // Performance could be improved here, because we actually
                // could remove elements [0..i] from the set
                Set<Set<E>> all = getAllCombinations(subset, m - 1);
                for (Set<E> one : all) {
                    Set<E> oneCombination = add(one, element);
                    // Below works because Set#equals() will return true only if two sets are same
                    // and Set#add() will do nothing if the element already exists in the set
                    result.add(oneCombination);
                }
            }
        }

        return result;
    }
}
